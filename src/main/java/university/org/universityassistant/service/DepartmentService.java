package university.org.universityassistant.service;

import university.org.universityassistant.model.Department;

import java.util.Optional;

public interface DepartmentService {
    Optional<Department> findByName(String name);

    double getAvgSalaryOfLectors(String name);
}
