package edu.wofford;

import java.util.Scanner;

public class ConsoleMain {

	public static void main(String[] args) {
		TicTacToeModel m  = new TicTacToeModel();

		Scanner keyboard = new Scanner(System.in);
		while(keyboard.hasNext() && !m.checkWin() && !m.boardFull()) {
			int i = keyboard.nextInt();
			int j = keyboard.nextInt();
			m.playMove(i, j);
			System.out.println(m.toString());
		}
		keyboard.close();
		String winner = m.getWinner();
		if (winner == "X" || winner == "O") {
			System.out.println(winner + " wins");
		} else if (m.boardFull()) {
			System.out.println("Tie");
		}
	}
}