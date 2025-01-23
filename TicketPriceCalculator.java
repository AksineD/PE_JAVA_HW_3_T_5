import java.util.Scanner;

public class TicketPriceCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int zone = showZoneMenu(scanner);
        int row = getRowNumber(scanner, zone);
        int tickets = getValidInteger(scanner, "Enter the number of tickets: ", 1, 40);
        scanner.close();

        processAndDisplayResults(zone, row, tickets);
    }

    /**
     * Processes the provided zone, row, and ticket quantity input,
     * calculates the total price based on the given criteria and discounts,
     * and displays the result to the user.
     *
     * @param zone    The selected zone (e.g., hall zone or exit zone)
     * @param row     The selected row within the zone
     * @param tickets The number of tickets being purchased
     */
    private static void processAndDisplayResults(int zone, int row, int tickets) {
        int totalPrice = 0;
        if (zone == 1) {
            if (row <= 10) {
                totalPrice = 45 * tickets;
            } else if (row <= 25) {
                totalPrice = 35 * tickets;
            } else {
                totalPrice = 30 * tickets;
            }
        } else {
            if (row <= 5) {
                totalPrice = 40 * tickets;
            } else {
                totalPrice = 45 * tickets;
            }
        }
        displayPrice(tickets, totalPrice);
    }

    /**
     * Calculates and displays the total price for the given number of tickets.
     * Applies a 10% discount if 5 or more tickets are purchased and displays
     * the discounted price.
     *
     * @param tickets    The number of tickets purchased
     * @param totalPrice The total price before any discount is applied
     */
    private static void displayPrice(int tickets, int totalPrice) {
        if (tickets >= 5) {
            System.out.println("You get a 10% discount!");
            System.out.println("Total price with discount: " + (totalPrice - ((totalPrice / 100.0) * 10)));
        } else {
            System.out.println("Total price: " + totalPrice);
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

        return getValidInteger(scanner, "Enter your choice: ", 1, 2);
    }

    /**
     * Prompts the user to select a valid row number based on the specified zone.
     * Ensures the row number is within the allowed range for the given zone.
     *
     * @param scanner Scanner object used to read user input
     * @param zone    The selected zone which determines the valid row range
     * @return A valid row number selected by the user
     */
    private static int getRowNumber(Scanner scanner, int zone) {
        System.out.println("Select a row:");
        if (zone == 1) {
            return getValidInteger(scanner, "Enter your choice: ", 1, 32);
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