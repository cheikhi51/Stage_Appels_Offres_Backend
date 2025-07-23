package com.offerTrack.offerTrack.dto;

import com.offerTrack.offerTrack.model.Role;
import lombok.*;

@Data
public class RegisterDto {
    private String nom;
    private String email;
    private String mot_de_passe;
    private Role role;

    public RegisterDto() {
    }

    public RegisterDto(String nom, String email, String mot_de_passe, Role role) {
        this.nom = nom;
        this.email = email;
        this.mot_de_passe = mot_de_passe;
        this.role = role;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
