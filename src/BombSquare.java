import java.util.*;

public class BombSquare extends GameSquare
{
	private boolean thisSquareHasBomb = false;
	public static final int MINE_PROBABILITY = 10;

	public BombSquare(int x, int y, GameBoard board) {
		super(x, y, "images/blank.png", board);

		Random r = new Random();
		thisSquareHasBomb = (r.nextInt(MINE_PROBABILITY) == 0);
	}

	public void clicked() {
		setImage("images/bomb.png");
		boolean farLeft = false, farRight = false, veryTop = false, veryBottom = false;
		if (xLocation == 1) { //square is on the far left of board
			farLeft = true;
		} else if (xLocation == board.getWidth()) { //square is far right of board
			farRight = true;
		} else if (yLocation == board.getHeight()) { //square if top of board
			veryTop = true;
		} else if (yLocation == 1) { //square if bottom of board
			veryBottom = true;
		}

		if (farLeft && !veryTop && !veryBottom) {
			GameSquare square;
			for (int x = 0; x < 3; x++) {
				 square = board.getSquareAt(x, yLocation - 1);
			}
		} else if () {

		}
	}
}
