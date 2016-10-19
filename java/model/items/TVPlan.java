/* 
 * TVPlan
 *
 * Represents a TV monthly subscription that can be ordered.
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
