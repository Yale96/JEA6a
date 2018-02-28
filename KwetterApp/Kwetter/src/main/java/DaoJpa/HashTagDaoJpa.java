/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoJpa;

import DAO.HashTagDao;
import Models.HashTag;
import Models.Profile;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author Yannick van Leeuwen
 */
@Stateless @JPA
public class HashTagDaoJpa extends DaoFacade<HashTag> implements HashTagDao {
    @PersistenceContext
    private EntityManager em;
    
    public HashTagDaoJpa()
    {
        super(HashTag.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void addHashTag(HashTag hashTag) {
        em.getTransaction().begin();
        em.persist(hashTag);
        em.getTransaction().commit();
    }

    @Override
    public void updateHashTag(HashTag hashTag) {
        em.getTransaction().begin();
        em.merge(hashTag);
        em.getTransaction().commit();
    }

    @Override
    public void deleteHashTag(HashTag hashTag) {
        em.getTransaction().begin();
        HashTag ht = em.merge(hashTag);
        em.remove(ht);
        em.getTransaction().commit();
    }

    @Override
    public ArrayList<HashTag> getAllHashtags() {
        Query query = em.createNamedQuery("SELECT h FROM HashTags h");
        return new ArrayList<>(query.getResultList());
    }

    @Override
    public HashTag getHashTagById(int id) {
        TypedQuery<HashTag> query = em.createNamedQuery("hashtag.getHashTagById", HashTag.class);
        query.setParameter("id", id);
        List<HashTag> result = query.getResultList();
        System.out.println("count : " + result.size());
        return result.get(0);
    }
    
}
