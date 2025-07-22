package com.offerTrack.offerTrack.service.Implmentation;

import com.offerTrack.offerTrack.model.RapportGenere;
import com.offerTrack.offerTrack.repository.RapportGenereRepository;
import com.offerTrack.offerTrack.service.RapportGenereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IRapportGenere implements RapportGenereService {
    @Autowired
    private final RapportGenereRepository rapportGenereRepository;

    public IRapportGenere(RapportGenereRepository rapportGenereRepository) {
        this.rapportGenereRepository = rapportGenereRepository;
    }

    @Override
    public List<RapportGenere> getAllRapport() {
        return rapportGenereRepository.findAll();
    }

    @Override
    public RapportGenere getRapportById(int id) {
        return rapportGenereRepository.findById(String.valueOf(id)).get();
    }

    @Override
    public String createRapport(RapportGenere rapportGenere) {
        rapportGenereRepository.save(rapportGenere);
        return "Rapport créé avec succès";
    }

    @Override
    public String updateRapport(int id, RapportGenere rapportGenere) {
        RapportGenere existingRapport = rapportGenereRepository.findById(String.valueOf(id)).orElse(null);
        if(existingRapport != null && existingRapport.getId() == id){
            existingRapport.setContenu(rapportGenere.getContenu());
            existingRapport.setDate(rapportGenere.getDate());
            existingRapport.setId_utilisateur(rapportGenere.getId_utilisateur());
            existingRapport.setNom_utilisateur(rapportGenere.getNom_utilisateur());
            rapportGenereRepository.save(existingRapport);
            return "Rapport Modifié avec succès";
        }
        return "Rapport non trouvé!";

    }

    @Override
    public String deleteRapport(int id) {
        rapportGenereRepository.deleteById(String.valueOf(id));
        return "Rapport supprimé avec succès";
    }
}
