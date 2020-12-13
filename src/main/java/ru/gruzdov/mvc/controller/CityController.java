package ru.gruzdov.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.gruzdov.mvc.model.City;
import ru.gruzdov.mvc.service.CityService;

import java.util.List;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping(value = "/")
    public ModelAndView getAll() {
        List<City> cityList = cityService.getAllCity();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("city");
        modelAndView.addObject("cityFromServer", cityList);
        return modelAndView;
    }

    @GetMapping(value = "/updateCity/{id}")
    public ModelAndView updatePage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updateCity");
        modelAndView.addObject("city", cityService.getCityById(id));
        return modelAndView;
    }

    @PostMapping(value = "/updateCity")
    public ModelAndView updateCity(@ModelAttribute("city") City city) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        cityService.updateCity(city);
        return modelAndView;
    }

    @GetMapping(value = "/addCity")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addCity");
        return modelAndView;
    }

    @PostMapping(value = "/addCity")
    public ModelAndView addCity(@ModelAttribute("city") City city) {
        cityService.addCity(city);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @GetMapping(value = "/deleteCity/{id}")
    public ModelAndView deleteCity(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        cityService.deleteCity(cityService.getCityById(id));
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
