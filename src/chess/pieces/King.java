package chess.pieces;

import boardGame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean[][] possibleMove() {
        Board board = getBoard();
        boolean[][] mat = new boolean[board.getRows()][board.getColumns()];
        return mat;
    }
}
