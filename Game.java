import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Runs the game, adds instruction panel, and adds reset functionality.
 * @author macbookpro
 *
 */
public class Game implements Runnable{
  
  @Override
  public void run() {
    // TODO Auto-generated method stub
    final BoardView court = new BoardView();
    final JFrame frame = court.frame;
    
    frame.setLocation(300, 300);
    JOptionPane.showMessageDialog(frame, "Welcome to Connect 4! \n"
        + "Click on the arrows above a column to place your piece\n"
        + "in a column. Player 1 is black, Player 2 is red.\n"
        + "The game ends when a player has 4 pieces \n"
        + "in a row, column, or diagonal.\n"
        + "Have fun!");
    // Status panel
    final JPanel status_panel = new JPanel();
    frame.add(status_panel, BorderLayout.SOUTH);
    final JLabel status = new JLabel("Running...");
    status_panel.add(status);   
    
    final JPanel control_panel = new JPanel();
    frame.add(control_panel, BorderLayout.SOUTH);

    // Note here that when we add an action listener to the reset
    // button, we define it as an anonymous inner class that is
    // an instance of ActionListener with its actionPerformed()
    // method overridden. When the button is pressed,
    // actionPerformed() will be called.
    final JButton reset = new JButton("Reset");
    reset.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        court.board.reset();
        court.repaint();
      }
    });
    control_panel.add(reset);
    // Put the frame on the screen
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setSize(500, 500);
    // Start game
    court.repaint();
  }
  
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Game());
  }

}
