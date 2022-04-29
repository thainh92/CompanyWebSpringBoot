package com.example.companywebsite.specification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ParamField {
    //Định nghĩa các trường trong database
    public final static String TITLE = "title";
    public final static String ID = "id";
    public final static String AUTHOR = "author_id";
    public final static String CATEGORY_ID = "category_id";
    public final static String STATUS = "status";
    public final static String CREATED_AT = "created_at";

    //Định nghĩa các trường cần search
    private long categoryId;
    private String categoryName;
    private int categoryStatus;
    private long articleId;
    private String articleTitle;
    private long author;
    private String startDate;
    private String endDate;
    private int articleStatus;

    private int page;
    private int pageSize;

    private int sort;
    private int type;
    private HashMap<String, String> mapField;


    public static final class ParamFieldBuilder {
        private long categoryId;
        private String categoryName;
        private int categoryStatus;
        private long articleId;
        private String articleTitle;
        private long author;
        private String startDate;
        private String endDate;
        private int articleStatus;
        private int page;
        private int pageSize;
        private int sort;
        private int type;
        private HashMap<String, String> mapField;

        private ParamFieldBuilder() {
        }

        public static ParamFieldBuilder aParamField() {
            return new ParamFieldBuilder();
        }

        public ParamFieldBuilder withCategoryId(long categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public ParamFieldBuilder withCategoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        public ParamFieldBuilder withCategoryStatus(int categoryStatus) {
            this.categoryStatus = categoryStatus;
            return this;
        }

        public ParamFieldBuilder withArticleId(long articleId) {
            this.articleId = articleId;
            return this;
        }

        public ParamFieldBuilder withArticleTitle(String articleTitle) {
            this.articleTitle = articleTitle;
            return this;
        }

        public ParamFieldBuilder withAuthor(long author) {
            this.author = author;
            return this;
        }

        public ParamFieldBuilder withStartDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public ParamFieldBuilder withEndDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        public ParamFieldBuilder withArticleStatus(int articleStatus) {
            this.articleStatus = articleStatus;
            return this;
        }

        public ParamFieldBuilder withPage(int page) {
            this.page = page;
            return this;
        }

        public ParamFieldBuilder withPageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public ParamFieldBuilder withSort(int sort) {
            this.sort = sort;
            return this;
        }

        public ParamFieldBuilder withType(int type) {
            this.type = type;
            return this;
        }

        public ParamFieldBuilder withMapField(HashMap<String, String> mapField) {
            this.mapField = mapField;
            return this;
        }

        public ParamField build() {
            ParamField paramField = new ParamField();
            paramField.setCategoryId(categoryId);
            paramField.setCategoryName(categoryName);
            paramField.setCategoryStatus(categoryStatus);
            paramField.setArticleId(articleId);
            paramField.setArticleTitle(articleTitle);
            paramField.setAuthor(author);
            paramField.setStartDate(startDate);
            paramField.setEndDate(endDate);
            paramField.setArticleStatus(articleStatus);
            paramField.setPage(page);
            paramField.setPageSize(pageSize);
            paramField.setSort(sort);
            paramField.setType(type);
            paramField.setMapField(mapField);
            return paramField;
        }
    }
}
