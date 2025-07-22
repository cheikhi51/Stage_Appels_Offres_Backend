package com.offerTrack.offerTrack.repository;

import com.offerTrack.offerTrack.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {
}
