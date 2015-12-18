/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.eniso.myfirstapp.web;

import java.io.Serializable;
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
public class LoginCtrl implements Serializable{
 
    private final Model model=new Model();

    public LoginCtrl() {
//        new Throwable().printStackTrace();
    }

    public Model getModel() {
        return model;
    }

    @Autowired
    private LoginService loginService;
    
   public String login(){
       String l=getModel().getLogin();
       String p=getModel().getPassword();
       try{model.setErrorMessage("");
           Utilisateur u=loginService.login(l, p);
           model.setMessage("Bienvenu");
           
           return "profil";
           
       }
       catch(Exception ex){
           ex.printStackTrace();
           model.setErrorMessage("Invalid UserName or password !!");
           return null;
       }
   }
   public String logout(){
       return "index";
   }
    public String signIn(){
       return "inscription";
   }
    
    public static class Model implements Serializable{
        private String login;
        private String password;
        private String message;
        private String errorMessage;

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

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
        
        
    }
}
