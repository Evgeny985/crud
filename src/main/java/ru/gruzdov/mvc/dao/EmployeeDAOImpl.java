package ru.gruzdov.mvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.gruzdov.mvc.model.Employee;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public void addEmployee(Employee employee) {
        sessionFactory.getCurrentSession().persist(employee);

    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);

    }

    @Override
    public void deleteEmployee(Employee employee) {
sessionFactory.getCurrentSession().delete(employee);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Employee> getAllEmployee() {
        return sessionFactory.getCurrentSession().createQuery("FROM Employee").list();
    }
}
