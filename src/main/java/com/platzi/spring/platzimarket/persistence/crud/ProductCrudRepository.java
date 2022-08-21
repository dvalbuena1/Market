package com.platzi.spring.platzimarket.persistence.crud;

import com.platzi.spring.platzimarket.persistence.entity.ProductSql;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<ProductSql, Integer> {
    List<ProductSql> findByCategoryIdOrderByNameAsc(int categoryId);
    Optional<List<ProductSql>> findByStockLessThanAndState(int stock, boolean state);
}
