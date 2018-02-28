/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Profile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yannick van Leeuwen
 */
public interface ProfileDao {
    void addProfile(Profile profile);
    
    void updateProfile(Profile profile);
    
    void deleteProfile(Profile profile);
    
    ArrayList<Profile> getAllProfiles();
    
    Profile getProfileByID(int id);
}
