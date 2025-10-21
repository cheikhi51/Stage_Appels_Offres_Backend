package com.offerTrack.offerTrack.repository;

import com.offerTrack.offerTrack.model.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OffreRepository extends JpaRepository<Offre, Integer> {
    @Query("SELECT i FROM Offre i WHERE i.id_maitre_ouvrage = :idMaitreOuvrage")
    List<Offre> findOffreByMaitreOuvrageId(@Param("idMaitreOuvrage") int idMaitreOuvrage);
}
