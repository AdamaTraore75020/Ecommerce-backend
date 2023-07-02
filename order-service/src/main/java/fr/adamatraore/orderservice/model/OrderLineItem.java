package fr.adamatraore.orderservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="order_line_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItem {
    @Id
    @Column(name="order_item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String skuCode;
    private Long price;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;
}
