/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.article.model;

import java.time.LocalDate;

/**
 *
 * @author user
 */
public class Article {
    private String intitule;
    private String contenue;
    private String date;
    private String username;
    private int id;

    public Article() {
    }

    public Article(String intitule, String contenue, String date, String username) {
        this.intitule = intitule;
        this.contenue = contenue;
        this.date = date;
        this.username = username;
    }

    public Article(String intitule, String contenue, String date, String username, int id) {
        this.intitule = intitule;
        this.contenue = contenue;
        this.date = date;
        this.username = username;
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getContenue() {
        return contenue;
    }

    public void setContenue(String contenue) {
        this.contenue = contenue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Article{" + "intitule=" + intitule + ", contenue=" + contenue + ", date=" + date + ", username=" + username + ", id=" + id + '}';
    }
}
