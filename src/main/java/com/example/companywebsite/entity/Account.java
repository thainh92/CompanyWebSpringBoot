package com.example.companywebsite.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
@SQLDelete(sql = "UPDATE accounts SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Entity
public class Account extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "status", nullable = false)
    private int status;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted = Boolean.FALSE;

    @OneToMany(mappedBy = "account")
    private List<Comment> comments;

    @OneToMany(mappedBy = "account")
    private List<Article> articles;

    @OneToMany(mappedBy = "account")
    private List<Gallery> galleries;

    public void updateAccount(Account account) {
        this.name = account.getName();
        this.password = account.getPassword();
        this.email = account.getEmail();
        this.status = account.getStatus();
    }
}
