/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Profile;
import Models.Tweet;
import java.util.ArrayList;

/**
 *
 * @author Yannick van Leeuwen
 */
public interface TweetDao {
    void create(Tweet tweet);
    
    void remove(Tweet tweet);

    Tweet findById(Long id);

    ArrayList<Tweet> getTweets();
}
