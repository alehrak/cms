package com.gmail.rak.aleh.app.cms.controllers;

import com.gmail.rak.aleh.app.cms.service.PageService;
import com.gmail.rak.aleh.app.cms.service.model.PageDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Log4j2
@Controller
public class PageController {
    private final PageService pageService;

    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping("/3000/{slug}")
    public String getPageBySlug(Model model, @PathVariable String slug) {
        PageDTO page = pageService.getPageBySlug(slug);
        model.addAttribute("page", page);
        log.info("!!!!!!!!!" + slug);
        log.info("!!!!!!!!!" + page);
        return "page-template";
    }

    @GetMapping("/add/page")
    public String createPage(){
        return "create-page";
    }
}
