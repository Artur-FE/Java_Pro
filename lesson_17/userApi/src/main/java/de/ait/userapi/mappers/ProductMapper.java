package de.ait.userapi.mappers;


import de.ait.userapi.dto.ProductRequestDto;
import de.ait.userapi.dto.ProductResponseDto;
import de.ait.userapi.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface ProductMapper {

    Product productRequestDtoToProduct(ProductRequestDto productRequestDto);
    ProductResponseDto productToproductResponseDto(Product product);
    List<ProductResponseDto> allProductResponseDto(List<Product> product);

}
