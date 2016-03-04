/* 
 * TVPlan
 * 
 * Represents a TV monthly subscription that can be ordered.
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

public class TVPlan extends Item implements java.io.Serializable {

    public TVPlan() {
        super();
        super.setCategory("TV Plan");
    }

    public TVPlan(String itemId, String name, BigDecimal price) {
        super(itemId, name, price, "TV Plan");
    }
}