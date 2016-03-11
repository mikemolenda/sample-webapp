/* 
 * PPVLiveEvent
 * 
 * Represents a pay-per-view event that can be ordered for a specific date.
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
import java.text.*;
import java.util.*; 

public class PPVLiveEvent extends Item implements java.io.Serializable {

    private Date eventDate;

    public PPVLiveEvent() {
        super();
        super.setCategory("PPV Live Event");
        setEventDate(null);
    }

    public PPVLiveEvent(String itemId, String name, BigDecimal price, 
            Date eventDate) {
        super(itemId, name, price, "PPV Live Event");
        setEventDate(eventDate);
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    /**
     * Returns eventDate as a formatted String.
     */
    public String dateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM, d, h:mm a z");
        return sdf.format(getEventDate()); 
    }
}