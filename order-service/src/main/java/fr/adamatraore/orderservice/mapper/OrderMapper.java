package fr.adamatraore.orderservice.mapper;

import org.mapstruct.Mapper;

import fr.adamatraore.orderservice.dto.OrderRequest;
import fr.adamatraore.orderservice.model.Order;

@Mapper(componentModel = "spring", uses = { OrderLineItemMapper.class })
public interface OrderMapper extends AbstractMapper<Order, OrderRequest> {
}
