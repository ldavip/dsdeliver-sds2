package com.devsuperior.dsdeliver.dto;

import com.devsuperior.dsdeliver.entities.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static com.devsuperior.dsdeliver.util.MappingUtils.map;

@Data
@NoArgsConstructor
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Double price;
    private String description;
    private String imageUri;

    public ProductDTO(Product product) {
        map(product, this);
    }
}
