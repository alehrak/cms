package com.gmail.rak.aleh.app.cms.service.impl;

import com.gmail.rak.aleh.app.cms.repository.PageRepository;
import com.gmail.rak.aleh.app.cms.repository.entity.Page;
import com.gmail.rak.aleh.app.cms.service.PageService;
import com.gmail.rak.aleh.app.cms.service.converter.PageConverter;
import com.gmail.rak.aleh.app.cms.service.model.PageDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

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
        return pageConverter.convert(allPublishedPages);
    }

    @Override
    public PageDTO getPageBySlug(String slug) {
        Page page = pageRepository.getPageBySlug(slug);
        if (Objects.nonNull(page)) {
            return pageConverter.convert(page);
        }
        return null;
    }

    @Override
    public List<PageDTO> getNotPublishedPages() {
        List<Page> allNotPublishedPages = pageRepository.getAllNotPublishedPages();
        return pageConverter.convert(allNotPublishedPages);
    }

    @Override
    public void addPage(PageDTO pageDTO) {
        Page page = pageConverter.convert(pageDTO);
        pageRepository.save(page);
    }

    @Override
    @Transactional
    public void deletePageBySlug(String slug) {
        pageRepository.deleteBySlug(slug);
    }

    @Override
    @Transactional
    public void updatePage(PageDTO pageDTO) {
        Page page = pageConverter.convert(pageDTO);
        pageRepository.updatePage(page.getTitle(), page.getDescription(), page.getMenuLabel(),
                page.getHOne(), page.getContent(), page.getPublished(), page.getPriority(), page.getSlug());
    }
}
