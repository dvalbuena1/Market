package com.platzi.spring.platzimarket.persistence;

import com.platzi.spring.platzimarket.domain.Product;
import com.platzi.spring.platzimarket.domain.repository.ProductRepository;
import com.platzi.spring.platzimarket.persistence.crud.ProductCrudRepository;
import com.platzi.spring.platzimarket.persistence.entity.ProductSql;
import com.platzi.spring.platzimarket.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductSqlRepository implements ProductRepository {
    private ProductCrudRepository productCrudRepository;
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<ProductSql> products = (List<ProductSql>) productCrudRepository.findAll();
        return mapper.toProducts(products);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<ProductSql> products = productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
        return Optional.of(mapper.toProducts(products));
    }

    @Override
    public Optional<List<Product>> getLimitedProducts(int quantity) {
        Optional<List<ProductSql>> products = productCrudRepository.findByStockLessThanAndState(quantity, true);
        return products.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        Optional<ProductSql> product = productCrudRepository.findById(productId);
        return product.map(prod -> mapper.toProduct(prod));
    }

    @Override
    public Product save(Product product) {
        ProductSql productSql = mapper.toProduct(product);
        return mapper.toProduct(productCrudRepository.save(productSql));
    }

    @Override
    public void delete(int productId) {
        productCrudRepository.deleteById(productId);
    }
}
