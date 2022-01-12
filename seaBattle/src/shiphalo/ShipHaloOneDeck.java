package shiphalo;

import entity.CellDesignation;

public class ShipHaloOneDeck {
	private static final int LAST_COORDINATE_POINT = 9;
	private static final int FIRST_COORDINATE_POINT = 0;

	public ShipHaloOneDeck() {
	}

	public String[][] haloPlacementAfterShipPlacement(String lineСoordinates, String[][] matrix) {
		String[] arrayXAndYNumbers = lineСoordinates.split(",");
		int xOne = Integer.parseInt(arrayXAndYNumbers[0]);
		int yOne = Integer.parseInt(arrayXAndYNumbers[1]);
		matrix = haloPlacement(xOne, yOne, matrix);
		return matrix;
	}

	private String[][] haloPlacement(int xOne, int yOne, String[][] matrix) {
		if ((yOne != FIRST_COORDINATE_POINT && yOne != LAST_COORDINATE_POINT)
				&& (xOne != FIRST_COORDINATE_POINT && xOne != LAST_COORDINATE_POINT)) {
			matrix = xAndYNotZeroAndNotNine(xOne, yOne, matrix);
		} else if (yOne == FIRST_COORDINATE_POINT && xOne == FIRST_COORDINATE_POINT) {
			matrix = xAndYAreZero(xOne, yOne, matrix);
		} else if ((yOne != FIRST_COORDINATE_POINT && yOne != LAST_COORDINATE_POINT)
				&& xOne == FIRST_COORDINATE_POINT) {
			matrix = xEqualsZeroAndYNotEqualsZeroAndNotEqualsNine(xOne, yOne, matrix);
		} else if (yOne == LAST_COORDINATE_POINT && xOne == FIRST_COORDINATE_POINT) {
			matrix = xEqualsZeroAndYEqualsNine(xOne, yOne, matrix);
		} else if (yOne == LAST_COORDINATE_POINT && (xOne != FIRST_COORDINATE_POINT && xOne != LAST_COORDINATE_POINT)) {
			matrix = xNotEqualZeroAndNotEqualNineAndYEqualNine(xOne, yOne, matrix);
		} else if (xOne == LAST_COORDINATE_POINT && yOne == LAST_COORDINATE_POINT) {
			matrix = xNineAndYNine(xOne, yOne, matrix);
		} else if ((yOne != LAST_COORDINATE_POINT && yOne != FIRST_COORDINATE_POINT) && xOne == LAST_COORDINATE_POINT) {
			matrix = xEqualsNineAndYNotEqualsZeroAndNotEqualsNine(xOne, yOne, matrix);
		} else if (xOne == LAST_COORDINATE_POINT && yOne == FIRST_COORDINATE_POINT) {
			matrix = xEqualsNineAndYEqualsZero(xOne, yOne, matrix);
		} else if (yOne == FIRST_COORDINATE_POINT
				&& (xOne != FIRST_COORDINATE_POINT && xOne != LAST_COORDINATE_POINT)) {
			matrix = xNotEqualsZeroAndNotEqualsNineAndYEqualsZero(xOne, yOne, matrix);
		}
		return matrix;
	}

	private String[][] xAndYNotZeroAndNotNine(int xOne, int yOne, String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] xAndYAreZero(int xOne, int yOne, String[][] matrix) {
		matrix[yOne][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] xEqualsZeroAndYNotEqualsZeroAndNotEqualsNine(int xOne, int yOne, String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] xEqualsZeroAndYEqualsNine(int xOne, int yOne, String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] xNotEqualZeroAndNotEqualNineAndYEqualNine(int xOne, int yOne, String[][] matrix) {
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] xNineAndYNine(int xOne, int yOne, String[][] matrix) {
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] xEqualsNineAndYNotEqualsZeroAndNotEqualsNine(int xOne, int yOne, String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] xEqualsNineAndYEqualsZero(int xOne, int yOne, String[][] matrix) {
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] xNotEqualsZeroAndNotEqualsNineAndYEqualsZero(int xOne, int yOne, String[][] matrix) {
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}
}