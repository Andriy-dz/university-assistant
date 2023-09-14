package university.org.universityassistant.strategy;

public interface MessageHandlerStrategy {
    boolean supports(String message);

    String handle(String message);
}
