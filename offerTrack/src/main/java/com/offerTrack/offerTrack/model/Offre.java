package com.offerTrack.offerTrack.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "offre")
public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_offre;

    @Column(name = "id_maitre_ouvrage")
    private int id_maitre_ouvrage;

    private String reference_num;
    private String objet;
    private String lieu;
    private LocalDateTime date_limite;
    private int num_ordre;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut_admin")
    private StatutEnum statut_admin;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut_tech")
    private StatutEnum statut_tech;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut_financier")
    private StatutEnum statut_financier;

    private String publication_portail;
    private String informations_additionnelles;

    // Store participant IDs as a comma-separated string in the database
    @Column(name = "participant_ids", columnDefinition = "TEXT")
    @JsonIgnore // Don't expose the raw string to the frontend
    private String participantIdsString;

    // Transient field to handle the list of participant IDs
    @Transient
    private List<Integer> participantIds = new ArrayList<>();

    // Transient field to get participant count
    @Transient
    private int participantCount;

    public void setParticipantCount(int participantCount) {
        this.participantCount = participantCount;
    }


    public Offre() {
    }

    public Offre(int id_offre, int id_maitre_ouvrage, String reference_num, String objet, String lieu, LocalDateTime date_limite, int num_ordre, StatutEnum statut_admin, StatutEnum statut_tech, StatutEnum statut_financier, String publication_portail, String informations_additionnelles, String participantIdsString, List<Integer> participantIds, int participantCount) {
        this.id_offre = id_offre;
        this.id_maitre_ouvrage = id_maitre_ouvrage;
        this.reference_num = reference_num;
        this.objet = objet;
        this.lieu = lieu;
        this.date_limite = date_limite;
        this.num_ordre = num_ordre;
        this.statut_admin = statut_admin;
        this.statut_tech = statut_tech;
        this.statut_financier = statut_financier;
        this.publication_portail = publication_portail;
        this.informations_additionnelles = informations_additionnelles;
        this.participantIdsString = participantIdsString;
        this.participantIds = participantIds;
        this.participantCount = participantCount;
    }

    // Method to add a participant
    public void addParticipant(int userId) {
        if (participantIds == null) {
            participantIds = new ArrayList<>();
        }
        if (!participantIds.contains(userId)) {
            participantIds.add(userId);
            updateParticipantIdsString();
        }
    }

    // Method to remove a participant
    public void removeParticipant(int userId) {
        if (participantIds != null) {
            participantIds.remove(Integer.valueOf(userId));
            updateParticipantIdsString();
        }
    }

    // Method to check if user has participated
    public boolean hasParticipated(int userId) {
        return participantIds != null && participantIds.contains(userId);
    }

    // Update the string representation of participant IDs
    private void updateParticipantIdsString() {
        if (participantIds == null || participantIds.isEmpty()) {
            this.participantIdsString = "";
        } else {
            this.participantIdsString = participantIds.stream()
                    .map(String::valueOf)
                    .reduce((a, b) -> a + "," + b)
                    .orElse("");
        }
    }

    // Parse participant IDs from string after loading from database
    @PostLoad
    private void parseParticipantIds() {
        if (participantIdsString != null && !participantIdsString.trim().isEmpty()) {
            participantIds = new ArrayList<>();
            String[] ids = participantIdsString.split(",");
            for (String id : ids) {
                try {
                    participantIds.add(Integer.parseInt(id.trim()));
                } catch (NumberFormatException e) {
                    // Skip invalid IDs
                }
            }
        } else {
            participantIds = new ArrayList<>();
        }
        this.participantCount = participantIds.size();
    }

    // Update string before saving to database
    @PrePersist
    @PreUpdate
    private void updateStringBeforeSave() {
        updateParticipantIdsString();
    }

    // All your existing getters and setters...
    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public int getId_maitre_ouvrage() {
        return id_maitre_ouvrage;
    }

    public void setId_maitre_ouvrage(int id_maitre_ouvrage) {
        this.id_maitre_ouvrage = id_maitre_ouvrage;
    }

    public String getReference_num() {
        return reference_num;
    }

    public void setReference_num(String reference_num) {
        this.reference_num = reference_num;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public StatutEnum getStatut_admin() {
        return statut_admin;
    }

    public void setStatut_admin(StatutEnum statut_admin) {
        this.statut_admin = statut_admin;
    }

    public StatutEnum getStatut_tech() {
        return statut_tech;
    }

    public void setStatut_tech(StatutEnum statut_tech) {
        this.statut_tech = statut_tech;
    }

    public StatutEnum getStatut_financier() {
        return statut_financier;
    }

    public void setStatut_financier(StatutEnum statut_financier) {
        this.statut_financier = statut_financier;
    }

    public LocalDateTime getDate_limite() {
        return date_limite;
    }

    public void setDate_limite(LocalDateTime date_limite) {
        this.date_limite = date_limite;
    }

    public int getNum_ordre() {
        return num_ordre;
    }

    public void setNum_ordre(int num_ordre) {
        this.num_ordre = num_ordre;
    }

    public String getPublication_portail() {
        return publication_portail;
    }

    public void setPublication_portail(String publication_portail) {
        this.publication_portail = publication_portail;
    }

    public String getInformations_additionnelles() {
        return informations_additionnelles;
    }

    public void setInformations_additionnelles(String informations_additionnelles) {
        this.informations_additionnelles = informations_additionnelles;
    }

    // New getters and setters for participants
    public String getParticipantIdsString() {
        return participantIdsString;
    }

    public void setParticipantIdsString(String participantIdsString) {
        this.participantIdsString = participantIdsString;
        parseParticipantIds(); // Parse when setting the string
    }

    public List<Integer> getParticipantIds() {
        return participantIds;
    }

    public void setParticipantIds(List<Integer> participantIds) {
        this.participantIds = participantIds;
        updateParticipantIdsString();
    }

    public int getParticipantCount() {
        return participantIds != null ? participantIds.size() : 0;
    }
}