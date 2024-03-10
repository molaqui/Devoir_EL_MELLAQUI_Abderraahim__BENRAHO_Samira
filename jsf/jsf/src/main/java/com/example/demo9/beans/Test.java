package com.example.demo9.beans;

import com.example.demo9.models.Employee;
import  com.example.demo9.db.*;
import javax.faces.bean.ManagedBean;

import java.sql.*;
import java.util.ArrayList;

@ManagedBean
public class Test {
    String nom;
    String prenom;
    java.util.Date naissance;

    String email;



    public void addEmployee(){
        Connection connection=Conix.getConnection();
        try {
            PreparedStatement pst=connection.prepareStatement("insert into employee(NAME,DEPARTEMENT,EMAIL,BRTHD) values(?,?,?,?) ");
            pst.setString(1,nom);
            pst.setString(2,prenom);

            pst.setString(3,email);
            pst.setDate(4, (Date) naissance);
            pst.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
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

    public java.util.Date getNaissance() {
        return naissance;
    }

    public void setNaissance(java.util.Date naissance) {
        this.naissance = naissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }










}
