package br.com.phricardo.mockecomm.services;

import static java.lang.String.format;
import static java.util.Objects.isNull;

import br.com.phricardo.mockecomm.dtos.ProductDto;
import br.com.phricardo.mockecomm.entities.ProductEntity;
import br.com.phricardo.mockecomm.exceptions.NotFoundException;
import br.com.phricardo.mockecomm.mappers.ProductMapper;
import br.com.phricardo.mockecomm.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductMapper productMapper;
  private final ProductRepository productRepository;

  @Transactional
  public ResponseEntity<ProductDto> create(final ProductDto productDto) {
    final ProductEntity productEntity = productMapper.dtoToEntity(productDto);
    final ProductEntity productEntitySaved = productRepository.save(productEntity);

    return ResponseEntity.created(URI.create(format("/products/%s", productEntitySaved.getSku())))
        .body(productMapper.entityToDto(productEntitySaved));
  }

  @Transactional
  public ResponseEntity<Void> delete(final String sku) {
    boolean isProductExist = productRepository.existsBySku(sku);
    if (!isProductExist) throw new NotFoundException("No products found with this SKU");

    productRepository.deleteBySku(sku);
    return ResponseEntity.noContent().build();
  }

  @Transactional
  public ResponseEntity<ProductDto> update(final String sku, final ProductDto productDto) {
    final ProductEntity productEntity = productRepository.findBySku(sku);
    if (isNull(productEntity)) throw new NotFoundException("No products found with this SKU");
    productMapper.updateEntityFromDto(productDto, productEntity);

    final ProductEntity updatedProductEntity = productRepository.save(productEntity);
    return ResponseEntity.ok(productMapper.entityToDto(updatedProductEntity));
  }

  public ResponseEntity<ProductDto> getByProductSku(final String sku) {
    final ProductEntity productEntity = productRepository.findBySku(sku);
    if (isNull(productEntity)) throw new NotFoundException("No products found with this SKU");
    return ResponseEntity.ok(productMapper.entityToDto(productEntity));
  }

  //  public List<ProductDto> getAllProducts() {
  //    return productRepository.findAll().stream()
  //        .map(productMapper::entityToDto)
  //        .collect(Collectors.toList());
  //  }

  public Page<ProductDto> getPaginatedProducts(final Pageable pageable) {
    final Page<ProductEntity> productPage = productRepository.findAll(pageable);
    return productPage.map(productMapper::entityToDto);
  }
}
