/* 
 * EntityData
 * 
 * Provides data hard-coded in HashMaps for use by the application.
 * Note that data will reset to default each time the application is started.
 * Since this is an academic exercise, that's not such a big deal.
 * 
 * Northwestern University
 * CIS 419 Web Application Development, Winter 2017
 * Final Project
 *
 * March 13, 2016
 *
 * Mike Molenda
 * michaelmolenda2014@u.northwestern.edu 
 */

package model;

import java.math.*; 
import java.util.*;
import java.util.Map.*;

import model.items.*;
import model.roles.*;
import model.system.*;

public class EntityData {

    /*
     * Data for Users hard-coded into Hashmap via anonymous class.
     *
     * Schema borrowed from CIS419 course materials.
     */
    private static Map<String, User> users = new HashMap<String, User>() {{
        put("customer1", new Customer("customer1", "steveholt@widecast.net",  
            "cis419", "Steve", "Holt", "1111111111111111")); 
        put("customer2", new Customer("customer2", "lucille2@widecast.net", 
            "cis419", "Lucille", "Austero", "2222222222222222")); 
        put("manager1", new Manager("manager1", "mrmanager@widecast.net", 
            "cis419", "George-Michael", "Bluth")); 
        put("manager2", new Manager("manager2", "her?@widecast.net", 
            "cis419", "Ann", "Veal"));
        put("technican1", new Technician("technican1", "tobias@widecast.net", 
            "cis419", "Tobias", "Funke"));
        put("technican2", new Technician("technican2", "gene@widecast.net", 
            "cis419", "Gene", "Parmesan"));
        put("accountadmin1", new AccountSpecialist("csr1", "gangie@widecast.net", 
            "cis419", "Lucille", "Bluth"));
        put("accountadmin2", new AccountSpecialist("csr2", "poppop@widecast.net", 
            "cis419", "George", "Bluth"));
    }};

    /* 
     * Data for TVPlan, InternetPlan, PPVLiveEvent, and PPVMovie hard-coded into
     * HashMap via anonymous class.
     *
     * Schema borrowed from CIS419 course materials.
     */
    private static Map<String, Item> items = new HashMap<String, Item>() {{
        put("1", new TVPlan("1", "Basic - 50 channels", 
            new BigDecimal("49.99")));
        put("2", new TVPlan("2", "BasicPlus - 100 channels", 
            new BigDecimal("99.99")));
        put("3", new TVPlan("3", "Ultimate - 200 channels", 
            new BigDecimal("149.99")));
        put("4", new InternetPlan("4", "SpeedLane - 20/5 Mbps", 
            new BigDecimal("99.99")));
        put("5", new InternetPlan("5", "LightLane - 50/10 Mbps", 
            new BigDecimal("149.99")));
        put("6", new PPVLiveEvent("6", "Boxing Heavyweight Championship", 
            new BigDecimal("99.99"), getDate()));
        put("7", new PPVLiveEvent("7", "WrestleMania MCDLXXXIV", 
            new BigDecimal("49.99"), getDate()));
        put("8", new PPVLiveEvent("8", "Wimbledon Tennis Championship", 
            new BigDecimal("49.99"), getDate()));
        put("9", new PPVLiveEvent("9", "MLB World Series", 
            new BigDecimal("39.99"), getDate()));
        put("10", new PPVLiveEvent("10", "NHL Stanley Cup Playoffs", 
            new BigDecimal("29.99"), getDate()));
        put("11", new PPVLiveEvent("11", "NCAA March Madness", 
            new BigDecimal("19.99"), getDate()));
        put("12", new PPVLiveEvent("12", "NFL Pro Bowl", 
            new BigDecimal("19.99"), getDate()));
        put("13", new PPVLiveEvent("13", "FIFA World Cup", 
            new BigDecimal("19.99"), getDate()));
        put("14", new PPVLiveEvent("14", "PGA Masters Tournament", 
            new BigDecimal("29.99"), getDate()));
        put("15", new PPVLiveEvent("15", "Quidditch World Cup", 
            new BigDecimal("39.99"), getDate()));
        put("16", new PPVMovie("16", "Troll 2 (1990)", 
            new BigDecimal("1.99")));
        put("17", new PPVMovie("17", "The Room (2003)", 
            new BigDecimal("1.99")));
        put("18", new PPVMovie("18", "Superman IV (1987)", 
            new BigDecimal("1.99")));
        put("19", new PPVMovie("19", "Batman and Robin (1997)", 
            new BigDecimal("1.99")));
        put("20", new PPVMovie("20", "Plan 9 from Outer Space (1989)", 
            new BigDecimal("1.99")));
        put("21", new PPVMovie("21", "Battlefield Earth (2000)", 
            new BigDecimal("1.99")));
        put("22", new PPVMovie("22", "Showgirls (1995)", 
            new BigDecimal("1.99")));
        put("23", new PPVMovie("23", "Mac and Me (1988)", 
            new BigDecimal("1.99")));
        put("24", new PPVMovie("24", "Birdemic (2008)", 
            new BigDecimal("1.99")));
        put("25", new PPVMovie("25", "Manos: The Hands of Fate (1966)", 
            new BigDecimal("1.99")));
        put("26", new PPVMovie("26", "Star Wars: The Phantom Menace (1999)",
            new BigDecimal("1.99")));
        put("27", new PPVMovie("27", "Transformers (2007)", 
            new BigDecimal("1.99")));
        put("28", new PPVMovie("28", "Transformers 2 (2009)", 
            new BigDecimal("1.99")));
        put("29", new PPVMovie("29", "Transformers 3 (2011)", 
            new BigDecimal("1.99")));
        put("30", new PPVMovie("30", "Transformers 4 (2014)", 
            new BigDecimal("1.99")));
        put("31", new PPVMovie("31", "Snakes on a Plane (2006)", 
            new BigDecimal("1.99")));
        put("32", new PPVMovie("32", "Gigli (2003)", 
            new BigDecimal("1.99")));
        put("33", new PPVMovie("33", "Fast and Furious 7 (2015)", 
            new BigDecimal("1.99")));
        put("34", new PPVMovie("34", "Freaked (1993)", 
            new BigDecimal("1.99")));
        put("35", new PPVMovie("35", "Adam Sandler's Citizen Kane (2016)", 
            new BigDecimal("1.99")));
    }};

    private static Map<String, Order> orders = new HashMap<String, Order>();

    private static Map<String, Ticket> tickets = new HashMap<String, Ticket>();

    private static int dayCounter = 1;  // Counter for use with getDate()

    /**
     * Generates a new date for each PPVLiveEvent in HashMap
     *
     * Borrowed from CIS419 course materials.
     */
    private static Date getDate() {
        Calendar cal = Calendar.getInstance();

        // All events start at 5:00 PM
        cal.set(Calendar.HOUR_OF_DAY, 17);  
        cal.set(Calendar.MINUTE, 00);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        // Increment value for eventDate, no two events are on the same day
        cal.add(Calendar.DATE, dayCounter++);

        Date broadcastDate = cal.getTime();
        return broadcastDate; 
    }

    public static Map<String, User> getUsers() {
        return users;
    }

    public static Map<String, Item> getItems() {
        return items;
    }

    public static Map<String, Order> getOrders() {
        return orders;
    }

    /**
     * Adds an order to the map
     */
    public static synchronized String addOrder(Order order) {
        
        String condition;   // Error/success condition of add

        // Do not add order if it is already in the list
        if (orders.containsValue(order)) {
            condition = "Item already ordered!";
            return condition;
        }

        for (Entry<String, Order> entry : orders.entrySet()) {
            // Verify that order does not duplicate a customer's existing order
            Order o = entry.getValue();
            if (order.getCustomer().equals(o.getCustomer())) {
                // Do not add if customer already has item with same name
                if (order.getItem().equals(o.getItem())) {
                    condition = "Item already ordered!";
                    return condition;
                }

                // Do not add TV Plan if customer already has one
                if (order.getItem().getCategory().equals("TV Plan") && 
                        o.getItem().getCategory().equals("TV Plan")) {
                    condition = "You must cancel your existing plan first!";
                    return condition;
                }

                // Do not add Internet Plan if customer already has one
                if (order.getItem().getCategory().equals("Internet Plan") && 
                        o.getItem().getCategory().equals("Internet Plan")) {
                    condition = "You must cancel your existing plan first!";
                    return condition;
                }

                // Do not add PPV event if date has passed
                if (order.getItem().getCategory().equals("PPV Live Event")) {
                    PPVLiveEvent event = (PPVLiveEvent) order.getItem();
                    Calendar eventCal = Calendar.getInstance();
                    Calendar todayCal = Calendar.getInstance();
                    eventCal.setTime(event.getEventDate());

                    if (eventCal.after(todayCal)) {
                        condition = "That event has already occurred!";
                        return condition;    
                    }
                }
            }
        }

        // Otherwise add the item
        orders.put(order.getOrderId(), order);
        condition = "Success!";
        return condition;
    }

    /**
     * Removes a single order, based on orderId
     */
    public static void removeOrder(String orderId) {
        orders.remove(orderId);
    }

    /**
     * Removes all of a specified user's orders
     */
    public static void clearOrders(Customer customer) {
        
        for (Entry<String, Order> entry : orders.entrySet()) {

            String key = entry.getKey();
            Order order = entry.getValue();
            
            if (order.getCustomer().equals(customer)) {
                orders.remove(key);
            }
        }
    }

    public static Map<String, Ticket> getTickets() {
        return tickets;
    }

    public static synchronized String addTicket(Ticket ticket) {

        String condition;   // Error/success condition of add

        return "";
    }
}