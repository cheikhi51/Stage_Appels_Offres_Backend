package com.offerTrack.offerTrack.service;

import com.offerTrack.offerTrack.model.Utilisateur;
import com.offerTrack.offerTrack.service.Implmentation.IUtilisateurService;

import java.util.List;

public interface UtilisateurService {
     List<Utilisateur> getAllUtilisateur();
     Utilisateur getUtilisateurById(int id);
     String createUtilisateur(Utilisateur utilisateur);
     String updateUtilisateurById(int id,Utilisateur utilisateur);
     String deleteUtilisateurById(int id);
}
