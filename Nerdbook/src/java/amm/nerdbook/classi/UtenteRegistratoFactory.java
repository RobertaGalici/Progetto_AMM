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
import java.util.logging.Level;
import java.util.logging.Logger;

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
            /*  //user.setDataNascita(res.getDate("dataNascita"));
            Con questo metodo non funziona. DATE?
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
                user.setDataNascita(res.getString("dataNascita"));
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
    
    public void eliminaUtente(UtenteRegistrato user) {
        try{
            Connection connessione = DriverManager.getConnection(connectionString, "adminSito", "sintassi");
            String query = "delete from utentePerOgniGruppo where utente = ? ";
            PreparedStatement frase = connessione.prepareStatement(query);
            frase.setInt(1, user.getId());
            frase.executeUpdate();
            
            query = "delete from utente where id = ?";
            frase = connessione.prepareStatement(query);
            frase.setInt(1, user.getId());
            frase.executeUpdate();
            
            frase.close();
            connessione.close();
        } 
        catch (SQLException e) {
            System.out.println("Errore SQL su eliminaListaPost");
            e.printStackTrace();
        }
    }
    
    public int login(String nome, String password) {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "nerd", "nerd");
            
            String query = 
                      "select * id from utente "
                    + "where nome = ? and password = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, nome);
            stmt.setString(2, password);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            int utenteLoggato;
                
            if (res.next()) {
                utenteLoggato = res.getInt("id");
                
                stmt.close();
                conn.close();
                return utenteLoggato;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public void aggiornaProfilo(UtenteRegistrato utente){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "Nerdbook", "password");
            
            String query = 
                    "UPDATE utente SET nome = ?, cognome = ?, email = ?, "
                    + "password = ?, urlProfilo = ?, dataNascita = ?, presentazione = ? "
                    + "WHERE id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, utente.getNome());
            stmt.setString(2, utente.getCognome());
            stmt.setString(3, utente.getEmail());
            stmt.setString(4, utente.getPassword());
            stmt.setString(5, utente.getPresentazione());
            stmt.setString(6, utente.getUrlProfilo());
            stmt.setString(7, utente.getDataNascita());
            stmt.setInt(8,utente.getId());
            // Esecuzione query
            stmt.execute();

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }    
    
    //ritorna la lista degli utenti
    public List getUtentiList(int id) {
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "nerd", "nerd");
            List<UtenteRegistrato> amici = new ArrayList<>();
            String query = 
                    "SELECT * FROM utente " +
                    "JOIN amicizie ON utente.id = amicizie.idUtente1 " +
                    "WHERE amicizie.idUtente2 = ? " +
                    "UNION " +
                    "SELECT * FROM utente " +
                    "JOIN amicizie ON utente.id = amicizie.idUtente2 " +
                    "WHERE amicizie.idUtente1 = ?";
            
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            stmt.setInt(2, id);
            
            // Esecuzione query
            ResultSet res;
            UtenteRegistrato current;
            res = stmt.executeQuery();
            
            // ciclo sulle righe restituite
            while (res.next()) {
                current = new UtenteRegistrato();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setPassword(res.getString("password"));
                current.setEmail(res.getString("email"));
                current.setUrlProfilo(res.getString("urlFoto"));
                current.setPresentazione(res.getString("presentazione"));
                current.setDataNascita(res.getString("dataNascita"));
                amici.add(current);
            }
            
            stmt.close();
            conn.close();
            return amici;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
