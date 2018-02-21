/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author frankcoenen
 */

@Entity
@NamedQueries({
    @NamedQuery(name = "student.findByname", query = "SELECT s FROM Student s WHERE s.name = :name"),
    @NamedQuery(name = "student.count", query = "SELECT COUNT(s) FROM Student s")})

@XmlRootElement
public class Student implements Serializable {
    
    @Id @GeneratedValue
    private Long id;   
    @Column(unique=true)
    private String name;
    private Integer age;
    private String skill;

    public Student() {
    }

    public Student(String name, Integer age, String skill) {
        this.name = name;
        this.age = age;
        this.skill = skill;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer Age) {
        this.age = Age;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String Skill) {
        this.skill = Skill;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        return Objects.equals(this.name, other.name);
    }
}
