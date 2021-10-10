package edu.wofford;

public class Main {

	public static void main(String[] args) {
		TicTacToeModel t = new TicTacToeModel();
		t.playMove(0, 0);
		t.playMove(1, 1);
		t.playMove(0, 1);
		t.playMove(0, 1);
		t.playMove(0, 2);
		t.playMove(2, 0);
		t.playMove(1, 0);
		t.playMove(2, 2);
		t.playMove(5);
		System.out.println(t.toString());
		System.out.println(t.checkWin());
		System.out.println(t.getWinner());
	}
}