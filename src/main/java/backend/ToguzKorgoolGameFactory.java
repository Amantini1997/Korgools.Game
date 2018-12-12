package backend;

public class ToguzKorgoolGameFactory {
    
    

    //use getShape method to get object of type shape 
    public static ToguzKorgoolGame getOnePlayerToguzKorgoolGame(int difficulty){
        return new AIBoard(difficulty);
    }

    public static ToguzKorgoolGame getOnePlayerToguzKorgoolGame(String boardString, int difficulty){
        return new AIBoard(boardString, difficulty);
    }

    public static ToguzKorgoolGame getTwoPlayerToguzKorgoolGame(){
        return new Board();
    }

    public static ToguzKorgoolGame getTwoPlayerToguzKorgoolGame(String boardString){
        return new Board(boardString);
    }
 }