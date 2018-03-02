/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.UserDao;
import DAO.JPA;
import Models.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Yannick van Leeuwen
 */
@Stateless
public class UserService {

    @Inject @JPA
    private UserDao userDao;

    public void addUser(User user) {
        userDao.create(user);
    }

    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public User getById(Long id) {
        return new User("Yannick");
    }

    public UserService(){

    }
}
