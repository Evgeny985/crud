package ru.gruzdov.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.gruzdov.mvc.model.City;
import ru.gruzdov.mvc.service.CityService;

import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping()
    public ModelAndView getAll() {
        List<City> cityList = cityService.getAllCity();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cityFromServer", cityList);
        modelAndView.setViewName("city");
        return modelAndView;
    }

    @GetMapping(value = "/{id}/edit")
    public ModelAndView updatePage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("city", cityService.getCityById(id));
        modelAndView.setViewName("updateCity");
        return modelAndView;
    }

    @PatchMapping()
    public ModelAndView updateCity(@ModelAttribute("city") City city) {
        cityService.updateCity(city);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/city");
        return modelAndView;
    }

    @GetMapping(value = "/new")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addCity");
        return modelAndView;
    }

    @PostMapping()
    public ModelAndView addCity(@ModelAttribute("city") City city) {
        cityService.addCity(city);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/city");
        return modelAndView;
    }

    @DeleteMapping(value = "/{id}")
    public ModelAndView deleteCity(@PathVariable("id") Integer id) {
        cityService.deleteCity(cityService.getCityById(id));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/city");
        return modelAndView;
    }
}
