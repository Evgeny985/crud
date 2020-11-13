package ru.gruzdov.mvc.dao;

import ru.gruzdov.mvc.model.City;
import ru.gruzdov.mvc.model.Department;

import java.util.List;

public interface CityDAO{
    void addCity(City city);
    City getCityById(Integer id);
    void updateCity(City city);
    void deleteCity(City city);
    List<City> getAllCity();
    List<Department> getDepByCityId(Integer id);
}
