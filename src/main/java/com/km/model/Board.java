package com.km.model;

import java.util.Arrays;
import java.util.Base64;

public class Board {
    private final byte[] board = new byte[16];

    public Board() {
        Arrays.fill(board, (byte) 0);
    }

    public void set(boolean white, int x, int y) {
        int offset = white ? 0 : 8;
        board[offset + y] = (byte) (board[offset + y] | 1 << x);
    }

    public boolean get(boolean white, int x, int y) {
        int offset = white ? 0 : 8;
        return (board[offset + y] & 1 << x) != 0;
    }

    public boolean empty(int x, int y) {
        byte xx = (byte) (1 << x);
        return (board[y] & xx) + (board[8 + y] & xx) == 0;
    }

    public String encode() {
        return Base64.getEncoder().encodeToString(board);
    }
}
