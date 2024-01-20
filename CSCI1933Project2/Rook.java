// zahrt003
public class Rook {
    int row;
    int col;
    boolean isBlack;
    public Rook(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;

    }
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (board.verifySourceAndDestination(this.row, this.col, endRow, endCol, isBlack)) {
            if (this.row == endRow) { // horizontal
                return board.verifyHorizontal(this.row, this.col, endRow, endCol);
            }
            if (this.col == endCol) { // vertical
                return board.verifyVertical(this.row, this.col, endRow, endCol);
            }
            return false;
        }
        return false;
    }
}
