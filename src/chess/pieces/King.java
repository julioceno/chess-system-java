package chess.pieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    private boolean testRookCastling(Position position) {
        ChessPiece piece = (ChessPiece)getBoard().piece(position);
        return piece != null
                && piece instanceof  Rook
                && piece.getColor() == getColor()
                && piece.getMoveCount() == 0;
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
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


        // #specialmove castling
        if (getMoveCount() == 0 && !chessMatch.getCheck()) {
            // #specialmove castling kingside rook
            Position positionRook1 = new Position(position.getRow(), position.getColumn() + 3);
            if (testRookCastling(positionRook1)) {
                Position p1 = new Position(position.getRow(), position.getColumn() + 1);
                Position p2 = new Position(position.getRow(), position.getColumn() + 2);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
                    mat[position.getRow()][position.getColumn() + 2] = true;
                }
            }
            // #specialmove castling queenside rook
            Position positionRook2 = new Position(position.getRow(), position.getColumn() - 4);
            if (testRookCastling(positionRook2)) {
                Position p1 = new Position(position.getRow(), position.getColumn() - 1);
                Position p2 = new Position(position.getRow(), position.getColumn() - 2);
                Position p3 = new Position(position.getRow(), position.getColumn() - 3);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
                    mat[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }
        return mat;
    }

    @Override
    public String toString() {
        return "K";
    }
}
