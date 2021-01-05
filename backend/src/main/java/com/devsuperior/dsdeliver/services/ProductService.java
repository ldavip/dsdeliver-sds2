package com.devsuperior.dsdeliver.services;

import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.entities.Product;
import com.devsuperior.dsdeliver.repositories.ProductRepository;
import com.devsuperior.dsdeliver.util.StreamUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.devsuperior.dsdeliver.util.StreamUtils.mapToList;

@Service
public class ProductService {

    private final ModelMapper mapper;
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.mapper = new ModelMapper();
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        List<Product> list = repository.findAllByOrderByNameAsc();
        return mapToList(list, o -> mapper.map(o, ProductDTO.class));
    }
}
