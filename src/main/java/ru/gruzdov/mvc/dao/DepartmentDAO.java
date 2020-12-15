package ru.gruzdov.mvc.dao;


import ru.gruzdov.mvc.model.Department;

import java.util.List;

public interface DepartmentDAO {
    void addDepartment(Department department);

    Department getDepartmentById(Integer id);

    void updateDepartment(Department department);

    void deleteDepartment(Integer id);

    List<Department> getAllDepartmentByCityId(Integer cityId);
}
