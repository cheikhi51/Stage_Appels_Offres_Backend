package com.offerTrack.offerTrack.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "rapportgenere")
public class RapportGenere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int id_utilisateur;
    private String nom_utilisateur;
    private String contenu;
    private LocalDateTime date;

    public RapportGenere() {
    }

    public RapportGenere(int id, int id_utilisateur, String nom_utilisateur, String contenu, LocalDateTime date) {
        this.id = id;
        this.id_utilisateur = id_utilisateur;
        this.nom_utilisateur = nom_utilisateur;
        this.contenu = contenu;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getNom_utilisateur() {
        return nom_utilisateur;
    }

    public void setNom_utilisateur(String nom_utilisateur) {
        this.nom_utilisateur = nom_utilisateur;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
