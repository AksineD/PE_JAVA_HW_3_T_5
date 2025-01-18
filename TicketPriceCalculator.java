import java.util.Scanner;

public class TicketPriceCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       int zone = showZoneMenu(scanner);
       int row = getRowNumber(scanner, zone);
       int tickets = getValidInteger(scanner, "Enter the number of tickets: ", 1, 40);
       if (zone == 1) {
           if(row <= 15) {
               System.out.println("Total price: " + 10 * tickets);
           } else {
               System.out.println("Total price: " + 20 * tickets);
           }

       } else {
           System.out.println("Total price: " + (row <= 6 ? 25 : 40) * tickets);
       }
    }

    /**
     * Displays the 'Zone' menu and gets the user's choice as a valid integer.
     *
     * @param scanner Scanner object used to read user input
     * @return The user's menu choice as an integer
     */
    private static int showZoneMenu(Scanner scanner) {
        System.out.println("Select a zone:");
        System.out.println("1. Hall zone");
        System.out.println("2. Exit zone");
        System.out.println("3. Exit");

        return getValidInteger(scanner, "Enter your choice: ", 1, 5);
    }

    private static int getRowNumber(Scanner scanner, int zone) {
        System.out.println("Select a row:");
        if (zone == 1) {
            return getValidInteger(scanner, "Enter your choice: ", 1, 30);
        } else {
            return getValidInteger(scanner, "Enter your choice: ", 1, 12);
        }
    }


    /**
     * Prompts the user to enter a valid integer within the specified range,
     * and handles errors like non-integer input or out-of-range values.
     *
     * @param scanner  Scanner object used to read user input
     * @param prompt   The input prompt message to display
     * @param minValue Minimum allowed value for the input
     * @param maxValue Maximum allowed value for the input
     * @return A valid integer entered by the user
     */
    private static int getValidInteger(Scanner scanner, String prompt, int minValue, int maxValue) {
        int value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer
                if (value >= minValue && value <= maxValue) {
                    return value;
                } else {
                    System.out.println("The value must be between " + minValue + " and " + maxValue + ".");
                }
            } else {
                System.out.println("Please enter a valid integer.");
                scanner.nextLine(); // Clear the buffer
            }
        }
    }

}
