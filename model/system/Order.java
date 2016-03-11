/* 
 * Order
 * 
 * Represents an order that can be placed by a Customer, and manipulated by an 
 * Account Specialist or Manager
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

package model.system; 

import java.text.*;
import java.util.*;

import model.*;
import model.items.*;
import model.roles.*; 

public class Order implements java.io.Serializable {

    private final String ORDER_ID;
    private Item item;
    private Customer customer;
    private Date orderDate;

    public Order() {
        // Always generate a unique ID for the order
        // Borrowed from http://stackoverflow.com/a/4009586
        this.ORDER_ID = UUID.randomUUID().toString(); 
        setItem(null);
        setOrderDate(null);
        setCustomer(null);
    }

    public Order(Item item, Date orderDate, Customer customer) {
        this.ORDER_ID = UUID.randomUUID().toString(); 
        setItem(item);
        setCustomer(customer);
        setOrderDate(orderDate);
    }

    // Set orderDate to today if no date provided to constructor
    public Order(Item item, Customer customer) {
        this.ORDER_ID = UUID.randomUUID().toString(); 
        setItem(item);
        setCustomer(customer);
        Calendar cal = Calendar.getInstance();
        setOrderDate(cal.getTime());
    }

    public String getOrderId() {
        return ORDER_ID;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Returns orderDate as a formatted String.
     */
    public String dateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(getOrderDate()); 
    }
}