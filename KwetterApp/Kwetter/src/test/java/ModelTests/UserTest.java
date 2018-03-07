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
import java.security.MessageDigest;
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
public class UserTest {
    
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testGettersAndSetters() {
        long id = 1;
        String email = "yannickvanleeuwen@i-lion.nl";
        String password = "yannick";
        String userName = "Yale96";
        String rol = "Admin";
        
        User follower = new User();
        follower.setEmail("test");
        follower.setPassword("test");
        follower.setUsername("uname");
        follower.setRol("rolleke");
        
        ArrayList<User> supers = new ArrayList<>();
        ArrayList<User> followers = new ArrayList<>();
        ArrayList<Tweet> likes = new ArrayList<>();
        ArrayList<Tweet> mentions = new ArrayList<>();
        ArrayList<Tweet> tweets = new ArrayList<>();
        
        String hashstring = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }

            hashstring = hexString.toString();
        }
        catch (Exception x) {
            System.out.println(x);
        }
        String expectedPassword = (hashstring == null || hashstring.isEmpty()) ? password : hashstring;
        
        User testUser = new User();
        testUser.setId(id);
        testUser.setPassword(password);
        testUser.setEmail(email);
        testUser.setUsername(userName);
        testUser.setRol(rol);
        
        Tweet t = new Tweet();
        t.setId(id);
        t.setContent("Tessst");
        t.setTimeStamp(new Date());
        t.setOwner(testUser);
        
        supers.add(testUser);
        followers.add(follower);
        likes.add(t);
        mentions.add(t);
        tweets.add(t);
        
        testUser.setSupers(supers);
        testUser.setFollowers(followers);
        testUser.setLikes(likes);
        testUser.setMentions(mentions);
        testUser.setTweets(tweets);
        
        assertEquals(id, testUser.getId());
        assertEquals(expectedPassword, testUser.getPassword());
        assertEquals(userName, testUser.getUsername());
        assertEquals(rol, testUser.getRol());
        
        assertEquals(supers, testUser.getSupers());
        assertEquals(followers, testUser.getFollowers());
        assertEquals(likes, testUser.getLikes());
        assertEquals(mentions, testUser.getMentions());        
        assertEquals(tweets, testUser.getTweets());
                
    }

    @Test
    public void testAddMethods() {
        User uOne = new User();
//        uOne.setId(1);
//        uOne.setPassword("Test");
//        uOne.setEmail("Test");
//        uOne.setUsername("Test");
//        uOne.setRol("Test");
        
        User uTwo = new User();
//        uTwo.setId(1);
//        uTwo.setPassword("Test");
//        uTwo.setEmail("Test");
//        uTwo.setUsername("Test");
//        uTwo.setRol("Test");
        
        Tweet tOne = new Tweet();
//        tOne.setId(1);
//        tOne.setOwner(uOne);
//        tOne.setContent("Test");
//        tOne.setTimeStamp(new Date());
        
//       Profile pOne = new Profile();
//       Profile pTwo = new Profile();
//        uOne.setProfile(pOne);
//        uTwo.setProfile(pTwo);
        
        Tweet tTwo = new Tweet();
//        tTwo.setId(1);
//        tTwo.setOwner(uOne);
//        tTwo.setContent("Test");
//        tTwo.setTimeStamp(new Date());
        
        HashTag hOne = new HashTag();
//        hOne.setId(1);
//        hOne.setContent("Testcontent");
        
        tOne.addLike(uOne);
        tOne.addMention(uOne);
        tOne.addHashTag(hOne);
        
        uOne.addSuper(uOne);
        uOne.addMention(tOne);
        uOne.addTweet(tOne);
        uOne.addLike(tOne);
        
        uTwo.addFollower(uOne);
        uTwo.addLike(tTwo);
        uTwo.addMention(tTwo);
        
        assertEquals(uOne, tOne.getLikes().get(0));
        assertEquals(uOne, tOne.getMentionedUsers().get(0));
        assertEquals(hOne, tOne.getHashtags().get(0));

        assertEquals(uOne, uOne.getLeaders().get(0));
        assertEquals(uOne, uOne.getFollowers().get(0));
        assertEquals(tOne, uOne.getMentions().get(0));
        assertEquals(tOne, uOne.getTweets().get(0));
        assertEquals(tOne, uOne.getLikes().get(0));

        assertEquals(uOne, uTwo.getFollowers().get(0));
        assertEquals(tTwo, uTwo.getLikes().get(0));
        assertEquals(tTwo, uTwo.getMentions().get(0));
    }

    @Test
    public void testRemoveMethods() {
        
    }
}
