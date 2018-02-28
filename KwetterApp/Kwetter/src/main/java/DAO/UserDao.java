/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yannick van Leeuwen
 */
public interface UserDao {
    void registerUser();
    
    void updateUser(User user);
    
    void deleteUser(User user);
    
    ArrayList<User> getAllUsers();
    
    User getUserById(int id);
}
