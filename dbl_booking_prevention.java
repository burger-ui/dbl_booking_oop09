import java.util.Scanner;

public class dbl_booking_prevention {

    static String[] names = new String[10];
    static String[] dates = new String[10];
    static String[] times = new String[10];
    static int count = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {

            System.out.println("\n--- Booking System ---");
            System.out.println("1. Add Booking");
            System.out.println("2. View Bookings");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                addBooking(scanner);
            }
            else if (choice == 2) {
                viewBookings();
            }
            else if (choice == 3) {
                running = false;
            }
            else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }

    public static void addBooking(Scanner scanner) {

        if (count >= 10) {
            System.out.println("Booking list is full.");
            return;
        }

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter date (ex. 2026-03-05): ");
        String date = scanner.nextLine();

        System.out.print("Enter time slot (ex. 10AM): ");
        String time = scanner.nextLine();

       
        // check for a booking at the same date and time
        for (int i = 0; i < count; i++) {
            if (dates[i].equalsIgnoreCase(date) && times[i].equalsIgnoreCase(time)) {
                System.out.println("Booking already exists for that date and time. Please choose another slot.");
                return;
            }
        }

        names[count] = name;
        dates[count] = date;
        times[count] = time;
        count++;

        System.out.println("Booking successful.");
    }

    public static void viewBookings() {

        if (count == 0) {
            System.out.println("No bookings yet.");
            return;
        }

        System.out.println("\n--- Current Bookings ---");
        for (int i = 0; i < count; i++) {
            System.out.println((i+1) + ". " + names[i] + " - " + dates[i] + " " + times[i]);
        }
    }
}