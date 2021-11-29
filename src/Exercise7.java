import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        char[] gameBoard = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int counterRound = 0;
        char signX = 'x';
        char circle = 'o';
        do {
            if (counterRound % 2 == 1) {
                System.out.println(" turn - o");
                placeSymbolOnBoard(gameBoard, getPositionFromUser(gameBoard), circle);
                counterRound++;
            } else {
                System.out.println(" turn - x ");
                placeSymbolOnBoard(gameBoard, getPositionFromUser(gameBoard), signX);
                counterRound++;
            }
        } while (checkWinner(gameBoard) != 'x' || checkWinner(gameBoard) == 'o' || checkWinner(gameBoard) == '-');
        printBoard(gameBoard);
    }

    public static void printBoard(char[] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.print("  " + gameBoard[i] + "  ");
            if ((i - 2) % 3 == 0) {
                System.out.println(" ");
            }
        }
    }

    public static boolean isAvailable(char[] gameBoard, int position) {
        char signX = 'x';
        char circle = 'o';
        boolean positionIsAvailable = true;
        if (gameBoard[position - 1] == signX || gameBoard[position - 1] == circle) {
            positionIsAvailable = false;
        }
        return positionIsAvailable;
    }

    public static int getPositionFromUser(char[] gameBoard) {
        Scanner scanner = new Scanner(System.in);
        int positionFromUser;
        do {
            printBoard(gameBoard);
            System.out.println("Enter the selected position between 1 - 9 : ");
            positionFromUser = scanner.nextInt();
        } while (positionFromUser < 1 || positionFromUser > 9);

        while (isAvailable(gameBoard, positionFromUser) == false) {
            printBoard(gameBoard);
            System.out.println("The place is occupied, choose a new place ");
            positionFromUser = scanner.nextInt();
        }
        return positionFromUser;
    }

    public static char checkWinner(char[] gameBoard) {
        char winner = '-';
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i] == gameBoard[i + 3] && gameBoard[i] == gameBoard[i + 6]) {
                winner = gameBoard[i];
            }
        }
        for (int i = 0; i < gameBoard.length; i = i + 3) {
            if (gameBoard[i] == gameBoard[i + 1] && gameBoard[i] == gameBoard[i + 2]) {
                winner = gameBoard[i];
            }
        }
        if ((gameBoard[4] == gameBoard[0] && gameBoard[4] == gameBoard[8]) ||
                (gameBoard[4] == gameBoard[2] && gameBoard[4] == gameBoard[6])) {

            winner = gameBoard[4];
        }
        return winner;
    }
    public static boolean placeSymbolOnBoard(char[] gameBoard, int positionFromUser, char sign) {
        boolean hasWinner = false;
        checkWinner(gameBoard);
        if (isAvailable(gameBoard, positionFromUser) == true) {
            gameBoard[positionFromUser - 1] = sign;
        }
        char signOfTheWinner = checkWinner(gameBoard);
        if (signOfTheWinner == 'x' || signOfTheWinner == 'o') {
            System.out.println("The winner is: " + signOfTheWinner);
            hasWinner = true;
        }
        return hasWinner;
    }
}