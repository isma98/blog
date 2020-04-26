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
public class category {
    
    private int id;
    private String image;
    private String title;

    public category(int id, String image, String title) {
        this.id = id;
        this.image = image;
        this.title = title;
    }
    
    public category() {
        this.id = 0;
        this.image = "";
        this.title = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}
