package ru.gruzdov.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.gruzdov.mvc.model.City;
import ru.gruzdov.mvc.model.Department;
import ru.gruzdov.mvc.service.CityService;
import ru.gruzdov.mvc.service.DepartmentService;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private CityService cityService;

    @GetMapping(value = "/department/{cityId}")
    public ModelAndView getAllDepartment(@PathVariable Integer cityId) {
        List<Department> departmentList = departmentService.getAllDepartmentByCityId(cityId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("departmentFromServer", departmentList);
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
                                         @RequestParam(value = "cityId", required = true) Integer cityId) {
        ModelAndView modelAndView = new ModelAndView();
        City city = cityService.getCityById(cityId);
        if (city != null) {
            department.setCity(city);
            departmentService.updateDepartment(department);
            modelAndView.setViewName("redirect:/department?id=" + cityId);
        } else {
            modelAndView.setViewName("Error");
        }
        return modelAndView;
    }

    @GetMapping(value = "/addDepartment")
    public ModelAndView addPage(@ModelAttribute("city") City city) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("city", city);
        modelAndView.setViewName("addDepartment");
        return modelAndView;
    }

    @PostMapping(value = "/addDepartment")
    public ModelAndView addDepartment(@ModelAttribute("department") Department department,
                                      @RequestParam(value = "cityId", required = false) Integer cityId) {
        ModelAndView modelAndView = new ModelAndView();
        City city = cityService.getCityById(cityId);
        if (city != null) {
            department.setCity(city);
            departmentService.addDepartment(department);
            modelAndView.setViewName("redirect:/department?id=" + cityId);
        } else {
            modelAndView.setViewName("Error");
        }
         return modelAndView;
    }

    @GetMapping(value = "/deleteDepartment/{id}")
    public ModelAndView deleteDepartment(@PathVariable("id") Integer id) {
        Department department = departmentService.getDepartmentById(id);
        ModelAndView modelAndView = new ModelAndView();
        departmentService.deleteDepartment(department);
        modelAndView.setViewName("redirect:/department?id=" + department.getCity().getId());
        return modelAndView;
    }
}
