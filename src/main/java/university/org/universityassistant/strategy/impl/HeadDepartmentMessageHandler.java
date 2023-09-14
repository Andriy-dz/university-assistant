package university.org.universityassistant.strategy.impl;

import org.springframework.stereotype.Component;
import university.org.universityassistant.model.Department;
import university.org.universityassistant.service.DepartmentService;
import university.org.universityassistant.strategy.MessageHandlerStrategy;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class HeadDepartmentMessageHandler implements MessageHandlerStrategy {
    private final DepartmentService departmentService;
    private final Pattern pattern = Pattern.compile("Who is head of department (.*?)\\.");

    public HeadDepartmentMessageHandler(DepartmentService departmentService) {
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
        if (optionalDepartment.isPresent()) {
            Department department = optionalDepartment.get();
            return String.format("Head of %s department is %s %s",
                    departmentName,
                    department.getHeadOfDepartment().getFirstName(),
                    department.getHeadOfDepartment().getLastName());
        }
        return "Can't find Departmane by name " + departmentName;
    }
}
