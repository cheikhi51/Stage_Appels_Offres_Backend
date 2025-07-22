package com.offerTrack.offerTrack.controller;

import com.offerTrack.offerTrack.model.IndicateursEntreprise;
import com.offerTrack.offerTrack.service.IndicateursEntrepriseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/")
public class IndicateursEntrepriseController {
    IndicateursEntrepriseService indicateursEntService;
    public IndicateursEntrepriseController(IndicateursEntrepriseService indicateursEntService){
        this.indicateursEntService = indicateursEntService;
    }
    @GetMapping("/api/indicateursEntreprise")
    public List<IndicateursEntreprise> getAllIndicateursEnt(){
        return indicateursEntService.getAllIndicateursEnt();
    }

    @GetMapping("/api/indicateursEntreprise/{id}")
    public IndicateursEntreprise getIndicateursEntById(@PathVariable("id") int id, IndicateursEntreprise indicateursEnt){
        return indicateursEntService.getIndicateursEntById(id);
    }

    @PostMapping("/api/indicateursEntreprise")
    public String createIndicateursEnt(IndicateursEntreprise indicateursEnt){
        indicateursEntService.createIndicateursEnt(indicateursEnt);
        return "Indicateurs Entreprise créés avec succès";
    }

    @PutMapping("/api/indicateusEntreprise/{id}")
    public String updateIndicateusEnt(@PathVariable("id") int id,IndicateursEntreprise indicateursEnt){
        indicateursEntService.updateIndicateursEntById(id,indicateursEnt);
        return "Indicateurs Entreprise mise à jour avec succès";
    }

    @DeleteMapping("/api/indicateusEntreprise/{id}")
    public String deleteIndicateusEnt(@PathVariable("id") int id){
        indicateursEntService.deleteIndicateursEntById(id);
        return "Indicateurs Entreprise suprimmées avec succès";
    }
}
