/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.HashTag;
import Models.Profile;
import java.util.ArrayList;

/**
 *
 * @author Yannick van Leeuwen
 */
public interface HashTagDao {
    void create(HashTag hashTag);
    
    void remove(HashTag hashTag);

    HashTag findById(Long id);

    ArrayList<HashTag> getHashTags();
}
