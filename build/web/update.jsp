<%-- 
    Document   : index
    Created on : 21 oct. 2022, 20:40:36
    Author     : user
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.article.model.Article"%>
<%
    Article article_select = null;
    Article article = (Article)request.getAttribute("article");
%>
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
                           
        <div>
            <form action="/Articles/articles-servlet" method="POST">
                <div class="modal-dialog">
                  <div class="modal-content">
                    <div class="modal-header">
                      <h1 class="modal-title fs-5" id="exampleModalLabel">Formulaire d'ajout</h1>
                      
                      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="mb-3">
                            <input type="text" hidden readonly class="form-control" id="id" name="id" value=<%out.print(article.getId());%> aria-describedby="intituleHelp">
                          </div>
                        <div class="mb-3">
                            <label for="intitule" class="form-label">Nom de l'article</label>
                            <input  type="text" class="form-control" id="intitule" name="intitule" value="<%out.print(article.getIntitule());%>" aria-describedby="intituleHelp">
                          </div>
                          <div class="mb-3">
                            <label for="contenue" class="form-label">Contenu de l'article</label>
                            <textarea class="form-control" id="contenue" name="contenue" value=<%out.println(article.getContenue());%> rows="3">
                                <%out.println(article.getContenue());%>
                            </textarea>
                          </div>
                          <div class="mb-3">
                            <label for="date" class="form-label">Date de publication de l'article</label>
                            <input type="date" class="form-control" id="date" name="date" value=<%out.print(article.getDate());%> aria-describedby="dateHelp">
                          </div>
                          <div class="mb-3">
                            <label for="username" class="form-label">Nom de l'editeur de l'article</label>
                            <input type="text" class="form-control" id="username" name="username" value=<%out.print(article.getUsername());%> aria-describedby="usernameHelp">
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