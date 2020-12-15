package ru.gruzdov.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.gruzdov.mvc.model.City;
import ru.gruzdov.mvc.model.Department;
import ru.gruzdov.mvc.service.CityService;
import ru.gruzdov.mvc.service.DepartmentService;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private CityService cityService;

    @GetMapping(value = "/department/{id}")
    public ModelAndView getAllDepartment(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("departmentFromServer", departmentService.getAllDepartmentByCityId(id));
        modelAndView.setViewName("department");
        return modelAndView;
    }

    @GetMapping(value = "/updateDepartment/{id}")
    public ModelAndView updatePage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("department", departmentService.getDepartmentById(id));
        modelAndView.setViewName("updateDepartment");
        return modelAndView;
    }

    @PostMapping(value = "/updateDepartment")
    public ModelAndView updateDepartment(@ModelAttribute("department") Department department,
                                         Integer cityId) {
        ModelAndView modelAndView = new ModelAndView();
        City city = cityService.getCityById(cityId);
        if (city!=null) {
            department.setCity(city);
            departmentService.updateDepartment(department);
            modelAndView.setViewName("redirect:/department/" + cityId);
        } else {
            modelAndView.setViewName("Error");
        }
        return modelAndView;
    }

    @GetMapping(value = "/addDepartment")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addDepartment");
        return modelAndView;
    }

    @PostMapping(value = "/addDepartment")
    public ModelAndView addDepartment(@ModelAttribute("department") Department department,
                                      Integer cityId) {
        ModelAndView modelAndView = new ModelAndView();
        City city = cityService.getCityById(cityId);
        if (city!=null) {
            department.setCity(city);
            departmentService.addDepartment(department);
            modelAndView.setViewName("redirect:/department/" + cityId);
        } else {
            modelAndView.setViewName("Error");
        }
        return modelAndView;
    }

    @GetMapping(value = "/deleteDepartment/{id}/{cityId}")
    public ModelAndView deleteDepartment(@PathVariable("id") Integer id,
                                         @PathVariable("cityId") Integer cityId) {
        departmentService.deleteDepartment(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/department/" + cityId);
        return modelAndView;
    }
}
