package com.offerTrack.offerTrack.controller;

import com.offerTrack.offerTrack.model.RapportGenere;
import com.offerTrack.offerTrack.service.RapportGenereService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/")
public class RapportGenereController {
    RapportGenereService rapportGenereService;

    public RapportGenereController(RapportGenereService rapportGenereService) {
        this.rapportGenereService = rapportGenereService;
    }

    @GetMapping("/api/rapportGenere")
    @PreAuthorize("hasRole('CONCURRENT') or hasRole('ADMIN') or hasRole('MAITREOUVRAGE')")
    public List<RapportGenere> getAllRapport(){
        return rapportGenereService.getAllRapport();
    }

    @GetMapping("/api/rapportGenere/{id}")
    @PreAuthorize("hasRole('CONCURRENT') or hasRole('ADMIN') or hasRole('MAITREOUVRAGE')")
    public RapportGenere getRapportById(@PathVariable("id") int id){
        return rapportGenereService.getRapportById(id);
    }

    @PostMapping("/api/rapportGenere")
    @PreAuthorize("hasRole('CONCURRENT') or hasRole('ADMIN') or hasRole('MAITREOUVRAGE')")
    public String createRapport(RapportGenere rapportGenere){
        rapportGenereService.createRapport(rapportGenere);
        return "Rapport créé avec succès";
    }

    @PutMapping("/api/rapportGenere/{id}")
    @PreAuthorize("hasRole('CONCURRENT') or hasRole('ADMIN') or hasRole('MAITREOUVRAGE')")
    public  String updateRapport(@PathVariable("id") int id,RapportGenere rapportGenere){
        rapportGenereService.updateRapport(id,rapportGenere);
        return "Rapport modifié avec succès";
    }

    @DeleteMapping("/api/rapportGenere/{id}")
    @PreAuthorize("hasRole('CONCURRENT') or hasRole('ADMIN') or hasRole('MAITREOUVRAGE')")
    public String deleteRapport(@PathVariable("id") int id){
        rapportGenereService.deleteRapport(id);
        return "Rapport supprimé avec succès";
    }
}
