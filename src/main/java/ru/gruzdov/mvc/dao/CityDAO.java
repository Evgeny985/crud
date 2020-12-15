package ru.gruzdov.mvc.dao;

import ru.gruzdov.mvc.model.City;

import java.util.List;

public interface CityDAO {
    void addCity(City city);

    City getCityById(Integer id);

    void updateCity(City city);

    void deleteCity(Integer id);

    List<City> getAllCity();
}
