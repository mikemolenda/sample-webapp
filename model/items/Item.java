/* 
 * Item
 * 
 * Represents a generic item that can be ordered.
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
import java.util.*;

public abstract class Item implements java.io.Serializable {

    private String itemId;
    private String name;
    private BigDecimal price;
    private String category;

    public Item() {
        setItemId(null);
        setName(null);
        setPrice(null);
        setCategory(null);
    }

    public Item(String itemId, String name, BigDecimal price, String category) {
        setItemId(itemId);
        setName(name);
        setPrice(price);
        setCategory(category);
    }

    public String getItemId() {
        return itemId;
    }    

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}