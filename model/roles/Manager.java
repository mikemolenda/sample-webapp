/* 
 * Manager
 * 
 * Represents a cable provider manager (user with full access privileges).
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

public class Manager extends User implements java.io.Serializable {

    public Manager() {
        super();
        super.setRole("Manager");
    }

    public Manager(String username, String email, String password, 
            String fName, String lName) {
        super(username, email, password, fName, lName, "Manager");
    }
}   