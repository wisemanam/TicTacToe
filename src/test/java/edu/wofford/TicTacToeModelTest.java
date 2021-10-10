package edu.wofford;

import org.junit.*;

import jdk.jfr.Timestamp;

import static org.junit.Assert.*;

public class TicTacToeModelTest {
   @Test
   public void testEmpty() {
        TicTacToeModel t = new TicTacToeModel();
        assertTrue(t.isCellEmpty(3));
   }

   @Test
   public void testPlayMove() {
      TicTacToeModel t = new TicTacToeModel();
      String[] board = {" ", "X", " ",
                        " ", " ", " ",
                        " ", " ", " "};
      t.playMove(1);
      t.playMove(1);
      t.playMove(2, 2);
      String[] board2 = {" ", "X", " ",
                        " ", " ", " ",
                        " ", " ", "O"};
      t.playMove(0, 0);
      String[] board3 = {"X", "X", " ",
                        " ", " ", " ",
                        " ", " ", "O"};
      assertArrayEquals(t.getBoard(), board3);
   }

   @Test
   public void testIsCellEmpty() {
      TicTacToeModel t = new TicTacToeModel();
      t.playMove(0, 0);
      boolean b = !t.isCellEmpty(0) && !t.isCellEmpty(0, 0) && t.isCellEmpty(3) && t.isCellEmpty(2, 2);
      assertTrue(b);
   }

   @Test 
   public void testWin() {
      String[] board1 = {"X", "O", "X",
                        "X", "O", "O",
                        "X", "X", "O"};
      TicTacToeModel t1 = new TicTacToeModel(board1);
      boolean test1 = (t1.checkWin() == true);

      String[] board2 = {"O", "O", "X",
                        "X", "O", "O",
                        "X", "O", "X"};
      TicTacToeModel t2 = new TicTacToeModel(board2);
      boolean test2 = (t2.checkWin() == true);

      String[] board3 = {"X", "O", "O",
                        "X", "X", "O",
                        "O", "X", "O"};
      TicTacToeModel t3 = new TicTacToeModel(board3);
      boolean test3 = (t3.checkWin() == true);

      String[] board4 = {"X", "O", "X",
                        "X", "X", "O",
                        "O", "X", "O"};
      TicTacToeModel t4 = new TicTacToeModel(board4);
      boolean test4 = (t4.checkWin() == false);

      String[] board5 = {"O", "O", "O",
                        "X", "X", "O",
                        "O", "X", "X"};
      TicTacToeModel t5 = new TicTacToeModel(board5);
      boolean test5 = (t5.checkWin() == true);

      String[] board6 = {"X", "O", "O",
                        "X", "X", "X",
                        "O", "X", "O"};
      TicTacToeModel t6 = new TicTacToeModel(board6);
      boolean test6 = (t6.checkWin() == true);

      String[] board7 = {"X", "O", "X",
                        "X", "X", "O",
                        "O", "O", "O"};
      TicTacToeModel t7 = new TicTacToeModel(board7);
      boolean test7 = (t7.checkWin() == true);

      String[] board8 = {"X", "O", "O",
                        "X", "X", "O",
                        "O", "O", "X"};
      TicTacToeModel t8 = new TicTacToeModel(board8);
      boolean test8 = (t8.checkWin() == true);

      String[] board9 = {"X", "O", "O",
                        "X", "O", "O",
                        "O", "X", "O"};
      TicTacToeModel t9 = new TicTacToeModel(board9);
      boolean test9 = (t9.checkWin() == true);

      assertTrue(test1 && test2 && test3 && test4 && test5 && test6 && test7 && test8 && test9);
   }

   @Test
   public void testGetWinner() {
      String[] board = {"X", "O", "O",
                        "X", "O", "O",
                        "O", "X", "O"};
      TicTacToeModel t = new TicTacToeModel(board);
      boolean test1 = t.getWinner().equals("O");
      String[] board2 = {"X", "O", "X",
                        "X", "X", "O",
                        "O", "X", "O"};
      TicTacToeModel t2 = new TicTacToeModel(board2);
      boolean test2 = t2.getWinner().equals("");
      assertTrue(test1 && test2);
   }

   @Test
   public void testXTurn() {
      TicTacToeModel t = new TicTacToeModel();
      assertTrue(t.isXTurn());
   }

   @Test
   public void testGetBoard() {
      String[] board = {"X", "O", "O",
                        "X", "O", "O",
                        "O", "X", "O"};
      TicTacToeModel t = new TicTacToeModel(board);
      assertTrue(board.equals(t.getBoard()));
   }

   @Test
   public void testBoardFull() {
      String[] board = {"X", "O", "O",
                        "X", "O", "O",
                        "O", "X", "O"};
      TicTacToeModel t = new TicTacToeModel(board);
      String[] board2 = {"X", "O", " ",
                        " ", "O", "O",
                        "O", " ", "O"};
      TicTacToeModel t2 = new TicTacToeModel(board2);
      assertTrue(t.boardFull() && !t2.boardFull());
   }

   @Test
   public void testToString() {
      String[] board = {"X", "O", " ",
                        " ", "O", "O",
                        "O", " ", "O"};
      TicTacToeModel t = new TicTacToeModel(board);
      String str = "X|O| \n-----\n |O|O\n-----\nO| |O";
      assertTrue(str.equals(t.toString()));
   }
}