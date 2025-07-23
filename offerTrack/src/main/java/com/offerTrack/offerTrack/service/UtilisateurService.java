package com.offerTrack.offerTrack.service;

import com.offerTrack.offerTrack.dto.LoginDto;
import com.offerTrack.offerTrack.dto.RegisterDto;
import com.offerTrack.offerTrack.model.Utilisateur;

import java.util.List;

public interface UtilisateurService {
     String register(RegisterDto registerDto);
     String login(LoginDto loginDto);
     Utilisateur findByEmail(String email);
     List<Utilisateur> getAllUtilisateur();
     Utilisateur getUtilisateurById(int id);
     String createUtilisateur(Utilisateur utilisateur);
     String updateUtilisateurById(int id,Utilisateur utilisateur);
     String deleteUtilisateurById(int id);
}
