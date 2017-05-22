/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.servlet;

import amm.nerdbook.classi.Gruppo;
import amm.nerdbook.classi.GruppoFactory;
import amm.nerdbook.classi.Post;
import amm.nerdbook.classi.PostFactory;
import amm.nerdbook.classi.UtenteRegistrato;
import amm.nerdbook.classi.UtenteRegistratoFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Robi
 */
public class Bacheca extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sessione = request.getSession(false);
        
        String canc = request.getParameter("cancella");
        
        if(request.getParameter("cancella") != null){
            
            Integer loggedUserID = (Integer) sessione.getAttribute("loggedUserID");
            int idUser = loggedUserID;
            
            
            int idcanc= Integer.parseInt(request.getParameter("cancella"));
            PostFactory.getInstance().deletePost(idcanc, idUser);
            response.setIntHeader("Refresh", 0);
                
        }

        
        if(sessione!=null && sessione.getAttribute("loggedIn")!=null && sessione.getAttribute("loggedIn").equals(true)){
            
            String paramUser = request.getParameter("user");
            int userID;
            if(paramUser != null){
                userID = Integer.parseInt(paramUser);
            } else {
                userID = (Integer)sessione.getAttribute("loggedUserID");

            }

            UtenteRegistrato user = UtenteRegistratoFactory.getInstance().getUserById(userID);
            if(user != null){
                request.setAttribute("user", user);
                
                List<Post> posts = PostFactory.getInstance().getPostList(user);
                request.setAttribute("posts", posts);

                List<UtenteRegistrato> listaUtenti = UtenteRegistratoFactory.getInstance().getUserList();
                request.setAttribute("users",listaUtenti);
                
                List<Gruppo> listaGruppoPost = GruppoFactory.getInstance().getGroupList();
                request.setAttribute("groups",listaGruppoPost);
                
                request.getRequestDispatcher("M3/bacheca.jsp").forward(request, response);
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        }
        else{
            try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Accesso Negato</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Errore: Accesso Negato</h1>");
            out.println("</body>");
            out.println("</html>");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
