package university.org.universityassistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import university.org.universityassistant.model.Lector;

import java.util.Set;

public interface LectorRepository extends JpaRepository<Lector, Long> {
    @Query(value = "SELECT COUNT(l.id) FROM Department d JOIN d.lectors l WHERE d.name = :departmentName")
    long countAllByDepartmentName(String departmentName);

    @Query(value = "SELECT DISTINCT l FROM Lector l\n" +
            "WHERE (LOWER(l.firstName) LIKE LOWER(:searchText) OR LOWER(l.lastName) LIKE LOWER(:searchText))")
    Set<Lector> findAllByFirstNameLikeAndLastNameLike(String searchText);
}
