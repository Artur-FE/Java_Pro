package de.ait.userapi.controller;


import de.ait.userapi.dto.ProductRequestDto;
import de.ait.userapi.dto.ProductResponseDto;
import de.ait.userapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts(){
        try {
            return ResponseEntity.ok(productService.getAllProducts());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable(value = "id") Long id){
        try {
            return ResponseEntity.ok(productService.getProductById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<ProductResponseDto> getProductById(@RequestBody ProductRequestDto productRequestDto){
        try {
            return ResponseEntity.status(201).body(productService.addProduct(productRequestDto));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

}
