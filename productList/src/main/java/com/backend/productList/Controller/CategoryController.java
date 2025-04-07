package com.backend.productList.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.productList.DTO.CategoryDTO;
import com.backend.productList.Service.CategoryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	//get category by id
	@GetMapping("/{id}")
	public CategoryDTO getCategoryById(@PathVariable Long id) {
		return categoryService.getCategoryById(id);
	}
	
	
	//createCategory
	@PostMapping
	public ResponseEntity<CategoryDTO> creatCategory(@RequestBody CategoryDTO categoryDTO) {
		return new ResponseEntity<> (categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
		
	}
	//get all category
	@GetMapping
	public List<CategoryDTO> getAllCategories(){
		return categoryService.getAllCategories();
		
	}
	//deleteCategory
	@DeleteMapping("/{id}")
	public String deleteCategory(@PathVariable Long id) {
		return categoryService.deleteCategory(id);
	}
	
	

}
