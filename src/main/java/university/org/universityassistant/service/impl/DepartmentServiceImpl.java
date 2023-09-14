package university.org.universityassistant.service.impl;

import org.springframework.stereotype.Service;
import university.org.universityassistant.model.Department;
import university.org.universityassistant.repository.DepartmentRepository;
import university.org.universityassistant.service.DepartmentService;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Optional<Department> findByName(String name) {
        return departmentRepository.findDepartmentByName(name);
    }

    @Override
    public double getAvgSalaryOfLectors(String name) {
        return departmentRepository.avgSalaryOfLectorByDepartmentByName(name);
    }
}
