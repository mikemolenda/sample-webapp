/* 
 * InternetPlan
 * 
 * Represents a Internet monthly subscription that can be ordered.
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

package model.items;

import java.math.*;

public class InternetPlan extends Item implements java.io.Serializable {

    public InternetPlan() {
        super();
        super.setCategory("Internet Plan");
    }

    public InternetPlan(String itemId, String name, BigDecimal price) {
        super(itemId, name, price, "Internet Plan");
    }    
} 