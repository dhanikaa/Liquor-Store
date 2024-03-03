package com.architecture.Liquor.Store.service;

import com.architecture.Liquor.Store.dto.CategoryDto;
import com.architecture.Liquor.Store.entity.Category;
import com.architecture.Liquor.Store.exception.CategoryNotFoundException;
import com.architecture.Liquor.Store.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getCategoryById(int categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category with id " + categoryId + " not found"));
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category createCategory(CategoryDto categoryDto) {
        Category category = new Category();
        mapDtoToEntity(categoryDto, category);
        return categoryRepository.save(category);
    }

    public Category updateCategory(int categoryId, CategoryDto categoryDto) {
        Category existingCategory = getCategoryById(categoryId);
        mapDtoToEntity(categoryDto, existingCategory);
        return categoryRepository.save(existingCategory);
    }

    public void deleteCategory(int categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    private void mapDtoToEntity(CategoryDto categoryDto, Category category) {
        category.setCategoryName(categoryDto.getCategoryName());
    }
}
