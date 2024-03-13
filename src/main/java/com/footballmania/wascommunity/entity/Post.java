package com.footballmania.wascommunity.entity;

import jakarta.persistence.*;

import java.util.UUID;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@RequiredArgsConstructor
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="uuid", unique = true)
    private String uuid;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="text", nullable = false)
    private String text;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Builder
    public Post(String title, String text, String created_at, String updated_at, boolean is_deleted, User user) {
        this.title = title;
        this.text = text;
        this.user = user;
    }

    @PrePersist
    public void autofill() {
        this.setUuid(UUID.randomUUID().toString());
    }
}
