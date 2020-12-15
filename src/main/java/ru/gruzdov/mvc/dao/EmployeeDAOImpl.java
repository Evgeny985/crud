package ru.gruzdov.mvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.gruzdov.mvc.model.Employee;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
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
    public void deleteEmployee(Integer id) {
        sessionFactory.getCurrentSession().delete(getEmployeeById(id));
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Employee> getAllEmployeeByDepartmentId(Integer departmentId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select e from Employee e join e.department d  where d.id=:id").setParameter("id", departmentId).list();
    }
}
