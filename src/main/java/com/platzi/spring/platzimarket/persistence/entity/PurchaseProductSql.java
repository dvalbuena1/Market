package com.platzi.spring.platzimarket.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "purchase_product")
public class PurchaseProductSql {

    @EmbeddedId
    private PurchaseProductPK id;

    private Integer quantity;

    private Double total;

    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "purchase_id", insertable = false, updatable = false)
    private PurchaseSql purhcase;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductSql product;

    public PurchaseProductPK getId() {
        return id;
    }

    public void setId(PurchaseProductPK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
