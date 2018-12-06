package backend;
import javafx.util.Pair;

import java.lang.Math;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class AIBoard extends Board{

  private static final int HARD = 3;
  private static final int MEDIUM = 2;
  private static final int EASY = 1;
  private static final int FORSEEN_MOVES = 1;
  private int level;

/**
Initialises the AI board with the given level of difficulty
@param hardness the difficulty of the AI
*/
  public AIBoard(int hardness){
    super();
    level = hardness;
  }
  /**
  Initialises the AI board with the given level of difficulty and setup
  @param board the initial state of the board
  @param hardness the difficulty of the AI
  */
  public AIBoard(String board, int hardness) {
    super(board);
    level = hardness;
  }
/**
   * Move the korgools according to the pressed hole
   * @param pressedHole: the hole pressed
   * @return True if the current player has won,
   *    False otherwise
   */
  @Override
  public boolean makeAMove(int pressedHole){
    if(isWhiteTurn)
      if(super.makeAMove(pressedHole))
        return true;
    if(!isWhiteTurn)
      return makeAIMove();
    return false;
  }

  /**
   * @return True if the current player has won,
   *    False otherwise
   */
  private boolean makeAIMove(){
    switch(level){
      case 1:
        return easyMove();
      case 2:
        return mediumMove();
      case 3:
        return hardMove();
      default:
        System.err.println("Hardness level not Allowed");
        return true;

    }
  }

  /**
   * AI makes a move based on randomness
      @return if the player has won
   */

  private boolean easyMove(){

    int randomHole = evaluate();
    while(!isValidMove(randomHole)){
      randomHole = evaluate();
    }

    return super.makeAMove(randomHole);

  }

  /**
   * Return the hole to move for the AI Player
   * The selection is done randomly
   * @return The hole selected
   */
  private int evaluate(){
    return (int)(Math.random()*8);
  }


  /**
  Ensures the given hole can be pressed by the AI
  @return if the AI can press the hole*/
  private boolean isValidMove(int pressedHole){
    return getPlayerHole(pressedHole).getKorgools() != 0;
  }

  /**
   * AI makes a move based on a basic logic
      @return if the player has won
   */
  private boolean mediumMove(){
    int a = getBestMoveForBlack(FORSEEN_MOVES*2);
    System.out.println("Moving " + a);
      return  super.makeAMove(a) ;
  }

  /**Applies an min max algorithm for the AI to determine its next move.
  @param boardString current state of the boardString
  @param depth how many moves in advance it has to look
  @param alpha Alpha index
  @param beta Beta index
  @param isBlackTurn whether it is the black player's turn*/
  private Pair<Integer, String> alphabeta(String boardString, int depth, int alpha, int beta, boolean isBlackTurn) {

    if (depth == 0 || gameHasEnded(boardString)) {
      return new Pair<Integer, String>(heuristicValue(boardString), boardString);
    }

    ArrayList<String> possibleBoards = getPossibleMoves(boardString);
    String bestBoard = "";
    if (isBlackTurn) { // maximize
      for (String newBoard : possibleBoards) {
        int newAlpha = alphabeta(newBoard, depth-1, alpha, beta, false).getKey();
        if (alpha < newAlpha) {
          alpha = newAlpha;
          bestBoard = newBoard;
          //System.out.println("switching to " + newBoard);

        }
        if (beta <= alpha) break; // prune
      }
      //System.out.println("max from black ?" + isBlackTurn + "\n" + bestBoard);
      return new Pair<>(alpha, bestBoard);
    }
    else { // minimize
      for (String newBoard : possibleBoards) {
        int newBeta = alphabeta(newBoard, depth-1, alpha, beta, true).getKey();
        //System.out.println("comparing " + beta + " and " + newBeta);
        if (beta > newBeta) {
          //System.out.println("resetting");
          beta = newBeta;
          bestBoard = newBoard;
          //System.out.println("switching to " + newBoard);
        }
        if (beta <= alpha) break; // prune
      }
      //System.out.println("min to " + bestBoard + "\n");
      return new Pair<>(beta, bestBoard);
    }
  }

  /**
  *Determines if the game has finished
  @return if the game has ended*/
  private boolean gameHasEnded(String boardString) {
    return (new Board(boardString)).gameHasEnded();
  }

  /**
   * Uses the min max algorithm to find the next move
   @return if the player has won
   */
  private boolean hardMove(){
      return super.makeAMove(getBestMoveForBlack(FORSEEN_MOVES*2));
  }

  /**
   * For now, the heurstic value is the difference between the scores of the players, favoring black.
   *
   * Other ideas:
   * Analyzing best tuz placements
   * Having more kergels on your side could be disadvantages as he could capture
   * How much board coverage you have (how many of his cells you can reach)
   * @param boardString the board that we want to get the h-value for
   * @return the heuristic value of the board
   */
  private int heuristicValue(String boardString) {
    String[] tokens = boardString.split("\n");
    int blackScore = Integer.parseInt(tokens[0].split(",")[9]);
    int whiteScore = Integer.parseInt(tokens[1].split(",")[9]);

    return blackScore - whiteScore;
  }

  private ArrayList<String> getPossibleMoves(String boardString) {
    ArrayList<String> reachableBoards = new ArrayList<>();
    for (int i = 0; i < 9; i++) {
      if ((new AIBoard(boardString, 0)).isValidMove(i)) {
        Board board = new Board(boardString);
        board.makeAMove(i);
        //System.out.println("Pressing " + i);
        //System.out.println(board);
        reachableBoards.add(board.toString());
      }
    }

    return reachableBoards;
  }

/**Finds the bext move for the AI
@param moveToLookForwardFor how many turns into the future the AI has to calculate
@return the hole to make the move*/
  private int getBestMoveForBlack(int moveToLookForwardFor) {
    //System.out.println("starting: " + boardString);
    //System.out.println(heuristicValue(boardString) + "\n");
    String boardString = this.toString();
    String desiredBoard = alphabeta(boardString, moveToLookForwardFor*2, Integer.MIN_VALUE, Integer.MAX_VALUE, true).getValue();

    System.out.println("desired: " + desiredBoard);
    //System.out.println(heuristicValue(desiredBoard) + "\n");


    for (int i = 0; i < 9; i++) {
      Board newBoard = new Board(boardString);
      newBoard.makeAMove(i);

      if (newBoard.toString().equals(desiredBoard)) return i;
    }

    try {
      throw new Exception("No Board found");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return -1;
  }
}
