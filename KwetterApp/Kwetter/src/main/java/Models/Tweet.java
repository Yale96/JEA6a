/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;


/**
 *
 * @author Yannick van Leeuwen
 */
public class Tweet {
    private int Id;
    private String Content;
    private Date Timestamp;
    
    public Tweet(String content, Date timestamp)
    {
        this.Content = content;
        this.Timestamp = timestamp;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public Date getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(Date Timestamp) {
        this.Timestamp = Timestamp;
    }        
}
