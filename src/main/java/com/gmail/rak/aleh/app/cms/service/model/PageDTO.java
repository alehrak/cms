package com.gmail.rak.aleh.app.cms.service.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PageDTO {
    @NotNull
    @NotBlank(message = "can't be empty")
    @Size(min = 2, message = "the number of characters must be longer than two")
    private String slug;
    @NotNull
    @NotBlank(message = "can't be empty")
    @Size(min = 2, message = "the number of characters must be longer than two")
    private String title;
    @NotNull
    @NotBlank(message = "can't be empty")
    @Size(min = 2, message = "the number of characters must be longer than two")
    private String description;
    @NotNull
    @NotBlank(message = "can't be empty")
    @Size(min = 2, message = "the number of characters must be longer than two")
    private String menuLabel;
    @NotNull
    @NotBlank(message = "can't be empty")
    @Size(min = 2, message = "the number of characters must be longer than two")
    private String hOne;
    @NotNull
    @NotBlank(message = "can't be empty")
    @Size(min = 16, message = "the number of characters must be longer than two")
    private String published;
    @NotNull
    @NotBlank(message = "can't be empty")
    @Size(min = 2, message = "the number of characters must be longer than two")
    private String content;
    @NotNull
    private Integer priority;
}
