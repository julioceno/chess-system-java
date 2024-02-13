package chess.pieces;

import boardGame.Board;
import boardGame.Position;
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

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }
    @Override
    public boolean[][] possibleMove() {
        Board board = getBoard();
        boolean[][] mat = new boolean[board.getRows()][board.getColumns()];

        Position piece = new Position(0, 0);

        // above
        piece.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(piece) && canMove(piece)) {
            mat[piece.getRow()][piece.getColumn()] = true;
        }

        // below
        piece.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(piece) && canMove(piece)) {
            mat[piece.getRow()][piece.getColumn()] = true;
        }

        // left
        piece.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(piece) && canMove(piece)) {
            mat[piece.getRow()][piece.getColumn()] = true;
        }

        // right
        piece.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(piece) && canMove(piece)) {
            mat[piece.getRow()][piece.getColumn()] = true;
        }

        // nw
        piece.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(piece) && canMove(piece)) {
            mat[piece.getRow()][piece.getColumn()] = true;
        }

        // ne
        piece.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(piece) && canMove(piece)) {
            mat[piece.getRow()][piece.getColumn()] = true;
        }

        // sw
        piece.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(piece) && canMove(piece)) {
            mat[piece.getRow()][piece.getColumn()] = true;
        }

        // se
        piece.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(piece) && canMove(piece)) {
            mat[piece.getRow()][piece.getColumn()] = true;
        }

        return mat;
    }
}
