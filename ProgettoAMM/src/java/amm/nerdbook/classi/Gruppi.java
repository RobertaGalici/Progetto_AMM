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

public class Gruppi {
    
    private UtentiRegistrati[] utentiGruppo ;
    private int id;
    private String nome;
    
    public Gruppi(){
        id = 0;
        nome = "";
        utentiGruppo = new UtentiRegistrati[200];
    }

    
    /**
     * 
     * @param utentiGruppo set utenti del gruppo
     */
    public void setUtentiGruppo(UtentiRegistrati[] utentiGruppo) {
		
        if (utentiGruppo.length != 0){
            this.utentiGruppo = utentiGruppo;
        }
    }
    
    /**
     * 
     * @return utentiGruppo utenti del gruppo
     */
    public UtentiRegistrati[] getUtentiGruppo(){
        return utentiGruppo;
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
    
}