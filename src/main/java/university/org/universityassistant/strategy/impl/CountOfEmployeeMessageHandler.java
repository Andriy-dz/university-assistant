package university.org.universityassistant.strategy.impl;

import org.springframework.stereotype.Component;
import university.org.universityassistant.service.LectorService;
import university.org.universityassistant.strategy.MessageHandlerStrategy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CountOfEmployeeMessageHandler implements MessageHandlerStrategy {
    private final LectorService lectorService;
    private final Pattern pattern = Pattern.compile("Show count of employee for (.*?)\\.");

    public CountOfEmployeeMessageHandler(LectorService lectorService) {
        this.lectorService = lectorService;
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
        return String.valueOf(lectorService.countAllLectorsByDepartmentName(departmentName));
    }
}
