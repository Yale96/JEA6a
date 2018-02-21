/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import domain.Student;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.*;


@Stateless @JPA
public class StudentDaoJPA implements StudentDao {

   //@PersistenceContext(unitName = "studentPU")
   @PersistenceContext
   private EntityManager em;

    public StudentDaoJPA() {
    }

    @Override
    public void addStudent(Student student) {
        em.persist(student);
    }

    @Override
    public void removeStudent(Student student) {
        em.remove(em.merge(student));
    }

    public void deleteStudent(String name) {
        em.remove(this.findByName(name));
    }

    @Override
    public Student findByName(String name) {
        TypedQuery<Student> query = em.createNamedQuery("student.findByname", Student.class);
        query.setParameter("name", name);
        List<Student> result = query.getResultList();
        return result.get(0);
    }

    @Override
    public ArrayList<Student> getStudenten() {
        Query query = em.createQuery("SELECT s FROM Student s");
        return new ArrayList<>(query.getResultList());
    }
    
    public int aantal () {
        return getStudenten().size();
    }
    
    
    @PostConstruct
    public void init() {
        //System.out.println("---StudentDaoJPA");
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    
    
}
