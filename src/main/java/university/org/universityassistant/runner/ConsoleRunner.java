package university.org.universityassistant.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import university.org.universityassistant.service.impl.MessageHandlerService;

import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final MessageHandlerService messageHandlerService;

    public ConsoleRunner(MessageHandlerService messageHandlerService) {
        this.messageHandlerService = messageHandlerService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("User Input: ");
            String input = scanner.nextLine().trim();

            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("The program terminates. Goodbye!");
                break;
            } else {
                System.out.println("Answer: " + messageHandlerService.handleMessage(input));
            }
        }
    }
}