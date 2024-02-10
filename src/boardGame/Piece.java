package boardGame;

public abstract class Piece {
    /* By default it is null */
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
    }

    protected Board getBoard() {
        return board;
    }

    public abstract boolean[][] possibleMove();

    public boolean possibleMove(Position position) {
        return possibleMove()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPossibleMove() {
        boolean[][] mat = possibleMove();
        for (int i=0; i<mat.length; i++) {
            for (int j=0; j<mat.length ; j++) {
                if (mat[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
