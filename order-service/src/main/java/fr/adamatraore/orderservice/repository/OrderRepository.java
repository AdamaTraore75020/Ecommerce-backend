package fr.adamatraore.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adamatraore.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
