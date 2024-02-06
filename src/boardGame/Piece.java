package boardGame;

public class Piece {
    /* By default it is null */
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
    }

    protected Board getBoard() {
        return board;
    }


}
