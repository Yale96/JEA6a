/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author Yannick van Leeuwen
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "tweet.findById", query = "SELECT t FROM Tweet t WHERE t.id = :id"),
    @NamedQuery(name = "tweet.count", query = "SELECT COUNT(t) FROM Tweet t")})
public class Tweet implements Serializable {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    private Date timeStamp;
    @OneToOne
    private ArrayList<Tweet> responses;
    @ManyToMany
    private ArrayList<HashTag> hashtags;
    @ManyToMany
    private ArrayList<User> mentionedUsers;
    @ManyToMany
    private ArrayList<User> likes;
    
    public Tweet()
    {
        
    }
    
    public Tweet(String content, Date timeStamp)
    {
        this.content = content;
        this.timeStamp = timeStamp;
        responses = new ArrayList<Tweet>();
        hashtags = new ArrayList<HashTag>();
        mentionedUsers = new ArrayList<User>();
        likes = new ArrayList<User>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public ArrayList<Tweet> getResponses() {
        return responses;
    }

    public void setResponses(ArrayList<Tweet> responses) {
        this.responses = responses;
    }

    public ArrayList<HashTag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(ArrayList<HashTag> hashtags) {
        this.hashtags = hashtags;
    }

    public ArrayList<User> getMentionedUsers() {
        return mentionedUsers;
    }

    public void setMentionedUsers(ArrayList<User> mentionedUsers) {
        this.mentionedUsers = mentionedUsers;
    }

    public ArrayList<User> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<User> likes) {
        this.likes = likes;
    }
}
