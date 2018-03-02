/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.awt.image.BufferedImage;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Yannick van Leeuwen
 */
@Entity
public class Profile {
    
    @Id
    @GeneratedValue
    private int Id;
    private BufferedImage Picture;
    private String Biography;
    private String Location;
    private String Website;
    private User Owner;
    
    public Profile(BufferedImage picture, String biography, String location, String website, User owner)
    {
        this.Picture = picture;
        this.Biography = biography;
        this.Location = location;
        this.Website = website;
        this.Owner = owner;
    }

    public User getOwner() {
        return Owner;
    }

    public void setOwner(User Owner) {
        this.Owner = Owner;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public BufferedImage getPicture() {
        return Picture;
    }

    public void setPicture(BufferedImage Picture) {
        this.Picture = Picture;
    }

    public String getBiography() {
        return Biography;
    }

    public void setBiography(String Biography) {
        this.Biography = Biography;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String Website) {
        this.Website = Website;
    }
}
