package com.gmail.rak.aleh.app.cms.controllers;

import com.gmail.rak.aleh.app.cms.service.PageService;
import com.gmail.rak.aleh.app.cms.service.model.PageDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@Log4j2
@Controller
public class PageController {
    private final PageService pageService;

    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping("/{slug}")
    public String getPageBySlug(Model model, @PathVariable String slug) {
        PageDTO page = pageService.getPageBySlug(slug);
        model.addAttribute("page", page);
        return "page-template";
    }

    @GetMapping("/page/add")
    public String createPages() {
        return "create-page";
    }

    @PostMapping("/page/add")
    public String createPage(@Valid @ModelAttribute PageDTO pageDTO, Model model) {
        String slug = pageDTO.getSlug();
        PageDTO pageBySlug = pageService.getPageBySlug(slug);
        if (Objects.nonNull(pageBySlug)) {
            model.addAttribute("slug", slug);
            return "error-page";
        } else {
            pageService.addPage(pageDTO);
            return "redirect:/";
        }
    }

    @PostMapping("/page/delete")
    public String deletePage(@RequestParam(value = "slugPageForDelete") String slug) {
        pageService.deletePageBySlug(slug);
        return "redirect:/";
    }

    @GetMapping("/page/refactoring/{slug}")
    public String getRefactoringPage(Model model, @PathVariable String slug) {
        PageDTO page = pageService.getPageBySlug(slug);
        model.addAttribute("page", page);
        return "refactor-page";
    }

    @PostMapping("/page/refactoring")
    public String refactoringPage(@Valid @ModelAttribute PageDTO pageDTO) {
        pageService.updatePage(pageDTO);
        log.info("@@@@@@@@@@@@" + pageDTO);
        return "redirect:/";
    }
}
