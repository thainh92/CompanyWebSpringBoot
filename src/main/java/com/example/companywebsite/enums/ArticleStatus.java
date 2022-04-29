package com.example.companywebsite.enums;

import lombok.Getter;

@Getter
public enum ArticleStatus {
    PENDING(1, "pending"),
    HIDDEN(2, "hidden"),
    DENIED(3, "denied"),
    APPROVED(1, "approved");

    private final int key;
    private final String value;

    ArticleStatus(int key, String value) {
        this.key = key;
        this.value = value;
    }
}
