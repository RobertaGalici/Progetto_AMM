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
        
        UtentiRegistratiFactory utentiRegistratiFactory = UtentiRegistratiFactory.getInstance();

        //Creazione Post
        Post post1 = new Post();
        post1.setContent("Luigi, ti aspetto in pista!");
        post1.setId(0);
        post1.setUser(utentiRegistratiFactory.getUtentiRegistratiById(0));

        Post post2 = new Post();
        post2.setContent("Preparati ad affrontare la mia ira, Crash Bandicoot!");
        post2.setId(1);
        post2.setUser(utentiRegistratiFactory.getUtentiRegistratiById(0));
        post2.setPostType(Post.Type.IMAGE);
        
        Post post3 = new Post();
        post3.setContent("Ehi Cortex, dai un'occhiata qua: https://www.youtube.com/watch?v=DYjcZ5e5-iM");
        post3.setId(2);
        post3.setUser(utentiRegistratiFactory.getUtentiRegistratiById(1));
        
        Post post4 = new Post();
        post4.setContent("Mario, guarda come eravamo giovani!");
        post4.setId(3);
        post4.setUser(utentiRegistratiFactory.getUtentiRegistratiById(1));
        post4.setPostType(Post.Type.IMAGE);

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

    public List getPostList(UtentiRegistrati ureg) {

        List<Post> listaPost = new ArrayList<Post>();

        for (Post post : this.listaPost) {
            if (post.getUser().equals(ureg)) {
                listaPost.add(post);
            }
        }
        return listaPost;
    }
}

