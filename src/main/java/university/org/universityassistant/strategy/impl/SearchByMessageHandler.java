package university.org.universityassistant.strategy.impl;

import org.springframework.stereotype.Component;
import university.org.universityassistant.model.Lector;
import university.org.universityassistant.service.LectorService;
import university.org.universityassistant.strategy.MessageHandlerStrategy;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class SearchByMessageHandler implements MessageHandlerStrategy {
    private final LectorService lectorService;
    private final Pattern pattern = Pattern.compile("Global search by (.*?)\\.");

    public SearchByMessageHandler(LectorService lectorService) {
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
        String searchText = matcher.group(1);
        if (searchText.length() > 1) {
            Set<Lector> lectors = lectorService.searchAllByExpression(searchText);
            StringBuilder listLectors = new StringBuilder();
            for (Lector lector : lectors) {
                listLectors.append(lector.getFirstName())
                        .append(" ")
                        .append(lector.getLastName())
                        .append(", ");
            }
            return listLectors.length() == 0 ? "Could not find any matches. Try again!" : listLectors.substring(0, listLectors.length() - 2);
        }
        return "I do not understand you. Please edit your message!";
    }
}
