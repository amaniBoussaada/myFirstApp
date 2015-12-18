/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.eniso.myfirstapp.model;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;


/**
 *
 * @author amani
 */
@Entity
public class InfoProf implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    private String NiveauEtude;
    private String NiveauExp;
    private String metier;
    private String secteurAct;
    private String typePoste;
    private String titreProf;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNiveauEtude() {
        return NiveauEtude;
    }

    public void setNiveauEtude(String NiveauEtude) {
        this.NiveauEtude = NiveauEtude;
    }

    public String getNiveauExp() {
        return NiveauExp;
    }

    public void setNiveauExp(String NiveauExp) {
        this.NiveauExp = NiveauExp;
    }

    public String getMetier() {
        return metier;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }

    public String getSecteurAct() {
        return secteurAct;
    }

    public void setSecteurAct(String secteurAct) {
        this.secteurAct = secteurAct;
    }

    public String getTypePoste() {
        return typePoste;
    }

    public void setTypePoste(String typePoste) {
        this.typePoste = typePoste;
    }

    public String getTitreProf() {
        return titreProf;
    }

    public void setTitreProf(String titreProf) {
        this.titreProf = titreProf;
    }
    
    
}
