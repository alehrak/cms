package com.gmail.rak.aleh.app.cms.service.model;

import lombok.Data;
import java.time.LocalDateTime;
@Data
public class PageDTO {
    private String slug;
    private String title;
    private String description;
    private String menuLabel;
    private String hOne;
    private LocalDateTime published;
    private String content;
    private Integer priority;
}
