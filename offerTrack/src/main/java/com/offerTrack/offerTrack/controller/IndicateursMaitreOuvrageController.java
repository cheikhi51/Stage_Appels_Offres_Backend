package com.offerTrack.offerTrack.controller;


import com.offerTrack.offerTrack.model.IndicateursMaitreOuvrage;
import com.offerTrack.offerTrack.service.IndicateursMaitreOuvrageService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/")
public class IndicateursMaitreOuvrageController {
    IndicateursMaitreOuvrageService indicateursMOService;

    public IndicateursMaitreOuvrageController(IndicateursMaitreOuvrageService indicateursMOService) {
        this.indicateursMOService = indicateursMOService;
    }

    @GetMapping("/api/indicateursMO")
    @PreAuthorize("hasRole('MAITREOUVRAGE') or hasRole('ADMIN')")
    public List<IndicateursMaitreOuvrage> getAllIndicateursMO(){
        return indicateursMOService.getAllIndicateursMO();
    }
    @GetMapping("/api/indicateursMO/{id_maitre_ouvrage}")
    @PreAuthorize("hasRole('MAITREOUVRAGE') or hasRole('ADMIN')")
    public ResponseEntity<IndicateursMaitreOuvrage> getIndicateursByMaitreOuvrageId(@PathVariable int id_maitre_ouvrage) {
        return ResponseEntity.ok(indicateursMOService.getIndicateursMOByMaitreOuvrageId(id_maitre_ouvrage));
    }
    @PostMapping("/api/indicateursMO")
    @PreAuthorize("hasRole('MAITREOUVRAGE') or hasRole('ADMIN')")
    public String createIndicateursMO(IndicateursMaitreOuvrage indicateursMO){
        indicateursMOService.createIndicateursMO(indicateursMO);
        return "Les Indicateurs Maitre d'Ouvrage sont crées avec succès";
    }
    @PutMapping("/api/indicateursMO/{id_maitre_ouvrage}")
    @PreAuthorize("hasRole('MAITREOUVRAGE') or hasRole('ADMIN')")
    public  String updateIndicateursMO(@PathVariable("id_maitre_ouvrage") int id_maitre_ouvrage,@RequestBody IndicateursMaitreOuvrage indicateursMO){
        indicateursMOService.updateIndicateursMO(id_maitre_ouvrage,indicateursMO);
        return "Les Indicateurs Maitre d'Ouvrage Modifiées avec succès";
    }
    @DeleteMapping("/api/indicateursMO/{id}")
    @PreAuthorize("hasRole('MAITREOUVRAGE') or hasRole('ADMIN')")
    public  String deleteIndicateursMOById(@PathVariable("id") int id){
        indicateursMOService.deleteIndicateursMO(id);
        return "Les Indicateurs Maitre d'Ouvrage supprimées avec succès";
    }
}
