/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Robi
 */
public class UtenteRegistratoFactory {

    //Pattern Design Singleton
    private static UtenteRegistratoFactory singleton;

    public static UtenteRegistratoFactory getInstance() {
        if (singleton == null) {
            singleton = new UtenteRegistratoFactory();
        }
        return singleton;
    }

    private ArrayList<UtenteRegistrato> listaUtentiRegistrati = new ArrayList<UtenteRegistrato>();

    private UtenteRegistratoFactory() {
        //Creazione utenti

        //Mario
        UtenteRegistrato utente1 = new UtenteRegistrato();
        utente1.setId(0);
        utente1.setNome("Mario");
        utente1.setCognome("Bros");
        utente1.setEmail("mariobros@gmail.com");
        utente1.setDataNascita("10/03/1900");
        utente1.setPassword("0000");
        utente1.setUrlProfilo("img/SuperMario.jpg");
        utente1.setPresentazione("Ciao, sono Mario!");
        
        //Neo Cortex
        UtenteRegistrato utente2 = new UtenteRegistrato();
        utente2.setId(2);
        utente2.setNome("Neo");
        utente2.setCognome("Cortex");
        utente2.setEmail("cortex@gmail.com");
        utente2.setPassword("9001");
        utente2.setUrlProfilo("");
        utente2.setPresentazione("Ciao, sono Cortex e sono un super cattivo! Mhuahahahah");
        
        //Crash Bandicoot
        UtenteRegistrato utente3 = new UtenteRegistrato();
        utente3.setId(2);
        utente3.setNome("Crash");
        utente3.setCognome("Bandicoot");
        utente3.setEmail("crashbandicoot@gmail.com");
        utente3.setPassword("5678");
        utente3.setUrlProfilo("");
        utente3.setPresentazione("Ciao, sono Crash!");

        //Luigi
        UtenteRegistrato utente4 = new UtenteRegistrato();
        utente4.setId(1);
        utente4.setNome("Luigi");
        utente4.setCognome("Bros");
        utente4.setEmail("luigino@gmail.com");
        utente4.setDataNascita("16/07/1930");
        utente4.setPassword("1234");
        utente4.setUrlProfilo("");
        utente4.setPresentazione("Ciao, sono Luigi!");

        listaUtentiRegistrati.add(utente1);
        listaUtentiRegistrati.add(utente2);
        listaUtentiRegistrati.add(utente3);
        listaUtentiRegistrati.add(utente4);
    }

    public UtenteRegistrato getUtentiRegistratiById(int id) {
        for (UtenteRegistrato user : this.listaUtentiRegistrati) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
    
    public int getIdByUserAndPassword(String user, String password){
        for(UtenteRegistrato utente : this.listaUtentiRegistrati){
            if(utente.getNome().equals(user) && utente.getPassword().equals(password)){
                return utente.getId();
            }
        }
        return -1;
    }

    public UtenteRegistrato getUserById(int loggedUserId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List getUserList() {
        return listaUtentiRegistrati;
    }
}
