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
    private String connectionString;

    private GruppoFactory() {}
    
    public List getGroupList(){
        return listaGruppoPost;
    }
    
    public Gruppo getGroupById(int id) {
        
        //GruppoFactory gruppoFactory = GruppoFactory.getInstance();
        UtenteRegistratoFactory utenteFactory = UtenteRegistratoFactory.getInstance();
        try{
            //nerd = username e password del database creato
            //Connessione al database
            Connection conn = DriverManager.getConnection(connectionString, "nerd", "nerd"); 
            
            //query di stringa
            String query = 
                    " select * from gruppo "
                    + " join utentePerOgniGruppo on utentePerOgniGruppo.gruppo = gruppo.idGruppo "
                    + " where idGruppo = ? ";
            
            PreparedStatement stmt = conn.prepareStatement(query); //processa query
            
            //previene gli attacchi di tipo Injection
            stmt.setInt(1, id); //se trovo caratteri non validi la gestisco io, es con un errore
            
            //set di risultati della query
            ResultSet res = stmt.executeQuery();
            
            if(res.next()){
                Gruppo gruppo = new Gruppo();
                
                gruppo.setId(res.getInt("idGruppo"));
                gruppo.setNome(res.getString("nome"));
                gruppo.setDescrizione(res.getString("descrizione"));
                UtenteRegistrato amministratore = utenteFactory.getUtentiRegistratiById(res.getInt("amministratore"));
                gruppo.setAmministratore(amministratore);
                //MOD gruppo.setUtentiGruppo(res.getString("gruppo")); ???
                //chiudo le connessioni sia se viene eseguita
                //se non chiudo le connessioni non posso eseguire altre query:
                //devo aspettare che termini la sessione
                stmt.close();
                conn.close();
                
                return gruppo;
            }
            
                //chiudo le connessioni sia se non viene eseguita
                stmt.close();
                conn.close();
                
        }
        catch(SQLException e ){
            e.printStackTrace();
        }
        return null;

    }
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
	return this.connectionString;
    }
}