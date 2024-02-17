import java.util.Scanner;

public class main {
    // public static char[][] screen = {"========================================".toCharArray(),
    //                                 "|                                      |".toCharArray(),
    //                                 "|                                      |".toCharArray(),
    //                                 "|                                      |".toCharArray(),
    //                                 "|                                      |".toCharArray(),
    //                                 "|    o                                 |".toCharArray(),
    //                                 "|   <|\\                               |".toCharArray(),
    //                                 "|   / >                                |".toCharArray(),
    //                                 "========================================".toCharArray(),};
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Player p = new Player();
        startGame(p, s);

        while () {
            //System.out.println(screen);
            int input = s.nextInt();
        }
    }

    public void updateScreen() {

    }

    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private startGame(Player p, Scanner s) {
        System.out.println("Enter your name: ");
        s.nextInt();
    }
    
}