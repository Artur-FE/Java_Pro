package de.ait.userapi.service;

import de.ait.userapi.dto.ProductRequestDto;
import de.ait.userapi.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {

    public List<ProductResponseDto> getAllProducts();
    public ProductResponseDto getProductById(Long id);
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto);
}
