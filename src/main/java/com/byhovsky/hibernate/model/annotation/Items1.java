package com.byhovsky.hibernate.model.annotation;

import javax.persistence.*;

@Entity
@Table(name = "ITEMS")
public class Items1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "item_total")
    private double itemTotal;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart1 cart1;

    /**
     * Constructs a new Items1.
     */ //Hibernate requires no-args constructor
    public Items1() {
    }

    public Items1(String itemId, double total, int qty, Cart1 c) {
        this.itemId = itemId;
        this.itemTotal = total;
        this.quantity = qty;
        this.cart1 = c;
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
     * Getter for property 'cart1'.
     *
     * @return Value for property 'cart1'.
     */
    public Cart1 getCart1() {
        return cart1;
    }

    /**
     * Setter for property 'cart1'.
     *
     * @param cart Value to set for property 'cart1'.
     */
    public void setCart1(Cart1 cart) {
        this.cart1 = cart;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Items1 items1 = (Items1) o;

        if (id != items1.id) return false;
        if (Double.compare(items1.itemTotal, itemTotal) != 0) return false;
        if (quantity != items1.quantity) return false;
        if (itemId != null ? !itemId.equals(items1.itemId) : items1.itemId != null) return false;
        return cart1 != null ? cart1.equals(items1.cart1) : items1.cart1 == null;
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
        result = 31 * result + (cart1 != null ? cart1.hashCode() : 0);
        return result;
    }

}
