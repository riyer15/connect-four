/** This class implements the logic behind the board's state: it holds a 2d
 * array of integers with values 0, 1, and 2 (0 for empty, 1 for player1, 
 * 2 for player2), and a boolean field holding whether or not the player is
 * player1. This class provides the back-end state that the BoardView class
 * depends on. 
 * Author: Rani Iyer
 * Date: 12/8/15
 **/

public class BoardModel {
  
    private int[][] myBoard = new int[6][7];
    private boolean player1;
   /**
    * resets the board to all 0's (empties) 
    * 
    */
    public int[][] getBoard(){
      return myBoard;
    }
    
    public boolean getPlayer(){
      return player1;
    }
    
    public void setPlayer(boolean val){
      player1 = val; 
    }
    
    public void reset(){
      for(int i = 0; i < 6; i++){
        for(int j = 0; j < 7; j++){
          myBoard[i][j] = 0;
        }
      }
    }
    
    public boolean hasFour(){
      
      // Checking if there are four in a row
      for(int i = 0; i < 6; i++){
        for(int j = 0; j < 4; j++){
          if(myBoard[i][j] != 0){
            if(myBoard[i][j] == myBoard[i][j+1] &&
                myBoard[i][j+1] == myBoard[i][j+2] &&
                myBoard[i][j+2] == myBoard[i][j+3]){
              reset();
              return true;
            } 
          }
        }
      }
      
      //Checking if there are four in a column
      for(int j = 0; j < 7; j++){
        for(int i = 0; i < 3; i++){
          if(myBoard[i][j] != 0){
            if(myBoard[i][j] == myBoard[i+1][j] &&
                myBoard[i+1][j] == myBoard[i+2][j]&&
                myBoard[i+2][j] == myBoard[i+3][j]){
              reset();
              return true;
            }
          }
        }
      }
      
      //Checking if there are northeast pointing diagonals
      for(int i = 5; i > 2; i--){
        for(int j = 0; j < 4; j++){
          if(myBoard[i][j] != 0){
            if(myBoard[i][j] == myBoard[i-1][j+1] &&
                myBoard[i-1][j+1] == myBoard[i-2][j+2]&&
                myBoard[i-2][j+2] == myBoard[i-3][j+3]){
              reset();
              return true;
            }
          }
        }
      }
     
      
      //Checking for northwest pointing diagonals
      for(int i = 5; i > 2; i--){
        for(int j = 6; j > 2; j--){
          if(myBoard[i][j] != 0){
            if(myBoard[i][j] == myBoard[i-1][j-1] &&
                myBoard[i-1][j-1] == myBoard[i-2][j-2]&&
                myBoard[i-2][j-2] == myBoard[i-3][j-3]){
              reset();
              return true;
            }
          }
        }
      }
      return false;
    }
    
    
    public boolean isFilled(){
      for(int x = 0; x < 6; x++){
        for(int y = 0; y < 7; y++){
          if(myBoard[x][y] == 0){
            return false;
          }
        }
      }
      return true;
    }
    
    public boolean isColFilled(int column){
      for(int i = 0; i < 6; i++){
        if(myBoard[i][column] == 0)
          return false;
      }
      return true;
    }
    
    public void addPiece(int column){
      for(int y = 5; y >= 0; y--){
        if(myBoard[y][column] == 0){
          if(player1 == true){
            myBoard[y][column] = 1;
            player1 = false;
            break;
          }
          else 
            myBoard[y][column] = 2;
            player1 = true;
            break;
            
        }
      }
      
    }
    

}
