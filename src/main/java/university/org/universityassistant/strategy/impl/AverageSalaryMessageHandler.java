package university.org.universityassistant.strategy.impl;

import org.springframework.stereotype.Component;
import university.org.universityassistant.service.DepartmentService;
import university.org.universityassistant.strategy.MessageHandlerStrategy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class AverageSalaryMessageHandler implements MessageHandlerStrategy {
    private final DepartmentService departmentService;
    private final Pattern pattern = Pattern.compile("Show the average salary for the department (.*?)\\.");

    public AverageSalaryMessageHandler(DepartmentService departmentService) {
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
        double avgSalaryOfLectors = departmentService.getAvgSalaryOfLectors(departmentName);
        return String.format("The average salary of %s is %s",
                departmentName,
                avgSalaryOfLectors);
    }
}
