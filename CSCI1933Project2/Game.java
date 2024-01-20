// zahrt003
import java.util.Scanner;

public class Game {
    private static int turn = 2; // will determine whether its black or whites turn.

    public static void main(String[] args) {
        Board b1 = new Board();
        Fen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", b1); // sets all pieces to starting pos
        System.out.println(b1);
        Scanner myScanner = new Scanner(System.in);
        String x = "";
        while (b1.isGameOver() != true) {
            if (turn % 2 == 0) {
                x = "White's ";
            }
            if (turn % 2 != 0) {
                x = "Black's ";
            }
                System.out.println("It is currently " + x + "turn to play.");
                System.out.println("What is your move? (format: [start row] [start col] [end row] [end col])");
                String user_input = myScanner.nextLine();
                String[] numbers = user_input.split(" ");
                int first = Integer.parseInt(numbers[0]); // start row
                int second = Integer.parseInt(numbers[1]); // start col
                int third = Integer.parseInt(numbers[2]); // end row
                int fourth = Integer.parseInt(numbers[3]); // end col
                if (b1.getPiece(first, second) != null) {
                    if (b1.getPiece(first, second).getCharacter() == '\u265f' || b1.getPiece(first, second).getCharacter() == '\u2659') {
                        // Pawn
                        Pawn p1 = new Pawn(first, second, b1.getPiece(first, second).getIsBlack());
                        if (p1.isMoveLegal(b1, third, fourth) == true) {
                            b1.movePiece(first, second, third, fourth);
                            turn += 1;
                        } else {
                            System.out.println("Invalid move");
                        }

                    } else if (b1.getPiece(first, second).getCharacter() == '\u2656' || b1.getPiece(first, second).getCharacter() == '\u265c') {
                        // Rook
                        Rook r1 = new Rook(first, second, b1.getPiece(first, second).getIsBlack());
                        if (r1.isMoveLegal(b1, third, fourth) == true) {
                            b1.movePiece(first, second, third, fourth);
                            turn += 1;
                        } else {
                            System.out.println("Invalid move");
                        }
                    } else if (b1.getPiece(first, second).getCharacter() == '\u265e' || b1.getPiece(first, second).getCharacter() == '\u2658') {
                        // Knight
                        Knight k1 = new Knight(first, second, b1.getPiece(first, second).getIsBlack());
                        if (k1.isMoveLegal(b1, third, fourth) == true) {
                            b1.movePiece(first, second, third, fourth);
                            turn += 1;
                        } else {
                            System.out.println("Invalid move");
                        }
                    } else if (b1.getPiece(first, second).getCharacter() == '\u265d' || b1.getPiece(first, second).getCharacter() == '\u2657') {
                        // Bishop
                        Bishop bb1 = new Bishop(first, second, b1.getPiece(first, second).getIsBlack());
                        if (bb1.isMoveLegal(b1, third, fourth) == true) {
                            b1.movePiece(first, second, third, fourth);
                            turn += 1;
                        } else {
                            System.out.println("Invalid move");
                        }
                    } else if (b1.getPiece(first, second).getCharacter() == '\u265b' || b1.getPiece(first, second).getCharacter() == '\u2655') {
                        //Queen
                        Queen q1 = new Queen(first, second, b1.getPiece(first, second).getIsBlack());
                        if (q1.isMoveLegal(b1, third, fourth) == true) {
                            b1.movePiece(first, second, third, fourth);
                            turn += 1;
                        } else {
                            System.out.println("Invalid move");
                        }
                    } else if (b1.getPiece(first, second).getCharacter() == '\u265a' || b1.getPiece(first, second).getCharacter() == '\u2654') {
                        //King
                        King k1 = new King(first, second, b1.getPiece(first, second).getIsBlack());
                        if (k1.isMoveLegal(b1, third, fourth) == true) {
                            b1.movePiece(first, second, third, fourth);
                            turn += 1;
                        } else {
                            System.out.println("Invalid move");
                        }
                    }
                }
                System.out.println(b1);
            }
        System.out.println(x + " has won the game!");

        }
    }


