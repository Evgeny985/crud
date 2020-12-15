package ru.gruzdov.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gruzdov.mvc.dao.CityDAO;
import ru.gruzdov.mvc.model.City;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDAO cityDAO;

    @Override
    @Transactional
    public void addCity(City city) {
        cityDAO.addCity(city);
    }

    @Override
    @Transactional
    public City getCityById(Integer id) {
        return cityDAO.getCityById(id);
    }

    @Override
    @Transactional
    public void updateCity(City city) {
        cityDAO.updateCity(city);
    }

    @Override
    @Transactional
    public void deleteCity(Integer id) {
        cityDAO.deleteCity(id);
    }

    @Override
    @Transactional
    public List<City> getAllCity() {
        return cityDAO.getAllCity();
    }
}
