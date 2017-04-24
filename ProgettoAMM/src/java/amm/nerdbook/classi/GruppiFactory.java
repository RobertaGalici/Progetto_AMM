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

public class GruppiFactory {
    
    //Pattern Design Singleton
    private static GruppiFactory singleton;

    public static GruppiFactory getInstance() {
        if (singleton == null) {
            singleton = new GruppiFactory();
        }
        return singleton;
    }

    private ArrayList<Post> listaGruppiPost = new ArrayList<Post>();

    private GruppiFactory() {
        
        UtentiRegistratiFactory utentiRegistratiFactory = UtentiRegistratiFactory.getInstance();

        //Creazione Post
        Post post1 = new Post();
        post1.setContent("La Sony ha sviluppato anche la PlayStation Camera, che rileva la posizione del DualShock 4 attraverso la LED Light Bar");
        post1.setId(5);
        post1.setUser(utentiRegistratiFactory.getUtentiRegistratiById(5));

        Post post2 = new Post();
        post2.setContent("Nintendo fu fondata da Fusajiro Yamauchi il 23 settembre 1889 a Kyoto con il nome di Nintendo Koppai.");
        post2.setId(6);
        post2.setUser(utentiRegistratiFactory.getUtentiRegistratiById(6));
       
        listaGruppiPost.add(post1);
        listaGruppiPost.add(post2);
    }

    public Post getPostById(int id) {
        for (Post post : this.listaGruppiPost) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    public List getPostList(UtentiRegistrati gruppi) {

        List<Post> listaGruppiPost = new ArrayList<Post>();

        for (Post post : this.listaGruppiPost) {
            if (post.getUser().equals(gruppi)) {
                listaGruppiPost.add(post);
            }
        }
        return listaGruppiPost;
    }
    
}
