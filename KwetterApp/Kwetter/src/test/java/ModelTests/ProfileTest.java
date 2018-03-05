/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelTests;

import Models.Profile;
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
public class ProfileTest {
    
    public ProfileTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testGettersAndSetters() {
        Profile p = new Profile();
        long id = 1;
        String name = "Yannick";
        String location = "TillyWestSide";
        String web = "www.yannick.nl";
        String bio = "Hoi ik ben Yannick. Een leuke jongeman uit het noorde van het zuiden van het land";
        String picture = "It's a dick pick";
        
        p.setId(id);
        p.setName(name);
        p.setLocation(location);
        p.setWeb(web);
        p.setBio(bio);
        p.setPicture(picture);
        
        assertEquals(id, p.getId());
        assertEquals(name, p.getName());
        assertEquals(location, p.getLocation());
        assertEquals(web, p.getWeb());
        assertEquals(bio, p.getBio());
        assertEquals(picture, p.getPicture());
    }

    @Test
    public void testAddMethods() {

    }

    @Test
    public void testRemoveMethods() {

    }
}
