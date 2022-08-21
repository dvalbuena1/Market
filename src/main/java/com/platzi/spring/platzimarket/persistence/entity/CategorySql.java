package com.platzi.spring.platzimarket.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class CategorySql {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private String categoryId;

    private String description;

    private Boolean state;

    @OneToMany(mappedBy = "category")
    private List<ProductSql> products;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
