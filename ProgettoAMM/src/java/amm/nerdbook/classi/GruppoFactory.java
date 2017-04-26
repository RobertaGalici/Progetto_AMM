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
import java.util.List;
import java.util.ArrayList;

public class GruppoFactory {
    
    //Pattern Design Singleton
    private static GruppoFactory singleton;

    public static GruppoFactory getInstance() {
        if (singleton == null) {
            singleton = new GruppoFactory();
        }
        return singleton;
    }

    private ArrayList<Gruppo> listaGruppoPost = new ArrayList<Gruppo>();

    private GruppoFactory() {
        
        UtenteRegistratoFactory utentiRegistratiFactory = UtenteRegistratoFactory.getInstance();
        
        UtenteRegistrato u0 = utentiRegistratiFactory.getUtentiRegistratiById(0);
        UtenteRegistrato u1 = utentiRegistratiFactory.getUtentiRegistratiById(1);
        UtenteRegistrato u2 = utentiRegistratiFactory.getUtentiRegistratiById(2);
        UtenteRegistrato u3 = utentiRegistratiFactory.getUtentiRegistratiById(3);
        
        Gruppo gruppo1 = new Gruppo();
        gruppo1.setId(0);
        gruppo1.addUtente(u0);
        gruppo1.addUtente(u1);
        gruppo1.setNome("Nintendo");
        gruppo1.setDescrizione("Ciao a tutti, se siete dei grandi fan della Nintendo, unitevi a noi!");

        Gruppo gruppo2 = new Gruppo();
        gruppo2.addUtente(u2);
        gruppo2.addUtente(u3);
        gruppo2.setId(1);
        gruppo2.setNome("Playstation");
        gruppo2.setDescrizione("Ciao a tutti, se siete dei grandi fan della Sony, quindi della playstation unitevi a noi!");

        listaGruppoPost.add(gruppo1);
        listaGruppoPost.add(gruppo2);
    }
    
    public Gruppo getGroupById(int id) {
        for (Gruppo gruppo : this.listaGruppoPost) {
            if (gruppo.getId() == id) {
                return gruppo;
            }
        }
        return null;
    }
}