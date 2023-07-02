package fr.adamatraore.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.adamatraore.productservice.dto.ProductRequest;
import fr.adamatraore.productservice.dto.ProductResponse;
import fr.adamatraore.productservice.mapper.ProductMapper;
import fr.adamatraore.productservice.model.Product;
import fr.adamatraore.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
            .name(productRequest.getName())
            .description(productRequest.getDescription())
            .price(productRequest.getPrice())
            .build();

        productRepository.save(product);
        log.info("Product created: {}", product);
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return productMapper.mapListFrom(products);
    }
}
