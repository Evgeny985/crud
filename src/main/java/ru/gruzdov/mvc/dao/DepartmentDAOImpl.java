package ru.gruzdov.mvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.gruzdov.mvc.model.City;
import ru.gruzdov.mvc.model.Department;

import java.util.List;
@Repository
public class DepartmentDAOImpl implements DepartmentDAO {
    @Autowired
    private SessionFactory sessionFactory;
    private City city;

    @Override
    public void addDepartment (Department department) {
        sessionFactory.getCurrentSession().persist(department);
    }


    @Override
    public Department getDepartmentById(Integer id) {
        return sessionFactory.getCurrentSession().get(Department.class, id);
    }

    @Override
    public void updateDepartment(Department department) {
        sessionFactory.getCurrentSession().update(department);
    }

    @Override
    public void deleteDepartment(Department department) {
        sessionFactory.getCurrentSession().delete(department);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Department> getAllDepartment() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Department").list();
    }



}
