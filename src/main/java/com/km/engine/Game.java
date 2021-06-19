package com.km.engine;

import com.km.model.Board;

public class Game {
    private final Board board;
    private final boolean turn;

    public Game() {
        turn = true;
        board = Rules.initialBoard();
    }

    public boolean isFinished() {
        // TODO implement
        return true;
    }

    public boolean getTurn() {
        return turn;
    }

    public void move(int x, int y) {
        // TODO implement
    }

    public Board getBoard() {
        return board;
    }

}
