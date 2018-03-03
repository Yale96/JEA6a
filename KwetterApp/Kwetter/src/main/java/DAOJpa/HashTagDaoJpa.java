/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOJpa;

import DAO.DaoFacade;
import DAO.HashTagDao;
import Models.HashTag;
import Models.Profile;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Yannick van Leeuwen
 */
public class HashTagDaoJpa extends DaoFacade<HashTag> implements HashTagDao {
    @PersistenceContext
    private EntityManager em;
    
    public HashTagDaoJpa() {
        super(HashTag.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public HashTag findById(Long id) {
        TypedQuery<HashTag> query = em.createNamedQuery("hashTag.findById", HashTag.class);
        query.setParameter("id", id);
        List<HashTag> result = query.getResultList();
        System.out.println("count: " + result.size());
        return result.get(0);
    }

    @Override
    public ArrayList<HashTag> getHashTags() {
         Query query = em.createQuery("SELECT h FROM HashTag h");
         return  new ArrayList<>(query.getResultList());
    }
}
