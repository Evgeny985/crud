package ru.gruzdov.mvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.gruzdov.mvc.model.City;
import ru.gruzdov.mvc.model.Department;

import java.util.List;

@Repository
public class CityDAOImpl implements CityDAO {

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public void addCity(City city) {
       sessionFactory.getCurrentSession().persist(city);//присоед объект к сессии и сохр в БД

    }


    @Override
    public City getCityById(Integer id) {
        return sessionFactory.getCurrentSession().get(City.class, id);//получ ид сущн в стутсе персист
    }

    @Override
    public void updateCity(City city) {
        sessionFactory.getCurrentSession().update(city);

    }

    @Override
    public void deleteCity(City city) {
     sessionFactory.getCurrentSession().delete(city);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<City> getAllCity() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from City").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Department> getDepByCityId(Integer cityid) {

        return sessionFactory.getCurrentSession().createQuery("select name from Department where id=city.id").list();
    }

  /*  public boolean checkTitle(String title) {
        Session session = sessionFactory.getCurrentSession();
        Query query;
        query = session.createQuery("from City where title = :title");
        query.setParameter("title", title);
        return query.list().isEmpty();
    }*/
}
