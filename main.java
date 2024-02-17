import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("========================================");
            System.out.println("|                                      |");
            System.out.println("|                               🍔    |");
            System.out.println("|                                      |");
            System.out.println("|                                      |");
            System.out.println("|                                      |");
            System.out.println("|                                      |");
            System.out.println("|                                      |");
            System.out.println("========================================");
        }
    }

    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}