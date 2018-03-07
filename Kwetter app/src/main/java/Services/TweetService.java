/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.JPA;
import DAO.TweetDao;
import DAO.UserDao;
import Models.Tweet;
import Models.User;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Yannick van Leeuwen
 */
@Stateless
public class TweetService {
    
    @EJB
    private UserService uService;
    
    @Inject @JPA
    private TweetDao tweetDao;

    public void addTweet(Tweet tweet) {
        tweetDao.create(tweet);
    }

    public List<Tweet> getTweets() {
        return tweetDao.getTweets();
    }

    public Tweet getById(Long id) {
        return new Tweet("Yannick", new Date());
    }

    public TweetService(){

    }
}
