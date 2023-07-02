package fr.adamatraore.orderservice.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import fr.adamatraore.orderservice.dto.OrderRequest;
import fr.adamatraore.orderservice.mapper.OrderMapper;
import fr.adamatraore.orderservice.model.Order;
import fr.adamatraore.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = orderMapper.mapTo(orderRequest);
        order.setOrderNumber(UUID.randomUUID().toString());
        orderRepository.save(order);
    }
}
