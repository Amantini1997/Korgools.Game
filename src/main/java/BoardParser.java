import backend.*;

public class BoardParser {
  public static String convertBoardToString(Board board) {
    return board.toString();
  }

  public static Board convertStringToBoard(String boardString) {
    return new Board(boardString);
  }
}
