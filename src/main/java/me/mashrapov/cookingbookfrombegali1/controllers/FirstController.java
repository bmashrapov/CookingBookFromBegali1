package me.mashrapov.cookingbookfrombegali1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class FirstController {
    @GetMapping
    public String welcome() {
        return "Приложение запущено!";
    }

    @GetMapping("/info")
    public String info() {
        String name = "Машрапов Бегали";
        String projectName = "Книга рецептов Бегали";
        LocalDate createDate = LocalDate.of(2023,2,23);
        return "Автор: " + name + ". Название проекта: " + projectName + ". Дата создания: " + createDate + ". Описание: Проект будет содержать в себе книгу рецептов изысканных и простых блюд, что позволит Вам усовершенстовавать свои кулинарные навыки и не бояться приема гостей!";
    }
}
