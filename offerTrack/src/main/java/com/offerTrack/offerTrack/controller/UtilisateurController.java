package com.offerTrack.offerTrack.controller;

import com.offerTrack.offerTrack.model.Utilisateur;
import com.offerTrack.offerTrack.service.UtilisateurService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/")
public class UtilisateurController {
    UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService){
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/api/utilisateurs")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Utilisateur> getUtilisateurs(){
        return utilisateurService.getAllUtilisateur();
    }


    @GetMapping("/api/utilisateurs/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Utilisateur getUtilisateurById(@PathVariable("id") int id){
        return utilisateurService.getUtilisateurById(id);
    }

    @PostMapping("/api/utilisateurs")
    @PreAuthorize("hasRole('ADMIN')")
    public  String createUtilisateur(@RequestBody Utilisateur utilisateur){
        utilisateurService.createUtilisateur(utilisateur);
        return "Utilisateur créé avec succès";
    }
    @PutMapping("/api/utilisateurs/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateUtilisateur(@PathVariable("id") int id,@RequestBody Utilisateur utilisateur){
        utilisateurService.updateUtilisateurById(id,utilisateur);
        return "Utilisateur mis à jour avec succès";
    }
    @DeleteMapping("/api/utilisateurs/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteUtilisateur(@PathVariable("id") int id){
        utilisateurService.deleteUtilisateurById(id);
        return "Utilisateur supprimé avec succès";
    }
}
