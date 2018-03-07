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
        
        User uOne = new User("yannickvanleeuwen@i-lion.nl", "", "Yale96", "Admin");
        uOne.setPassword("Yannick");
        uService.addUser(uOne);
        
        Profile pOne = new Profile("TestOne", "TestOne", "TestOne", "TestOne", "TestOne");
        pService.addProfile(pOne);
        
        Tweet tOne = new Tweet("Test", new Date());
        tService.addTweet(tOne);
        
        HashTag hOne = new HashTag("#DitIsEenTest");
        hService.addHashTag(hOne);
        
        uOne.setProfile(pOne);
    }
}
