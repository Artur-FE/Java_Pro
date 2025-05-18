package de.ait.userapi.service;

import de.ait.userapi.dto.ProductRequestDto;
import de.ait.userapi.dto.ProductResponseDto;
import de.ait.userapi.mappers.ProductMapper;
import de.ait.userapi.model.Product;
import de.ait.userapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return productMapper.allProductResponseDto(productRepository.findAll());
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        return productMapper.productToproductResponseDto(productRepository.findById(id).get());
    }

    @Override
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) {
        System.out.println(productRequestDto);
        Product product = productMapper.productRequestDtoToProduct(productRequestDto);
        System.out.println(product);
        Product save = productRepository.save(product);
        return productMapper.productToproductResponseDto(save);
    }
}
