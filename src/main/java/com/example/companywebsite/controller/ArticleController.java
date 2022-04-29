package com.example.companywebsite.controller;

import com.example.companywebsite.Service.Article.ArticleService;
import com.example.companywebsite.entity.Article;
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
@RequestMapping("api/v1/articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getArticles(@RequestParam(name = "page", defaultValue = "1") int page,
                                      @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                      @RequestParam(name = "title", required = false) String title,
                                      @RequestParam(name = "categoryId", defaultValue = "-1") int categoryId,
                                      @RequestParam(name = "authorId", defaultValue = "-1") int authorId,
                                      @RequestParam(name = "status", defaultValue = "-1") int status,
                                      @RequestParam(name = "sort", defaultValue = "-1") int sort
    ) {
        ParamField paramField = ParamField.ParamFieldBuilder.aParamField()
                .withPage(page)
                .withPageSize(pageSize)
                .withArticleTitle(title)
                .withCategoryId(categoryId)
                .withAuthor(authorId)
                .withArticleStatus(status)
                .withSort(sort)
                .build();
        Page<?> articles = articleService.getArticles(paramField);
        return new ResponseEntity<>(new RestResponse.Success()
                .setPagination(new RestPagination(articles.getNumber() + 1, articles.getSize(), articles.getTotalElements()))
                .setStatus(HttpStatus.FOUND.value())
                .addDatas(articles.getContent())
                .build(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Article article) {
        return new ResponseEntity<>(new RestResponse.Success()
                .setStatus(HttpStatus.CREATED.value())
                .setMessage("Create successfully")
                .addData(articleService.save(article))
                .build(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> getArticleById(@PathVariable Long id) {
        return new ResponseEntity<>(new RestResponse.Success()
                .setStatus(HttpStatus.FOUND.value())
                .setMessage("Found")
                .addData(articleService.getArticleById(id))
                .build()
                , HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "edit/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody Article article) {
        return new ResponseEntity<>(new RestResponse.Success()
                .setStatus(HttpStatus.ACCEPTED.value())
                .setMessage("Update successfully")
                .addData(articleService.edit(id, article))
                .build()
        , HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        articleService.delete(id);
        return new ResponseEntity<>(new RestResponse.Success()
                .setStatus(HttpStatus.ACCEPTED.value())
                .setMessage("Delete successfully")
                .build()
                , HttpStatus.OK);
    }
}
