package com.offerTrack.offerTrack.service.Implmentation;

import com.offerTrack.offerTrack.model.IndicateursEntreprise;
import com.offerTrack.offerTrack.repository.IndicateursEntrepriseRepository;
import com.offerTrack.offerTrack.service.IndicateursEntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IIndicateursEntrepriseService implements IndicateursEntrepriseService {
    @Autowired
    private final IndicateursEntrepriseRepository indicateursEntRepository;
    public IIndicateursEntrepriseService(IndicateursEntrepriseRepository indicateursEntRepository){
        this.indicateursEntRepository = indicateursEntRepository;
    }

    @Override
    public List<IndicateursEntreprise> getAllIndicateursEnt() {
        return indicateursEntRepository.findAll();
    }

    @Override
    public IndicateursEntreprise getIndicateursEntById(int id) {
        return indicateursEntRepository.findById(id).get();
    }

    @Override
    public IndicateursEntreprise getIndicateursEntByConId(int id_concurrent) {
        return indicateursEntRepository.findByIdConcurrent(id_concurrent)
                .orElseThrow(() -> new RuntimeException("No indicators found for Maitre Ouvrage ID: " + id_concurrent));
    }

    @Override
    public String createIndicateursEnt(IndicateursEntreprise indicateursEntreprise) {
        indicateursEntRepository.save(indicateursEntreprise);
        return "Creation des indicateurs avec succès";
    }

    @Override
    public String updateIndicateursEntById(int id, IndicateursEntreprise indicateursEntreprise) {
        IndicateursEntreprise existingindicateursEnt = indicateursEntRepository.findById(id).orElse(null);
        if(existingindicateursEnt != null && existingindicateursEnt.getId() == id){
            existingindicateursEnt.setId_concurrent(indicateursEntreprise.getId_concurrent());
            existingindicateursEnt.setGain_total(indicateursEntreprise.getGain_total());
            existingindicateursEnt.setNb_ao_reussis(indicateursEntreprise.getNb_ao_reussis());
            existingindicateursEnt.setNb_ao_total(indicateursEntreprise.getNb_ao_total());
            existingindicateursEnt.setNb_refus_admin(indicateursEntreprise.getNb_refus_admin());
            existingindicateursEnt.setNb_refus_fin(indicateursEntreprise.getNb_refus_fin());
            existingindicateursEnt.setNb_refus_tech(indicateursEntreprise.getNb_refus_tech());
            existingindicateursEnt.setPart_marche(indicateursEntreprise.getPart_marche());
            existingindicateursEnt.setTaux_reussite(indicateursEntreprise.getTaux_reussite());
            indicateursEntRepository.save(existingindicateursEnt);
            return "Les Indicateurs Entreprise sont mis à jour avec succès";
        }
        return "Les Indicateurs Entreprise n'existent pas!";
    }

    @Override
    public String deleteIndicateursEntById(int id) {
        indicateursEntRepository.deleteById(id);
        return "Indicateurs Entreprise Supprimés!";
    }
}
