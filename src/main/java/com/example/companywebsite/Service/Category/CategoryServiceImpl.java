package com.example.companywebsite.Service.Category;

import com.example.companywebsite.dto.CategoryDto;
import com.example.companywebsite.entity.Category;
import com.example.companywebsite.exception.NotFoundException;
import com.example.companywebsite.repository.CategoryRepository;
import com.example.companywebsite.specification.ParamField;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Page<Category> getCategories(ParamField paramField) {
        return null;
    }

    @Override
    public CategoryDto save(Category category) {
        return modelMapper.map(categoryRepository.save(category), CategoryDto.class);
    }

    @Override
    public CategoryDto getCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category == null) {
            throw new NotFoundException("Category not found");
        }
        return modelMapper.map(categoryRepository.findById(categoryId).get(), CategoryDto.class);
    }

    @Override
    public CategoryDto edit(Long categoryId, Category category) {
        Optional<Category> categoryFound = categoryRepository.findById(categoryId);
        if (!categoryFound.isPresent()) {
            throw new NotFoundException("Category not found");
        }
        categoryFound.get().updateCategory(category);
        return modelMapper.map(categoryRepository.save(categoryFound.get()), CategoryDto.class);
    }

    @Override
    public String delete(Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (!category.isPresent()) {
            throw new NotFoundException("Category not found");
        }
        categoryRepository.deleteById(categoryId);
        return "Delete category successfully";
    }
}
