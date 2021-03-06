/* 
 * Ticket
 *
 * Represents a support ticket that can be assigned to a technician
 */

package model.system;

import java.util.*;
import java.text.*;

import model.*;
import model.roles.*;

public class Ticket implements java.io.Serializable {

    private final String TICKET_ID;
    String message;
    Customer customer;
    Technician technician;
    boolean open;
    Date scheduleDate;

    public Ticket() {
        // Always generate a unique ID for the ticket
        // Borrowed from http://stackoverflow.com/a/4009586
        this.TICKET_ID = UUID.randomUUID().toString();
        setMessage(null);
        setCustomer(null);
        setTechnician(null);
        setOpen(false);
        setScheduleDate(null);
    }

    public Ticket(String message, Customer customer,
            Technician technician, Date scheduleDate, boolean open) {
        this.TICKET_ID = UUID.randomUUID().toString();
        setMessage(message);
        setCustomer(customer);
        setTechnician(technician);
        setOpen(open);
        setScheduleDate(scheduleDate);
    }

    // Set scheduleDate to today if no date provided to constructor
    public Ticket(String message, Customer customer,
            Technician technician, boolean open) {
        this.TICKET_ID = UUID.randomUUID().toString();
        setMessage(message);
        setCustomer(customer);
        setTechnician(technician);
        setOpen(open);
        Calendar cal = Calendar.getInstance();
        setScheduleDate(cal.getTime());
    }

    public String getTicketId() {
        return TICKET_ID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    /**
     * Returns scheduleDate as a formatted String.
     */
    public String dateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(getScheduleDate());
    }
}
