package ru.gruzdov.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration //конфиг файл содержащий бин-компонент
@EnableWebMvc // импорт конфиг MVC
@ComponentScan(basePackages = "ru.gruzdov.mvc") //где искать компоненты, которые определяют бин класса
public  class WebConfig  {

    @Bean
    ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp"); // view
        return  viewResolver;
    }
}
