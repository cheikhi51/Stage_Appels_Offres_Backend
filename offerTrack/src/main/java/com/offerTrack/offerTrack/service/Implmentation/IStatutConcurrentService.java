package com.offerTrack.offerTrack.service.Implmentation;

import com.offerTrack.offerTrack.model.StatutConcurrent;
import com.offerTrack.offerTrack.repository.StatutConcurrentRepository;
import com.offerTrack.offerTrack.service.StatutConcurrentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IStatutConcurrentService implements StatutConcurrentService {
    @Autowired
    private final StatutConcurrentRepository statutConcurrentRepository;

    public IStatutConcurrentService(StatutConcurrentRepository statutConcurrentRepository){
        this.statutConcurrentRepository = statutConcurrentRepository;
    }


    @Override
    public List<StatutConcurrent> getAllStatutConcurrent() {
        return statutConcurrentRepository.findAll();
    }

    @Override
    public StatutConcurrent getStatutConcurrentById(int id) {
        return statutConcurrentRepository.findById(String.valueOf(id)).get();
    }

    @Override
    public String createStatutConcurrent(StatutConcurrent statutConcurrent) {
        statutConcurrentRepository.save(statutConcurrent);
        return "Création avec succès";
    }

    @Override
    public String updateStatutConcurrentById(int id, StatutConcurrent statutConcurrent) {
        StatutConcurrent existingStatutConcurrent = statutConcurrentRepository.findById(String.valueOf(id)).orElse(null);
        if (existingStatutConcurrent != null && existingStatutConcurrent.getId() == id){
            existingStatutConcurrent.setId_offre(statutConcurrent.getId_offre());
            existingStatutConcurrent.setId_concurrent(statutConcurrent.getId_concurrent());
            existingStatutConcurrent.setStatut_administratif(statutConcurrent.getStatut_administratif());
            existingStatutConcurrent.setStatut_technique(statutConcurrent.getStatut_technique());
            existingStatutConcurrent.setStatut_financier(statutConcurrent.getStatut_financier());
            statutConcurrentRepository.save(existingStatutConcurrent);
            return "Statut Concurrent mis à jour avec succèss";

        }
        return "Statut Concurrent non trouvé";
    }

    @Override
    public String deleteStatutConcurrent(int id) {
        statutConcurrentRepository.deleteById(String.valueOf(id));
        return "Suppression avec succès";
    }
}
