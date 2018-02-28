/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yannick van Leeuwen
 */
public class HashTag {
    private String Content;
    public List<Tweet> TaggedIn;
    
    public HashTag(String content)
    {
        this.Content = content;
        TaggedIn = new ArrayList<Tweet>();
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }
    
}
