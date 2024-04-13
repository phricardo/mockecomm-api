package br.com.phricardo.mockecomm.controllers;

import br.com.phricardo.mockecomm.dtos.ProductDto;
import br.com.phricardo.mockecomm.services.ProductService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class ProductController {

  private final ProductService productService;

  @PostMapping
  public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody final ProductDto productDto) {
    return productService.create(productDto);
  }

  @DeleteMapping("/{sku}")
  public ResponseEntity<Void> deleteProduct(@PathVariable final String sku) {
    return productService.delete(sku);
  }

  @PutMapping("/{sku}")
  public ResponseEntity<ProductDto> updateProdutct(
      @PathVariable final String sku, @Valid @RequestBody final ProductDto productDto) {
    return productService.update(sku, productDto);
  }

  @GetMapping("/{sku}")
  public ResponseEntity<ProductDto> getProductBySku(@PathVariable final String sku) {
    return productService.getByProductSku(sku);
  }

  @GetMapping
  public List<ProductDto> getProduct() {
    return productService.getAllProducts();
  }
}
