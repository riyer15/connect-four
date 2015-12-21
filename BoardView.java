/**
 * This class holds the view of the board and the controllers to change its 
 * state
 * @author Rani Iyer
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class BoardView {
  public BoardModel board;
  private JPanel panel;
  private JLabel[][] boardPlaces;
  public JFrame frame;  
  private Player p;
  GridLayout boardGrid = new GridLayout(8,7,1,1);
  
  /**
   * Constructor initializes the board's state,
   * the actual board view 
   * the associated controllers & reactions
   *
   */
  public BoardView(){
    board = new BoardModel();
    boardPlaces = new JLabel[6][7];
    try {
      p = new Player();
      
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    
    frame = new JFrame();
    panel = new JPanel();
    panel.setLayout(boardGrid);

    for(int i = 0; i < 7; i++){
        final int j = i;
        JButton a = new JButton();
        try {        
          Image img = ImageIO.read(getClass().getResource("down1.jpeg"));
          a.setIcon(new ImageIcon(img));
        } catch(IOException e){
          
        }
        panel.add(a);
 

        a.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            if(board.isColFilled(j)){
              JOptionPane.showMessageDialog(frame, "This row is filled!");
            }
            if(!(board.isColFilled(j))){
              board.addPiece(j);
              repaint();
              if(board.hasFour()){
                 String player;
                if(board.getPlayer() == true){
                  player = "1";
                }
                else{
                  player = "2";
                }
                JOptionPane.showMessageDialog(frame,
                    "Player" + player + "has Connect Four! \n");
                repaint();
                try {
                  String s = (String)JOptionPane.showInputDialog(
                      frame,
                      "What's your name?",
                      "Add to High Scores list",
                      JOptionPane.PLAIN_MESSAGE);
                 p.addPlayer(s);
                 JOptionPane.showMessageDialog(frame, p.getHighestScores());
                 
                } catch (HeadlessException e1) {
                  // TODO Auto-generated catch block
                  e1.printStackTrace();
                } catch (FileNotFoundException e1) {
                  // TODO Auto-generated catch block
                  e1.printStackTrace();
                }
              }  
            if(board.isFilled()){
              JOptionPane.showMessageDialog(frame, "No more moves!");
              board.reset();
              repaint();
            }
            }
          }
        });
    }
    
    for(int i = 0; i < 6; i++){
      for(int j = 0; j < 7; j++){
        boardPlaces[i][j] = new JLabel();
        boardPlaces[i][j].setPreferredSize(new Dimension(50,50));
        boardPlaces[i][j].setBackground(Color.BLUE);
        boardPlaces[i][j].setOpaque(true);
      }
    }
    frame.add(panel);

  }
  
  /**
   * This method repaints the board based on the BoardModel's State
   */
  
  public void repaint(){
    int[][] gridModel = board.getBoard();
    for(int i = 0; i < boardPlaces.length; i++){
      for(int j = 0; j < boardPlaces[0].length; j++){
        if(gridModel[i][j] == 1){
          boardPlaces[i][j].setBackground(Color.RED);
        }
        else if(gridModel[i][j] == 2){
          boardPlaces[i][j].setBackground(Color.BLACK);
        }
        else{
          boardPlaces[i][j].setBackground(Color.BLUE);
        }
        boardPlaces[i][j].setOpaque(true);
        panel.add(boardPlaces[i][j]);
      }
    }
  }
  
}
