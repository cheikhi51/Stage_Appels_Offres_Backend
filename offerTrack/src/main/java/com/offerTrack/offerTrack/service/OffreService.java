package com.offerTrack.offerTrack.service;

import com.offerTrack.offerTrack.model.Offre;

import java.util.List;
import java.util.Map;

public interface OffreService {
    List<Offre> getAllOffres();
    Offre getOffreById(int id);
    List<Offre> findOffreByMaitreOuvrageId(int id_maitre_ouvrage);
    String createOffre(Offre offre);
    String updateOffreById(int id,Offre offre);
    String deleteOffreById(int id);

    String addParticipantToOffre(int offreId, int userId);
    String removeParticipantFromOffre(int offreId, int userId);
    int getParticipantCount(int offreId);
    boolean hasUserParticipated(int offreId, int userId);
    List<Offre> getAllOffresWithParticipationStatus(Integer userId);

    // NEW METHODS TO ADD:
    List<Map<String, Object>> getOffresWithParticipantsByMaitreOuvrage(int idMaitreOuvrage);
    String updateParticipantStatus(int offreId, int userId, String status);
    List<Map<String, Object>> getOffreParticipants(int offreId);

    String getParticipantStatus(int offreId, int userId);

    int getTotalOffresRemportees();
}
