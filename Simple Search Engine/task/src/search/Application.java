package search;


import strategies.MatcherContext;

import java.util.List;
import java.util.Scanner;

/**
 * @author Dionysios Stolis 4/13/2020
 */
class Application {

    private Application() {
    }

    private static Scanner scanner;

    protected static void open(String... args) {
        scanner = new Scanner(System.in);
        Container container = Container.init(args);
        mainMenu(container);
    }

    private static void run(int choice, Container container) {
        switch (choice) {
            case 1:
                find(container);
                mainMenu(container);
                break;
            case 2:
                printAll(container);
                mainMenu(container);
                break;
            case 0:
                System.out.println("Bye!");
                System.exit(0);
                break;
            default:
                System.out.println("Wrong choice, again!");
                mainMenu(container);
                break;
        }
    }

    private static void printAll(Container container) {
        System.out.println("=== List of people ===");
        for (Object s : container.getList()) {
            System.out.println(s.toString());
        }
        System.out.println();
    }

    private static void mainMenu(Container container) {
        System.out.println("=== Menu ===");
        System.out.println("1. Find a person\n" +
                "2. Print all people\n" +
                "0. Exit");
        int choice = Integer.parseInt(scanner.nextLine());
        System.out.println();
        run(choice, container);
    }

    private static void find(Container container) {
        MatcherContext context = new MatcherContext<>();
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        context.setMatcher(scanner.nextLine());
        System.out.println();
        System.out.println("Enter a name or email to search all suitable people.");
        Object value = scanner.nextLine();
        List list = context.execute(container, value);
        print(list);
    }

    private static void print(List list) {
        if (list.isEmpty()) {
            System.out.println("No matching people found.");
        } else {
            System.out.println(String.format("%d persons found:", list.size()));
            for (Object s : list) {
                System.out.println(s);
            }
        }
        System.out.println();
    }
}
