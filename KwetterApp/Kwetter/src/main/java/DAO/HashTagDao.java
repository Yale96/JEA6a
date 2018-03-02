/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.HashTag;
import Models.Tweet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yannick van Leeuwen
 */
public interface HashTagDao {
    void create(HashTag hashTag);
    
    void remove(HashTag hashTag);
    
    HashTag findById(int id);
    
    ArrayList<HashTag> getAll();
}
