// zahrt003
public class Queen {
    int row;
    int col;
    boolean isBlack;
    public Queen(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;

    }
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (board.verifySourceAndDestination(this.row, this.col, endRow, endCol, isBlack)) {
            if (this.row == endRow && this.col != endCol) {// horizontal
                return board.verifyHorizontal(this.row, this.col, endRow, endCol);
            }
            if (this.col == endCol && this.row != endRow) { // vertical
                return board.verifyVertical(this.row, this.col, endRow, endCol);
            }
            if (Math.abs(this.col - endCol) == Math.abs(this.row - endRow)) { // diagonal
                return board.verifyDiagonal(this.row, this.col, endRow, endCol);
            } else {
                return false;
            }
        }
        return false;
    }
}
