/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoJpa;

import DAO.ProfileDao;
import DAO.UserDao;
import Models.HashTag;
import Models.Profile;
import Models.User;
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
public class UserDaoJpa extends DaoFacade<User> implements UserDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public UserDaoJpa()
    {
        super(User.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void registerUser(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public void updateUser(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    @Override
    public void deleteUser(User user) {
        em.getTransaction().begin();
        User u = em.merge(user);
        em.remove(u);
        em.getTransaction().commit();
    }

    @Override
    public ArrayList<User> getAllUsers() {
        Query query = em.createQuery("SELECT u FROM User u");
         return  new ArrayList<>(query.getResultList());
    }

    @Override
    public User getUserById(int id) {
        TypedQuery<User> query = em.createNamedQuery("hashtag.getUserId", User.class);
        query.setParameter("id", id);
        List<User> result = query.getResultList();
        System.out.println("count : " + result.size());
        return result.get(0);
    }
    
}
