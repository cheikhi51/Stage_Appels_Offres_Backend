package com.offerTrack.offerTrack.model;

import jakarta.persistence.*;

@Entity
@Table(name = "montantconcurrent")
public class MontantConcurrent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int id_offre;
    private int id_concurrent;

    private boolean depot;

    private float montant_engagement_ttc;
    private float montant_engagement_ht;
    private float verification_montant_ttc;
    private  float verification_montant_ht;

    public MontantConcurrent() {
    }


    public MontantConcurrent(int id,int id_offre, int id_concurrent, boolean depot, float montant_engagement_ttc, float montant_engagement_ht, float verification_montant_ttc, float verification_montant_ht) {
        this.id = id;
        this.id_offre = id_offre;
        this.id_concurrent = id_concurrent;
        this.depot = depot;
        this.montant_engagement_ttc = montant_engagement_ttc;
        this.montant_engagement_ht = montant_engagement_ht;
        this.verification_montant_ttc = verification_montant_ttc;
        this.verification_montant_ht = verification_montant_ht;
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

    public boolean isDepot() {
        return depot;
    }

    public void setDepot(boolean depot) {
        this.depot = depot;
    }

    public float getMontant_engagement_ht() {
        return montant_engagement_ht;
    }

    public void setMontant_engagement_ht(float montant_engagement_ht) {
        this.montant_engagement_ht = montant_engagement_ht;
    }

    public float getMontant_engagement_ttc() {
        return montant_engagement_ttc;
    }

    public void setMontant_engagement_ttc(float montant_engagement_ttc) {
        this.montant_engagement_ttc = montant_engagement_ttc;
    }

    public float getVerification_montant_ttc() {
        return verification_montant_ttc;
    }

    public void setVerification_montant_ttc(float verification_montant_ttc) {
        this.verification_montant_ttc = verification_montant_ttc;
    }

    public float getVerification_montant_ht() {
        return verification_montant_ht;
    }

    public void setVerification_montant_ht(float verification_montant_ht) {
        this.verification_montant_ht = verification_montant_ht;
    }
}
