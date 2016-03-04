/* 
 * Technician
 * 
 * Represents a technical support employee of the cable provider.
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

public class Technician extends User implements java.io.Serializable {

    public Technician() {
        super();
        super.setRole("Technician");
    }

    public Technician(String username, String email, String password, 
            String fName, String lName) {
        super(username, email, password, fName, lName, "Technician");
    }
}