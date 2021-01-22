import java.util.Scanner;

public class PlayConnectFour {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        Board board = new Board();
        board.PrintBoard();
        Player red = new Player('R');
        Player yellow = new Player('Y');

        int redDisk, yellowDisk;

        while (!(red.getStatus()) && !(yellow.getStatus()) && (!board.isDraw())) {
            System.out.print("Drop a red disk at column (0-6): ");
            redDisk = stdin.nextInt();
            while (redDisk < 0 || redDisk > 6) {
                System.out.print("Drop a red disk at column (0-6): ");
                redDisk = stdin.nextInt();
            }
            board.DropDisk(red, redDisk);
            red.setStatus(Player.checkForWin(red, board));
            if (red.getStatus()) {
                System.out.println("The red player won!");
                return;
            }
            if (Player.checkDraw(red, board)) {
                System.out.println("The game is a draw!");
                return;
            }
            System.out.print("Drop a yellow disk at column (0-6): ");
            yellowDisk = stdin.nextInt();
            while (yellowDisk < 0 || yellowDisk > 6) {
                System.out.print("Drop a yellow disk at column (0-6): ");
                yellowDisk = stdin.nextInt();
            }
            board.DropDisk(yellow, yellowDisk);
            yellow.setStatus(Player.checkForWin(yellow, board));
            if (yellow.getStatus()) {
                System.out.println("The yellow player won!");
                return;
            }
            if (Player.checkDraw(yellow, board)) {
                System.out.println("The game is a draw!");
                return;
            }
        }
    }
}
