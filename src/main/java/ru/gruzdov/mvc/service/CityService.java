package ru.gruzdov.mvc.service;

import ru.gruzdov.mvc.model.City;
import java.util.List;

public interface CityService {

    void addCity(City city);

    City getCityById(Integer id);

    void updateCity(City city);

    void deleteCity(City city);

    List<City> getAllCity();
}
