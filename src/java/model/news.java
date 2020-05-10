/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ismael
 */
public class news {
    
    private int id;
    private int id_category;
    private String category_title;
    private String title;
    private String content_image;
    private String content_text;
    private String post_date;
    private int views;

    public news(int id, int id_category, String category_title, String title, String content_image, String content_text, String post_date,int views) {
        this.id = id;
        this.id_category = id_category;
        this.category_title = category_title;
        this.title = title;
        this.content_image = content_image;
        this.content_text = content_text;
        this.post_date = post_date;
        this.views = views;
    }
    
    public news() {
        this.id = 0;
        this.id_category = 0;
        this.category_title = "";
        this.title = "";
        this.content_image = "";
        this.content_text = "";
        this.post_date = "";
        this.views = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getCategory_title() {
        return category_title;
    }

    public void setCategory_title(String category_title) {
        this.category_title = category_title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent_image() {
        return content_image;
    }

    public void setContent_image(String content_image) {
        this.content_image = content_image;
    }

    public String getContent_text() {
        return content_text;
    }

    public void setContent_text(String content_text) {
        this.content_text = content_text;
    }

    public String getPost_date() {
        return post_date;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
    
}
