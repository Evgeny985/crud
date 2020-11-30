package ru.gruzdov.mvc.dao;

import ru.gruzdov.mvc.model.City;
import ru.gruzdov.mvc.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee);

    Employee getEmployeeById(Integer id);

    void updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);

    List<Employee> getAllEmployeeByDepartmentId(Integer departmentId);
}
