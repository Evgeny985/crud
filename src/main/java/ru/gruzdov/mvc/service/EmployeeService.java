package ru.gruzdov.mvc.service;

import ru.gruzdov.mvc.model.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);

    Employee getEmployeeById(Integer id);

    void updateEmployee(Employee employee);

    void deleteEmployee(Integer id);

    List<Employee> getAllEmployeeByDepartmentId(Integer departmentId);
}
