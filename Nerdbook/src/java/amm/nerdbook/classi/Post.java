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
public class Post {

    public enum Type {
        TEXT, IMAGE, LINK
    };

    protected int id;
    protected UtenteRegistrato user;
    private String contentImmagine, contentText, contentLink;
    private Type postType;

    public Post() {
        id = 0;
        user = null;
        contentImmagine = "";
        contentText = "";
        contentLink = "";
        postType = Type.TEXT;
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
     * @return the user
     */
    public UtenteRegistrato getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(UtenteRegistrato user) {
        this.user = user;
    }

    /**
     * @return the postType
     */
    public Type getPostType() {
        return postType;
    }

    /**
     * @param postType the postType to set
     */
    public void setPostType(Type postType) {
        this.postType = postType;
    }
    
    /**
     * @return the contentImmagine
     */
    public String getContentImmagine() {
        return contentImmagine;
    }

    /**
     * @param contentImmagine the contentImmagine to set
     */
    public void setContentImmagine(String contentImmagine) {
        this.contentImmagine = contentImmagine;
    }

    /**
     * @return the contentText
     */
    public String getContentText() {
        return contentText;
    }

    /**
     * @param contentText the contentText to set
     */
    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    /**
     * @return the contentLink
     */
    public String getContentLink() {
        return contentLink;
    }

    /**
     * @param contentLink the contentLink to set
     */
    public void setContentLink(String contentLink) {
        this.contentLink = contentLink;
    }

}
