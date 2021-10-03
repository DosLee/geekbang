package org.geek.rpcfx.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * 描述:
 *
 * @author lil
 */
public class Order implements Serializable {

    private static final long serialVersionUID = 4911319175488014437L;

    private Integer id;

    private String name;

    public Order(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(name, order.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
