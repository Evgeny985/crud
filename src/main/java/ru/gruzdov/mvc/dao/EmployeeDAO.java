package ru.gruzdov.mvc.dao;


import ru.gruzdov.mvc.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee);

    Employee getEmployeeById(Integer id);

    void updateEmployee(Employee employee);

    void deleteEmployee(Integer id);

    List<Employee> getAllEmployeeByDepartmentId(Integer departmentId);
}
