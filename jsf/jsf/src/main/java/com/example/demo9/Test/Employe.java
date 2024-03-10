package com.example.demo9.Test;

import com.example.demo9.db.Conix;
import lombok.Getter;

import javax.faces.bean.ManagedBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;


@ManagedBean
public class Employe {
    String nom;
    String prenom;
    String naissance;




    String email;
    int id;


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNaissance() {
        return naissance;
    }

    public void setNaissance(String naissance) {
        this.naissance = naissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void ajouter() {
        try (Connection conn = Conix.getConnection();
             PreparedStatement pr = conn.prepareStatement("INSERT INTO employee(NAME, DEPARTEMENT, EMAIL, BRTHD) VALUES (?, ?, ?, ?)")) {
            pr.setString(1, this.nom);
            pr.setString(2, this.prenom);
            // Conversion java.util.Date à java.sql.Date si nécessaire.

            pr.setString(3, this.email);
            pr.setString(4,this.naissance);
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
