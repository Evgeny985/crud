package ru.gruzdov.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.gruzdov.mvc.model.City;
import ru.gruzdov.mvc.model.Department;
import ru.gruzdov.mvc.model.Employee;
import ru.gruzdov.mvc.service.CityService; 
import ru.gruzdov.mvc.service.DepartmentService;
import ru.gruzdov.mvc.service.EmployeeService;

@Controller
public class EmployeeController {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CityService cityService;

    @GetMapping(value = "/employee/{id}")
    public ModelAndView getAllEmployee(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employeeFromServer", employeeService.getAllEmployeeByDepartmentId(id));
        modelAndView.setViewName("employee");
        return modelAndView;
    }

    @GetMapping(value = "/updateEmployee/{id}")
    public ModelAndView updatePage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employee", employeeService.getEmployeeById(id));
        modelAndView.setViewName("updateEmployee");
        return modelAndView;
    }

    @PostMapping(value = "/updateEmployee")
    public ModelAndView updateEmployee(@ModelAttribute("employee") Employee employee,
                                       Integer departmentId, Integer cityId) {
        City city = cityService.getCityById(cityId);
        Department department = departmentService.getDepartmentById(departmentId);
        ModelAndView modelAndView = new ModelAndView();
        if (city != null && department != null) {
            department.setCity(city);
            employee.setDepartment(department);
            employeeService.updateEmployee(employee);
            modelAndView.setViewName("redirect:/employee/" + departmentId);
        } else {
            modelAndView.setViewName("Error");
        }
        return modelAndView;
    }

    @GetMapping(value = "/addEmployee")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addEmployee");
        return modelAndView;
    }

    @PostMapping(value = "/addEmployee")
    public ModelAndView addEmployee(@ModelAttribute("employee") Employee employee,
                                    Integer departmentId) {
        Department department = departmentService.getDepartmentById(departmentId);
        ModelAndView modelAndView = new ModelAndView();
        if (department != null) {
            employee.setDepartment(department);
            employeeService.addEmployee(employee);
            modelAndView.setViewName("redirect:/employee/" + departmentId);
        } else {
            modelAndView.setViewName("Error");
        }
        return modelAndView;
    }

    @GetMapping(value = "/deleteEmployee/{id}/{departmentId}")
    public ModelAndView deleteEmployee(@PathVariable("id") Integer id,
                                       @PathVariable("departmentId") Integer departmentId) {
        employeeService.deleteEmployee(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/employee/"+departmentId);
        return modelAndView;
    }
}
