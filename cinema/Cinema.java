package cinema;

import java.util.Scanner;

public class Cinema {
    static final Integer priceFront = 10;
    static final Integer priceBack = 8;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = input.hasNextInt() ? input.nextInt(): 0;
        System.out.println("Enter the number of seats in each row:");
        int cols = input.hasNextInt() ? input.nextInt() : 0;

        printRoom(rows, cols);
        System.out.println("Enter a row number:");
        int chosenRow = input.hasNextInt() ? input.nextInt() : 0;
        System.out.println("Enter a seat number in that row:");
        int chosenSeat = input.hasNextInt() ? input.nextInt() : 0;

        System.out.println("$" + calculateTicketPrice(rows, cols, chosenRow));
        printRoom(rows, cols, chosenRow, chosenSeat);



    }

    static int calculateTicketPrice(int rows, int cols, int chosenRow) {
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

    static void printRoom(int rows, int cols, int chosenRow, int chosenSeat) {
        System.out.println("Cinema:");
        // notice that the top row does not need to be part of a loop
        System.out.print("  ");
        for (int i = 1; i <= cols; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 1; i <= rows; i++) {
            System.out.print(i);
            for (int j = 1; j <= cols; j++) {
                if (i == chosenRow && j == chosenSeat) {
                    System.out.print(" B");
                } else {
                    System.out.print(" S");
                }
            }
            System.out.println();
        }
    }

    static void printRoom(int rows, int cols) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= cols; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 1; i <= rows; i++) {
            System.out.print(i + " S".repeat(cols));
            System.out.println();
        }
    }
}