package com.offerTrack.offerTrack.controller;


import com.offerTrack.offerTrack.model.Offre;
import com.offerTrack.offerTrack.service.OffreService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class OffreController {
    OffreService offreService;
    public OffreController(OffreService offreService){
        this.offreService = offreService;
    }
    @GetMapping("/api/offres")
    @PreAuthorize("hasRole('CONCURRENT') or hasRole('ADMIN') or hasRole('MAITREOUVRAGE')")
    public List<Offre> getAllOffres(){
        return offreService.getAllOffres();
    }
    @GetMapping("/api/offres/{id}")
    @PreAuthorize("hasRole('CONCURRENT') or hasRole('ADMIN') or hasRole('MAITREOUVRAGE')")
    public Offre getOffreById(@PathVariable("id") int id){
        return offreService.getOffreById(id);
    }
    @PostMapping("/api/offres")
    @PreAuthorize("hasRole('CONCURRENT') or hasRole('ADMIN') or hasRole('MAITREOUVRAGE')")
    public String createOffre(Offre offre){
        offreService.createOffre(offre);
        return "Offre créé avec succès";
    }
    @PutMapping("/api/offres/{id}")
    @PreAuthorize("hasRole('CONCURRENT') or hasRole('ADMIN') or hasRole('MAITREOUVRAGE')")
    public String updateOffreById(@PathVariable("id") int id, Offre offre){
        offreService.updateOffreById(id,offre);
        return "Offre mis à jour avec succès";
    }
    @DeleteMapping("/api/offres/{id}")
    @PreAuthorize("hasRole('CONCURRENT') or hasRole('ADMIN') or hasRole('MAITREOUVRAGE')")
    public String deleteOffreById(@PathVariable("id") int id){
        offreService.deleteOffreById(id);
        return "Offre supprimée avec succès";
    }
}
