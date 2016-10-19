/* 
 * PPVMovie
 *
 * Represents a pay-per-view movie that can be ordered.
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
