package br.com.phricardo.mockecomm.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.Data;

@Data
@Entity
@Table(name = "DP_PRODUCTS")
public class ProductEntity {

  @Id
  @Column(name = "product_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "sku", length = 50, unique = true)
  private String sku;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "price")
  private BigDecimal price;

  @Enumerated(EnumType.STRING)
  @Column(name = "category")
  private ProductCategoryEnum category;

  @Column(name = "image_url", length = 255)
  private String imageUrl;
}
