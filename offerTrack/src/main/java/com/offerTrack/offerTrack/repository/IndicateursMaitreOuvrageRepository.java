package com.offerTrack.offerTrack.repository;

import com.offerTrack.offerTrack.model.IndicateursMaitreOuvrage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IndicateursMaitreOuvrageRepository extends JpaRepository<IndicateursMaitreOuvrage, Integer> {

    @Query("SELECT i FROM IndicateursMaitreOuvrage i WHERE i.id_maitre_ouvrage = :idMaitreOuvrage")
    Optional<IndicateursMaitreOuvrage> findByIdMaitreOuvrage(@Param("idMaitreOuvrage") int idMaitreOuvrage);
}