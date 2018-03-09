/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPATest;

import util.DatabaseCleaner;
import DAOJpa.HashTagDaoJpa;
import Models.HashTag;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yanni
 */
public class HashTagTest {
    
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("kwetterTestPU");
//    private EntityManager em;
//    private EntityTransaction tx;
//    private HashTagDaoJpa hashTagDao;
//    
//    public HashTagTest() {
//    }
//    
//    @Before
//    public void setUp() {
//        try {
//            new DatabaseCleaner(emf.createEntityManager()).clean();
//        } catch (SQLException ex) {
//            Logger.getLogger(HashTagDaoJpa.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        em = emf.createEntityManager();
//        tx = em.getTransaction();
//
//        hashTagDao = new HashTagDaoJpa();
//        hashTagDao.setEm(em);
//    }
//
//    // TODO add test methods here.
//    // The methods must be annotated with annotation @Test. For example:
//    //
//    @Test
//    public void findStudentSuccesful() {
//        HashTag tag = new HashTag();
//        long id = 2;
//        tag.setContent("#TestContent");
//        tx.begin();
//        hashTagDao.create(tag);
//        HashTag tagFound = hashTagDao.findById(id);
//        tx.commit();
//        assertThat(tagFound, is(tag));
//    }
}
