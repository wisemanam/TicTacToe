package edu.wofford;

public class Main {

	public static void main(String[] args) {
		for (int i = 0; i < 9; i ++) {
			if (i < 3) {
				System.out.println("location" + "0" + String.valueOf(i));
			} else if (i < 6) {
				System.out.println("location" + "1" + String.valueOf(i - 3));
			} else if (i < 9) {
				System.out.println("location" + "2" + String.valueOf(i - 6));
			}
		}
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