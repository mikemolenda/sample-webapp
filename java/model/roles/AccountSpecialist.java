/* 
 * AccountSpecialist
 *
 * Represents a customer account support employee of the cable provider.
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
