/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
/**
 *
 * @author Yannick van Leeuwen
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "profile.findById", query = "SELECT p FROM Profile p WHERE p.name = :name"),
    @NamedQuery(name = "profile.count", query = "SELECT COUNT(p) FROM Profile p")})
public class Profile implements Serializable{

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinTable(name="user_profile",
        joinColumns=
            @JoinColumn(name="profile_id", referencedColumnName="ID"),
        inverseJoinColumns=
            @JoinColumn(name="user_id", referencedColumnName="ID"))
    private User user;
    
    private String name;
    private String location;
    private String web;
    private String bio;
    private String picture;

    public Profile() {

    }

    public Profile(String name, String location, String web, String bio, String picture){
        this.name = name;
        this.location = location;
        this.web = web;
        this.bio = bio;
        this.picture = picture;
    }

    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }
    
    public User getUser()
    {
        return user;
    }
    
    public void setUser(User user)
    {
        this.user = user;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
