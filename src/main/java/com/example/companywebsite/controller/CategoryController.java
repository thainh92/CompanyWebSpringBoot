package com.example.companywebsite.controller;

import com.example.companywebsite.Service.Category.CategoryService;
import com.example.companywebsite.entity.Category;
import com.example.companywebsite.response.RestPagination;
import com.example.companywebsite.response.RestResponse;
import com.example.companywebsite.specification.ParamField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getCategories(@RequestParam(name = "page", defaultValue = "1") int page,
                                           @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                           @RequestParam(name = "categoryId", defaultValue = "-1") int categoryId,
                                           @RequestParam(name = "status", defaultValue = "-1") int status,
                                           @RequestParam(name = "sort", defaultValue = "-1") int sort
    ) {
        ParamField paramField = ParamField.ParamFieldBuilder.aParamField()
                .withPage(page)
                .withPageSize(pageSize)
                .withCategoryId(categoryId)
                .withCategoryStatus(status)
                .withSort(sort)
                .build();
        Page<?> categories = categoryService.getCategories(paramField);
        return new ResponseEntity<>(new RestResponse.Success()
                .setPagination(new RestPagination(categories.getNumber() + 1, categories.getSize(), categories.getTotalElements()))
                .setStatus(HttpStatus.FOUND.value())
                .addDatas(categories.getContent())
                .build(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Category category) {
        return  new ResponseEntity<>(new RestResponse.Success()
                .setStatus(HttpStatus.CREATED.value())
                .setMessage("Create successfully")
                .addData(categoryService.save(category))
                .build(),
                HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable long id) {
        return new ResponseEntity<>(new RestResponse.Success()
                .setStatus(HttpStatus.FOUND.value())
                .setMessage("Category Found")
                .addData(categoryService.getCategoryById(id))
                .build(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "edit/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody Category category) {
        return new ResponseEntity<>(new RestResponse.Success()
                .setStatus(HttpStatus.ACCEPTED.value())
                .setMessage("Update successfully")
                .addData(categoryService.edit(id, category))
                .build(),
                HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return new ResponseEntity<>(new RestResponse.Success()
                .setStatus(HttpStatus.ACCEPTED.value())
                .setMessage("Delete successfully")
                .build(),
                HttpStatus.OK);
    }


}
