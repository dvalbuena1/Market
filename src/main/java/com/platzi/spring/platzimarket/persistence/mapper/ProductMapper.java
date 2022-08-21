package com.platzi.spring.platzimarket.persistence.mapper;

import com.platzi.spring.platzimarket.domain.Product;
import com.platzi.spring.platzimarket.persistence.entity.ProductSql;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "productId", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "categoryId", target = "categoryId"),
            @Mapping(source = "salePrice", target = "price"),
            @Mapping(source = "stock", target = "stock"),
            @Mapping(source = "state", target = "active"),
            @Mapping(source = "category", target = "category"),
    })
    Product toProduct(ProductSql product);
    List<Product> toProducts(List<ProductSql> products);

    @InheritInverseConfiguration
    @Mapping(target = "barcode", ignore = true)
    ProductSql toProduct(Product product);
}
