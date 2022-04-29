package com.example.companywebsite.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "galleries")
@SQLDelete(sql = "UPDATE galleries SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Entity
public class Gallery {
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

    @Column(name = "last_updated_by", nullable = false)
    private long lastUpdatedByUserId;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "gallery")
    private List<Picture> pictures;

    @ManyToOne
    @JoinColumn(name="account_id", insertable = false, updatable = false)
    private Account account;

    public void updateGallery(Gallery gallery) {
        this.name = gallery.getName();
        this.thumbnail = gallery.getThumbnail();
        this.description = gallery.getDescription();
        this.status = gallery.getStatus();
        this.updatedAt = LocalDateTime.now();
    }
}
