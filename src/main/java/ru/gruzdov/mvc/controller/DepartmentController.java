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
    private CityService cityService;

    @GetMapping(value = "/department")
    public ModelAndView getAllDepartment() {
        List<Department> department=departmentService.getAllDepartment();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("department");
        modelAndView.addObject("DepartmentFromServer",department);
        return modelAndView;
    }
    @GetMapping(value ="/updateD/{id}")//место параметра в адресной строке
    public ModelAndView updatePage(@PathVariable Integer id){
        Department department=departmentService.getDepartmentById(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("updateDepartment");
        modelAndView.addObject("department",department);
        return modelAndView;
    }
    @PostMapping(value = "/updateD")
    public ModelAndView updateDepartment(@ModelAttribute("department") Department department){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("redirect:/department");
        departmentService.updateDepartment(department);
        return  modelAndView;
    }
    @GetMapping(value="/addD")
    public ModelAndView addPage(){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("addDepartment");
        return modelAndView;
    }

    @PostMapping(value = "/addD")
    public ModelAndView addDepartment(@ModelAttribute("department") Department department
                                      ){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("redirect:/department");
        department.setCity(cityService.getCityById(2));
        departmentService.addDepartment(department);
        return  modelAndView;
    }
    @GetMapping(value ="/deleteD/{id}")
    public ModelAndView deleteDepartment(@PathVariable("id") Integer id) {
        Department department=departmentService.getDepartmentById(id);
        ModelAndView modelAndView = new ModelAndView();
        departmentService.deleteDepartment(department);
        modelAndView.setViewName("redirect:/department");
        return modelAndView;
    }
}
