package com.gmail.rak.aleh.app.cms.service;

import com.gmail.rak.aleh.app.cms.service.model.PageDTO;

import java.util.List;

public interface PageService {
    List<PageDTO> getPublishedPages();

    PageDTO getPageBySlug(String slug);

    List<PageDTO> getNotPublishedPages();

    void addPage(PageDTO pageDTO);

    void deletePageBySlug(String slug);

    void updatePage(PageDTO pageDTO);
}
