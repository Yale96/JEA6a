/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.JPA;
import domain.Student;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author frankcoenen
 */
@Singleton
@Startup
public class StartUp {

    @Inject 
    private StudentService service;
      
    public StartUp() {
    }
     
    @PostConstruct
    private void intData(){
        service.addStudent(new Student("Frank", 30, "Java"));
        service.addStudent(new Student("Monique", 29, "JavaScript"));
        service.addStudent(new Student("Jasmijn", 28, "C#"));
        service.addStudent(new Student("Feline", 26, "C++"));
        service.addStudent(new Student("Pim", 25, "C"));
        service.addStudent(new Student("Joris", 24, "Java EE"));
    }
    
}
