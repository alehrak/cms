package com.gmail.rak.aleh.app.cms.service.converter;

import com.gmail.rak.aleh.app.cms.repository.entity.Page;
import com.gmail.rak.aleh.app.cms.service.model.PageDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PageConverter {
    public List<PageDTO> convert(List<Page> allPublishedPages) {
        return allPublishedPages.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
    public PageDTO convert(Page page){
        PageDTO pageDTO = new PageDTO();
        pageDTO.setSlug(page.getSlug());
        pageDTO.setTitle(page.getTitle());
        pageDTO.setDescription(page.getDescription());
        pageDTO.setMenuLabel(page.getMenuLabel());
        pageDTO.setHOne(page.getHOne());
        pageDTO.setPublished(page.getPublished());
        pageDTO.setContent(page.getContent());
        pageDTO.setPriority(page.getPriority());
        return pageDTO;
    }
}
