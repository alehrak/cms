package com.gmail.rak.aleh.app.cms.repository.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "pages")
public class Page {
    @Id
    private String slug;
    private String title;
    private String description;
    @Column(name = "menu_label")
    private String menuLabel;
    @Column(name = "h1")
    private String hOne;
    @Column(name = "published_at")
    private LocalDateTime published;
    private String content;
    private Integer priority;
}
