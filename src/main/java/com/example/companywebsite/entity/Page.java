//package com.example.companywebsite.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.hibernate.annotations.SQLDelete;
//import org.hibernate.annotations.Where;
//
//import javax.persistence.*;
//
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "pages")
//@SQLDelete(sql = "UPDATE pages SET deleted = true WHERE id=?")
//@Where(clause = "deleted=false")
//@Entity
//public class Page extends BaseEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private long id;
//
//    @Column(name = "title", nullable = false)
//    private String title;
//
//    @Column(name = "thumbnail", columnDefinition = "TEXT", nullable = false)
//    private String thumbnail;
//
//    @Column(name = "content", columnDefinition = "TEXT", nullable = false)
//    private String content;
//
//    @Column(name = "url", columnDefinition = "TEXT", nullable = false)
//    private String url;
//
//    @Column(name = "status", nullable = false)
//    private int status;
//
//    @Column(name = "index", nullable = false)
//    private int index;
//
//    @Column(name = "deleted", nullable = false)
//    private Boolean deleted = Boolean.FALSE;
//
//    @Column(name = "last_updated_by", nullable = false)
//    private long lastUpdatedByUserId;
//
//    public void updatePage(Page page) {
//        this.title = page.getTitle();
//        this.thumbnail = page.getThumbnail();
//        this.content = page.getContent();
//        this.url = page.getUrl();
//        this.status = page.getStatus();
//    }
//}
