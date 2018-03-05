/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelTests;

import Models.User;
import java.security.MessageDigest;
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testGettersAndSetters() {
        long id = 1;
        String email = "yannickvanleeuwen@i-lion.nl";
        String password = "yannick";
        String userName = "Yale96";
        String rol = "Admin";
        
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
        
        assertEquals(id, testUser.getId());
        assertEquals(expectedPassword, testUser.getPassword());
        assertEquals(userName, testUser.getUsername());
        assertEquals(rol, testUser.getRol());
                
    }

    @Test
    public void testAddMethods() {

    }

    @Test
    public void testRemoveMethods() {

    }
}
