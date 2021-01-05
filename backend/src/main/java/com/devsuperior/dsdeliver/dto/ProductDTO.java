package com.devsuperior.dsdeliver.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Double price;
    private String description;
    private String imageUri;
}
