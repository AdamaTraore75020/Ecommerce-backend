package fr.adamatraore.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.adamatraore.productservice.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    
}
