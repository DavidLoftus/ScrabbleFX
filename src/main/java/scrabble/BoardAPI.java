package scrabble;

public interface BoardAPI {

    boolean isLegalPlay(Frame frame, Word word);

    Square getSquareCopy(int row, int col);

    boolean isFirstPlay();
}
