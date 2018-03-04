/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.JPA;
import DAO.ProfileDao;
import DAO.UserDao;
import Models.Profile;
import Models.User;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Yannick van Leeuwen
 */
@Stateless
public class ProfileService {

    @EJB
    private UserService uService;
    
    @Inject @JPA
    private ProfileDao profileDao;

    public void addProfile(Profile profile) {
        profileDao.create(profile);
    }

    public List<Profile> getProfiles() {
        return profileDao.getProfiles();
    }

    public Profile getById(Long id) {
        return new Profile("Test", "Test", "Test", "Test", "Test");
    }

    public ProfileService(){

    }
}
