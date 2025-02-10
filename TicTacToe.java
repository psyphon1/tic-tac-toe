package XO;

import java.util.Scanner;

public class TicTacToe {
    static Scanner sc = new Scanner(System.in);
    static String user1, user2, currentUser;
    static char[][] board = {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'}
    };
    static int moves = 0;
    
    public static void main(String[] args) {
        showMenu();
    }
    
    public static void showMenu() {
        while (true) {
            System.out.println("Welcome to Tic-Tac-Toe\n1. Start Game\n2. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                System.out.print("Enter Player 1 Name: ");
                user1 = sc.nextLine();
                System.out.print("Enter Player 2 Name: ");
                user2 = sc.nextLine();
                playGame();
            } else if (choice == 2) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid Input!");
            }
        }
    }
    
    public static void playGame() {
        moves = 0;
        currentUser = user1;
        resetBoard();
        printBoard();
        
        while (moves < 9) {
            System.out.print("Enter move (1-9) for " + currentUser + ": ");
            int move = sc.nextInt();
            if (makeMove(move)) {
                printBoard();
                if (checkWin()) {
                    System.out.println(currentUser + " wins!");
                    return;
                }
                currentUser = (currentUser.equals(user1)) ? user2 : user1;
                moves++;
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
        System.out.println("It's a draw!");
    }
    
    public static void resetBoard() {
        char ch = '1';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ch++;
            }
        }
    }
    
    public static void printBoard() {
        System.out.println("\n" + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("--+---+--");
        System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("--+---+--");
        System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2] + "\n");
    }
    
    public static boolean makeMove(int move) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == (char)(move + '0')) {
                    board[i][j] = (currentUser.equals(user1)) ? 'X' : 'O';
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) return true;
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) return true;
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) return true;
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) return true;
        return false;
    }
}
