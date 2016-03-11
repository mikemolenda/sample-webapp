/* 
 * User
 * 
 * Represents a generic user of the application.
 * 
 * Northwestern University
 * CIS 419 Web Application Development, Winter 2016
 * Final Project
 *
 * March 13, 2016
 *
 * Mike Molenda
 * michaelmolenda2014@u.northwestern.edu 
 */

package model.roles; 

public abstract class User implements java.io.Serializable {

    private String username;
    private String email;
    private String password;
    private String fName;
    private String lName;   
    private String role;        

    public User() {
        setUsername(null);
        setEmail(null);
        setPassword(null);
        setFName(null);
        setLName(null);
        setRole(null);
    }

    public User(String username, String email, String password, String fName, 
            String lName, String role) {
        setUsername(username);
        setEmail(email);
        setPassword(password);
        setFName(fName);
        setLName(lName);
        setRole(role);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}