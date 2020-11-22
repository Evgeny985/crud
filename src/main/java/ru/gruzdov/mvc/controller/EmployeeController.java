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

import java.io.IOException;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeService employeeService;


    @GetMapping(value = "/employee")
    public ModelAndView getAllEmployee(@RequestParam  Integer id) {
        List<Employee> employee=employeeService.getAllEmployeeByDepartmentId(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employee");
        modelAndView.addObject("EmployeeFromServer",employee);
        return modelAndView;
    }

    @GetMapping(value ="/updateEmployee/{id}")//место параметра в адресной строке
    public ModelAndView updatePage(@PathVariable Integer id){
        Employee employee=employeeService.getEmployeeById(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("updateEmployee");
        modelAndView.addObject("employee",employee);
        return modelAndView;
    }
    @PostMapping(value = "/updateEmployee")
    public ModelAndView updateEmployee(@ModelAttribute("employee") Employee employee){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("redirect:/");
        employeeService.updateEmployee(employee);
        return  modelAndView;
    }
    @GetMapping(value="/addEmployee")
    public ModelAndView addPage(@ModelAttribute ("department")Department department){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.addObject("department",department);
        modelAndView.setViewName("addEmployee");
        return modelAndView;
    }
    @PostMapping(value = "/addEmployee")
    public ModelAndView addEmployee(@ModelAttribute("employee") Employee employee,
                                    @RequestParam(value = "departmentId", required = false)
                                              Integer departmentId)  {
        ModelAndView modelAndView=new ModelAndView();
        if(departmentService.getDepartmentById(departmentId).equals(employee.getDepartment())){
            modelAndView.setViewName("Error");
    }
    else{
            employee.setDepartment(departmentService.getDepartmentById(departmentId));
            employeeService.addEmployee(employee);
            modelAndView.setViewName("redirect:/employee?id=" + departmentId);
    }
        return  modelAndView;
    }
    @GetMapping(value ="/deleteEmployee")
    public ModelAndView deleteEmployee(@RequestParam(value = "id", required = false)
                                                   Integer id) {
        Employee employee=employeeService.getEmployeeById(id);
        ModelAndView modelAndView = new ModelAndView();
        employeeService.deleteEmployee(employee);
     modelAndView.setViewName("redirect:/employee?id="+id);
        return modelAndView;
    }
}
