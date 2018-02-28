/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Tweet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yannick van Leeuwen
 */
public interface TweetDao {
    void addTweet();
    
    void updateTweet(Tweet tweet);
    
    void deleteTweet(Tweet tweet);
    
    ArrayList<Tweet> getAllTweets();
    
    Tweet getTweetById(int id); 
}
