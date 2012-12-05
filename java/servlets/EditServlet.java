/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import db_objects.Mentor;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mysql.MentorIO;

/**
 *
 * @author TeamParaGoomba
 */
@WebServlet(name = "EditServlet", urlPatterns = {"/EditServlet"})
public class EditServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "";
        String message = "";
        int id = Integer.parseInt(request.getParameter("id"));
        String img = request.getParameter("img");
        String name = request.getParameter("name");
        String qual = request.getParameter("qual");
        
        String email= request.getParameter("email");
        String comment = request.getParameter("comment");
        String submit = request.getParameter("submit");
        url = "/admin.jsp";
        
        
        
        
        
        if(name.length() > 0 && qual.length() > 0 && email.length() > 0)
        {
            if(submit.equalsIgnoreCase("Save Edit"))
            {
                if(img.length() <= 0)
                {
                    img = "no_image.jpg";
                }
                MentorIO.updateMentor(new Mentor(id, img, name, qual, email, comment));
            }
        }
        else{
            message = " | Error: A required field was empty!";
        }
        
        if(submit.equalsIgnoreCase("Delete"))
        {
            MentorIO.removeMentor(id);
        }
        
        ArrayList<Mentor> mentors = MentorIO.listMentors();
        request.setAttribute("mentors", mentors);
        request.setAttribute("message", message);


        
        RequestDispatcher dispatcher = 
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
