/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelTests;

import Models.HashTag;
import Models.Profile;
import Models.Tweet;
import Models.User;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yannick van Leeuwen
 */
public class HashTagTest {
    
    public HashTagTest() {
    }
    
    @Test
    public void testGettersAndSetters() {
        long id = 1;
        String testTag = "#DitIsEenTestTag";
        
        User owner = new User();
        owner.setId(1);
        owner.setPassword("Yannick");
        owner.setEmail("Test");
        owner.setUsername("Yale96");
        owner.setRol("Admin");
        
        Tweet t = new Tweet();
        t.setId(id);
        t.setContent("Tessst");
        t.setTimeStamp(new Date());
        t.setOwner(owner);
        
        ArrayList<Tweet> tweets = new ArrayList<>();
        tweets.add(t);
        
        HashTag testHashTag = new HashTag();
        testHashTag.setId(id);
        testHashTag.setContent(testTag);
        testHashTag.setTweets(tweets);
        
        assertEquals(id, testHashTag.getId());
        assertEquals(testTag, testHashTag.getContent()); 
        assertEquals(tweets, testHashTag.getTweets());
    }

    @Test
    public void testAddMethods() {
        Tweet tOne = new Tweet();
        HashTag hOne = new HashTag();
        
        hOne.addTweet(tOne);
        
        assertEquals(tOne, hOne.getTweets().get(0));
    }

    @Test
    public void testRemoveMethods() {

    }
}
