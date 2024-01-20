// zahrt003
public class Bishop {
    int row;
    int col;
    boolean isBlack;
    public Bishop(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;

    }
    public boolean isMoveLegal(Board board, int endRow, int endCol) { // diagonal
        if (board.verifySourceAndDestination(this.row, this.col, endRow, endCol, isBlack)) {
            return board.verifyDiagonal(this.row, this.col, endRow, endCol);

        }
        return false;
    }
}
