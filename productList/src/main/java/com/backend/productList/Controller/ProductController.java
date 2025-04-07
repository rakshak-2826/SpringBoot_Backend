package com.backend.productList.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.productList.DTO.ProductDTO;
import com.backend.productList.Service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
	
	private ProductService productService;
	
	//get all Product
	@GetMapping
	public List<ProductDTO> getAllProduct(){
		return productService.getAllProducts();
	}
	
	
	//get product by id
	@GetMapping("/{id}")
	public ProductDTO getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	
	//createProduct
	@PostMapping
	public ResponseEntity<ProductDTO> creatProduct(@RequestBody ProductDTO productDTO) {
		return new ResponseEntity<> (productService.createProduct(productDTO),HttpStatus.CREATED);
		
	}
	
	//updateProduct
	@PutMapping("/{id}")
	public ProductDTO updateProduct(@PathVariable Long id , @RequestBody ProductDTO productDTO) {
		return productService.updateProduct(id, productDTO);
	}
	
	//deleteProduct
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id) {
		return productService.deleteProduct(id);
	}

}
