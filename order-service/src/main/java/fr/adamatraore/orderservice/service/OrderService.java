package fr.adamatraore.orderservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import fr.adamatraore.orderservice.dto.InventoryResponse;
import fr.adamatraore.orderservice.dto.OrderRequest;
import fr.adamatraore.orderservice.mapper.OrderMapper;
import fr.adamatraore.orderservice.model.Order;
import fr.adamatraore.orderservice.model.OrderLineItem;
import fr.adamatraore.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final WebClient webClient;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = orderMapper.mapTo(orderRequest);
        order.setOrderNumber(UUID.randomUUID().toString());

        List<String> skuCodes = order.getOrderLineItems().stream().map(OrderLineItem::getSkuCode).collect(Collectors.toList());

        // call inventory service to check if order items are in stock
        InventoryResponse[] inventoryResponses = webClient
                .get()
                .uri("http://localhost:8082/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve().bodyToMono(InventoryResponse[].class).block();

        boolean allProductsAreInStock = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock);
        if (allProductsAreInStock) {
            orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Product is not in stock");
        }
    }
}
