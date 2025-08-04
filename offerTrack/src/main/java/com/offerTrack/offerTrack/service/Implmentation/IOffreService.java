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
    public String createOffre(Offre offre) {
        if (offre == null || offre.getReference_num() == null || offre.getReference_num().isEmpty()) {
            return "Offre invalide: le numéro de référence est requis.";
        }
        offreRepository.save(offre);
        return "Création avec succès";
    }

    @Override
    public String updateOffreById(int id, Offre updatedOffre) {
        Optional<Offre> optionalExisting = offreRepository.findById(id);

        if (optionalExisting.isPresent()) {
            Offre existing = optionalExisting.get();
            updateOffreFields(existing, updatedOffre);
            offreRepository.save(existing);
            return "Offre mise à jour avec succès";
        } else {
            return "Offre non trouvée avec l'ID: " + id;
        }
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

    private void updateOffreFields(Offre existing, Offre updated) {
        existing.setDate_limite(updated.getDate_limite());
        existing.setLieu(updated.getLieu());
        existing.setObjet(updated.getObjet());
        existing.setNum_ordre(updated.getNum_ordre());
        existing.setPublication_portail(updated.getPublication_portail());
        existing.setStatut_admin(updated.getStatut_admin());
        existing.setStatut_financier(updated.getStatut_financier());
        existing.setStatut_tech(updated.getStatut_tech());
        existing.setInformations_additionnelles(updated.getInformations_additionnelles());
        existing.setReference_num(updated.getReference_num());
        // Avoid updating IDs unless explicitly required
    }
}
