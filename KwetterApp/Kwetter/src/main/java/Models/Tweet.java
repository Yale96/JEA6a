/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false)
    private String content;
    
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;
    
    @ManyToMany
    @JoinTable(name = "tweet_hashtag"
            , joinColumns = @JoinColumn(name = "tweet_hashtag_id", referencedColumnName = "id")
            , inverseJoinColumns = @JoinColumn(name = "hashtag_hashtag_id", referencedColumnName = "id"))
    private ArrayList<HashTag> hashtags;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;
    
    @ManyToMany
    @JoinTable(name = "tweet_tweeter_mentions"
            , joinColumns = @JoinColumn(name = "tweet_mention_id", referencedColumnName = "id")
            , inverseJoinColumns = @JoinColumn(name = "user_mention_id", referencedColumnName = "id"))
    private ArrayList<User> mentionedUsers;
    
    @ManyToMany
    @JoinTable(name = "tweet_user_likes"
            , joinColumns = @JoinColumn(name = "tweet_like_id", referencedColumnName = "id")
            , inverseJoinColumns = @JoinColumn(name = "user_like_id", referencedColumnName = "id"))
    private ArrayList<User> likes;
    
    @OneToMany
    @JoinTable(name = "tweet_responses"
            , joinColumns = @JoinColumn(name = "tweet_id", referencedColumnName = "id")
            , inverseJoinColumns = @JoinColumn(name = "responded_tweet_id", referencedColumnName = "id"))
    private ArrayList<Tweet> responses;
    
    public Tweet()
    {
       responses = new ArrayList<Tweet>();
       hashtags = new ArrayList<HashTag>();
       mentionedUsers = new ArrayList<User>();
       likes = new ArrayList<User>(); 
    }
    
    public Tweet(String content, Date timeStamp)
    {
        this.content = content;
        this.timeStamp = timeStamp;
        
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
        if(!owner.getTweets().contains(this))
        {
            owner.addTweet(this);
        }
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
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
