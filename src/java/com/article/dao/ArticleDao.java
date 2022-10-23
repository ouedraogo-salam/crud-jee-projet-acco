/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.article.dao;

import com.article.model.Article;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class ArticleDao {
    
     public int save(Article article) throws ClassNotFoundException, SQLException{
        
        Class.forName("org.postgresql.Driver");
       /* String url = "jdbc:postgresql://localhost:5432/test?user=postgres&password=postgres&ssl=true";*/
        
        String url = "jdbc:postgresql://localhost:5432/user";
        String user = "postgres";
        String password = "postgres";

        Connection conn = DriverManager.getConnection(url, user, password);
        int result = 0;
        String query = "INSERT INTO public.\"Article\" "+
               "(intitule, Contenue, date, username) VALUES "+
                "(?, ?, ?, ?)";
        
        PreparedStatement preparedStatement;
        preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, article.getIntitule());
        preparedStatement.setString(2, article.getContenue());
        preparedStatement.setString(3, article.getDate());
        preparedStatement.setString(4, article.getUsername());
        result = preparedStatement.executeUpdate();
        return result;
    }
     
     public ArrayList<Article> findall() throws SQLException, ClassNotFoundException{
        
        Class.forName("org.postgresql.Driver");
       /* String url = "jdbc:postgresql://localhost:5432/test?user=postgres&password=postgres&ssl=true";*/
        
        String url = "jdbc:postgresql://localhost:5432/user";
        String user = "postgres";
        String password = "postgres";

        Connection conn = DriverManager.getConnection(url, user, password);
        
        String query = "Select * from public.\"Article\" ";
        PreparedStatement preparedStatement;
        preparedStatement = conn.prepareStatement(query);
        
        ResultSet execute = preparedStatement.executeQuery();
        
        String intitule;
        String contenue;
        String username;
        String date;
        int id;
        
        ArrayList<Article> articles = new ArrayList<>();
        
        while(execute.next()){
            intitule = execute.getString("intitule");
            contenue = execute.getString("contenue");
            username = execute.getString("username");
            date = execute.getString("date");
            id = execute.getInt("id");
            articles.add(new Article(intitule, contenue, date, username, id));
        }
        return articles;
    }
    
    public Article findById(int id) throws SQLException, ClassNotFoundException{
        
        Class.forName("org.postgresql.Driver");
       /* String url = "jdbc:postgresql://localhost:5432/test?user=postgres&password=postgres&ssl=true";*/
        
        String url = "jdbc:postgresql://localhost:5432/user";
        String user = "postgres";
        String password = "postgres";

        Connection conn = DriverManager.getConnection(url, user, password);
        
        String intitule;
        String contenue;
        String username;
        String date;
        
        String query = "SELECT * FROM public.\"Article\" WHERE id="+id;
        
        PreparedStatement preparedStatement;
        preparedStatement = conn.prepareStatement(query);
        ResultSet execute = preparedStatement.executeQuery();
        execute.next();
        intitule = execute.getString("intitule");
        contenue = execute.getString("contenue");
        username = execute.getString("username");
        date =  execute.getString("date");
            
        Article article = new Article(intitule, contenue, date, username, id);
        return article;
    }
    
        public int Delete(int id) throws SQLException, ClassNotFoundException{
        
        Class.forName("org.postgresql.Driver");
       /* String url = "jdbc:postgresql://localhost:5432/test?user=postgres&password=postgres&ssl=true";*/
        
        String url = "jdbc:postgresql://localhost:5432/user";
        String user = "postgres";
        String password = "postgres";

        Connection conn = DriverManager.getConnection(url, user, password);
        
        int result = 0;
        String query = "DELETE FROM public.\"Article\" WHERE id="+id;
        PreparedStatement preparedStatement;
        preparedStatement = conn.prepareStatement(query);
        result = preparedStatement.executeUpdate();
        return result;
    }

    
    public int update(Article article) throws ClassNotFoundException, SQLException{
        
        Class.forName("org.postgresql.Driver");
       /* String url = "jdbc:postgresql://localhost:5432/test?user=postgres&password=postgres&ssl=true";*/
        
        String url = "jdbc:postgresql://localhost:5432/user";
        String user = "postgres";
        String password = "postgres";

        Connection conn = DriverManager.getConnection(url, user, password);
        int result;
         result = 0;
        String query = "UPDATE public.\"Article\""+
                "SET intitule='"+article.getIntitule()+"', Contenue='"+article.getContenue()+
                "', date='"+article.getDate()+"', username='"+article.getUsername()+
                "' WHERE id="+article.getId();

        PreparedStatement preparedStatement;
        preparedStatement = conn.prepareStatement(query);
        result = preparedStatement.executeUpdate();
        return result;
    }
}
