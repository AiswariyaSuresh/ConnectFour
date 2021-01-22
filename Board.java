import java.util.Arrays;

public class Board {
    static char[][] theBoard = new char[7][29];

    public Board() {
        //format of row -- | c | c | c | c | c | c | c |
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 29; j++) {
                if (j % 4 == 0)
                    theBoard[i][j] = '|';
                else
                    theBoard[i][j] = ' ';
            }
        }
        Arrays.fill(theBoard[6], '.');
    }

    public void PrintBoard() {
        for (int i = 0; i < theBoard.length; i++) {
            for (int j = 0; j < theBoard[i].length; j++)
                System.out.print(theBoard[i][j]);
            System.out.println();
        }
    }

    public void DropDisk(Player player1, int column) {
        int indexOfDisk = (4 * column) + 2; //due to setup of board
        for (int i = 5; i >= 0; i--) {
            if (theBoard[i][indexOfDisk] == ' ') {
                theBoard[i][indexOfDisk] = player1.getColor();
                break;
            }
        }
        PrintBoard();
    }

    //print the board when player choose where to put piece--
    //parameters char for color piece and int for row
    //method works
    public boolean isHorizontalWin(Player player1) {
        boolean hFlag = true;
        for (int i = 5; i >= 0; i--) {
            //since checking for character
            //start at first index of characters (index 2)
            for (int j = 2; j <= 26; j += 4) {
                if (theBoard[i][j] == 'R' || theBoard[i][j] == 'Y') {
                    char colorCheck = theBoard[i][j];
                    for (int k = 0; k <= 12; k += 4) {
                        if (j + k > 26) {
                            hFlag = false;
                            break;
                        }
                        if (theBoard[i][j + k] != colorCheck) {
                            hFlag = false;
                            break;
                        }
                        hFlag = true;
                    }
                    if (hFlag)
                        return hFlag;
                }
            }
        }
        hFlag = false;
        return hFlag;
    }

    public boolean isVerticalWin(Player player1) {
        boolean vFlag = false;
        for (int j = 2; j <= 26; j += 4) {
            for (int i = 0; i < 6; i++) {
                if (theBoard[i][j] == 'R' || theBoard[i][j] == 'Y') {
                    char colorCheck = theBoard[i][j];
                    for (int k = 0; k <= 3; k++) {
                        if (i + k > 5) {
                            vFlag = false;
                            break;
                        }
                        if (theBoard[i + k][j] != colorCheck) {
                            vFlag = false;
                            break;
                        }
                        vFlag = true;
                    }
                    if (vFlag)
                        return vFlag;
                }
            }
        }
        vFlag = false;
        return vFlag;
    }

    public boolean isAscendingDiagonalWin(Player player1) {
        boolean aFlag = false;
        for (int i = 5; i >= 0; i--) {
            for (int j = 2; j <= 26; j += 4) {
                if (theBoard[i][j] == 'R' || theBoard[i][j] == 'Y') {
                    char colorCheck = theBoard[i][j];
                    for (int k = 0, m = 0; (k >= -3 && m <= 12); k--, m += 4) {
                        if (j + m > 26 || i + k < 0) {
                            aFlag = false;
                            break;
                        }
                        if (theBoard[i + k][j + m] != colorCheck) {
                            aFlag = false;
                            break;
                        }
                        aFlag = true;
                    }
                    if (aFlag)
                        return aFlag;
                }
            }
        }
        aFlag = false;
        return aFlag;
    }

    public boolean isDescendingDiagonalWin(Player player1) {
        boolean ddFlag = false;
        for (int i = 0; i < 6; i++) {
            for (int j = 2; j <= 26; j += 4) {
                if (theBoard[i][j] == 'R' || theBoard[i][j] == 'Y') {
                    char colorCheck = theBoard[i][j];
                    for (int k = 0, m = 0; (k <= 3 && m <= 12); k++, m += 4) {
                        if (i + k > 5 || j + m > 26) {
                            ddFlag = false;
                            break;
                        }
                        if (theBoard[i + k][j + m] != colorCheck) {
                            ddFlag = false;
                            break;
                        }
                        ddFlag = true;
                    }
                    if (ddFlag)
                        return ddFlag;
                }
            }
        }
        ddFlag = false;
        return ddFlag;
    }

    public boolean isDraw() {
        boolean drawFlag = true;
        for (int i = 0; i < 6; i++) {
            for (int j = 2; j <= 26; j += 4) {
                if (theBoard[i][j] != 'R' && theBoard[i][j] != 'Y') {
                    drawFlag = false;
                    return drawFlag;
                }
            }
        }
        return drawFlag;
    }
}
