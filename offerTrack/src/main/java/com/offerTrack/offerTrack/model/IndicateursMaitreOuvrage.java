package com.offerTrack.offerTrack.model;

import jakarta.persistence.*;

@Entity
@Table(name = "indicateursmaitreouvrage")
public class IndicateursMaitreOuvrage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "id_maitre_ouvrage")
    private int id_maitre_ouvrage;
    private int total_appels;
    private int total_participants;
    private float moyenne_participants_par_ao;
    private int appels_offres_attribues;
    private int total_rejets_admin;
    private int total_rejets_techniques;
    private int total_rejets_financiers;
    private float montant_total;
    private float taux_participation;
    private float taux_attribution;

    public IndicateursMaitreOuvrage() {
    }

    public IndicateursMaitreOuvrage(int id, int id_maitre_ouvrage, int total_appels, int total_participants, float moyenne_participants_par_ao, int appels_offres_attribues, int total_rejets_admin, int total_rejets_techniques, int total_rejets_financiers, float montant_total, float taux_participation, float taux_attribution) {
        this.id = id;
        this.id_maitre_ouvrage = id_maitre_ouvrage;
        this.total_appels = total_appels;
        this.total_participants = total_participants;
        this.moyenne_participants_par_ao = moyenne_participants_par_ao;
        this.appels_offres_attribues = appels_offres_attribues;
        this.total_rejets_admin = total_rejets_admin;
        this.total_rejets_techniques = total_rejets_techniques;
        this.total_rejets_financiers = total_rejets_financiers;
        this.montant_total = montant_total;
        this.taux_participation = taux_participation;
        this.taux_attribution = taux_attribution;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_maitre_ouvrage() {
        return id_maitre_ouvrage;
    }

    public void setId_maitre_ouvrage(int id_maitre_ouvrage) {
        this.id_maitre_ouvrage = id_maitre_ouvrage;
    }

    public int getTotal_appels() {
        return total_appels;
    }

    public void setTotal_appels(int total_appels) {
        this.total_appels = total_appels;
    }

    public int getTotal_participants() {
        return total_participants;
    }

    public void setTotal_participants(int total_participants) {
        this.total_participants = total_participants;
    }

    public float getMoyenne_participants_par_ao() {
        return moyenne_participants_par_ao;
    }

    public void setMoyenne_participants_par_ao(float moyenne_participants_par_ao) {
        this.moyenne_participants_par_ao = moyenne_participants_par_ao;
    }

    public int getAppels_offres_attribues() {
        return appels_offres_attribues;
    }

    public void setAppels_offres_attribues(int appels_offres_attribues) {
        this.appels_offres_attribues = appels_offres_attribues;
    }

    public int getTotal_rejets_admin() {
        return total_rejets_admin;
    }

    public void setTotal_rejets_admin(int total_rejets_admin) {
        this.total_rejets_admin = total_rejets_admin;
    }

    public int getTotal_rejets_techniques() {
        return total_rejets_techniques;
    }

    public void setTotal_rejets_techniques(int total_rejets_techniques) {
        this.total_rejets_techniques = total_rejets_techniques;
    }

    public int getTotal_rejets_financiers() {
        return total_rejets_financiers;
    }

    public void setTotal_rejets_financiers(int total_rejets_financiers) {
        this.total_rejets_financiers = total_rejets_financiers;
    }

    public float getMontant_total() {
        return montant_total;
    }

    public void setMontant_total(float montant_total) {
        this.montant_total = montant_total;
    }

    public float getTaux_participation() {
        return taux_participation;
    }

    public void setTaux_participation(float taux_participation) {
        this.taux_participation = taux_participation;
    }

    public float getTaux_attribution() {
        return taux_attribution;
    }

    public void setTaux_attribution(float taux_attribution) {
        this.taux_attribution = taux_attribution;
    }
}
