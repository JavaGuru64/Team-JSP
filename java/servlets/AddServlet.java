/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import db_objects.Mentor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mysql.MentorIO;

/**
 *
 * @author Team ParaGoomba
 */
public class AddServlet extends HttpServlet {

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
        String img = request.getParameter("img");
        String name = request.getParameter("name");
        String qual = request.getParameter("qual");
        System.out.println(qual);
        String email= request.getParameter("email");
        String comment = request.getParameter("comment");
        String submit = request.getParameter("submit");
        url = "/admin.jsp";
        
        
        
        
        if(submit.equalsIgnoreCase("Add"))
        {
            if(name.length() > 0 && qual.length() > 0 && email.length() > 0)
            {

                if(img.length() <= 0)
                {
                    img = "no_image.jpg";
                }
                MentorIO.addMentor(new Mentor(0, img, name, qual, email, comment));
            }
            else
            {
                message = " | Error: A required field was empty!";
                url = "/add.jsp";
            }
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
