package com.offerTrack.offerTrack.service.Implmentation;

import com.offerTrack.offerTrack.model.IndicateursMaitreOuvrage;
import com.offerTrack.offerTrack.repository.IndicateursMaitreOuvrageRepository;
import com.offerTrack.offerTrack.service.IndicateursMaitreOuvrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IIndicateursMaitreOuvrageService implements IndicateursMaitreOuvrageService {

    @Autowired
    private final IndicateursMaitreOuvrageRepository indicateursMORepository;

    public IIndicateursMaitreOuvrageService(IndicateursMaitreOuvrageRepository indicateursMORepository) {
        this.indicateursMORepository = indicateursMORepository;
    }

    @Override
    public List<IndicateursMaitreOuvrage> getAllIndicateursMO() {
        return indicateursMORepository.findAll();
    }

    @Override
    public IndicateursMaitreOuvrage getIndicateursMOByMaitreOuvrageId(int id_maitre_ouvrage) {
        return indicateursMORepository.findByIdMaitreOuvrage(id_maitre_ouvrage)
                .orElseThrow(() -> new RuntimeException("No indicators found for Maitre Ouvrage ID: " + id_maitre_ouvrage));
    }


    @Override
    public String createIndicateursMO(IndicateursMaitreOuvrage indicateursMO) {
        indicateursMORepository.save(indicateursMO);
        return "Indicateurs Maitre d'Ouvrage créés avec succès";
    }

    @Override
    public String updateIndicateursMO(int id_maitre_ouvrage, IndicateursMaitreOuvrage indicateursMO) {
        IndicateursMaitreOuvrage existingIndicateursMO = indicateursMORepository.findByIdMaitreOuvrage(id_maitre_ouvrage).orElse(null);
        if (existingIndicateursMO != null ){
            existingIndicateursMO.setMontant_total(indicateursMO.getMontant_total());
            existingIndicateursMO.setTaux_attribution(indicateursMO.getTaux_attribution());
            existingIndicateursMO.setTotal_appels(indicateursMO.getTotal_appels());
            existingIndicateursMO.setTaux_participation(indicateursMO.getTaux_participation());
            existingIndicateursMO.setAppels_offres_attribues(indicateursMO.getAppels_offres_attribues());
            existingIndicateursMO.setTotal_participants(indicateursMO.getTotal_participants());
            existingIndicateursMO.setMoyenne_participants_par_ao(indicateursMO.getMoyenne_participants_par_ao());
            existingIndicateursMO.setTotal_rejets_financiers(indicateursMO.getTotal_rejets_financiers());
            existingIndicateursMO.setTotal_rejets_admin(indicateursMO.getTotal_rejets_admin());
            existingIndicateursMO.setTotal_rejets_techniques(indicateursMO.getTotal_rejets_techniques());
            indicateursMORepository.save(existingIndicateursMO);
            return "Indicateurs Maitre d'Ouvrage modifiés avec succès";
        }
        return "Indicateurs Maitre d'Ouvrage n'existe pas!";
    }

    @Override
    public String deleteIndicateursMO(int id) {
        indicateursMORepository.deleteById(id);
        return "Indicateurs Maitre d'Ouvrage supprimés avec succès";
    }
}
