/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.User;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author Yannick van Leeuwen
 */
@Singleton
@Startup
public class StartUp {


    @Inject
    private UserService service;

    public StartUp() {
        //TODO Might want to do something on startup.. like maybe seed Database
    }

    @PostConstruct
    private void intData(){
        service.addUser(new User("YannickVanLeeuwen"));
        service.addUser(new User("DennisVanLeeuwen"));
    }
}
