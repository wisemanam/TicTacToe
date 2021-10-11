package edu.wofford;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiMain extends JFrame implements ActionListener {

    private TicTacToeModel t;
    private JButton[] buttons;
    private JLabel result;
    
    public void actionPerformed(ActionEvent event) {
      JButton button = (JButton) event.getSource();
      boolean playValid = false;
      for (int i = 0; i < buttons.length; i++) {
        if (buttons[i] == button) {
          playValid = t.playMove(i);
        }
      }
      if (playValid) {
        if (!t.isXTurn() && button.getText().equals("")) {
            button.setText("X");
        } else if (t.isXTurn() && button.getText().equals("")) {
            button.setText("O");
        }
        String winner = t.getWinner();
        if (winner == "X" || winner == "O") {
          result.setText(winner + " wins");
        } else if (t.boardFull()) {
          result.setText("Tie");
        }
      }
    }
    
    public GuiMain() {
      t = new TicTacToeModel();
      result = new JLabel("");
      add(result, BorderLayout.PAGE_START);
      buttons = new JButton[9];
      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridLayout(3, 3));
      for (int i = 0; i < 9; i++) {
        buttons[i] = new JButton();
        buttons[i].addActionListener(this);
        if (i < 3) {
          buttons[i].setName("location" + "0" + String.valueOf(i));
        } else if (i < 6) {
          buttons[i].setName("location" + "1" + String.valueOf(i - 3));
        } else if (i < 9) {
          buttons[i].setName("location" + "2" + String.valueOf(i - 6));
        }
        buttonPanel.add(buttons[i]);
      }
      add(buttonPanel);
      pack();
      setSize(400, 400);
      setTitle("Tic Tac Toe");
      setVisible(true);
    }
    
    public static void main(String[] args) {
      GuiMain window  = new GuiMain();
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}