/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import java.sql.Date;
//import java.text.DateFormat;
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
    private String connectionString;

    private UtenteRegistratoFactory() {}

    public UtenteRegistrato getUtentiRegistratiById(int id) {
        try{
            //nerd = username e password del database creato
            //Connessione al database
            Connection conn = DriverManager.getConnection(connectionString, "nerd", "nerd"); 
            
            //query di stringa
            String query = 
                    "select * from utente "
                    + "where id = ?"; //in realta è idUtente
            
            PreparedStatement stmt = conn.prepareStatement(query); //processa query
            
            //previene gli attacchi di tipo Injection
            stmt.setInt(1, id); //se trovo caratteri non validi la gestisco io, es con un errore
            
            //set di risultati della query
            ResultSet res = stmt.executeQuery();
            /*
            Date date;
            DateFormat df = new SimpleDataFormat("yyyy/mm/dd");
            String text = df.format(date);*/
            
            if(res.next()){
                UtenteRegistrato user = new UtenteRegistrato();
                user.setId(res.getInt("id")); //idUtente
                user.setNome(res.getString("nome"));
                user.setCognome(res.getString("cognome"));
                user.setEmail(res.getString("email"));
                user.setPassword(res.getString("password"));
                user.setUrlProfilo(res.getString("urlProfilo"));
                //user.setDataNascita(res.getDate("dataNascita"));
                user.setPresentazione("presentazione");
                
                //chiudo le connessioni sia se viene eseguita
                //se non chiudo le connessioni non posso eseguire altre query:
                //devo aspettare che termini la sessione
                stmt.close();
                conn.close();
                
                return user;
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
    
    public int getIdByUserAndPassword(String user, String password) throws SQLException{
         try{
            //nerd = username e password del database creato
            //Connessione al database
            Connection conn = DriverManager.getConnection(connectionString, "nerd", "nerd"); 
            
            //query di stringa
            String query = 
                    "select * from utente "
                    + "where name = ? and password = ?"; //in realta è idUtente
          
            PreparedStatement stmt = conn.prepareStatement(query); //processa query
            
            stmt.setString(1, user);
            stmt.setString(2, password);
            
            ResultSet res = stmt.executeQuery();
            
            if(res.next()){
                int id = res.getInt("id"); //utenteId
                
                stmt.close();
                conn.close();
                return id;
            }
            
            stmt.close();
            conn.close();
                
            }
        catch(SQLException e ){
            e.printStackTrace();
        }
        return -1;
    }

    public UtenteRegistrato getUserById(int loggedUserId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List getUserList() {
        return listaUtentiRegistrati;
    }
        
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
	return this.connectionString;
    }
}
