package university.org.universityassistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import university.org.universityassistant.model.Department;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query(value = "SELECT d FROM Department d " +
            "LEFT JOIN FETCH d.headOfDepartment " +
            "LEFT JOIN FETCH d.lectors where d.name = :name")
    Optional<Department> findDepartmentByName(String name);

    @Query(value = "SELECT AVG(l.salary) FROM Department d " +
            "JOIN d.lectors l WHERE d.name = :name")
    double avgSalaryOfLectorByDepartmentByName(String name);
}
