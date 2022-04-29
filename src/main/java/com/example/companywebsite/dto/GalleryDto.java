package com.example.companywebsite.dto;

import com.example.companywebsite.entity.Account;
import com.example.companywebsite.entity.Picture;

import java.util.List;

public class GalleryDto {
    private long id;
    private String name;
    private String thumbnail;
    private String description;
    private int status;
    private long createdByUserId;
    private long lastUpdatedByUserId;
    private List<Picture> pictures;
    private Account account;
}
