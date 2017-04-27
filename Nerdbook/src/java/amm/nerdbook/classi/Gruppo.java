/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Robi
 */

public class Gruppo {

    
    
    private List <UtenteRegistrato> utenteGruppo ;
    private int id;
    private String nome;
    private String descrizione;
    
    public Gruppo(){
        id = 0;
        nome = " ";
        utenteGruppo = new ArrayList <>();
    }
       
    /**
     * 
     * @param utenteGruppo set utenti del gruppo
     */
    public void setUtentiGruppo(List <UtenteRegistrato> utenteGruppo) {
		
        if (utenteGruppo.size() != 0){
            this.utenteGruppo = utenteGruppo;
        }
    }
    
    public void addUtente(UtenteRegistrato utente){
        this.utenteGruppo.add(utente);
    }
    
    /**
     * 
     * @return utenteGruppo utenti del gruppo
     */
    public List <UtenteRegistrato> getUtentiGruppo(){
        return utenteGruppo;
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
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * @return the descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }
    
    /**
     * @param descrizione the descrizione to set
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
  
}