package com.gmail.rak.aleh.app.cms.repository;

import com.gmail.rak.aleh.app.cms.repository.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PageRepository extends JpaRepository<Page, String> {
    @Modifying
    @Query("select p from Page p where p.published <= current_timestamp order by p.priority")
    List<Page> getAllPublishedPages();

    Page getPageBySlug(String slug);

    @Modifying
    @Query("select p from Page p where p.published > current_timestamp order by p.priority")
    List<Page> getAllNotPublishedPages();

    void deleteBySlug(String slug);

    @Modifying
    @Query("update Page p set p.title = :title, p.description = :description, p.menuLabel = :menuLabel," +
            "p.hOne = :hOne, p.content = :content, p.published = :published, p.priority = :priority where p.slug = :slug")
    void updatePage(String title, String description, String menuLabel, String hOne,
                    String content, LocalDateTime published, Integer priority, String slug);
}
