package com.byhovsky.hibernate.model;

import java.io.Serializable;

public class Items implements Serializable {

    private long id;
    private String itemId;
    private double itemTotal;
    private int quantity;
    private Cart cart;

    public Items(String itemId, double total, int quantity, Cart cart) {
        this.itemId = itemId;
        this.itemTotal = total;
        this.quantity = quantity;
        this.cart = cart;
    }

    /**
     * Constructs a new Items.
     */
    public Items() {
    }

    /**
     * Getter for property 'itemId'.
     *
     * @return Value for property 'itemId'.
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * Setter for property 'itemId'.
     *
     * @param itemId Value to set for property 'itemId'.
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * Getter for property 'itemTotal'.
     *
     * @return Value for property 'itemTotal'.
     */
    public double getItemTotal() {
        return itemTotal;
    }

    /**
     * Setter for property 'itemTotal'.
     *
     * @param itemTotal Value to set for property 'itemTotal'.
     */
    public void setItemTotal(double itemTotal) {
        this.itemTotal = itemTotal;
    }

    /**
     * Getter for property 'quantity'.
     *
     * @return Value for property 'quantity'.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter for property 'quantity'.
     *
     * @param quantity Value to set for property 'quantity'.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

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
     * Getter for property 'cart'.
     *
     * @return Value for property 'cart'.
     */
    public Cart getCart() {
        return cart;
    }

    /**
     * Setter for property 'cart'.
     *
     * @param cart Value to set for property 'cart'.
     */
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Items items = (Items) o;

        if (id != items.id) return false;
        if (Double.compare(items.itemTotal, itemTotal) != 0) return false;
        if (quantity != items.quantity) return false;
        if (itemId != null ? !itemId.equals(items.itemId) : items.itemId != null) return false;
        return cart != null ? cart.equals(items.cart) : items.cart == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (itemId != null ? itemId.hashCode() : 0);
        temp = Double.doubleToLongBits(itemTotal);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + quantity;
        result = 31 * result + (cart != null ? cart.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", itemId='" + itemId + '\'' +
                ", itemTotal=" + itemTotal +
                ", quantity=" + quantity +
                ", cart=" + cart +
                '}';
    }
}
