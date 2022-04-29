package com.example.companywebsite.Service.Article;

import com.example.companywebsite.dto.ArticleDto;
import com.example.companywebsite.entity.Article;
import com.example.companywebsite.enums.ArticleStatus;
import com.example.companywebsite.enums.SearchOperation;
import com.example.companywebsite.exception.NotFoundException;
import com.example.companywebsite.repository.ArticleRepository;
import com.example.companywebsite.specification.ArticleSpecification;
import com.example.companywebsite.specification.ParamField;
import com.example.companywebsite.specification.SearchCriteria;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Page<Article> getArticles(ParamField paramField) {
        Specification<Article> spe = Specification.where(null);
        PageRequest paging = PageRequest.of(paramField.getPage() - 1, paramField.getPageSize());
        if (paramField.getArticleTitle() != null) {
            spe = spe.and(new ArticleSpecification(new SearchCriteria(ParamField.TITLE, SearchOperation.LIKE, paramField.getArticleTitle())));
        }
        if (paramField.getAuthor() > -1) {
            spe = spe.and(new ArticleSpecification(new SearchCriteria(ParamField.AUTHOR, SearchOperation.EQUALITY, paramField.getAuthor())));
        }
        if (paramField.getArticleStatus() > -1) {
            spe = spe.and(new ArticleSpecification(new SearchCriteria(ParamField.STATUS, SearchOperation.EQUALITY, paramField.getArticleStatus())));
        }
        if (paramField.getSort() > -1) {
            switch (paramField.getSort()) {
                case 0:
                    paging = PageRequest.of(paramField.getPage() -1, paramField.getPageSize(), Sort.Direction.DESC, ParamField.TITLE);
                    break;
                case 1:
                    paging = PageRequest.of(paramField.getPage() -1, paramField.getPageSize(), Sort.Direction.ASC, ParamField.TITLE);
                    break;
                case 2:
                    paging = PageRequest.of(paramField.getPage() -1, paramField.getPageSize(), Sort.Direction.DESC, ParamField.AUTHOR);
                    break;
                case 3:
                    paging = PageRequest.of(paramField.getPage() -1, paramField.getPageSize(), Sort.Direction.ASC, ParamField.AUTHOR);
                    break;
                case 4:
                    paging = PageRequest.of(paramField.getPage() -1, paramField.getPageSize(), Sort.Direction.ASC, ParamField.CREATED_AT);
                    break;
                default:
                    paging = PageRequest.of(paramField.getPage() -1, paramField.getPageSize(), Sort.Direction.DESC, ParamField.CREATED_AT);
                    System.out.println("default");
                    break;
            }
        }
        return articleRepository.findAll(spe, paging);
    }

    @Override
    public ArticleDto save(Article article) {
        return modelMapper.map(articleRepository.save(article), ArticleDto.class);
    }

    @Override
    public ArticleDto getArticleById(Long articleId) {
        Article article = articleRepository.findById(articleId).orElse(null);
        if (article == null) {
            throw new NotFoundException("Article not found");
        }
        return modelMapper.map(articleRepository.findById(articleId).get(), ArticleDto.class);
    }

    @Override
    public ArticleDto edit(Long articleId, Article article) {
        Optional<Article> articleFound = articleRepository.findById(articleId);
        if (!articleFound.isPresent()) {
            throw new NotFoundException("Article not found!");
        }
        articleFound.get().updateArticle(article);
        return modelMapper.map(articleRepository.save(articleFound.get()), ArticleDto.class);
    }

    @Override
    public String delete(Long articleId) {
        Optional<Article> article = articleRepository.findById(articleId);
        if (!article.isPresent()) {
            throw new NotFoundException("Article not found");
        }
        articleRepository.deleteById(articleId);
        return "Delete article successfully";
    }
}
