package university.org.universityassistant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import university.org.universityassistant.strategy.MessageHandlerStrategy;

import java.util.List;

@Service
public class MessageHandlerService {
    private final List<MessageHandlerStrategy> handlers;

    @Autowired
    public MessageHandlerService(List<MessageHandlerStrategy> handlers) {
        this.handlers = handlers;
    }

    public String handleMessage(String message) {
        for (MessageHandlerStrategy handler : handlers) {
            if (handler.supports(message)) {
                return handler.handle(message);
            }
        }
        return "I do not understand you. Please edit your message!";
    }
}
