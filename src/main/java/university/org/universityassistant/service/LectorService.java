package university.org.universityassistant.service;

import university.org.universityassistant.model.Lector;

import java.util.Set;

public interface LectorService {
    long countAllLectorsByDepartmentName(String departmentName);

    Set<Lector> searchAllByExpression(String expression);
}
