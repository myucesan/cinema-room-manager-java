package cinema;

public class Cinema {

    public static void main(String[] args) {
        System.out.println("Cinema:");

        int rows = 7;
        int cols = 8;

        // notice that the top row does not need to be part of a loop
        System.out.print("  ");
        System.out.println("1 2 3 4 5 6 7 8");

        for (int i = 1; i <= rows; i++) {
            System.out.print(i + " S".repeat(cols));
            System.out.println();
        }
    }
}