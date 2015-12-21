import static org.junit.Assert.*;

import org.junit.*;

public class BoardModelTest {

  @Test
  public void testHasFourColumn(){
    BoardModel myBoard = new BoardModel();
    myBoard.setPlayer(true);
    myBoard.addPiece(1);
    myBoard.addPiece(0);
    myBoard.addPiece(1);
    myBoard.addPiece(0);
    myBoard.addPiece(1);
    myBoard.addPiece(0);
    myBoard.addPiece(1);
    assertTrue("column has connect four!", myBoard.hasFour());
  }
  @Test
  public void testHasFourRow(){
    BoardModel myBoard = new BoardModel();
    myBoard.setPlayer(true);
    myBoard.addPiece(1);
    myBoard.addPiece(0);
    myBoard.addPiece(2);
    myBoard.addPiece(0);
    myBoard.addPiece(3);
    myBoard.addPiece(0);
    myBoard.addPiece(4);
    assertTrue("row has connect four!", myBoard.hasFour());
  }
  @Test
  public void testHasFourDiagNE(){
    BoardModel myBoard = new BoardModel();
    myBoard.setPlayer(true);
    myBoard.addPiece(0);
    myBoard.addPiece(1);
    myBoard.addPiece(1);
    myBoard.addPiece(2);
    myBoard.setPlayer(false);
    myBoard.addPiece(2);
    myBoard.setPlayer(true);
    myBoard.addPiece(2);
    myBoard.addPiece(3);
    myBoard.addPiece(3);
    myBoard.addPiece(3);
    myBoard.setPlayer(true);
    myBoard.addPiece(3);
    assertTrue("NE Diag has connect four!", myBoard.hasFour());
  }
  @Test
  
  public void testHasFourDiagNW(){
    BoardModel myBoard = new BoardModel();
    myBoard.setPlayer(true);
    myBoard.addPiece(6);
    myBoard.addPiece(5);
    myBoard.addPiece(5);
    myBoard.addPiece(4);
    myBoard.addPiece(3);
    myBoard.addPiece(4);
    myBoard.addPiece(4);
    myBoard.addPiece(2);
    myBoard.addPiece(3);
    myBoard.addPiece(3);
    myBoard.addPiece(3);
    assertTrue("NE Diag has connect four!", myBoard.hasFour());
  }
  
  @Test
  public void testReset(){
    BoardModel myBoard = new BoardModel();
    //adding arbitrary pieces to board
    myBoard.addPiece(6);
    myBoard.addPiece(4);
    myBoard.addPiece(2);
    myBoard.reset();
    boolean result = true;
    for(int i = 0; i< 6; i++){
      for(int j = 0; j<7; j++){
        if(myBoard.getBoard()[i][j] != 0)
          result = false;
       }
    }
    assertTrue("reset sets board's val's to 0", result);
    
  }
  
  @Test
  public void testAddPiece(){
    BoardModel myBoard = new BoardModel();
    myBoard.setPlayer(true);
    myBoard.addPiece(5);
    assertEquals(1, myBoard.getBoard()[5][5]);
  }
  
  @Test
  public void testColFilled(){
    BoardModel myBoard = new BoardModel();
    int j = 0;
    while(j < 7){
      myBoard.addPiece(2);
      j++;
    }
    assertTrue("column 2 is filled", myBoard.isColFilled(2));
  }
  
  @Test
  public void testBoardFilled(){
    BoardModel myBoard = new BoardModel();
    for(int i = 0; i < 7; i++){
      int j = 0;
      while(j < 7){
        myBoard.addPiece(i);
        j++;
      }
      j = 0;
    }
    assertTrue("board is filled", myBoard.isFilled());
    
  }
  
  @Test
  public void testPlayerSet(){
    BoardModel myBoard = new BoardModel();
    myBoard.setPlayer(false);
    assertFalse("Player1 is false", myBoard.getPlayer());
  }
}
