/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Yannick van Leeuwen
 */
public class Authenticator {

    public String authenticate(String username, String password) {
		if (("prasad".equalsIgnoreCase(username))
				&& ("password".equals(password))) {
			return "success";
		} else {
			return "failure";
		}
	}
    
}
