/* 
 * Technician
 *
 * Represents a technical support employee of the cable provider.
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
