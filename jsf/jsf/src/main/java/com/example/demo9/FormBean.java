package com.example.demo9;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class FormBean {
    private String name;
    private String surname;
    private String password;
    private float note;

    public FormBean(String name, String surname, String password, float note) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.note = note;
    }

    public FormBean() {
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
// Getter and Setter methods for name, surname, and password

    public String submit() {
        // Place your logic for form submission here
        return "result"; // Navigation case to redirect to result page
    }

    public Boolean func(){
        return !(note <= 20 && note >= 0);
    }
}
