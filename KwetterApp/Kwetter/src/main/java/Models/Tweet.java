/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Yannick van Leeuwen
 */
public class Tweet {
    private int Id;
    private String Content;
    private Date Timestamp;
    public List<HashTag> Tags;
    private User Tweeter;
    public List<User> Likers;
    public List<Tweet> Responses;
    
    public Tweet(String content, Date timestamp, User tweeter)
    {
        this.Content = content;
        this.Timestamp = timestamp;
        Tags = new ArrayList<HashTag>();
        this.Tweeter = tweeter;
        Likers = new ArrayList<User>();
        Responses = new ArrayList<Tweet>();
    }

    public User getTweeter() {
        return Tweeter;
    }

    public void setTweeter(User Tweeter) {
        this.Tweeter = Tweeter;
    }
           
    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public Date getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(Date Timestamp) {
        this.Timestamp = Timestamp;
    }
    
    public int getNumberOfLikes()
    {
        int likes = Likers.size();
        return likes;
    }
}
