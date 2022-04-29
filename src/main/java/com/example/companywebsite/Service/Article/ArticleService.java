package com.example.companywebsite.Service.Article;

import com.example.companywebsite.dto.ArticleDto;
import com.example.companywebsite.entity.Article;
import com.example.companywebsite.specification.ParamField;
import org.springframework.data.domain.Page;

public interface ArticleService {
    Page<Article> getArticles(ParamField paramField);
    ArticleDto save(Article article);
    ArticleDto getArticleById(Long articleId);
    ArticleDto edit(Long articleId, Article article);
    String delete(Long articleId);

}
