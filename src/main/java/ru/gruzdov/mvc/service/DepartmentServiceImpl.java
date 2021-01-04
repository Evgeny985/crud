package ru.gruzdov.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gruzdov.mvc.dao.DepartmentDAO;
import ru.gruzdov.mvc.model.Department;
import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentDAO departmentDAO;

    @Override
    public void addDepartment(Department department) {
        departmentDAO.addDepartment(department);
    }

    @Override
    public Department getDepartmentById(Integer id) {
        return departmentDAO.getDepartmentById(id);
    }

    @Override
    @Transactional
    public void updateDepartment(Department department) {
departmentDAO.updateDepartment(department);
    }

    @Override
    public void deleteDepartment(Integer id) {
        departmentDAO.deleteDepartment(id);
    }

    @Override
    public List<Department> getAllDepartmentByCityId(Integer cityId) {
        return departmentDAO.getAllDepartmentByCityId(cityId);
    }
}
