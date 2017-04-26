/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;
import java.util.ArrayList;
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

        //Luigi
        UtenteRegistrato utente2 = new UtenteRegistrato();
        utente2.setId(1);
        utente2.setNome("Luigi");
        utente2.setCognome("Bros");
        utente2.setEmail("luigino@gmail.com");
        utente2.setDataNascita("16/07/1930");
        utente2.setPassword("1234");
        utente2.setUrlProfilo("");
        utente2.setPresentazione("Ciao, sono Luigi!");
        
        //Crash Bandicoot
        UtenteRegistrato utente3 = new UtenteRegistrato();
        utente3.setId(2);
        utente3.setNome("Crash");
        utente3.setCognome("Bandicoot");
        utente3.setEmail("crashbandicoot@gmail.com");
        utente3.setPassword("5678");
        utente3.setUrlProfilo("");
        utente3.setPresentazione("Ciao, sono Crash!");
        
        //Neo Cortex
        UtenteRegistrato utente4 = new UtenteRegistrato();
        utente4.setId(2);
        utente4.setNome("Neo");
        utente4.setCognome("Cortex");
        utente4.setEmail("cortex@gmail.com");
        utente4.setPassword("9001");
        utente4.setUrlProfilo("");
        utente4.setPresentazione("Ciao, sono Cortex e sono un super cattivo! Mhuahahahah");
       

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
}
