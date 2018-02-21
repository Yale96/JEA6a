
package service;

import dao.StudentDaoColl;
import domain.Student;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class StudentService {
  
    @Inject 
    private StudentDaoColl studentDao;

    public void addStudent(Student student) {        
        studentDao.addStudent(student);
    }
    
    public void removeStudent(Student student) {
       studentDao.removeStudent(student);
    }
    
    public void removeStudent(String name) {
        Student student = findByName(name);
        studentDao.removeStudent(student);  
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
