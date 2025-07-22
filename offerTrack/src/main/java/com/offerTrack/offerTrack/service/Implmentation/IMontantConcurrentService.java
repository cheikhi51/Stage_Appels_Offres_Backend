package com.offerTrack.offerTrack.service.Implmentation;

import com.offerTrack.offerTrack.model.MontantConcurrent;
import com.offerTrack.offerTrack.repository.MontantConcurrentRepository;
import com.offerTrack.offerTrack.service.MontantConcurrentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IMontantConcurrentService implements MontantConcurrentService {
    @Autowired
    private final MontantConcurrentRepository montantConcurrentRepository;

    public IMontantConcurrentService(MontantConcurrentRepository montantConcurrentRepository) {
        this.montantConcurrentRepository = montantConcurrentRepository;
    }

    @Override
    public List<MontantConcurrent> getAllMontantConcurrent() {
        return montantConcurrentRepository.findAll();
    }

    @Override
    public MontantConcurrent getMontantConcurrentById(int id) {
        return montantConcurrentRepository.findById(String.valueOf(id)).get();
    }

    @Override
    public String createMontantConcurrent(MontantConcurrent montantConcurrent) {
        montantConcurrentRepository.save(montantConcurrent);
        return "Montant Concurrent créé";
    }

    @Override
    public String updateMontantConcurrentById(int id, MontantConcurrent montantConcurrent) {
        MontantConcurrent existingMC = montantConcurrentRepository.findById(String.valueOf(id)).orElse(null);
        if(existingMC != null && existingMC.getId() == id) {
            existingMC.setId_concurrent(montantConcurrent.getId_concurrent());
            existingMC.setDepot(montantConcurrent.isDepot());
            existingMC.setMontant_engagement_ht(montantConcurrent.getMontant_engagement_ht());
            existingMC.setVerification_montant_ht(montantConcurrent.getVerification_montant_ht());
            existingMC.setVerification_montant_ttc(montantConcurrent.getVerification_montant_ttc());
            existingMC.setMontant_engagement_ttc(montantConcurrent.getMontant_engagement_ttc());
            existingMC.setId_offre(montantConcurrent.getId_offre());
            montantConcurrentRepository.save(existingMC);
            return "Montant concurrent modifié";
        }
        return "Montant concurrent non trouvé";
    }

    @Override
    public String deleteMontantConcurrentById(int id) {
        montantConcurrentRepository.deleteById(String.valueOf(id));
        return "Montant concurrent supprimé";
    }
}
