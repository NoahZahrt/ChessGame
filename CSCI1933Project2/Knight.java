// zahrt003
public class Knight {
    int row;
    int col;
    boolean isBlack;
    public Knight(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;

    }
    public boolean isMoveLegal(Board board, int endRow, int endCol){
        if (Math.abs(this.row - endRow) == 2 && Math.abs(this.col - endCol) == 1){
            if (board.verifySourceAndDestination(this.row,this.col,endRow,endCol,isBlack)){
            // vertical first and then over
            if (board.getPiece(endRow,endCol) == null || board.getPiece(endRow,endCol).getIsBlack() != isBlack) {
                    return true;
                }
            }
            else{
                return false;
            }

        }
        if (Math.abs(this.row - endRow) == 1 && Math.abs(this.col - endCol) == 2){
            // over first and then vertical
            if (board.verifySourceAndDestination(this.row, this.col, endRow, endCol, isBlack)) {
            if (board.getPiece(endRow,endCol) == null || board.getPiece(endRow,endCol).getIsBlack() != isBlack){
                    return true;
                }
            }
            else{
                return false;
            }
        }
        return false;
    }
}
