/* 
 * Customer
 *
 * Represents a customer of the cable provider.
 */

package model.roles;

public class Customer extends User implements java.io.Serializable {

    private String creditCardNo;

    public Customer() {
        super();
        super.setRole("Customer");
        setCreditCardNo(null);
    }

    public Customer(String username, String email, String password, String fName,
            String lName, String creditCardNo) {
        super(username, email, password, fName, lName, "Customer");
        setCreditCardNo(creditCardNo);
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public String getCCLast4() {
        return creditCardNo.substring(creditCardNo.length() - 4);
    }

}
