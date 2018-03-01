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
public class User {
    private int Id;
    private String Username;
    private String Password;
    public List<User> IsFollowing;
    public List<User> FollowedBy;
    public List<Tweet> MentionedIn;
    private Profile Profile;
    private Roles Role;
    public List<Tweet> Posts;
    public List<Tweet> LikedTweets;
    
    public User(String username, String password, Roles role, Profile profile)
    {
        this.Username = username;
        this.Password = password;
        IsFollowing = new ArrayList<User>();
        FollowedBy = new ArrayList<User>();
        MentionedIn = new ArrayList<Tweet>();
        Posts = new ArrayList<Tweet>();
        this.Role = role;
        LikedTweets = new ArrayList<Tweet>();
        this.Profile = profile;
    }

    public Roles getRole() {
        return Role;
    }

    public void setRole(Roles Role) {
        this.Role = Role;
    }
    
    public Profile getProfile() {
        return Profile;
    }

    public void setProfile(Profile Profile) {
        this.Profile = Profile;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }
    
    public void addFollower(User follower)
    {
        this.FollowedBy.add(follower);
    }
    
    public void addFollowing(User following)
    {
        this.IsFollowing.add(following);
    }
    
    public void removeFollower(User follower)
    {
        this.FollowedBy.remove(follower);
    }
    
    public void removeFollowing(User following)
    {
        this.IsFollowing.remove(following);
    }
    
    public List<User> getAllFollowers()
    {
        List<User> AllFollowers = new ArrayList<>();
        for(User u: FollowedBy)
        {
            AllFollowers.add(u);
        }
        return AllFollowers;
    }
    
    public List<User> getAllFollowing()
    {
        List<User> AllFollowing = new ArrayList<>();
        for(User u: IsFollowing)
        {
            AllFollowing.add(u);
        }
        return AllFollowing;
    }
}
