package com.byhovsky.hibernate.model.annotation;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CART")
public class Cart1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private long id;

    @Column(name = "total")
    private double total;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "cart1")
    private Set<Items1> items1;

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
     * Getter for property 'items1'.
     *
     * @return Value for property 'items1'.
     */
    public Set<Items1> getItems1() {
        return items1;
    }

    /**
     * Setter for property 'items1'.
     *
     * @param items1 Value to set for property 'items1'.
     */
    public void setItems1(Set<Items1> items1) {
        this.items1 = items1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart1 cart1 = (Cart1) o;

        if (id != cart1.id) return false;
        if (Double.compare(cart1.total, total) != 0) return false;
        if (name != null ? !name.equals(cart1.name) : cart1.name != null) return false;
        return items1 != null ? items1.equals(cart1.items1) : cart1.items1 == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        temp = Double.doubleToLongBits(total);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

}
