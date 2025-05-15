package de.ait.userapi.dto;

import lombok.*;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Setter
public class ProductRequestDto {

    private String title;
    private BigDecimal price;
}
