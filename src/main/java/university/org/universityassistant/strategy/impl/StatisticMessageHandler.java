package university.org.universityassistant.strategy.impl;

import org.springframework.stereotype.Component;
import university.org.universityassistant.model.Department;
import university.org.universityassistant.model.Lector;
import university.org.universityassistant.service.DepartmentService;
import university.org.universityassistant.strategy.MessageHandlerStrategy;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class StatisticMessageHandler implements MessageHandlerStrategy {
    private final DepartmentService departmentService;
    private final Pattern pattern = Pattern.compile("Show (.*?) statistics.");

    public StatisticMessageHandler(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public boolean supports(String message) {
        return pattern.matcher(message).find();
    }

    @Override
    public String handle(String message) {
        Matcher matcher = pattern.matcher(message);
        matcher.find();
        String departmentName = matcher.group(1);
        Optional<Department> optionalDepartment = departmentService.findByName(departmentName);
        if (optionalDepartment.isEmpty()) {
            return "Can't find Departmane by name " + departmentName;
        }
        Department department = optionalDepartment.get();
        int assistants = 0;
        int assistantProfessors = 0;
        int professors = 0;
        for (Lector lector : department.getLectors()) {
            if (lector.getDegree() == Lector.Degree.ASSISTANT) {
                assistants++;
            }
            if (lector.getDegree() == Lector.Degree.ASSISTANT_PROFESSOR) {
                assistantProfessors++;
            }
            if (lector.getDegree() == Lector.Degree.PROFESSOR) {
                professors++;
            }
        }
        String sb = "assistans - " + assistants + "." + System.lineSeparator() +
                "associate professors - " + assistantProfessors + System.lineSeparator() +
                "professors - " + professors;
        return sb;
    }
}
