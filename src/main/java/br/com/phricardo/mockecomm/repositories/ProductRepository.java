package br.com.phricardo.mockecomm.repositories;

import br.com.phricardo.mockecomm.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

  boolean existsBySku(String sku);

  ProductEntity findBySku(String sku);

  void deleteBySku(String sku);
}
