/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.eniso.myfirstapp.web;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import tn.edu.eniso.myfirstapp.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import tn.edu.eniso.myfirstapp.service.LoginService;

/**
 *
 * @author amani
 */
@Controller
//@ManagedBean
@Scope("session")
public class InscripCtrl implements Serializable {

    private final Model model = new Model();

    public InscripCtrl() {
//        new Throwable().printStackTrace();
    }

    public Model getModel() {
        return model;
    }

    @Autowired
    private LoginService loginService;

    public String signIn() {
        try {
            model.setErrorMessage("");
            Utilisateur u = loginService.inscrip(getModel().getLogin(), getModel().getPassword(), getModel().getNom(), getModel().getPrenom(),getModel().getDate1(), getModel().getAdresse(),getModel().getVille(), getModel().getTelephone(), getModel().getEmail());

            return "profil";

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String logout() {
        return "index";
    }

     
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
     
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }
 
   
    public static class Model implements Serializable {
        private Date date1;
        private String login;
        private String password;
        private String errorMessage;
        private String prenom;
        private String nom;
        private Date dateNaiss;
        private String adresse;
        private String ville;
        private String telephone;
        private String email;

         public Date getDate1() {
        return date1;
    }

        public void setDate1(Date date1) {
            this.date1 = date1;
        }
         

        public String getPrenom() {
            return prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public Date getDateNaiss() {
            return dateNaiss;
        }

        public void setDateNaiss(Date dateNaiss) {
            this.dateNaiss = dateNaiss;
        }

       

        public String getAdresse() {
            return adresse;
        }

        public void setAdresse(String adresse) {
            this.adresse = adresse;
        }

        public String getVille() {
            return ville;
        }

        public void setVille(String ville) {
            this.ville = ville;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
        
        

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    }
}
