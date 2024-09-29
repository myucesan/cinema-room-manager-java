package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    static final Integer priceFront = 10;
    static final Integer priceBack = 8;
    static Scanner input = new Scanner(System.in);
    static String[][] room;

    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        int rows = input.hasNextInt() ? input.nextInt() : 0;
        System.out.println("Enter the number of seats in each row:");
        int cols = input.hasNextInt() ? input.nextInt() : 0;
        room = new String[rows + 1][cols + 1];
        for (String[] row : room) {
            Arrays.fill(row, "S");  // Fill each row with "S"
        }

        while (!printMenu()) ;
        return;
    }

    private static boolean purchaseTicket(int chosenRow, int chosenSeat) {
        if (chosenRow >= room.length || chosenSeat >= room[0].length) {
            System.out.println("Wrong input!");
            return false;
        } else if (room[chosenRow][chosenSeat].equals("S")) {
            room[chosenRow][chosenSeat] = "B";
            return true;
        } else {
            System.out.println("That ticket has already been purchased!");
        }
        return false;
    }

    private static boolean printMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        int choice = input.hasNextInt() ? input.nextInt() : 0;
        if (choice == 1) {
            printRoom();
            return false;
        } else if (choice == 2) {
            int chosenRow;
            int chosenSeat;
            do {
                System.out.println("Enter a row number:");
                chosenRow = input.hasNextInt() ? input.nextInt() : 0;
                System.out.println("Enter a seat number in that row:");
                chosenSeat = input.hasNextInt() ? input.nextInt() : 0;
            } while (!purchaseTicket(chosenRow, chosenSeat));

            System.out.println("Ticket price: $" + calculateTicketPrice(chosenRow));
            return false;
        } else if (choice == 3) {
            calculateStatistics();
            return false;
        } else  return choice == 0;
    }

    private static void calculateStatistics() {
        int rows = room.length - 1;
        int cols = room[0].length - 1;
        long noOfPurchasedTickets = Arrays.stream(room)
                .flatMap(Arrays::stream) // Flatten the 2D array into a stream of elements
                .filter(item -> item.equals("B"))
                .count();

        double percentageSold = (double) noOfPurchasedTickets / (double)(rows * cols) * 100;

        int currentIncome = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (room[i][j].equals("B")) {
                    currentIncome += calculateTicketPrice(i);
                }
            }
        }

        int totalIncome = 0;
        for (int i = 1; i <= rows; i++) {
            totalIncome += calculateTicketPrice(i) * cols;
        }


        System.out.println("Number of purchased tickets: " + noOfPurchasedTickets);
        System.out.printf("Percentage: %.2f%% %n", percentageSold);;
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }


    static int calculateTicketPrice(int chosenRow) {
        int rows = room.length - 1;
        int cols = room[0].length - 1;
        int totalSeats = rows * cols;
        if (totalSeats <= 60) {
            return 10;
        } else {
                if (chosenRow <= rows / 2) {
                    return priceFront;
                } else {
                    return priceBack;
                }
        }
    }

    static void printRoom() {
        System.out.println("Cinema:");
        int rows = room.length - 1;
        int cols = room[0].length - 1;
        // notice that the top row does not need to be part of a loop
        System.out.print("  ");
        for (int i = 1; i <= cols; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 1; i <= rows; i++) {
            System.out.print(i);
            for (int j = 1; j <= cols; j++) {
                System.out.print(" " + room[i][j]);
            }
            System.out.println();
        }
    }
    }
