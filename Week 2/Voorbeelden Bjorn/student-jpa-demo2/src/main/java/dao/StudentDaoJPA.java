/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Student;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author frankcoenen
 */
@Stateless @JPA
public class StudentDaoJPA extends DaoFacade<Student> implements StudentDao {

    @PersistenceContext
    private EntityManager em;
    
    public StudentDaoJPA() {
        super(Student.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public Student findByName(String name) {
        TypedQuery<Student> query = em.createNamedQuery("student.findByname", Student.class);
        query.setParameter("name", name);
        List<Student> result = query.getResultList();
        System.out.println("count: " + result.size());
        return result.get(0);
    }

    @Override
    public ArrayList<Student> getStudenten() {
         Query query = em.createQuery("SELECT s FROM Student s");
         return  new ArrayList<>(query.getResultList());
    }
    
}
