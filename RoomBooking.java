import java.util.Scanner;

public class RoomBooking {
    public static int roomBook(String[] name, long[] number, int[] roomNumb, boolean[] isBooked, int count) {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Enter your Details ===== ");
        System.out.print("Enter your name: ");
        String naam = sc.next();
        System.out.print("Enter your Contact Number: ");
        long numb = sc.nextLong();
        int idx = -1;
        for (int i = 0; i < count; i++) {
            if (numb == number[i]) {
                idx = i;
                System.out.println("This contact Detail is already exist, please enter different Details!");
                return count;
            }
        }
        if (idx == -1) {
            name[count] = naam;
            number[count] = numb;
            roomNumb[count] = 101 + count;
            isBooked[count] = true;
            System.out.println("Hotel Room is Booked Successfully!");
        }

        System.out.println("===== Your Hotel Room Details ===== ");
        System.out.println("Name: " + name[count]);
        System.out.println("Contact Number: " + number[count]);
        System.out.println("Room Number: " + roomNumb[count]);
        System.out.println("Room Booked: " + isBooked[count]);
        System.out.println("------------------------------------");

        count++;
        return count;
    }

    public static int cancelBooking(String[] name, long[] number, int[] roomNumb, boolean[] isBooked, int count) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Name: ");
        String naam = sc.next();
        System.out.print("Enter your Contact detail: ");
        long numb = sc.nextLong();

        int idx = -1;
        int roomNum = -1;
        for (int i = 0; i < count; i++) {
            if (numb == number[i]) {
                idx = i;
                System.out.print("Enter your Room Number: ");
                roomNum = sc.nextInt();
            }
        }
        int indx = -1;
        for (int i = 0; i < count; i++) {
            if (roomNum == roomNumb[i]) {
                indx = i;
                isBooked[i] = false;
                System.out.println("Your Booking is Cancel Successfully!");
                return count;
            }
        }
        if (idx == -1) {
            System.out.println("Your contact detail is Wrong!");
            return count;
        }
        if (indx == -1) {
            System.out.println("Room Number is Incorrect!");
            return count;
        }

        return count;
    }

    public static void displayAvailableBooking(String[] name, long[] number, int[] roomNumb, boolean[] isBooked, int count) {
        System.out.println("===== Available Hotel Rooms ===== ");
        for (int i = 0; i < count; i++) {
            if (isBooked[i] == false) {
                System.out.println("Room Number: " + roomNumb[i] + " | Booked: " + isBooked[i]);
            }
        }
    }

    public static void yourBookingDetails(String[] name, long[] number, int[] roomNumb, boolean[] isBooked, int count) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Name: ");
        String naam = sc.next();
        System.out.print("Enter your Contact detail: ");
        long numb = sc.nextLong();

        for (int i = 0; i < count; i++) {
            if (numb == number[i] && isBooked[i] == true) {
                System.out.println("===== Your Hotel Room Details =====");
                System.out.println("Name: " + name[i]);
                System.out.println("Contact Number: " + number[i]);
                System.out.println("Room Number: " + roomNumb[i]);
                System.out.println("Room Booked: " + isBooked[i]);
                System.out.println("------------------------------------");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] name = new String[10];
        long[] number = new long[10];
        int[] roomNumb = new int[10];
        boolean[] isBooked = new boolean[10];
        int count = 0;

        int choice;
        do {
            System.out.println("===== Hotel Room Booking System =====");
            System.out.println("1. Book a Room");
            System.out.println("2. Cancel Booking");
            System.out.println("3. Display Available Rooms");
            System.out.println("4. Your Booking Details");
            System.out.println("5. Exit");
            System.out.println("=====================================");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    count = roomBook(name, number, roomNumb, isBooked, count);
                    break;
                case 2:
                    count = cancelBooking(name, number, roomNumb, isBooked, count);
                    break;
                case 3:
                    displayAvailableBooking(name, number, roomNumb, isBooked, count);
                    break;
                case 4:
                    yourBookingDetails(name, number, roomNumb, isBooked, count);
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice, Please try again!");
            }
        } while (choice != 5);
    }
}
