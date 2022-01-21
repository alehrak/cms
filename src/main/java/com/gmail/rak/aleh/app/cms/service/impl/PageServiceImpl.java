package com.gmail.rak.aleh.app.cms.service.impl;

import com.gmail.rak.aleh.app.cms.repository.PageRepository;
import com.gmail.rak.aleh.app.cms.repository.entity.Page;
import com.gmail.rak.aleh.app.cms.service.PageService;
import com.gmail.rak.aleh.app.cms.service.converter.PageConverter;
import com.gmail.rak.aleh.app.cms.service.model.PageDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class PageServiceImpl implements PageService {
    private final PageRepository pageRepository;
    private final PageConverter pageConverter;

    public PageServiceImpl(PageRepository pageRepository, PageConverter pageConverter) {
        this.pageRepository = pageRepository;
        this.pageConverter = pageConverter;
    }

    @Override
    public List<PageDTO> getPublishedPages() {
        List<Page> allPublishedPages = pageRepository.getAllPublishedPages();
        log.info(allPublishedPages.size());
        List<PageDTO> publishedPages = pageConverter.convert(allPublishedPages);
        for (PageDTO publishedPage : publishedPages) {
            System.out.println(publishedPage);
        }
        return publishedPages;
    }

    @Override
    public PageDTO getPageBySlug(String slug) {
        Page page = pageRepository.getPageBySlug(slug);
        PageDTO pageDTO = pageConverter.convert(page);
        return pageDTO;
    }

    @Override
    public List<PageDTO> getNotPublishedPages() {
        List<Page> allNotPublishedPages = pageRepository.getAllNotPublishedPages();
        List<PageDTO> pages = pageConverter.convert(allNotPublishedPages);
        log.info("5555555saxaxaxaSIZE"+pages.size());
        return pages;
    }
}
