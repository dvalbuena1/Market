package com.platzi.spring.platzimarket.persistence.mapper;

import com.platzi.spring.platzimarket.domain.Category;
import com.platzi.spring.platzimarket.persistence.entity.CategorySql;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "categoryId", target = "categoryId"),
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "state", target = "active")
    })
    Category toCategory(CategorySql category);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    CategorySql toCategorySql(Category category);
}
