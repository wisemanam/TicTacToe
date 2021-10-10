package edu.wofford;

//import javax.swing.plaf.nimbus.ImageScalingHelper;

public class TicTacToeModel {
    private String[] board;
    private int SIZE = 9;
    private boolean xTurn;

    public TicTacToeModel() {
        board = new String[]{" ", " ", " ",
                             " ", " ", " ",
                             " ", " ", " "};
        xTurn = true;

    }

    public TicTacToeModel(String[] board) {
        this.board = board;
        xTurn = true;
    }

    public boolean playMove(int loc) {
        // plays move with only one integer representing location (0-8)
        if ((loc >= 0 && loc < SIZE) && isCellEmpty(loc) && !checkWin()) {
            if (xTurn) {
                board[loc] = "X";
            } else {
                board[loc] = "O";
            }
            xTurn = !xTurn;
            return true;
        }
        return false;
    }

    public boolean playMove(int x, int y) {
        // plays move with 2 integers representing location (1-3)
        if (x == 0) {
            return playMove(y);
        } else if (x == 1) {
            return playMove(3 + y);
        } else if (x == 2) {
            return playMove(6 + y);
        }
        return false;
    }
    
    public boolean isCellEmpty(int loc) {
        return board[loc].equals(" ");
    }

    public boolean isCellEmpty(int x, int y) {
        if (x == 0) {
            return isCellEmpty(y);
        } else if (x == 1) {
            return isCellEmpty(3 + y);
        } else if (x == 2) {
            return isCellEmpty(6 + y);
        }
        return false;
    }

    public String[] getBoard() {
        return board;
    }

    public boolean checkWin() {
        return (((board[0].equals(board[3])) && (board[3].equals(board[6])) && (!isCellEmpty(0)))
             || ((board[1].equals(board[4])) && (board[4].equals(board[7])) && (!isCellEmpty(1)))
             || ((board[2].equals(board[5])) && (board[5].equals(board[8])) && (!isCellEmpty(2)))
             || ((board[0].equals(board[1])) && (board[1].equals(board[2])) && (!isCellEmpty(0)))
             || ((board[3].equals(board[4])) && (board[4].equals(board[5])) && (!isCellEmpty(3)))
             || ((board[6].equals(board[7])) && (board[7].equals(board[8])) && (!isCellEmpty(6)))
             || ((board[2].equals(board[4])) && (board[4].equals(board[6])) && (!isCellEmpty(4)))
             || ((board[0].equals(board[4])) && (board[4].equals(board[8])) && (!isCellEmpty(0))));
    }

    public String getWinner() {
        if (checkWin()) {
            if (((board[0].equals(board[3])) && (board[3].equals(board[6])) && (!isCellEmpty(0))) 
            || ((board[0].equals(board[1])) && (board[1].equals(board[2])) && (!isCellEmpty(0))) 
            || ((board[0].equals(board[4])) && (board[4].equals(board[8])) && (!isCellEmpty(0)))) {
                return board[0];
            } else if (((board[6].equals(board[7])) && (board[7].equals(board[8])) && (!isCellEmpty(6)))
            || ((board[2].equals(board[5])) && (board[5].equals(board[8])) && (!isCellEmpty(2)))) {
                return board[8];
            } else {
                return board[4];
            }
        } else {
            return "";
        }
    }

    public boolean boardFull() {
        for (int i = 0; i < SIZE; i++) {
            if (isCellEmpty(i)) {
                return false;
            }
        }
        return true;
    }

    public String toString(){
        String str = board[0] + "|" + board[1] + "|" + board[2] + "\n";
        str += "-----\n";
        str += board[3] + "|" + board[4] + "|" + board[5] + "\n";
        str += "-----\n";
        str += board[6] + "|" + board[7] + "|" + board[8];
        return str;
    }

    public boolean isXTurn() {
        return xTurn;
    }
}