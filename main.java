import java.util.Scanner;

public class main {
    public static char[][] board = {"========================================".toCharArray(),
                             "|                                      |".toCharArray(),
                             "|                                      |".toCharArray(),
                             "|                                      |".toCharArray(),
                             "|                                      |".toCharArray(),
                             "|    o                                  |".toCharArray(),
                             "|   <|\\                                |".toCharArray(),
                             "|   / >                                 |".toCharArray(),
                             "========================================".toCharArray(),};
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println(board);
            s.;
        }

    }

    public void  {

    }

    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}