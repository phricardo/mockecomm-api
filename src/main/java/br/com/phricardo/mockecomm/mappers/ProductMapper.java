package br.com.phricardo.mockecomm.mappers;

import br.com.phricardo.mockecomm.dtos.ProductDto;
import br.com.phricardo.mockecomm.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {

  ProductEntity dtoToEntity(ProductDto productDto);

  ProductDto entityToDto(ProductEntity productEntity);

  void updateEntityFromDto(ProductDto productDto, @MappingTarget ProductEntity productEntity);
}
