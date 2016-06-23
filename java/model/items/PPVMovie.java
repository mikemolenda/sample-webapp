/* 
 * PPVMovie
 * 
 * Represents a pay-per-view movie that can be ordered.
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

public class PPVMovie extends Item implements java.io.Serializable {

    public PPVMovie() {
        super();
        super.setCategory("PPV Movie");
    }

    public PPVMovie(String itemId, String name, BigDecimal price) {
        super(itemId, name, price, "PPV Movie");
    }
    
}