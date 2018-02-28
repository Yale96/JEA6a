/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.HashTag;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yannick van Leeuwen
 */
public interface HashTagDao {
    void addHashTag(HashTag hashTag);
    
    void updateHashTag(HashTag hashTag);
    
    void deleteHashTag(HashTag hashTag);
    
    ArrayList<HashTag> getAllHashtags();
    
    HashTag getHashTagById(int id);
}
