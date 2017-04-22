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
public class UtentiRegistratiFactory {

    //Pattern Design Singleton
    private static UtentiRegistratiFactory singleton;

    public static UtentiRegistratiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiRegistratiFactory();
        }
        return singleton;
    }

    private ArrayList<UtentiRegistrati> listaUtentiRegistrati = new ArrayList<UtentiRegistrati>();

    private UtentiRegistratiFactory() {
        //Creazione utenti

        //Mario
        UtentiRegistrati utente1 = new UtentiRegistrati();
        utente1.setId(0);
        utente1.setNome("Mario");
        utente1.setCognome("Bros");
        utente1.setEmail("mariobros@gmail.com");
        utente1.setDataNascita("10/03/1900");
        utente1.setPassword("0000");
        utente1.setUrlProfilo("img/SuperMario.jpg");
        utente1.setPresentazione("Ciao, sono Mario!");

        //Luigi
        UtentiRegistrati utente2 = new UtentiRegistrati();
        utente2.setId(1);
        utente2.setNome("Luigi");
        utente2.setCognome("Bros");
        utente2.setEmail("luigino@gmail.com");
        utente2.setDataNascita("16/07/1930");
        utente2.setPassword("1234");
        utente2.setUrlProfilo("");
        utente2.setPresentazione("Ciao, sono Luigi!");
        
        //Crash Bandicoot
        UtentiRegistrati utente3 = new UtentiRegistrati();
        utente3.setId(2);
        utente3.setNome("Crash");
        utente3.setCognome("Bandicoot");
        utente3.setEmail("crashbandicoot@gmail.com");
        utente3.setPassword("5678");
        utente3.setUrlProfilo("");
        utente3.setPresentazione("Ciao, sono Crash!");
        
        //Neo Cortex
        UtentiRegistrati utente4 = new UtentiRegistrati();
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

    public UtentiRegistrati getUtentiRegistratiById(int id) {
        for (UtentiRegistrati user : this.listaUtentiRegistrati) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
