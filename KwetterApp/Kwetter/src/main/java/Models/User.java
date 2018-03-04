/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yannick van Leeuwen
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "user.findById", query = "SELECT u FROM User u WHERE u.username = :name"),
    @NamedQuery(name = "user.count", query = "SELECT COUNT(u) FROM User u")})

@XmlRootElement
public class User implements Serializable {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique=true)
    private String username;
    
    @Column(unique=true)
    private String email;
    
    @Column(nullable = false)
    private String password;
    
    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(name = "user_leaders"
            , joinColumns = @JoinColumn(name = "super_id", referencedColumnName = "id", nullable = false)
            , inverseJoinColumns = @JoinColumn(name = "follower_id", referencedColumnName = "id", nullable = false))
    private ArrayList<User> supers;
    
    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(name = "user_followers"
            , joinColumns = @JoinColumn(name = "follower_id", referencedColumnName = "id", nullable = false)
            , inverseJoinColumns = @JoinColumn(name = "super_id", referencedColumnName = "id", nullable = false))
    private ArrayList<User> followers;
    
    @ManyToMany(mappedBy="likes", cascade = CascadeType.MERGE)
    private ArrayList<Tweet> likes;
    
    @ManyToMany(mappedBy="mentionedUsers", cascade = CascadeType.MERGE)
    private ArrayList<Tweet> mentions;
    
    @OneToMany(mappedBy = "owner", cascade = CascadeType.MERGE)
    private ArrayList<Tweet> tweets;
    
//    @OneToOne(cascade = CascadeType.PERSIST)
//    @JoinTable(name="user_profile",
//        joinColumns=
//            @JoinColumn(name="user_id", referencedColumnName="ID"),
//        inverseJoinColumns=
//            @JoinColumn(name="profile_id", referencedColumnName="ID"))
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;
    
    @Column(nullable = false)
    private String rol;
    
    public User()
    {
        
    }
    
    public User(String email, String password, String username, String rol)
    {
        this.email = email;
        this.password = password;
        this.username = username;
        this.rol = rol;
    }
    
    public Long getId() {
        return id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password)
    {
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
        this.password = (hashstring == null || hashstring.isEmpty()) ? password : hashstring;
    }
    
    public ArrayList<User> getLeaders() {
        return supers;
    }

    public void setLeaders(ArrayList<User> leaders) {
        this.supers = leaders;
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<User> followers) {
        this.followers = followers;
    }

    public ArrayList<Tweet> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<Tweet> likes) {
        this.likes = likes;
    }

    public ArrayList<Tweet> getMentions() {
        return mentions;
    }

    public void setMentions(ArrayList<Tweet> mentions) {
        this.mentions = mentions;
    }

    public ArrayList<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(ArrayList<Tweet> tweets) {
        this.tweets = tweets;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return Objects.equals(this.username, other.username);
    }
}
