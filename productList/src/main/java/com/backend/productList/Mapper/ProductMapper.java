package com.backend.productList.Mapper;

import com.backend.productList.DTO.ProductDTO;
import com.backend.productList.Entity.Category;
import com.backend.productList.Entity.Product;

public class ProductMapper {
	
	//Entity to DTO
	public static ProductDTO toProductDTO(Product product) {
		return new ProductDTO(
				product.getId(),
				product.getName(),
				product.getDescription(),
				product.getPrice(),
				product.getCategory().getId()
				);
	}
	
	
	//DTO to Entity 
	public static Product toProductEntity(ProductDTO productDTO, Category category) {
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());

		
		category.setId(category.getId());
		category.setName(category.getName());
		product.setCategory(category); 

		return product;
	}
}
