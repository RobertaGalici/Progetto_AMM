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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
     public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
	return this.connectionString;
    }
    
    private ArrayList<Post> listaPost = new ArrayList<Post>();
    private String connectionString;

    private PostFactory() {}

    public Post getPostById(int id) {
        UtenteRegistratoFactory utenteFactory = UtenteRegistratoFactory.getInstance();
        try{
            Connection conn = DriverManager.getConnection(connectionString, "nerd", "nerd"); 
            
            //query di stringa
            String query = 
                    "select * from post "
                    + "join tipoPost on tipoUrl.tipo = tipoPost.id" // al posto di id = idTipoPost da fare
                    + "where id = ?"; //id = idPost 
          
            PreparedStatement stmt = conn.prepareStatement(query); //processa query
            
            stmt.setInt(1, id);
            
            ResultSet res = stmt.executeQuery();
            
            if(res.next()){
                Post user = new Post();
                
                //imposto id del post
                user.setId(res.getInt("id")); //idPost
                user.setUser(res.getString("utente"));
                //impost il contenuto del post
                user.setContentText(res.getString("contentText"));
                //imposto il tipo del post
                user.setPostType(this.postTypeFromString(res.getString("tipoPost")));
                UtenteRegistrato utente = utenteFactory.getUtentiRegistratiById(res.getInt("utente"));
                //imposto l'autore del post
                user.setUser(utente);
                
                stmt.close();
                conn.close();
                return user;
            }
            stmt.close();
            conn.close();
               
        }
        catch(SQLException e ){}
        
        return null;
        
    }
    
    private Post.Type postTypeFromString(String type){
        
        if(type.equals("IMAGE"))
            return Post.Type.IMAGE;
        else{
            if(type.equals("LINK"))
                return Post.Type.LINK;
        }
        
        return Post.Type.NULL;
    }

    public List getPostList(UtenteRegistrato users) {

        List<Post> listaPost = new ArrayList<Post>();
        try{
            Connection conn = DriverManager.getConnection(connectionString, "nerd", "nerd"); 
            
            //query di stringa
             String query = 
                    "select * from post "
                    + "join tipoPost on tipoUrl.tipo = tipoPost.id" // al posto di id = idTipoPost da fare
                    + "where utente = ?"; //id = idPost 
          
            PreparedStatement stmt = conn.prepareStatement(query); //processa query
            
            stmt.setInt(1, users.getId());
            
            ResultSet res = stmt.executeQuery();
            
            while(res.next()){
                Post user = new Post();
                user.setId(res.getInt("id")); //idPost
                user.setUser(users);
                user.setContentText(res.getString("contentText"));
                user.setContentUrl(res.getString("url"));
                user.setPostType(this.postTypeFromString(res.getString("tipoPost")));
                
                listaPost.add(user);
                        
            }
            
            stmt.close();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return listaPost;
    }
    
    public void addNewPost(Post post){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "nerd", "nerd");
            
            String query = 
                      "insert into post (id, utente, contentText, url, tipoPost) "
                    + "values (default, ? , ? , ? , ? )";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, post.getContentText());

            stmt.setInt(2, this.postTypeFromEnum(post.getPostType()));
            
            stmt.setInt(3, post.getUser().getId());
            
            // Esecuzione query
            stmt.executeUpdate(); //per aggiornare, inserire o cancellare dati uso executeUpdate
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    private int postTypeFromEnum(Post.Type type){
        
        if(type == Post.Type.NULL)
                return 0;
        else{
            if(type == Post.Type.LINK)
                return 2;
        }
        return 1; //se è IMAGE
    }
    
    public void deletePost(int idPost, int idUtente) {

        int idutente = -1;

        try {
            //path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "nerd", "nerd");

            String query1 = "delete from post " + "where id = ? ";

            PreparedStatement stmt = conn.prepareStatement(query1);

            // Si associano i valori
            stmt.setInt(1, idUtente);

            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                idutente = res.getInt("utente");

                stmt.close();
                conn.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public void deleteAllPost(UtenteRegistrato utente) {

        try {

            Connection conn = DriverManager.getConnection(connectionString, "nerd", "nerd");
            String query = "delete from post " + "where utente = ? ";
            // Si associano i valori

            PreparedStatement stmt = conn.prepareStatement(query);

            // Si associano i valori
            stmt.setInt(1, utente.getId());

            // Esecuzione query
            stmt.executeUpdate();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

