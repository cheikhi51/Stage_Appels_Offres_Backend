package com.offerTrack.offerTrack.controller;


import com.offerTrack.offerTrack.model.Offre;
import com.offerTrack.offerTrack.service.OffreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/")
public class OffreController {
    OffreService offreService;
    public OffreController(OffreService offreService){
        this.offreService = offreService;
    }
    @GetMapping("/api/offres")
    public List<Offre> getAllOffres(){
        return offreService.getAllOffres();
    }
    @GetMapping("/api/offres/{id}")
    public Offre getOffreById(@PathVariable("id") int id){
        return offreService.getOffreById(id);
    }
    @PostMapping("/api/offres")
    public String createOffre(Offre offre){
        offreService.createOffre(offre);
        return "Offre créé avec succès";
    }
    @PutMapping("/api/offres/{id}")
    public String updateOffreById(@PathVariable("id") int id,Offre offre){
        offreService.updateOffreById(id,offre);
        return "Offre mis à jour avec succès";
    }
    @DeleteMapping("/api/offres/{id}")
    public String deleteOffreById(@PathVariable("id") int id){
        offreService.deleteOffreById(id);
        return "Offre supprimée avec succès";
    }
}
