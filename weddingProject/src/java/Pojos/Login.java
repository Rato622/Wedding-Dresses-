/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pojos;

/**
 *
 * @author user
 */
public class Login 
{
    
    private String username;
    private String password,clientID;
    private String role;

    public Login() {
    }

    public Login(String clientID,String username, String password, String role) {
        this.clientID=clientID;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
    
}
