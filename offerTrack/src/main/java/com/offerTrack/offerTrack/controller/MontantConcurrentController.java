package com.offerTrack.offerTrack.controller;

import com.offerTrack.offerTrack.model.MontantConcurrent;
import com.offerTrack.offerTrack.service.MontantConcurrentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/")
public class MontantConcurrentController {
    MontantConcurrentService montantConcurrentService;

    public MontantConcurrentController(MontantConcurrentService montantConcurrentService) {
        this.montantConcurrentService = montantConcurrentService;
    }
    @GetMapping("/api/montantConcurrent")
    public List<MontantConcurrent> getAllMC(){
        return montantConcurrentService.getAllMontantConcurrent();
    }
    @GetMapping("/api/montantConcurrent/{id}")
    public MontantConcurrent getMCById(@PathVariable("id") int id){
        return montantConcurrentService.getMontantConcurrentById(id);
    }
    @PostMapping("/api/montantConcurrent")
    public String createMC(MontantConcurrent montantConcurrent){
        montantConcurrentService.createMontantConcurrent(montantConcurrent);
        return  "Montatn Concurrent créé avec succès";
    }
    @PutMapping("/api/montantConcurrent/{id}")
    public String updateMCById(@PathVariable("id") int id,MontantConcurrent montantConcurrent){
        montantConcurrentService.updateMontantConcurrentById(id,montantConcurrent);
        return "Montant Concurrent modifié avec succès";
    }
    @DeleteMapping("/api/montantConcurrent/{id}")
    public String deleteMCById(@PathVariable("id") int id){
        montantConcurrentService.deleteMontantConcurrentById(id);
        return "Montant concurrent supprimé avec succès";
    }
}
