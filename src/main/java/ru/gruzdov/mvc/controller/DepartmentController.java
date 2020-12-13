package ru.gruzdov.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    @GetMapping(value = "/department/{id}")
    public ModelAndView getAllDepartment(@PathVariable Integer id) {
        List<Department> departmentList = departmentService.getAllDepartmentByCityId(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("department");
        modelAndView.addObject("departmentFromServer", departmentList);
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
            department.setCity(cityService.getCityById(cityId));
            departmentService.addDepartment(department);
            modelAndView.setViewName("redirect:/department/" + cityId);
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
        modelAndView.setViewName("redirect:/department/" + department.getCity().getId());
        return modelAndView;
    }
}
