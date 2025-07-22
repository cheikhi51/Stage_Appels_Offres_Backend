package com.offerTrack.offerTrack.service.Implmentation;

import com.offerTrack.offerTrack.model.Utilisateur;

import com.offerTrack.offerTrack.repository.UtilisateurRepository;
import com.offerTrack.offerTrack.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUtilisateurService implements UtilisateurService {
    @Autowired
    private final UtilisateurRepository utilisateurRepository;
    public  IUtilisateurService(UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public List<Utilisateur> getAllUtilisateur() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur getUtilisateurById(int id) {
        return utilisateurRepository.findById(String.valueOf(id)).get();
    }

    @Override
    public String createUtilisateur(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
        return "creation avec succèss";
    }

    @Override
    public String updateUtilisateurById(int id, Utilisateur utilisateur) {
        Utilisateur existingUser = utilisateurRepository.findById(String.valueOf(id)).orElse(null);
        if(existingUser != null && existingUser.getId() == id){
            existingUser.setNom(utilisateur.getNom());
            existingUser.setEmail(utilisateur.getEmail());
            existingUser.setMot_de_passe(utilisateur.getMot_de_passe());
            utilisateurRepository.save(existingUser);
            return "Utilisateur mis à jour avec succèss";
        }
        return "Utilisateur non trouvé";

    }

    @Override
    public String deleteUtilisateurById(int id) {
        utilisateurRepository.deleteById(String.valueOf(id));
        return "suppression avec succèss";
    }
}
