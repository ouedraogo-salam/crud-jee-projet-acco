/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.article.controller;

import com.article.dao.ArticleDao;
import com.article.model.Article;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */

@WebServlet("/articles-servlet")
public class ArticleServlet extends HttpServlet {

    private ArticleDao articleDao = new ArticleDao();

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ArticleServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ArticleServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String id = request.getParameter("id");
        String update = request.getParameter("update");
        Article article = new Article();
        
        try {
            ArrayList<Article> articles;
            if(id!=null){
                if(update!=null){
                    article = articleDao.findById(Integer.parseInt(id));
                }else{
                    articleDao.Delete(Integer.parseInt(id));
                }
            }
            
            if(update==null){
                articles = articleDao.findall();
                request.setAttribute("articles", articles);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/");
                dispatcher.forward(request, response);
            }else{
                request.setAttribute("article", article);
                RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticleServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ArticleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        
        String id = request.getParameter("id");
        String intitule = request.getParameter("intitule");
        String contenue = request.getParameter("contenue");
        String username = request.getParameter("username");
        String date = request.getParameter("date");
        if(id==null){
            Article article = new Article(intitule, contenue, date, username);
            try {
                articleDao.save(article);
                doGet(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ArticleServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ArticleServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            Article article = new Article(intitule, contenue, date, username, Integer.parseInt(id));
            try {
                 ArrayList<Article> articles;
               articleDao.update(article);
                articles = articleDao.findall();
                request.setAttribute("articles", articles);
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ArticleServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ArticleServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
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
