<%-- 
    Document   : index
    Created on : 21 oct. 2022, 20:40:36
    Author     : user
--%>

<%@page import="java.util.logging.Level"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="com.article.controller.ArticleServlet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.io.IOException"%>
<%@page import="com.article.dao.ArticleDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.article.model.Article"%>
<% ArticleDao articleDao = new ArticleDao();%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <title>CRUD TEST</title>
    </head>
    <body>
        <div class="bg-secondary">
            <nav class="navbar navbar-expand-md bg-dark navbar-dark">
                <a class="navbar-brand" href="">Gestion des articles</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                    <span class="navbar-toggler-icon"></span>
                  </button>
                <div class="collapse navbar-collapse  justify-content-center" id="collapsibleNavbar">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link active" href="index.html">Accueil</a>
                        </li>

                    </ul>
                </div>
            </nav>
        </div>
        <div>
            <div class="m-2"><span class="text-light justify-content-right"><button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                Ajouter un article
              </button></span></div>
            <div class="text-center">Liste des articles</div>
                <div class="card m-4">

                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Nom de l'article</th>
                                <th scope="col">Editeur</th>
                                <th scope="col">Date de publication</th>
                                <th scope="col">Paramètre</th>
                            </tr>
                          </thead>
                        <tbody>
                            <% 
                                ArrayList<Article> articles = (ArrayList<Article>)request.getAttribute("articles");
                                
                                if(articles==null){
                                    try {
                                        articles = articleDao.findall();
                                       } catch (SQLException ex) {
                                            Logger.getLogger(ArticleServlet.class.getName()).log(Level.SEVERE, null, ex);
                                        } catch (ClassNotFoundException ex) {
                                            Logger.getLogger(ArticleServlet.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                }                               
                                
                                for(Article article:articles){
                                    out.println("<tr>");
                                    out.println("<td>"+article.getId()+"</td>");
                                    out.println("<td>"+article.getIntitule()+"</td>");
                                    out.println("<td>"+article.getUsername()+"</td>");
                                    out.println("<td>"+article.getDate()+"</td>");
                                    out.println("<td>"+
                                          "<a href=\"/Articles/articles-servlet?update=True&id="+article.getId()+"\"><ion-icon data-bs-toggle=\"modal\" data-bs-target=\"#detailModal\" name=\"pencil-outline\" style=\"color: blue; margin-right: 10px; cursor: pointer;\"></ion-icon></a>"+
                                          "<a href=\"/Articles/articles-servlet?id="+article.getId()+"\"><ion-icon name=\"close-outline\" style=\"color: red; cursor: pointer;\"></ion-icon></a>"+
                                           "</td>");
                                    out.println("</tr>");
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
                       
                           
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            
            <form action="/Articles/articles-servlet" method="POST">
                <div class="modal-dialog">
                  <div class="modal-content">
                    <div class="modal-header">
                      <h1 class="modal-title fs-5" id="exampleModalLabel">Formulaire d'ajout</h1>
                      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="mb-3">
                            <label for="intitule" class="form-label">Nom de l'article</label>
                            <input type="text" class="form-control" id="intitule" name="intitule" aria-describedby="intituleHelp">
                          </div>
                          <div class="mb-3">
                            <label for="contenue" class="form-label">Contenu de l'article</label>
                            <textarea class="form-control" id="contenue" name="contenue" rows="3"></textarea>
                          </div>
                          <div class="mb-3">
                            <label for="date" class="form-label">Date de publication de l'article</label>
                            <input type="date" class="form-control" id="date" name="date" aria-describedby="dateHelp">
                          </div>
                          <div class="mb-3">
                            <label for="username" class="form-label">Nom de l'editeur de l'article</label>
                            <input type="text" class="form-control" id="username" name="username" aria-describedby="usernameHelp">
                          </div>
                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Annuler</button>
                      <button type="submit" class="btn btn-primary">Enregitrer</button>
                    </div>
                  </div>
                </div>
            </form>
        </div>
                        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

    </body>
</html>