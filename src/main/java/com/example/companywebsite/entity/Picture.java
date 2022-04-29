package com.example.companywebsite.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pictures")
@SQLDelete(sql = "UPDATE pictures SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Entity
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "thumbnail", columnDefinition = "TEXT", nullable = false)
    private String thumbnail;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "status", nullable = false)
    private int status;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted = Boolean.FALSE;

    @Column(name = "created_by", nullable = false)
    private long createdByUserId;

    @ManyToOne
    @JoinColumn(name = "gallery_id", insertable = false, updatable = false)
    private Gallery gallery;

    public void updatePicture(Picture picture) {
        this.name = gallery.getName();
        this.thumbnail = gallery.getThumbnail();
        this.description = gallery.getDescription();
        this.status = gallery.getStatus();
    }
}
