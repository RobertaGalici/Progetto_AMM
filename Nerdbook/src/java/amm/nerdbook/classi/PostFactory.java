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

public class PostFactory {

    //Pattern Design Singleton
    private static PostFactory singleton;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }

    private ArrayList<Post> listaPost = new ArrayList<Post>();

    private PostFactory() {
        
        UtenteRegistratoFactory utentiRegistratiFactory = UtenteRegistratoFactory.getInstance();

        //Creazione Post
        Post post1 = new Post();
        post1.setContentImmagine("");
        post1.setContentLink("");
        post1.setContentText("Luigi, ti aspetto in pista!");
        post1.setId(0);
        post1.setUser(utentiRegistratiFactory.getUtentiRegistratiById(0));

        Post post2 = new Post();
        post2.setContentImmagine("");
        post2.setContentLink("");
        post2.setContentText("Preparati ad affrontare la mia ira, Crash Bandicoot!");
        post2.setId(1);
        post2.setUser(utentiRegistratiFactory.getUtentiRegistratiById(0));
        post2.setPostType(Post.Type.IMAGE);
        
        Post post3 = new Post();
        post3.setContentImmagine("");
        post3.setContentLink("");
        post3.setContentText("Ehi Cortex, dai un'occhiata qua: https://www.youtube.com/watch?v=DYjcZ5e5-iM");
        post3.setId(2);
        post3.setUser(utentiRegistratiFactory.getUtentiRegistratiById(1));
        
        Post post4 = new Post();
        
        post4.setId(3);
        post4.setUser(utentiRegistratiFactory.getUtentiRegistratiById(1));
        post4.setPostType(Post.Type.IMAGE);
        post4.setContentImmagine("");
        post4.setContentLink("");
        post4.setContentText("Mario, guarda come eravamo giovani!");
        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
        listaPost.add(post4);
    }

    public Post getPostById(int id) {
        for (Post post : this.listaPost) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    public List getPostList(UtenteRegistrato users) {

        List<Post> listaPost = new ArrayList<Post>();

        for (Post post : this.listaPost) {
            if (post.getUser().equals(users)) {
                listaPost.add(post);
            }
        }
        return listaPost;
    }

}
