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

	public boolean getBomb() {
		return this.thisSquareHasBomb;
	}

	public void squareChecker(int x, int y) {
		int[] xs = {-1, 0, 1};
		int[] xy = {-1, 0 ,1};
		int count = 0;

		for (int i = 0; i < 3; i++) {
			for (int g = 0; g < 3; g++) {
				if (board.getSquareAt(x + xs[i], y + xy[g]) != null) {

					if ((board.getSquareAt(x + xs[i], y + xy[g]) instanceof BombSquare)) {
						count++;
					}
				}
			}
		}

		if (count > 0) {
			board.getSquareAt(x, y).setImage(("images/x.png").replace("x", Integer.toString(count)));
		} else {
			board.getSquareAt(x, y).setImage("images/blank.png");
		}
	}

	public void clicked()
	{
		System.out.print(xLocation);
		System.out.print(", " +  yLocation);
		System.out.println("");
		setImage("images/bomb.png");
		int[] xs = {-1, 0, 1};
		int[] xy = {-1, 0, 1};

		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				squareChecker(xLocation + xs[x], yLocation + xy[y]);
			}
		}
	}
}
