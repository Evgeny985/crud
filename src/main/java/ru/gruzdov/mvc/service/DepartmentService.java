package ru.gruzdov.mvc.service;

import ru.gruzdov.mvc.model.Department;

import java.util.List;

public interface DepartmentService {
    void addDepartment(Department department);
    Department getDepartmentById(Integer id);
    void updateDepartment(Department department);
    void deleteDepartment(Department department);
    List<Department> getAllDepartmentByCityId(Integer cityId);

}
