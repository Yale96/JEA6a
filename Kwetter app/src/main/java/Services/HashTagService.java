/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.HashTagDao;
import DAO.JPA;
import DAO.ProfileDao;
import Models.HashTag;
import Models.Profile;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Yannick van Leeuwen
 */
@Stateless
public class HashTagService {
    
    @Inject @JPA
    private HashTagDao hashTagDao;

    public void addHashTag(HashTag hashTag) {
        hashTagDao.create(hashTag);
    }

    public List<HashTag> getHashTags() {
        return hashTagDao.getHashTags();
    }

    public HashTag getById(Long id) {
        return new HashTag("TestTag");
    }

    public HashTagService(){

    }
}
