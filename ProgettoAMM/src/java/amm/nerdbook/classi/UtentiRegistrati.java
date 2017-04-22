/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;

/**
 *
 * @author Robi
 */
public class UtentiRegistrati {
    
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String urlProfilo;
    private String dataNascita;
    private String presentazione;
    
    public UtentiRegistrati() {
        id = 0;
        nome = "";
        cognome = "";
        email = "";
        password = "";
        urlProfilo = "";
        dataNascita = "";
        presentazione = "";
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * @return the nome
     */
    public String getNome(){
        return nome;
    }
    
    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }
    
    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * @return the urlProfilo
     */
    public String getUrlProfilo() {
        return urlProfilo;
    }

    /**
     * @param urlProfilo the urlProfilo to set
     */
    public void setUrlProfilo(String urlProfilo) {
        this.urlProfilo = urlProfilo;
    }
    
    /**
     * @return the dataNascita
     */
    public String getDataNascita() {
        return dataNascita;
    }

    /**
     * @param dataNascita the dataNascita to set
     */
    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }
    
    /**
     * @return the presentazione
     */
    public String getPresentazione() {
        return presentazione;
    }

    /**
     * @param presentazione the presentazione to set
     */
    public void setPresentazione(String presentazione) {
        this.presentazione = presentazione;
    }
    
    @Override
    public boolean equals(Object altroUtente) {
        if (altroUtente instanceof UtentiRegistrati)
            if (this.getId() == ((UtentiRegistrati)altroUtente).getId()) return true;
        return false;
    }

}


