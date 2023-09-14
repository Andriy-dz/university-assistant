package university.org.universityassistant.service.impl;

import org.springframework.stereotype.Service;
import university.org.universityassistant.model.Lector;
import university.org.universityassistant.repository.LectorRepository;
import university.org.universityassistant.service.LectorService;

import java.util.Set;

@Service
public class LectorServiceImpl implements LectorService {
    private final LectorRepository lectorRepository;

    public LectorServiceImpl(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    @Override
    public long countAllLectorsByDepartmentName(String departmentName) {
        return lectorRepository.countAllByDepartmentName(departmentName);
    }

    @Override
    public Set<Lector> searchAllByExpression(String expression) {
        return lectorRepository.findAllByFirstNameLikeAndLastNameLike("%" + expression + "%");
    }
}
