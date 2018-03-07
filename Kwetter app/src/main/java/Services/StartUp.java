/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.HashTag;
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
    @Inject
    private HashTagService hService;

    public StartUp() {
        
    }

    @PostConstruct
    private void intData(){
//        User uOne = new User("yannickvanleeuwen@i-lion.nl", "", "Yale96", "Admin");
//        uOne.setPassword("Yannick");
//        User uTwo = new User("dennisvanleeuwen@i-lion.nl", "", "Dendi78", "User");
//        uTwo.setPassword("Dennis");
//        
//        Profile pOne = new Profile("TestOne", "TestOne", "TestOne", "TestOne", "TestOne");
//        Profile pTwo = new Profile("TestTwo", "TestTwo", "TestTwo", "TestTwo", "TestTwo");
//        
//        Tweet t = new Tweet("Test", new Date());
//        
////        uService.addUser(new User("TestOne", "TestOne", "TestOne", "TestOne"));
////        uService.addUser(new User("TestTwo", "TestTwo", "TestTwo", "TestTwo"));
//
//        pService.addProfile(pOne);
//        pService.addProfile(pTwo);
//        
//        hService.addHashTag(new HashTag("Test hashTag #Jeej"));
//        
//        uOne.setProfile(pOne);
//        uTwo.setProfile(pTwo);
//        uService.addUser(uOne);
//        uService.addUser(uTwo);
//        
//        t.setOwner(uOne);
//        tService.addTweet(t);
        
    }
}
