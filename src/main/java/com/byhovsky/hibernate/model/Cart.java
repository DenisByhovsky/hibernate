package com.byhovsky.hibernate.model;

import java.io.Serializable;
import java.util.Set;

public class Cart implements Serializable {

    private long id;
    private double total;
    private String name;
    private Set<Items> items;

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public long getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Getter for property 'total'.
     *
     * @return Value for property 'total'.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Setter for property 'total'.
     *
     * @param total Value to set for property 'total'.
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for property 'name'.
     *
     * @param name Value to set for property 'name'.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for property 'items'.
     *
     * @return Value for property 'items'.
     */
    public Set<Items> getItems() {
        return items;
    }

    /**
     * Setter for property 'items'.
     *
     * @param items Value to set for property 'items'.
     */
    public void setItems(Set<Items> items) {
        this.items = items;
    }

}
