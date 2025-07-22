package com.offerTrack.offerTrack.service.Implmentation;

import com.offerTrack.offerTrack.model.Offre;
import com.offerTrack.offerTrack.repository.OffreRepository;
import com.offerTrack.offerTrack.service.OffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IOffreService implements OffreService {
    @Autowired
    private final OffreRepository offreRepository;

    public  IOffreService(OffreRepository offreRepository){
        this.offreRepository = offreRepository;
    }
    @Override
    public List<Offre> getAllOffres() {
        return offreRepository.findAll();
    }

    @Override
    public Offre getOffreById(int id) {
        return offreRepository.findById(String.valueOf(id)).get();
    }

    @Override
    public String createOffre(Offre offre) {
        offreRepository.save(offre);
        return "Création avec succès";
    }

    @Override
    public String updateOffreById(int id, Offre offre) {
        Offre existingOffre = offreRepository.findById(String.valueOf(id)).orElse(null);
        if (existingOffre != null && existingOffre.getId_offre() == id) {
            existingOffre.setDate_limite(offre.getDate_limite());
            existingOffre.setLieu(offre.getLieu());
            existingOffre.setObjet(offre.getObjet());
            existingOffre.setNum_ordre(offre.getNum_ordre());
            existingOffre.setId_maitre_ouvrage(offre.getId_maitre_ouvrage());
            existingOffre.setPublication_portail(offre.getPublication_portail());
            existingOffre.setStatut_admin(offre.getStatut_admin());
            existingOffre.setStatut_financier(offre.getStatut_financier());
            existingOffre.setStatut_tech(offre.getStatut_tech());
            existingOffre.setInformations_additionnelles(offre.getInformations_additionnelles());
            existingOffre.setReference_num(offre.getReference_num());
            offreRepository.save(existingOffre);
            return "Offre mis à our avec succès";
        }
        return "Offre n'est pas trouvée";
    }

    @Override
    public String deleteOffreById(int id) {
        offreRepository.deleteById(String.valueOf(id));
        return "suppression avec succèss";
    }
}
