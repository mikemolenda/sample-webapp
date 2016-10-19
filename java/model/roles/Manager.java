/* 
 * Manager
 *
 * Represents a cable provider manager (user with full access privileges).
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
