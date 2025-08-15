package com.offerTrack.offerTrack.repository;

import com.offerTrack.offerTrack.model.IndicateursEntreprise;
import com.offerTrack.offerTrack.model.IndicateursMaitreOuvrage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IndicateursEntrepriseRepository extends JpaRepository<IndicateursEntreprise, Integer> {
    @Query("SELECT i FROM IndicateursEntreprise i WHERE i.id_concurrent = :idConcurrent")
    Optional<IndicateursEntreprise> findByIdConcurrent(@Param("idConcurrent") int idConcurrent);
}
