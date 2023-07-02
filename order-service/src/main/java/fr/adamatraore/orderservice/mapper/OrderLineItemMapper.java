package fr.adamatraore.orderservice.mapper;

import org.mapstruct.Mapper;

import fr.adamatraore.orderservice.dto.OrderLineItemDto;
import fr.adamatraore.orderservice.model.OrderLineItem;

@Mapper(componentModel = "spring")
public interface OrderLineItemMapper extends AbstractMapper<OrderLineItem, OrderLineItemDto> {
    
}
