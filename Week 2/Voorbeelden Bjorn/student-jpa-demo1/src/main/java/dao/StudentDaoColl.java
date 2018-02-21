/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import domain.Student;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;


@Stateless @Default
public class StudentDaoColl implements StudentDao {

    CopyOnWriteArrayList<Student> studenten = new CopyOnWriteArrayList<>();

    @Override
    public void addStudent(Student student) {
        studenten.add(student);
    }
 
    @Override
    public void removeStudent(Student student) {
       studenten.remove(student);
    }

    @Override
    public ArrayList<Student> getStudenten() {
        return new ArrayList<>(studenten);
    }

    @Override
    public Student findByName(String name) {
        for (Student student : studenten) {
            if (student.getName().contentEquals(name)) {
                return student;
            }
        }
        return null;
    }
    
    
    @PostConstruct
    private void init(){
       // System.out.println("StudentDaoColl");
    }
    
    
    public StudentDaoColl() {
    }
    
     
  
}
