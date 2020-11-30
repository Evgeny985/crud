package ru.gruzdov.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gruzdov.mvc.dao.EmployeeDAO;
import ru.gruzdov.mvc.model.Employee;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        this.employeeDAO.addEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(Integer id) {
        return this.employeeDAO.getEmployeeById(id);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        this.employeeDAO.updateEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(Employee employee) {
        this.employeeDAO.deleteEmployee(employee);
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployeeByDepartmentId(Integer departmentId) {
        return this.employeeDAO.getAllEmployeeByDepartmentId(departmentId);
    }
}
