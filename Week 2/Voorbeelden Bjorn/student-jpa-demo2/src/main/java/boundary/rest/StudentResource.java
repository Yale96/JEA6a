/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.rest;

import domain.Student;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import service.StudentService;


@Path("students")
@Stateless
public class StudentResource {

    @Inject
    private StudentService s;

    @GET
    public List<Student> getAll() {
        return s.getStudenten();
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudent(@PathParam("name") String name) {
        Student student = s.findByName(name);
        return student;
    }
}

//  @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})