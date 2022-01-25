package com.gmail.rak.aleh.app.cms.service.converter;

import com.gmail.rak.aleh.app.cms.repository.entity.Page;
import com.gmail.rak.aleh.app.cms.service.model.PageDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Component
public class PageConverter {
    private static final String SEPARATOR_DATE_TIME = "T";
    private static final String SEPARATOR_DATE = "-";
    private static final String SEPARATOR_TIME = ":";

    public List<PageDTO> convert(List<Page> allPublishedPages) {
        return allPublishedPages.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public PageDTO convert(Page page) {
        PageDTO pageDTO = new PageDTO();
        pageDTO.setSlug(page.getSlug());
        pageDTO.setTitle(page.getTitle());
        pageDTO.setDescription(page.getDescription());
        pageDTO.setMenuLabel(page.getMenuLabel());
        pageDTO.setHOne(page.getHOne());
        pageDTO.setPublished(page.getPublished().toString());
        pageDTO.setContent(page.getContent());
        pageDTO.setPriority(page.getPriority());
        return pageDTO;
    }

    public Page convert(PageDTO pageDTO) {
        Page page = new Page();
        page.setSlug(pageDTO.getSlug());
        page.setTitle(pageDTO.getTitle());
        page.setDescription(pageDTO.getDescription());
        page.setMenuLabel(pageDTO.getMenuLabel());
        page.setHOne(pageDTO.getHOne());
        LocalDateTime published = getDateTimePublished(pageDTO);
        page.setPublished(published);
        page.setContent(pageDTO.getContent());
        page.setPriority(pageDTO.getPriority());
        return page;
    }

    private LocalDateTime getDateTimePublished(PageDTO pageDTO) {
        String publishedString = pageDTO.getPublished();
        String[] dateAndTime = publishedString.split(SEPARATOR_DATE_TIME);
        String[] dateString = dateAndTime[0].split(SEPARATOR_DATE);
        String[] timeString = dateAndTime[1].split(SEPARATOR_TIME);
        LocalDate datePublished = LocalDate.of(
                Integer.parseInt(dateString[0]),
                Integer.parseInt(dateString[1]),
                Integer.parseInt(dateString[2]));
        LocalTime timePublished = LocalTime.of(
                Integer.parseInt(timeString[0]),
                Integer.parseInt(timeString[1]));
        LocalDateTime published = LocalDateTime.of(datePublished, timePublished);
        return published;
    }
}
