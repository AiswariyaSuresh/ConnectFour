public class Player {
    private char color;
    private boolean hasWon = false;

    public Player(char color) {
        this.color = color;
    }

    //mutator & accessor methods
    public char getColor() {
        return color;
    }

    public boolean getStatus() {
        return hasWon;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public void setStatus(boolean status) {
        hasWon = status;
    }

    public static boolean checkForWin(Player player1, Board board1) {
        boolean win = false;
        //check for horizontal win
        if (board1.isHorizontalWin(player1)) {
            win = true;
            return win;
        } else if (board1.isVerticalWin(player1)) {
            win = true;
            return win;
        } else if (board1.isDescendingDiagonalWin(player1)) {
            win = true;
            return win;
        } else if (board1.isAscendingDiagonalWin(player1)) {
            win = true;
            return win;
        } else {
            return win;
        }
    }

    public static boolean checkDraw(Player player1, Board board) {
        return board.isDraw();
    }

}
