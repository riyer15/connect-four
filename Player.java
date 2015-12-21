import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class Player{
  
  private Map<String, Integer> highScores;
  private String fileName = "highScores.txt";
  /**
   * The player constructor reads in the highScores.txt file and uses it to 
   * create initial values for the highScores map. We do this because every 
   * run of the Game class creates a new highScores map, but we need to save the 
   * names of past players and their numbers of wins. 
   * @throws IOException
   */
  public Player() throws IOException{
    highScores = new TreeMap<String, Integer>();
    Reader r = new FileReader("highScores.txt");
    BufferedReader read = new BufferedReader(r);
    String player = read.readLine();
    while(player != null && player != ""){
      String[] thisLine = player.split(",");
      highScores.put(thisLine[0],Integer.parseInt( thisLine[1]));
      player = read.readLine();
    }
    read.close();
  }
  
  /**
   * Method adds a name to the map from an input and increases their number
   * of wins by 1. 
   * @param name
   */
  public void addPlayer(String name){
    if(highScores.containsKey(name)){
      int num = highScores.get(name);
      highScores.put(name, num + 1);
    }
    else{
      highScores.put(name, 1);
    }
  }
  
  /**
   * getHighestScores() returns the top 2 players with their scores 
   * and writes out all the players with their scores to a highScores.txt file
   * that overwrites the initial values of the players + their scores. 
   * 
   * @return String of the top 2 players
   * @throws FileNotFoundException
   */

  public String getHighestScores() throws FileNotFoundException{
   Set<String> allNames = highScores.keySet();
   Iterator<String> firstName = allNames.iterator();
   String maxKey = firstName.next();
   int maxInt = highScores.get(maxKey);
   int index1 = 0;
   int maxIndex = 0;
   String fileOutput = maxKey + "," + maxInt; // converts all the keys/values to strings
   while(firstName.hasNext()){
     String currName = firstName.next();
     index1++;
     int currInt = highScores.get(currName);
     fileOutput += "\n"+ currName + "," + currInt;
     if(currInt > maxInt){
       maxIndex = index1;
       maxInt = currInt;
       maxKey = currName;
     }
   }
   
   int secondInt = 0;
   int index2 = 0; 
   String secondKey = "";
   Iterator<String> secondName = allNames.iterator();
   while(secondName.hasNext()){
     String currName = secondName.next();
     int currInt = highScores.get(currName);
     if(currInt > secondInt && index2 != maxIndex){
       secondInt = currInt;
       secondKey = currName;
     }
     index2++;  
   }
  /* String fileOutput =  maxKey +"," + highScores.get(maxKey) + "\n" + secondKey + 
       "," + highScores.get(secondKey);*/

   String frameOutput =  "1. "+ maxKey +": " + highScores.get(maxKey) + "\n" +
       "2. "+ secondKey +  ": " + highScores.get(secondKey);
   
   PrintWriter writer = new PrintWriter(new File(fileName));
   writer.println(fileOutput); 
   writer.close();
   return frameOutput;
   
  }

  
  
  }
