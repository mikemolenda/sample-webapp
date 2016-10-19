/* 
 * InternetPlan
 *
 * Represents a Internet monthly subscription that can be ordered.
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
