package com.example.companywebsite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {
    private long id;
    private String title;
    private String content;
    private String thumbnail;
    private long categoryId;
    private int status;
    private long authorId;
}
