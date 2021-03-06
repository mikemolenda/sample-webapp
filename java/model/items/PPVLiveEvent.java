/* 
 * PPVLiveEvent
 *
 * Represents a pay-per-view event that can be ordered for a specific date.
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
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM, d, h:mm a");
        return sdf.format(getEventDate());
    }
}
