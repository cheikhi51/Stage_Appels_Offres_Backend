package com.offerTrack.offerTrack.model;

import jakarta.persistence.*;

@Entity
@Table(name = "statutconcurrents")
public class StatutConcurrent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int id_offre;
    private int id_concurrent;
    private String statut_administratif;
    private String statut_technique;
    private String statut_financier;

    public StatutConcurrent() {
    }

    public StatutConcurrent(int id ,int id_offre, int id_concurrent, String statut_administratif, String statut_technique, String statut_financier) {
        this.id = id;
        this.id_offre = id_offre;
        this.id_concurrent = id_concurrent;
        this.statut_administratif = statut_administratif;
        this.statut_technique = statut_technique;
        this.statut_financier = statut_financier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public int getId_concurrent() {
        return id_concurrent;
    }

    public void setId_concurrent(int id_concurrent) {
        this.id_concurrent = id_concurrent;
    }

    public String getStatut_administratif() {
        return statut_administratif;
    }

    public void setStatut_administratif(String statut_administratif) {
        this.statut_administratif = statut_administratif;
    }

    public String getStatut_technique() {
        return statut_technique;
    }

    public void setStatut_technique(String statut_technique) {
        this.statut_technique = statut_technique;
    }

    public String getStatut_financier() {
        return statut_financier;
    }

    public void setStatut_financier(String statut_financier) {
        this.statut_financier = statut_financier;
    }
}
