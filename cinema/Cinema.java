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
        if (room[chosenRow][chosenSeat].equals("S")) {
            room[chosenRow][chosenSeat] = "B";
            return true;
        }
        return false;
    }

    private static boolean printMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("0. Exit");
        int choice = input.hasNextInt() ? input.nextInt() : 0;
        if (choice == 1) {
            printRoom();
            return false;
        } else if (choice == 2) {
            System.out.println("Enter a row number:");
            int chosenRow = input.hasNextInt() ? input.nextInt() : 0;
            System.out.println("Enter a seat number in that row:");
            int chosenSeat = input.hasNextInt() ? input.nextInt() : 0;
            if (!purchaseTicket(chosenRow, chosenSeat)) {
                // handle when ticket is already bought
            }
            System.out.println("$" + calculateTicketPrice(chosenRow));
            return false;
        } else return choice == 0;
    }


    static int calculateTicketPrice(int chosenRow) {
        int rows = room.length - 1;
        int cols = room[0].length - 1;
        int totalSeats = rows * cols;
        System.out.println("Ticket price:");
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
