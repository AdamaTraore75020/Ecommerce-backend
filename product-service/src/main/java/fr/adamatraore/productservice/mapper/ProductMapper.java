package fr.adamatraore.productservice.mapper;

import org.mapstruct.Mapper;

import fr.adamatraore.productservice.dto.ProductResponse;
import fr.adamatraore.productservice.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper extends AbstractMapper<Product, ProductResponse> {
}
