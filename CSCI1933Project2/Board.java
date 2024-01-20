// zahrt003
public class Board {

    // Instance variables
    private Piece[][] board;

    //TODO:
    // Construct an object of type Board using given arguments.
    public Board() {
         this.board = new Piece[8][8];
    }

    // Accessor Methods

    // Return the Piece object stored at a given row and column
    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    // Update a single cell of the board to the new piece.
    public void setPiece(int row, int col, Piece piece) {
        board[row][col] =  piece;

    }

    // Game functionality methods
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) { // moves piece if legal
        Piece piece = board[startRow][startCol];
        if (piece != null) {
            if (piece.isMoveLegal(this, endRow, endCol)) {
                setPiece(endRow,endCol,piece);
                getPiece(startRow,startCol).setPosition(endRow,endCol);
                board[startRow][startCol] = null;
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }


    public boolean isGameOver() { // determines if game is over
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != null) {
                    if (board[i][j].getCharacter() == '\u265a') {
                        count += 1;
                    }
                    if (board[i][j].getCharacter() == '\u2654') {
                        count += 1;
                    }
                }
            }
        }
        if (count == 2) {
            return false;
        }
        else {
            return true;
        }
    }


    public String toString() { // prints board
        String x = "  0 1 2 3 4 5 6 7 \n";
        for (int i = 0; i < board.length; i++) {
            x += i + "|";
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == null) {
                    x += " |";
                } else {
                    x += board[i][j] + "|";
                }
            }
                x += "\u2001" + "\n";

            }
        return x;
    }

    //TODO:
    // Sets every cell of the array to null. For debugging and grading purposes.
    public void clear() { // clears board
        for (int i =0; i < this.board.length; i ++){
            for (int j =0; j < this.board[0].length; j++){
                board[i][j] = null;
            }

        }

    }

    // Movement helper functions

    // verifies move is somewhat legal
    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
        if (startRow < 0 || startCol < 0 || endRow < 0 || endCol < 0){
            return false;
        }
        if (startRow > 7 || startCol > 7 || endRow > 7 || endCol > 7){
            return false;
        }
        else if (board[startRow][startCol] == null){
            return false;
        }
        else if(board[startRow][startCol].getIsBlack() != isBlack){
            return false;
        }
        else if (board[endRow][endCol] != null && board[endRow][endCol].getIsBlack() == isBlack){
            return false;
        }
        else{
            return true;
        }

    }

    // Check whether the 'start' position and 'end' position are adjacent to each other
    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
        if (Math.abs(endRow - startRow) == 1 && Math.abs(startCol - endCol) == 1){
            return true; // diagnal adjacent
        }
        else if (Math.abs(startCol - endCol) == 1 && (startRow - endRow) == 0){
            return true; // horizontal adjacent
        }
        else if (Math.abs(startRow - endRow) == 1 && (startCol - endCol) == 0){
            return true;
        }
        else if (startCol == endCol && startRow == endRow){
            return true;
        }
        return false;
    }


    // Checks whether a given 'start' and 'end' position are a valid horizontal move.
    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        int difference = Math.abs(startCol - endCol);
        if (startRow != endRow){
            return false;
        }
        else if (startRow == endRow && startCol - endCol > 0){
            for (int i = 1; i < difference; i++){
                if (board[startRow][startCol - i] != null){
                    return false;
                }
            }
            return true;

        }
        else if (startRow == endRow && startCol - endCol < 0){
            for (int i = 1; i < difference; i++){
                if (board[startRow][startCol + i] != null){
                    return false;
                }
            }
            return true;
        }
        return true;
    }


    // Checks whether a given 'start' and 'end' position are a valid vertical move.
    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        int difference = Math.abs(startRow - endRow);
        if (startCol != endCol) {
            return false;
        } else if (startRow == endRow && startCol == endCol) {
            return true;
        }
        if (difference == 1) {
            return true;
        }
        else if ((startCol == endCol) && (startRow - endRow > 0)) {
            if (difference >= 2) {
                for (int i = 1; i < difference; i++) {
                    if (board[startRow - i][startCol] != null) {
                        return false;
                    }
                }
            } else {
                if (board[startRow - 1][startCol] != null) {
                    return false;
                }
            }
        }
                else if ((startCol == endCol) && (startRow - endRow < 0)) {
                    if (difference >= 2) {
                        for (int i = 1; i < difference; i++) {
                            if (board[i + startRow][startCol] != null) {
                                return false;
                            }
                        }

                    }
                    else {
                        if (board[startRow + 1][startCol] != null) {
                            return false;
                        }
                    }
                }
                return true;
            }



    // Checks whether a given 'start' and 'end' position are a valid diagonal move.
    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
        int movedX = (startCol - endCol); // moves columns
        int movedY = (startRow - endRow); // moves rows
        int difference = Math.abs(startCol - endCol);
        if (Math.abs(endRow - startRow) != Math.abs(endCol - startCol)){
            return false;
        }
        else if (Math.abs(endRow - startRow) == Math.abs(endCol - startCol)){
            if (movedX < 0 && movedY > 0){
                for (int i = 1; i < difference; i++){
                    if (board[startRow - i][startCol + i] != null){
                        return false; // up and to right diag
                    }
                }
            }
            else if (movedX < 0 && movedY < 0){
                for (int i = 1; i < difference; i ++){
                    if (board[startRow + i][startCol + i] != null){
                        return false; // down and to the right diag
                    }
                }
            }
            else if (movedX > 0 && movedY > 0){
                for (int i = 1; i < difference; i++){
                    if (board[startRow - i][startCol - i] != null){
                        return false; // up and to the left
                    }
                }
            }
            else if (movedX > 0 && movedY < 0){
                for (int i = 1; i < difference; i ++){
                    if (board[startRow + i][startCol - i] != null){
                        return false; // down and to the left
                    }
                }
            }
        }
        return true;
    }
}
