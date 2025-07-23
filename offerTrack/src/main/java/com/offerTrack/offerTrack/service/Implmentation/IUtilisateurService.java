package com.offerTrack.offerTrack.service.Implmentation;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.offerTrack.offerTrack.dto.JwtResponse;
import com.offerTrack.offerTrack.dto.LoginDto;
import com.offerTrack.offerTrack.dto.RegisterDto;
import com.offerTrack.offerTrack.model.Utilisateur;

import com.offerTrack.offerTrack.repository.UtilisateurRepository;
import com.offerTrack.offerTrack.service.UtilisateurService;
import com.offerTrack.offerTrack.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IUtilisateurService implements UtilisateurService {
    @Autowired
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private ObjectMapper objectMapper;

    public IUtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public String register(RegisterDto registerDto) {
        try {
            // Check if user already exists
            if (utilisateurRepository.findByEmail(registerDto.getEmail()).isPresent()) {
                return "{\"error\": \"Un utilisateur avec cet email existe déjà\"}";
            }

            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setNom(registerDto.getNom());
            utilisateur.setEmail(registerDto.getEmail());
            utilisateur.setMot_de_passe(passwordEncoder.encode(registerDto.getMot_de_passe()));
            utilisateur.setRole(registerDto.getRole());

            utilisateurRepository.save(utilisateur);

            // Generate JWT token
            String token = jwtUtil.generateToken(utilisateur.getEmail(), utilisateur.getRole().name());

            JwtResponse response = new JwtResponse(
                    token,
                    utilisateur.getRole().name(),
                    utilisateur.getEmail(),
                    "Utilisateur créé avec succès"
            );

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            return "{\"error\": \"Erreur lors de la création: " + e.getMessage() + "\"}";
        }
    }

    @Override
    public String login(LoginDto loginDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getMot_de_passe())
            );

            Utilisateur utilisateur = findByEmail(loginDto.getEmail());
            String token = jwtUtil.generateToken(utilisateur.getEmail(), utilisateur.getRole().name());

            JwtResponse response = new JwtResponse(
                    token,
                    utilisateur.getRole().name(),
                    utilisateur.getEmail(),
                    "Connexion réussie"
            );

            return objectMapper.writeValueAsString(response);

        } catch (AuthenticationException e) {
            return "{\"error\": \"Identifiants invalides\"}";
        } catch (Exception e) {
            return "{\"error\": \"Erreur lors de la connexion: " + e.getMessage() + "\"}";
        }
    }

    @Override
    public Utilisateur findByEmail(String email) {
        return utilisateurRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }


    @Override
    public List<Utilisateur> getAllUtilisateur() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur getUtilisateurById(int id) {
        return utilisateurRepository.findById(id).get();
    }

    @Override
    public String createUtilisateur(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
        return "creation avec succèss";
    }

    @Override
    public String updateUtilisateurById(int id, Utilisateur utilisateur) {
        Utilisateur existingUser = utilisateurRepository.findById(id).orElse(null);
        if(existingUser != null && existingUser.getId() == id){
            existingUser.setNom(utilisateur.getNom());
            existingUser.setEmail(utilisateur.getEmail());
            existingUser.setMot_de_passe(utilisateur.getMot_de_passe());
            existingUser.setRole(utilisateur.getRole());
            utilisateurRepository.save(existingUser);
            return "Utilisateur mis à jour avec succèss";
        }
        return "Utilisateur non trouvé";

    }

    @Override
    public String deleteUtilisateurById(int id) {
        utilisateurRepository.deleteById(id);
        return "suppression avec succèss";
    }
}
