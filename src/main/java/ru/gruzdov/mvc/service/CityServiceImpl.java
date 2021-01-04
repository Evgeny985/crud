package ru.gruzdov.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gruzdov.mvc.dao.CityDAO;
import ru.gruzdov.mvc.model.City;

import java.util.List;

@Service
@Transactional
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDAO cityDAO;

    @Override
    public void addCity(City city) {
        cityDAO.addCity(city);
    }

    @Override
    public City getCityById(Integer id) {
        return cityDAO.getCityById(id);
    }

    @Override
    public void updateCity(City city) {
        cityDAO.updateCity(city);
    }

    @Override
    public void deleteCity(Integer id) {
        cityDAO.deleteCity(id);
    }

    @Override
    public List<City> getAllCity() {
        return cityDAO.getAllCity();
    }
}
