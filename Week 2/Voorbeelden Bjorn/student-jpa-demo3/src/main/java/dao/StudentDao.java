/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Student;
import java.util.ArrayList;

/**
 *
 * @author frankcoenen
 */
public interface StudentDao {

    void addStudent(Student student);
    
    void removeStudent(Student student);

    Student findByName(String name);

    ArrayList<Student> getStudenten();
    
}
