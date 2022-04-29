package com.example.companywebsite.dto;

import com.example.companywebsite.entity.Article;
import com.example.companywebsite.entity.Comment;
import com.example.companywebsite.entity.Gallery;

import java.util.List;

public class AccountDto {
    private long id;
    private String name;
    private String username;
    private String password;
    private String email;
    private int status;
    private List<Comment> comments;
    private List<Article> articles;
    private List<Gallery> galleries;
}
