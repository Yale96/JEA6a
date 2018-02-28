/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Yannick van Leeuwen
 */
public class User {
    private int Id;
    private String Username;
    private String Password;
    private Roles Role;
    
    public User(String username, String password, Roles role)
    {
        this.Username = username;
        this.Password = password;
        this.Role = role;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public Roles getRole() {
        return Role;
    }

    public void setRole(Roles Role) {
        this.Role = Role;
    }
}
