package com.backend.productList.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.productList.DTO.ProductDTO;
import com.backend.productList.Entity.Category;
import com.backend.productList.Entity.Product;
import com.backend.productList.Mapper.ProductMapper;
import com.backend.productList.Repository.CategoryRepository;
import com.backend.productList.Repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {
	
	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;
	
	//Create Product
	public ProductDTO createProduct(ProductDTO productDTO) {
		Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()-> new RuntimeException("Category not found"));
		
		//DTO -> Entity
		Product product = ProductMapper.toProductEntity(productDTO, category);
		product = productRepository.save(product);
		
		//Entity -> DTO
		return ProductMapper.toProductDTO(product);
	}
	
	//Get All Products
	public List<ProductDTO> getAllProducts(){
		return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
	}
	
	//Get Product By Id
	public ProductDTO getProductById(Long id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product Not Found"));
		return ProductMapper.toProductDTO(product);
	}
	
	
	//Update product
	public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
		Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not Found"));
		Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()-> new RuntimeException("Category not Found"));
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());
		product.setCategory(category);
		productRepository.save(product);
		return ProductMapper.toProductDTO(product);
	}
	
	
	//Delete product
	public String deleteProduct(Long id) {
		productRepository.deleteById(id);
		return "Product "+ id +" has been deleted!";
	}

}
