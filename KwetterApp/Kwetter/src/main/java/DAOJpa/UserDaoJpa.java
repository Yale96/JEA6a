/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOJpa;

import DAO.DaoFacade;
import DAO.JPA;
import DAO.UserDao;
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
    
    public UserDaoJpa() {
        super(User.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public User findById(Long id) {
        TypedQuery<User> query = em.createNamedQuery("user.findById", User.class);
        query.setParameter("id", id);
        List<User> result = query.getResultList();
        System.out.println("count: " + result.size());
        return result.get(0);
    }

    @Override
    public ArrayList<User> getUsers() {
         Query query = em.createQuery("SELECT u FROM User u");
         return  new ArrayList<>(query.getResultList());
    }
}
