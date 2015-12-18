/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.eniso.myfirstapp.service;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tn.edu.eniso.myfirstapp.model.Utilisateur;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author amani
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class LoginService {

    @PersistenceContext
    EntityManager em;

    public LoginService() {
//        new Throwable().printStackTrace();
    }

    public Utilisateur login(String login, String password) throws SecurityException {
        List<Utilisateur> all = em.createQuery("Select u from Utilisateur u")
                .getResultList();
        if (all.isEmpty()) {
            Utilisateur u = new Utilisateur();
            u.setLogin("admin");
            u.setPassword("admin");
            u.setNom("admin");
            em.persist(u);
        }

        List<Utilisateur> ok = em.createQuery("Select u from Utilisateur u where u.login=:login and u.password=:password")
                .setParameter("login", login)
                .setParameter("password", password)
                .getResultList();
        if (ok.isEmpty()) {

            throw new SecurityException("Login or password Incorrect");
        }
        return ok.get(0);
    }
    
    public Utilisateur inscrip(String login, String pwd, String nom, String prenom, Date dateNaiss, String adresse,String ville, String telephone, String email){
        Utilisateur u=new Utilisateur();
        u.setLogin(login);
        u.setPassword(pwd);
        u.setNom(nom);
        u.setPrenom(prenom);
        u.setDateNaiss(dateNaiss);
        u.setAdresse(adresse);
        u.setVille(ville);
        u.setTelephone(telephone);
        u.setEmail(email);
        em.persist(u);
        return u;
    }
}
