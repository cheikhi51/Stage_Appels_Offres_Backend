package com.offerTrack.offerTrack.controller;


import com.offerTrack.offerTrack.model.StatutConcurrent;
import com.offerTrack.offerTrack.service.StatutConcurrentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/")
public class StatutConcurrentController {
    StatutConcurrentService statutConcurrentService;
    public StatutConcurrentController(StatutConcurrentService statutConcurrentService){
        this.statutConcurrentService = statutConcurrentService;
    }
    @GetMapping("/api/statutConcurrent")
    public List<StatutConcurrent> getAllStatutConcurrent(){
        return statutConcurrentService.getAllStatutConcurrent();
    }

    @GetMapping("/api/statutConcurrent/{id}")
    public StatutConcurrent getStatutConcurrent(@PathVariable("id") int id){
        return statutConcurrentService.getStatutConcurrentById(id);
    }

    @PostMapping("/api/statutConcurrent")
    public  String createStatutConcurrent(StatutConcurrent statutConcurrent){
        statutConcurrentService.createStatutConcurrent(statutConcurrent);
        return "Statut Concurrent créé avec succès";
    }

    @PutMapping("/api/statutConcurrent/{id}")
    public String updateStatutConcurrent(@PathVariable("id") int id,StatutConcurrent statutConcurrent){
        statutConcurrentService.updateStatutConcurrentById(id, statutConcurrent);
        return "Statut Concurrent mis à jour avec succès ";
    }

    @DeleteMapping("/api/statutConcurrent/{id}")
    public String deleteStatutConcurrent(@PathVariable("id") int id){
        statutConcurrentService.deleteStatutConcurrent(id);
        return "Statut Concurrent supprimé avec succès";
    }

}
