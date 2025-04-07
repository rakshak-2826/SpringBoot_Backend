package com.backend.productList.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.productList.DTO.CategoryDTO;
import com.backend.productList.Entity.Category;
import com.backend.productList.Mapper.CategoryMapper;
import com.backend.productList.Repository.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService {
	
	private CategoryRepository categoryRepository;
	
	//createCategory
	public CategoryDTO createCategory(CategoryDTO categoryDTO) {
		Category category = CategoryMapper.toCategoryEntity(categoryDTO);
		category = categoryRepository.save(category);
		return CategoryMapper.toCategoryDTO(category);
	}
	
	
	//get all categories
	public List<CategoryDTO> getAllCategories(){
		return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
	}
	
	
	//get Category by Id
	public CategoryDTO getCategoryById(Long id) {
		Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not Found"));
		return CategoryMapper.toCategoryDTO(category);
		
	}
	
	//delete category
	public String deleteCategory(Long id) {
		categoryRepository.deleteById(id);
		return "Category " + id + " has been deleted";
	}

}
