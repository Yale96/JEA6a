/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoJpa;

import DAO.ProfileDao;
import DAO.TweetDao;
import Models.HashTag;
import Models.Profile;
import Models.Tweet;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Yannick van Leeuwen
 */
@Stateless @JPA
public class TweetDaoJpa extends DaoFacade<Tweet> implements TweetDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public TweetDaoJpa()
    {
        super(Tweet.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void addTweet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateTweet(Tweet tweet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteTweet(Tweet tweet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Tweet> getAllTweets() {
        Query query = em.createQuery("SELECT t FROM Tweet t");
         return  new ArrayList<>(query.getResultList());
    }

    @Override
    public Tweet getTweetById(int id) {
        TypedQuery<Tweet> query = em.createNamedQuery("hashtag.getTweetById", Tweet.class);
        query.setParameter("id", id);
        List<Tweet> result = query.getResultList();
        System.out.println("count : " + result.size());
        return result.get(0);
    }
    
}
