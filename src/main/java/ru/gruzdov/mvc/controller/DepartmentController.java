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


    @GetMapping(value = "/department")
    public ModelAndView getAllDepartment(@RequestParam  Integer id) {
        List<Department> department=departmentService.getAllDepartmentByCityId(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("department");
        modelAndView.addObject("DepartmentFromServer",department);
        return modelAndView;
    }

    @GetMapping(value ="/updateDepartment/{id}")//место параметра в адресной строке
    public ModelAndView updatePage(@PathVariable Integer id){
        Department department=departmentService.getDepartmentById(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("updateDepartment");
        modelAndView.addObject("department",department);
        return modelAndView;
    }
    @PostMapping(value = "/updateDepartment")
    public ModelAndView updateDepartment(@ModelAttribute("department") Department department){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("department");
        departmentService.updateDepartment(department);
        return  modelAndView;
    }
    @GetMapping(value="/addDepartment")
    public ModelAndView addPage(@ModelAttribute("city") City city,
                                @RequestParam(value = "cityId", required = false)
                                        Integer cityId){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.addObject("city",city);
        modelAndView.setViewName("addDepartment");
        return modelAndView;
    }

    @PostMapping(value = "/addDepartment")
    public ModelAndView addDepartment(@ModelAttribute("department") Department department,
                                      @RequestParam(value = "cityId", required = false)
                                              Integer cityId){

        ModelAndView modelAndView=new ModelAndView();

        department.setCity(cityService.getCityById(cityId));
        departmentService.addDepartment(department);
        modelAndView.setViewName("redirect:/department?id="+cityId);
        return  modelAndView;
    }

    @GetMapping(value ="/deleteDepartment/{id}")
    public ModelAndView deleteDepartment(@PathVariable ("id") Integer id){
            Department department = departmentService.getDepartmentById(id);
            ModelAndView modelAndView = new ModelAndView();
            departmentService.deleteDepartment(department);
            modelAndView.setViewName("redirect:/");
    return modelAndView;
    }
}
