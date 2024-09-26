package cinema;

public class Cinema {

    public static void main(String[] args) {
        System.out.println("Cinema:");

        int rows = 7;
        int cols = 8;

        System.out.print("  ");
        for (int i = 1; i <= cols; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 1; i <= rows; i++) {
            System.out.print(i + " ");
            for (int j = 1; j <= cols; j++) {
                System.out.print("S ");
            }
            System.out.println();
        }
    }
}