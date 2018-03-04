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
//        User uOne = new User("TestOne", "TestOne", "TestOne", "TestOne");
//        uOne.setPassword("Yannick");
//        User uTwo = new User("TestTwo", "TestTwo", "TestTwo", "TestTwo");
//        uOne.setPassword("Dennis");
//        uService.addUser(uOne);
//        uService.addUser(uTwo);
        uService.addUser(new User("TestOne", "TestOne", "TestOne", "TestOne"));
        uService.addUser(new User("TestTwo", "TestTwo", "TestTwo", "TestTwo"));
        tService.addTweet(new Tweet("Test", new Date()));
        pService.addProfile(new Profile("TestOne", "TestOne", "TestOne", "TestOne", "TestOne"));
        pService.addProfile(new Profile("TestTwo", "TestTwo", "TestTwo", "TestTwo", "TestTwo"));
    }
}
