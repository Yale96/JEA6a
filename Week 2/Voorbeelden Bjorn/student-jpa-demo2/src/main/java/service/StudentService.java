/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.JPA;
import dao.StudentDao;
import domain.Student;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author frankcoenen
 */
@Stateless
public class StudentService {
  
    @Inject @JPA
    private StudentDao studentDao;

     public void addStudent(Student student) {
         studentDao.create(student);
    }
    
    public void removeStudent(Student student) {
       studentDao.remove(student);
    }
         
    public ArrayList<Student> getStudenten() {
        return studentDao.getStudenten();
    }

    public Student findByName(String name) {
        return studentDao.findByName(name);
    }
    
    public StudentService() {
    }  
}
