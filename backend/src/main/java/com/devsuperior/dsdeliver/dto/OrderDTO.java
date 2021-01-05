package com.devsuperior.dsdeliver.dto;

import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.entities.OrderStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static com.devsuperior.dsdeliver.util.MappingUtils.map;
import static com.devsuperior.dsdeliver.util.MappingUtils.mapList;

@Data
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private String address;
    private Double latitude;
    private Double longitude;
    private Instant moment;
    private OrderStatus status;

    @Setter(AccessLevel.NONE)
    private List<ProductDTO> products = new ArrayList<>();

    public OrderDTO(Order order) {
        map(order, this);
        products = mapList(order.getProducts(), ProductDTO.class);
    }
}
