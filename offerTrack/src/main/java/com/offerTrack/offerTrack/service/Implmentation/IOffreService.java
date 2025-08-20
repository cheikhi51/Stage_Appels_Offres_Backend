package com.offerTrack.offerTrack.service.Implmentation;

import com.offerTrack.offerTrack.model.Offre;
import com.offerTrack.offerTrack.repository.OffreRepository;
import com.offerTrack.offerTrack.service.OffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IOffreService implements OffreService {

    private final OffreRepository offreRepository;

    @Autowired
    public IOffreService(OffreRepository offreRepository) {
        this.offreRepository = offreRepository;
    }

    @Override
    public List<Offre> getAllOffres() {
        return offreRepository.findAll();
    }

    @Override
    public Offre getOffreById(int id) {
        return offreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Offre non trouvée avec l'ID: " + id));
    }

    @Override
    public List<Offre> findOffreByMaitreOuvrageId(int id_maitre_ouvrage){
        return offreRepository.findOffreByMaitreOuvrageId(id_maitre_ouvrage);
    }

    @Override
    public String createOffre(Offre offre) {
        if (offre == null || offre.getReference_num() == null || offre.getReference_num().isEmpty()) {
            return "Offre invalide: le numéro de référence est requis.";
        }
        offreRepository.save(offre);
        return "Création avec succès";
    }

    @Override
    public String updateOffreById(int id, Offre updatedOffre) {
        Offre existingOffre = offreRepository.findById(id).orElse(null);

        if (existingOffre == null || existingOffre.getId_offre() != id) {
            return "Offre non trouvée avec l'ID: " + id;
        }
        if (updatedOffre.getReference_num() != null) {
            existingOffre.setReference_num(updatedOffre.getReference_num());
        }
        if (updatedOffre.getObjet() != null) {
            existingOffre.setObjet(updatedOffre.getObjet());
        }
        if (updatedOffre.getLieu() != null) {
            existingOffre.setLieu(updatedOffre.getLieu());
        }
        if (updatedOffre.getNum_ordre() != 0) { // assuming 0 means "not provided"
            existingOffre.setNum_ordre(updatedOffre.getNum_ordre());
        }
        if (updatedOffre.getPublication_portail() != null) {
            existingOffre.setPublication_portail(updatedOffre.getPublication_portail());
        }
        if (updatedOffre.getDate_limite() != null) {
            existingOffre.setDate_limite(updatedOffre.getDate_limite());
        }
        if (updatedOffre.getStatut_admin() != null) {
            existingOffre.setStatut_admin(updatedOffre.getStatut_admin());
        }
        if (updatedOffre.getStatut_tech() != null) {
            existingOffre.setStatut_tech(updatedOffre.getStatut_tech());
        }
        if (updatedOffre.getStatut_financier() != null) {
            existingOffre.setStatut_financier(updatedOffre.getStatut_financier());
        }
        if (updatedOffre.getInformations_additionnelles() != null) {
            existingOffre.setInformations_additionnelles(updatedOffre.getInformations_additionnelles());
        }
        // Save updated entity
        offreRepository.save(existingOffre);
        return "Offre mise à jour avec succès";
    }


    @Override
    public String deleteOffreById(int id) {
        if (offreRepository.existsById(id)) {
            offreRepository.deleteById(id);
            return "Suppression avec succès";
        } else {
            return "Offre non trouvée avec l'ID: " + id;
        }
    }

    // NEW PARTICIPATION METHODS
    @Override
    public String addParticipantToOffre(int offreId, int userId) {
        try {
            Optional<Offre> offreOpt = offreRepository.findById(offreId);
            if (offreOpt.isEmpty()) {
                return "Offre non trouvée avec l'ID: " + offreId;
            }

            Offre offre = offreOpt.get();

            // Check if user has already participated
            if (offre.hasParticipated(userId)) {
                return "L'utilisateur a déjà participé à cette offre";
            }

            // Add participant
            offre.addParticipant(userId);
            offreRepository.save(offre);

            return "Participation ajoutée avec succès";

        } catch (Exception e) {
            return "Erreur lors de l'ajout de la participation: " + e.getMessage();
        }
    }

    @Override
    public String removeParticipantFromOffre(int offreId, int userId) {
        try {
            Optional<Offre> offreOpt = offreRepository.findById(offreId);
            if (offreOpt.isEmpty()) {
                return "Offre non trouvée avec l'ID: " + offreId;
            }

            Offre offre = offreOpt.get();

            // Check if user has participated
            if (!offre.hasParticipated(userId)) {
                return "L'utilisateur n'a pas participé à cette offre";
            }

            // Remove participant
            offre.removeParticipant(userId);
            offreRepository.save(offre);

            return "Participation supprimée avec succès";

        } catch (Exception e) {
            return "Erreur lors de la suppression de la participation: " + e.getMessage();
        }
    }

    @Override
    public int getParticipantCount(int offreId) {
        try {
            Optional<Offre> offreOpt = offreRepository.findById(offreId);
            return offreOpt.map(Offre::getParticipantCount).orElse(0);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public boolean hasUserParticipated(int offreId, int userId) {
        try {
            Optional<Offre> offreOpt = offreRepository.findById(offreId);
            return offreOpt.map(offre -> offre.hasParticipated(userId)).orElse(false);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Offre> getAllOffresWithParticipationStatus(Integer userId) {
        try {
            List<Offre> offres = offreRepository.findAll();
            // The participation status will be automatically calculated when the entity is loaded
            // due to the @PostLoad method in the Offre entity
            return offres;
        } catch (Exception e) {
            // Return empty list in case of error
            return List.of();
        }
    }

    // Helper method to validate offre exists
    private boolean offreExists(int offreId) {
        return offreRepository.existsById(offreId);
    }

    // Helper method to get offre safely
    private Optional<Offre> getOffreSafely(int offreId) {
        try {
            return offreRepository.findById(offreId);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

}
