/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Yannick van Leeuwen
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "hashtag.findById", query = "SELECT h FROM HashTag h WHERE h.id = :id"),
    @NamedQuery(name = "hashtag.count", query = "SELECT COUNT(h) FROM HashTag h")})
public class HashTag implements Serializable{
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @ManyToMany
    @JoinTable(
      name="TAGGED_USER",
      joinColumns=@JoinColumn(name="USER_ID", referencedColumnName="ID"),
      inverseJoinColumns=@JoinColumn(name="TWEET_ID", referencedColumnName="ID"))
    private ArrayList<Tweet> tagged;
    
    public HashTag()
    {
        
    }
    
    public HashTag(String content)
    {
        this.content = content;
        tagged = new ArrayList<Tweet>();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<Tweet> getTagged() {
        return tagged;
    }

    public void setTagged(ArrayList<Tweet> tagged) {
        this.tagged = tagged;
    }
    
}
