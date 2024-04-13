package br.com.phricardo.mockecomm.dtos;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductDto {

  private String sku;
  private String name;
  private String description;
  private BigDecimal price;
  private String category;
  private String imageUrl;
}
