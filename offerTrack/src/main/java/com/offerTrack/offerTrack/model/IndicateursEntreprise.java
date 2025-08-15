package com.offerTrack.offerTrack.model;

import jakarta.persistence.*;

@Entity
@Table(name = "indicateursentreprise")
public class IndicateursEntreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "id_concurrent")
    private int id_concurrent;
    private int nb_ao_total;
    private int nb_ao_reussis;
    private int nb_refus_admin;
    private int nb_refus_tech;
    private int nb_refus_fin;
    private float gain_total;
    private float part_marche;
    private float taux_reussite;

    public IndicateursEntreprise() {
    }

    public IndicateursEntreprise(int id, int id_concurrent, int nb_ao_total, int nb_ao_reussis, int nb_refus_admin, int nb_refus_tech, int nb_refus_fin, float gain_total, float part_marche, float taux_reussite) {
        this.id = id;
        this.id_concurrent = id_concurrent;
        this.nb_ao_total = nb_ao_total;
        this.nb_ao_reussis = nb_ao_reussis;
        this.nb_refus_admin = nb_refus_admin;
        this.nb_refus_tech = nb_refus_tech;
        this.nb_refus_fin = nb_refus_fin;
        this.gain_total = gain_total;
        this.part_marche = part_marche;
        this.taux_reussite = taux_reussite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_concurrent() {
        return id_concurrent;
    }

    public void setId_concurrent(int id_concurrent) {
        this.id_concurrent = id_concurrent;
    }

    public int getNb_ao_total() {
        return nb_ao_total;
    }

    public void setNb_ao_total(int nb_ao_total) {
        this.nb_ao_total = nb_ao_total;
    }

    public int getNb_ao_reussis() {
        return nb_ao_reussis;
    }

    public void setNb_ao_reussis(int nb_ao_reussis) {
        this.nb_ao_reussis = nb_ao_reussis;
    }

    public int getNb_refus_admin() {
        return nb_refus_admin;
    }

    public void setNb_refus_admin(int nb_refus_admin) {
        this.nb_refus_admin = nb_refus_admin;
    }

    public int getNb_refus_tech() {
        return nb_refus_tech;
    }

    public void setNb_refus_tech(int nb_refus_tech) {
        this.nb_refus_tech = nb_refus_tech;
    }

    public int getNb_refus_fin() {
        return nb_refus_fin;
    }

    public void setNb_refus_fin(int nb_refus_fin) {
        this.nb_refus_fin = nb_refus_fin;
    }

    public float getGain_total() {
        return gain_total;
    }

    public void setGain_total(float gain_total) {
        this.gain_total = gain_total;
    }

    public float getPart_marche() {
        return part_marche;
    }

    public void setPart_marche(float part_marche) {
        this.part_marche = part_marche;
    }

    public float getTaux_reussite() {
        return taux_reussite;
    }

    public void setTaux_reussite(float taux_reussite) {
        this.taux_reussite = taux_reussite;
    }
}
