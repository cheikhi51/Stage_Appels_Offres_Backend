package com.offerTrack.offerTrack.controller;


import com.offerTrack.offerTrack.model.Offre;
import com.offerTrack.offerTrack.service.OffreService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/api/offresMO/{id_maitre_ouvrage}")
    @PreAuthorize("hasRole('MAITREOUVRAGE') or hasRole('ADMIN')")
    public List<Offre> getAllOffresByMOId(@PathVariable("id_maitre_ouvrage") int id_maitre_ouvrage){
        return offreService.findOffreByMaitreOuvrageId(id_maitre_ouvrage);
    }
    @PostMapping("/api/offres")
    @PreAuthorize("hasRole('CONCURRENT') or hasRole('ADMIN') or hasRole('MAITREOUVRAGE')")
    public String createOffre(@RequestBody Offre offre){
        offreService.createOffre(offre);
        return "Offre créé avec succès";
    }

    @PostMapping("/api/offres/{id}/participate")
    @PreAuthorize("hasRole('CONCURRENT') or hasRole('ADMIN') or hasRole('MAITREOUVRAGE')")
    public ResponseEntity<?> addParticipant(@PathVariable("id") int id, @RequestBody Map<String, Object> request) {
        try {
            // Extract userId from request body
            Object userIdObj = request.get("userId");
            Integer userId = null;

            if (userIdObj instanceof Integer) {
                userId = (Integer) userIdObj;
            } else if (userIdObj instanceof String) {
                userId = Integer.parseInt((String) userIdObj);
            }

            if (userId == null) {
                return ResponseEntity.badRequest().body(createErrorResponse("User ID is required"));
            }

            // Use service method to add participant
            String result = offreService.addParticipantToOffre(id, userId);

            // Check if the result indicates success
            if (result.contains("succès")) {
                return ResponseEntity.ok(createSuccessResponse(result));
            } else {
                return ResponseEntity.badRequest().body(createErrorResponse(result));
            }

        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body(createErrorResponse("Invalid user ID format"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(createErrorResponse("An error occurred: " + e.getMessage()));
        }
    }

    // Optional: Remove participant endpoint
    @DeleteMapping("/api/offres/{id}/participate/{userId}")
    @PreAuthorize("hasRole('CONCURRENT') or hasRole('ADMIN') or hasRole('MAITREOUVRAGE')")
    public ResponseEntity<?> removeParticipant(@PathVariable("id") int id, @PathVariable("userId") int userId) {
        try {
            String result = offreService.removeParticipantFromOffre(id, userId);

            if (result.contains("succès")) {
                return ResponseEntity.ok(createSuccessResponse(result));
            } else {
                return ResponseEntity.badRequest().body(createErrorResponse(result));
            }

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(createErrorResponse("An error occurred: " + e.getMessage()));
        }
    }

    // Helper method to get participation status for a user
    @GetMapping("/api/offres/{id}/participation-status/{userId}")
    @PreAuthorize("hasRole('CONCURRENT') or hasRole('ADMIN') or hasRole('MAITREOUVRAGE')")
    public ResponseEntity<?> getParticipationStatus(@PathVariable("id") int id, @PathVariable("userId") int userId) {
        try {
            boolean hasParticipated = offreService.hasUserParticipated(id, userId);
            int participantCount = offreService.getParticipantCount(id);

            Map<String, Object> response = new HashMap<>();
            response.put("hasParticipated", hasParticipated);
            response.put("participantCount", participantCount);
            response.put("offreId", id);
            response.put("userId", userId);
            response.put("success", true);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(createErrorResponse("An error occurred: " + e.getMessage()));
        }
    }

    // Get participant count for an offre
    @GetMapping("/api/offres/{id}/participants/count")
    @PreAuthorize("hasRole('CONCURRENT') or hasRole('ADMIN') or hasRole('MAITREOUVRAGE')")
    public ResponseEntity<?> getParticipantCount(@PathVariable("id") int id) {
        try {
            int count = offreService.getParticipantCount(id);

            Map<String, Object> response = new HashMap<>();
            response.put("participantCount", count);
            response.put("offreId", id);
            response.put("success", true);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(createErrorResponse("An error occurred: " + e.getMessage()));
        }
    }
    @PutMapping("/api/offres/{id}")
    @PreAuthorize("hasRole('CONCURRENT') or hasRole('ADMIN') or hasRole('MAITREOUVRAGE')")
    public String updateOffreById(@PathVariable("id") int id,@RequestBody  Offre offre){
        offreService.updateOffreById(id,offre);
        return "Offre mis à jour avec succès";
    }
    @DeleteMapping("/api/offres/{id}")
    @PreAuthorize("hasRole('CONCURRENT') or hasRole('ADMIN') or hasRole('MAITREOUVRAGE')")
    public String deleteOffreById(@PathVariable("id") int id){
        offreService.deleteOffreById(id);
        return "Offre supprimée avec succès";
    }

    // Helper methods to create consistent response format
    private Map<String, Object> createSuccessResponse(String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("success", true);
        return response;
    }

    private Map<String, Object> createErrorResponse(String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("success", false);
        return response;
    }
}
