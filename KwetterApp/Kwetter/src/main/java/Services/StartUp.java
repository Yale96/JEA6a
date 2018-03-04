/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.Profile;
import Models.Tweet;
import Models.User;
import java.util.Date;
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
    private UserService uService;
    @Inject
    private TweetService tService;
    @Inject
    private ProfileService pService;

    public StartUp() {
        
    }

    @PostConstruct
    private void intData(){
        uService.addUser(new User("TestOne", "TestOne", "TestOne", "TestOne"));
        uService.addUser(new User("TestTwo", "TestTwo", "TestTwo", "TestTwo"));
        tService.addTweet(new Tweet("Test", new Date()));
        pService.addProfile(new Profile("Test", "Test", "Test", "Test", "Test"));
        pService.addProfile(new Profile("Test", "Test", "Test", "Test", "Test"));
    }
}
