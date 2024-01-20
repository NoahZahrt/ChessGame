// zahrt003
public class King {
    int row;
    int col;
    boolean isBlack;
    public King(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;

    }
    public boolean isMoveLegal(Board board, int endRow, int endCol) { // adjacent
        if (board.verifySourceAndDestination(this.row, this.col, endRow, endCol, isBlack)) {
            return board.verifyAdjacent(this.row, this.col, endRow, endCol);
        }
        return false;
    }
}
