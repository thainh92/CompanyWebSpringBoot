package com.example.companywebsite.Service.Category;

import com.example.companywebsite.dto.CategoryDto;
import com.example.companywebsite.entity.Category;
import com.example.companywebsite.specification.ParamField;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    Page<Category> getCategories(ParamField paramField);
    CategoryDto save(Category category);
    CategoryDto getCategoryById(Long categoryId);
    CategoryDto edit(Long categoryId, Category category);
    String delete(Long categoryId);
}
