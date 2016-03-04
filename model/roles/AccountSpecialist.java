/* 
 * AccountSpecialist
 * 
 * Represents a customer account support employee of the cable provider.
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

public class AccountSpecialist extends User implements java.io.Serializable {

    public AccountSpecialist() {
        super();
        super.setRole("Account Specialist");
    }

    public AccountSpecialist(String username, String email, String password, 
            String fName, String lName) {
        super(username, email, password, fName, lName, "Account Specialist");
    }
}