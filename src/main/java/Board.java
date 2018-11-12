public class Board {
  private Player white;
  private Player black;
  private boolean isWhiteTurn;

  public Board(){
    white = new Player();
    black = new Player();
    isWhiteTurn = true;
    start();
  }

  public void start(){
    int hole = 0;
    Player currentPlayer = (isWhiteTurn)?white:black;
    while(true){
       hole = callAMove();
       hole = currentPlayer.act(hole);
       while(hole>0){
         if(isWhiteTurn){
           currentPlayer = white;
         }else{
           currentPlayer = black;
         }
         isWhiteTurn = !isWhiteTurn;
         hole = currentPlayer.act(hole);
       }
       if(checkForVictory){
         System.out.println("Player x has won!!");
         return;
       }
    }
  }

  public int callAMove(){
    //GUI function selecting a hole
    return selectedHole;
  }
}
