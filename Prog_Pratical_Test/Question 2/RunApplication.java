import java.util.Scanner;

public class RunApplication {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] types = {"PS5", "XBOX", "SWITCH"};

        System.out.println("Select the console type");
        for (int i = 0; i < types.length; i++) {
            System.out.println((i + 1) + ") " + types[i]);
        }

        int choice = 0;
        while (choice < 1 || choice > types.length) {
            if (input.hasNextInt()) {
                choice = input.nextInt();
            } else {
                input.next();
            }
            if (choice < 1 || choice > types.length) {
                System.out.println("Invalid choice. Enter 1, 2 or 3:");
                choice = 0;
            }
        }
        input.nextLine(); // clear newline
        String consoleType = types[choice - 1];

        System.out.print("Enter the store: ");
        String store = input.nextLine();

        int total = -1;
        System.out.print("Enter the total sales of " + consoleType + " consoles for " + store + ": ");
        while (total < 0) {
            if (input.hasNextInt()) {
                total = input.nextInt();
                if (total < 0) System.out.print("Sales cannot be negative. Try again: ");
            } else {
                input.next();
                System.out.print("Please enter a whole number: ");
            }
        }
        System.out.println();

        ConsoleSales report = new ConsoleSales(consoleType, store, total);
        report.printReport();
        input.close();
    }
}
