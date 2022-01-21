package com.gmail.rak.aleh.app.cms.controllers;

import com.gmail.rak.aleh.app.cms.service.PageService;
import com.gmail.rak.aleh.app.cms.service.model.PageDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Log4j2
@Controller
public class StartController {
    private final PageService pageService;

    public StartController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping
    public String startPage(Model model) {
        List<PageDTO> pagesPublished = pageService.getPublishedPages();
        model.addAttribute("pages", pagesPublished);
        log.info("111111111" + pagesPublished);
        List<PageDTO> notPublishedPages = pageService.getNotPublishedPages();
        model.addAttribute("notPublishedPages", notPublishedPages);
        log.info("333333333" + notPublishedPages);
        return "start-page";
    }
}
