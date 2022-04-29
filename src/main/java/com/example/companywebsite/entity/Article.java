package com.example.companywebsite.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "articles")
@SQLDelete(sql = "UPDATE articles SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Entity
public class Article extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "thumbnail", columnDefinition = "TEXT", nullable = false)
    private String thumbnail;

    @Column(name = "status", nullable = false)
    private int status;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted = Boolean.FALSE;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @ManyToOne
    @JoinColumn(name="category_id", insertable = false, updatable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name="account_id", insertable = false, updatable = false)
    private Account account;

    public void updateArticle(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
        this.thumbnail = article.getThumbnail();
    }
}
