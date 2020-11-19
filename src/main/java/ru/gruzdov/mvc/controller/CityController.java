package ru.gruzdov.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.gruzdov.mvc.model.City;
import ru.gruzdov.mvc.model.Department;
import ru.gruzdov.mvc.service.CityService;
import ru.gruzdov.mvc.service.DepartmentService;

import java.util.List;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = "/")
    public ModelAndView getAll() {
        List<City> city=cityService.getAllCity();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("city");
        modelAndView.addObject("CityFromServer",city);
        return modelAndView;

    }

    @GetMapping(value ="/depofcity/{id}")//место параметра в адресной строке
    public ModelAndView getDepOfCity(@PathVariable Integer id){
        //City city=cityService.getCityById(id);
        List<Department> departments=cityService.getDepByCityId(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("depofcity");
        modelAndView.addObject("AllDepartment",departments);
        return modelAndView;
    }

    @GetMapping(value ="/updateCity/{id}")//место параметра в адресной строке
    public ModelAndView updatePage(@PathVariable Integer id){
        City city=cityService.getCityById(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("updateCity");
        modelAndView.addObject("city",city);
        return modelAndView;
    }

    @PostMapping(value = "/updateCity")
    public ModelAndView updateCity(@ModelAttribute("city") City city){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("redirect:/");
        cityService.updateCity(city);
        return  modelAndView;
    }


    @GetMapping(value="/addCity")
    public ModelAndView addPage(){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("addCity");
        return modelAndView;
    }
    @PostMapping(value = "/addCity")
    public ModelAndView addCity(@ModelAttribute("city") City city){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("redirect:/");
        cityService.addCity(city);
        return  modelAndView;
    }
    @GetMapping(value ="/deleteCity/{id}")
    public ModelAndView deleteCity(@PathVariable("id") int id) {
        City city=cityService.getCityById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        cityService.deleteCity(city);
        return modelAndView;
    }



}
