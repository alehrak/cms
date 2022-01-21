package com.gmail.rak.aleh.app.cms.repository;

import com.gmail.rak.aleh.app.cms.repository.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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
}
