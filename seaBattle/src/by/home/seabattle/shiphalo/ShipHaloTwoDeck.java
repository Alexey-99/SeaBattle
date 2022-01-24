package by.home.seabattle.shiphalo;

import by.home.seabattle.entity.CellDesignation;

public class ShipHaloTwoDeck {
	private static final int LAST_COORDINATE_POINT = 9;
	private static final int FIRST_COORDINATE_POINT = 0;
	private static final int DIFFERENCE_BETWEEN_POINTS_ONE = 1;

	public ShipHaloTwoDeck() {
	}

	public String[][] haloPlacementAfterShipPlacement(String lineСoordinates, String[][] matrix) {
		String[] arrayTwoСoordinates = lineСoordinates.split(";");
		String lineXAndYNumbers = arrayTwoСoordinates[0] + "," + arrayTwoСoordinates[1];
		String[] arrayLineXAndYNumbers = lineXAndYNumbers.split(",");
		int xOne = Integer.parseInt(arrayLineXAndYNumbers[0]);
		int yOne = Integer.parseInt(arrayLineXAndYNumbers[1]);
		int xTwo = Integer.parseInt(arrayLineXAndYNumbers[2]);
		int yTwo = Integer.parseInt(arrayLineXAndYNumbers[3]);
		if ((yOne == yTwo) && (xTwo - xOne == DIFFERENCE_BETWEEN_POINTS_ONE)) {
			matrix = placementHaloInHorizontalPositionAndWithCoordinatesAscending(xOne, yOne, xTwo, matrix);
		} else if ((yOne == yTwo) && (xOne - xTwo == DIFFERENCE_BETWEEN_POINTS_ONE)) {
			matrix = placementHaloInHorizontalPositionAndWithCoordinatesDescending(xOne, yOne, xTwo, yTwo, matrix);
		} else if ((xOne == xTwo) && (yTwo - yOne == DIFFERENCE_BETWEEN_POINTS_ONE)) {
			matrix = placementHaloInVerticalPositionAndWithCoordinatesAscending(xOne, yOne, yTwo, matrix);
		} else if ((xOne == xTwo) && (yOne - yTwo == DIFFERENCE_BETWEEN_POINTS_ONE)) {
			matrix = placementHaloInVerticalPositionAndWithCoordinatesDescending(xOne, yOne, xTwo, yTwo, matrix);
		}
		return matrix;
	}

	private String[][] placementHaloInHorizontalPositionAndWithCoordinatesAscending(int xOne, int yOne, int xTwo,
			String[][] matrix) {
		if ((yOne != FIRST_COORDINATE_POINT && yOne != LAST_COORDINATE_POINT)
				&& (xOne != FIRST_COORDINATE_POINT && xTwo != LAST_COORDINATE_POINT)) {
			matrix = horizontalAscendingXFirstNotEqualZeroAndXSecondNotEqualNineAndYNotEqualZeroAndNotEqualNine(xOne,
					yOne, matrix);
		} else if (yOne == FIRST_COORDINATE_POINT && xOne == FIRST_COORDINATE_POINT) {
			matrix = horizontalAscendingXFirstEqualZeroYEqualZero(xOne, yOne, matrix);
		} else if ((yOne != FIRST_COORDINATE_POINT && yOne != LAST_COORDINATE_POINT)
				&& xOne == FIRST_COORDINATE_POINT) {
			matrix = horizontalAscendingXFirstEqualZeroYNotEqualZeroAndNotEqualNine(xOne, yOne, matrix);
		} else if (yOne == LAST_COORDINATE_POINT && xOne == FIRST_COORDINATE_POINT) {
			matrix = horizontalAscendingXFirstEqualsZeroYEqualsNine(xOne, yOne, matrix);
		} else if (yOne == LAST_COORDINATE_POINT && (xOne != FIRST_COORDINATE_POINT && xTwo != LAST_COORDINATE_POINT)) {
			matrix = horizontalAscendingXFirstNotEqualZeroAndXSecondNotEqualNineYEqualNine(xOne, yOne, matrix);
		} else if (yOne == LAST_COORDINATE_POINT && xTwo == LAST_COORDINATE_POINT) {
			matrix = horizontalAscendingXSecondEqualsNineYEqualsNine(xOne, yOne, matrix);
		} else if ((yOne != FIRST_COORDINATE_POINT && yOne != LAST_COORDINATE_POINT) && xTwo == LAST_COORDINATE_POINT) {
			matrix = horizontalAscendingXSecondEqualsNineYNotEqualsZeroAndNotEqualsNine(xOne, yOne, matrix);
		} else if (yOne == FIRST_COORDINATE_POINT && xTwo == LAST_COORDINATE_POINT) {
			matrix = horizontalAscendingXSecondEqualsNineYEqualsZero(xOne, yOne, matrix);
		} else if (yOne == FIRST_COORDINATE_POINT
				&& (xOne != FIRST_COORDINATE_POINT && xTwo != LAST_COORDINATE_POINT)) {
			matrix = horizontalAscendingXFirstNotEqualsZeroAndXSecondNotEqualsNineYEqualsZero(xOne, yOne, matrix);
		}
		return matrix;
	}

	private String[][] placementHaloInHorizontalPositionAndWithCoordinatesDescending(int xOne, int yOne, int xTwo,
			int yTwo, String[][] matrix) {
		if ((yOne != FIRST_COORDINATE_POINT && yOne != LAST_COORDINATE_POINT)
				&& (xOne != LAST_COORDINATE_POINT && xTwo != FIRST_COORDINATE_POINT)) {
			matrix = horizontalDescendingXFirstNotEqualNineXSecondNotEqualZeroAndYNotEqualNineAndNotEqualZero(xTwo,
					yTwo, matrix);
		} else if (yOne == FIRST_COORDINATE_POINT && xTwo == FIRST_COORDINATE_POINT) {
			matrix = horizontalDescendingXSecondEqualZeroAndYEqualZero(xTwo, yTwo, matrix);
		} else if ((yOne != FIRST_COORDINATE_POINT && yOne != LAST_COORDINATE_POINT)
				&& xTwo == FIRST_COORDINATE_POINT) {
			matrix = horizontalDescendingXSecondEqualZeroAndYNotEqualZeroAndNotEqualNine(xTwo, yTwo, matrix);
		} else if (yOne == LAST_COORDINATE_POINT && xTwo == FIRST_COORDINATE_POINT) {
			matrix = horizontalDescendingXSecondEqualZeroAndYEqualNine(xTwo, yTwo, matrix);
		} else if (yOne == LAST_COORDINATE_POINT && (xOne != LAST_COORDINATE_POINT && xTwo != FIRST_COORDINATE_POINT)) {
			matrix = horizontalDescendingXFirstNotEqualNineXSecondNotEqualZeroAndYEqualNine(xTwo, yTwo, matrix);
		} else if (yOne == LAST_COORDINATE_POINT && xOne == LAST_COORDINATE_POINT) {
			matrix = horizontalDescendingXFirstEqualsNineAndYEqualsNine(xTwo, yTwo, matrix);
		} else if ((yOne != FIRST_COORDINATE_POINT && yOne != LAST_COORDINATE_POINT) && xOne == LAST_COORDINATE_POINT) {
			matrix = horizontalDescendingXFirstEqualNineAndYNotEqualZeroAndNotEqualNine(xTwo, yTwo, matrix);
		} else if (yOne == FIRST_COORDINATE_POINT && xOne == LAST_COORDINATE_POINT) {
			matrix = horizontalDescendingXFirstNineAndYEqualZero(xTwo, yTwo, matrix);
		} else if (yOne == FIRST_COORDINATE_POINT
				&& (xOne != LAST_COORDINATE_POINT && xTwo != FIRST_COORDINATE_POINT)) {
			matrix = horizontalDescendingXFirstNotEqualNineAndXSecondNotEqualZeroAndYEqualZero(xTwo, yTwo, matrix);
		}
		return matrix;
	}

	private String[][] placementHaloInVerticalPositionAndWithCoordinatesAscending(int xOne, int yOne, int yTwo,
			String[][] matrix) {
		if ((xOne != LAST_COORDINATE_POINT && xOne != FIRST_COORDINATE_POINT)
				&& (yOne != FIRST_COORDINATE_POINT && yTwo != LAST_COORDINATE_POINT)) {
			matrix = verticalAscendingXNotEqualZeroAndNineAndYFirstNotEqualZeroAndYSecondNotEqualNine(xOne, yOne,
					matrix);
		} else if (yOne == FIRST_COORDINATE_POINT && xOne == FIRST_COORDINATE_POINT) {
			matrix = verticalAscendingXEqualsZeroAndYFirstEqualsZero(xOne, yOne, matrix);
		} else if ((yOne != FIRST_COORDINATE_POINT && yTwo != LAST_COORDINATE_POINT)
				&& xOne == FIRST_COORDINATE_POINT) {
			matrix = verticalAscendingXEqualZeroYFirstNotEqualZeroAndYSecondNotEqualNine(xOne, yOne, matrix);
		} else if (yTwo == LAST_COORDINATE_POINT && xOne == FIRST_COORDINATE_POINT) {
			matrix = verticalAscendingXEqualsZeroAndYSecondEqualsNine(xOne, yOne, matrix);
		} else if (yTwo == LAST_COORDINATE_POINT && (xOne != FIRST_COORDINATE_POINT && xOne != LAST_COORDINATE_POINT)) {
			matrix = verticalAscendingXNotEqualsNineAndNotEqualsZeroAndYSecondNotEqualNine(xOne, yOne, matrix);
		} else if (yTwo == LAST_COORDINATE_POINT && xOne == LAST_COORDINATE_POINT) {
			matrix = verticalAscendingXEqualsNineAndYSecondEqualsNine(xOne, yOne, matrix);
		} else if ((yOne != FIRST_COORDINATE_POINT && yTwo != LAST_COORDINATE_POINT) && xOne == LAST_COORDINATE_POINT) {
			matrix = verticalAscendingXEqualNineAndYFirstNotEqualsZeroAndYSecondNotEqualNine(xOne, yOne, matrix);
		} else if (yOne == FIRST_COORDINATE_POINT && xOne == LAST_COORDINATE_POINT) {
			matrix = verticalAscendingXEqualsNineAndYFirstEqualsZero(xOne, yOne, matrix);
		} else if (yOne == FIRST_COORDINATE_POINT
				&& (xOne != FIRST_COORDINATE_POINT && xOne != LAST_COORDINATE_POINT)) {
			matrix = verticalAscendingXZeroAndYFirstNotZeroAndYSecondNotNine(xOne, yOne, matrix);
		}
		return matrix;
	}

	private String[][] placementHaloInVerticalPositionAndWithCoordinatesDescending(int xOne, int yOne, int xTwo,
			int yTwo, String[][] matrix) {
		if ((yOne != LAST_COORDINATE_POINT && yTwo != FIRST_COORDINATE_POINT)
				&& (xOne != LAST_COORDINATE_POINT && xOne != FIRST_COORDINATE_POINT)) {
			matrix = verticalDescendingXNotEqualZeroAndNotEqualNineAndYFirstNotEqualNineAndYSecondNotEqualZero(xTwo,
					yTwo, matrix);
		} else if (yTwo == FIRST_COORDINATE_POINT && xOne == FIRST_COORDINATE_POINT) {
			matrix = verticalDescendingXEqualsZeroAndYSecondEqualsZero(xTwo, yTwo, matrix);
		} else if ((yOne != LAST_COORDINATE_POINT && yTwo != FIRST_COORDINATE_POINT)
				&& xOne == FIRST_COORDINATE_POINT) {
			matrix = verticalDescendingXEqualsZeroAndYFirstNotEqualsNineAndYSecondNotEqualsZero(xTwo, yTwo, matrix);
		} else if (yOne == LAST_COORDINATE_POINT && xOne == FIRST_COORDINATE_POINT) {
			matrix = verticalDescendingXEqualsZeroAndYFirstEqualsNine(xTwo, yTwo, matrix);
		} else if (yOne == LAST_COORDINATE_POINT && (xOne != FIRST_COORDINATE_POINT && xOne != LAST_COORDINATE_POINT)) {
			matrix = verticalDescendingXNotEqualsNineAndEqualsZeroAndYFirstNotEqualsNine(xTwo, yTwo, matrix);
		} else if (yOne == LAST_COORDINATE_POINT && xOne == LAST_COORDINATE_POINT) {
			matrix = verticalDescendingXEqualsNineAndYFirstEqualsNine(xTwo, yTwo, matrix);
		} else if ((yOne != LAST_COORDINATE_POINT && yTwo != FIRST_COORDINATE_POINT) && xOne == LAST_COORDINATE_POINT) {
			matrix = verticalDescendingXEqualNineAndYFirstNotEqualNineAndYSecondNotEqualZero(xTwo, yTwo, matrix);
		} else if (yTwo == FIRST_COORDINATE_POINT && xOne == LAST_COORDINATE_POINT) {
			matrix = verticalDescendingXEqualsNineAndYSecondEqualsZero(xTwo, yTwo, matrix);
		} else if (yTwo == FIRST_COORDINATE_POINT
				&& (xOne != FIRST_COORDINATE_POINT && xOne != LAST_COORDINATE_POINT)) {
			matrix = verticalDescendingXNotEqualsZeroAndNotEqualsNineAndYSecondEqualsZero(xTwo, yTwo, matrix);
		}
		return matrix;
	}

	private String[][] horizontalAscendingXFirstNotEqualZeroAndXSecondNotEqualNineAndYNotEqualZeroAndNotEqualNine(
			int xOne, int yOne, String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalAscendingXFirstEqualZeroYEqualZero(int xOne, int yOne, String[][] matrix) {
		matrix[yOne][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalAscendingXFirstEqualZeroYNotEqualZeroAndNotEqualNine(int xOne, int yOne,
			String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalAscendingXFirstEqualsZeroYEqualsNine(int xOne, int yOne, String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalAscendingXFirstNotEqualZeroAndXSecondNotEqualNineYEqualNine(int xOne, int yOne,
			String[][] matrix) {
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalAscendingXSecondEqualsNineYEqualsNine(int xOne, int yOne, String[][] matrix) {
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalAscendingXSecondEqualsNineYNotEqualsZeroAndNotEqualsNine(int xOne, int yOne,
			String[][] matrix) {
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalAscendingXSecondEqualsNineYEqualsZero(int xOne, int yOne, String[][] matrix) {
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalAscendingXFirstNotEqualsZeroAndXSecondNotEqualsNineYEqualsZero(int xOne, int yOne,
			String[][] matrix) {
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXFirstNotEqualNineXSecondNotEqualZeroAndYNotEqualNineAndNotEqualZero(
			int xTwo, int yTwo, String[][] matrix) {
		matrix[yTwo - 1][xTwo] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo - 1][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo - 1][xTwo + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo][xTwo + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo - 1][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXSecondEqualZeroAndYEqualZero(int xTwo, int yTwo, String[][] matrix) {
		matrix[yTwo][xTwo + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXSecondEqualZeroAndYNotEqualZeroAndNotEqualNine(int xTwo, int yTwo,
			String[][] matrix) {
		matrix[yTwo - 1][xTwo] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo - 1][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo - 1][xTwo + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo][xTwo + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXSecondEqualZeroAndYEqualNine(int xTwo, int yTwo, String[][] matrix) {
		matrix[yTwo - 1][xTwo] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo - 1][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo - 1][xTwo + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo][xTwo + 2] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXFirstNotEqualNineXSecondNotEqualZeroAndYEqualNine(int xTwo, int yTwo,
			String[][] matrix) {
		matrix[yTwo][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo - 1][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo - 1][xTwo] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo - 1][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo - 1][xTwo + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo][xTwo + 2] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXFirstEqualsNineAndYEqualsNine(int xTwo, int yTwo, String[][] matrix) {
		matrix[yTwo][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo - 1][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo - 1][xTwo] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo - 1][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXFirstEqualNineAndYNotEqualZeroAndNotEqualNine(int xTwo, int yTwo,
			String[][] matrix) {
		matrix[yTwo - 1][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo - 1][xTwo] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo - 1][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXFirstNineAndYEqualZero(int xTwo, int yTwo, String[][] matrix) {
		matrix[yTwo][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXFirstNotEqualNineAndXSecondNotEqualZeroAndYEqualZero(int xTwo, int yTwo,
			String[][] matrix) {
		matrix[yTwo][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo][xTwo + 2] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalAscendingXNotEqualZeroAndNineAndYFirstNotEqualZeroAndYSecondNotEqualNine(int xOne,
			int yOne, String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalAscendingXEqualsZeroAndYFirstEqualsZero(int xOne, int yOne, String[][] matrix) {
		matrix[yOne][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalAscendingXEqualZeroYFirstNotEqualZeroAndYSecondNotEqualNine(int xOne, int yOne,
			String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalAscendingXEqualsZeroAndYSecondEqualsNine(int xOne, int yOne, String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalAscendingXNotEqualsNineAndNotEqualsZeroAndYSecondNotEqualNine(int xOne, int yOne,
			String[][] matrix) {
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalAscendingXEqualsNineAndYSecondEqualsNine(int xOne, int yOne, String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalAscendingXEqualNineAndYFirstNotEqualsZeroAndYSecondNotEqualNine(int xOne, int yOne,
			String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalAscendingXEqualsNineAndYFirstEqualsZero(int xOne, int yOne, String[][] matrix) {
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalAscendingXZeroAndYFirstNotZeroAndYSecondNotNine(int xOne, int yOne, String[][] matrix) {
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXNotEqualZeroAndNotEqualNineAndYFirstNotEqualNineAndYSecondNotEqualZero(
			int xTwo, int yTwo, String[][] matrix) {
		matrix[yTwo - 1][xTwo] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo - 1][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 2][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 2][xTwo] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 2][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo - 1][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXEqualsZeroAndYSecondEqualsZero(int xTwo, int yTwo, String[][] matrix) {
		matrix[yTwo][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 2][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 2][xTwo] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXEqualsZeroAndYFirstNotEqualsNineAndYSecondNotEqualsZero(int xTwo, int yTwo,
			String[][] matrix) {
		matrix[yTwo - 1][xTwo] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo - 1][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 2][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 2][xTwo] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXEqualsZeroAndYFirstEqualsNine(int xTwo, int yTwo, String[][] matrix) {
		matrix[yTwo - 1][xTwo] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo - 1][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXNotEqualsNineAndEqualsZeroAndYFirstNotEqualsNine(int xTwo, int yTwo,
			String[][] matrix) {
		matrix[yTwo + 1][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo - 1][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo - 1][xTwo] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo - 1][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXEqualsNineAndYFirstEqualsNine(int xTwo, int yTwo, String[][] matrix) {
		matrix[yTwo - 1][xTwo] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo - 1][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXEqualNineAndYFirstNotEqualNineAndYSecondNotEqualZero(int xTwo, int yTwo,
			String[][] matrix) {
		matrix[yTwo - 1][xTwo] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo - 1][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 2][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 2][xTwo] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXEqualsNineAndYSecondEqualsZero(int xTwo, int yTwo, String[][] matrix) {
		matrix[yTwo][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 2][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 2][xTwo] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXNotEqualsZeroAndNotEqualsNineAndYSecondEqualsZero(int xTwo, int yTwo,
			String[][] matrix) {
		matrix[yTwo][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 2][xTwo - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 2][xTwo] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 2][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo + 1][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yTwo][xTwo + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}
}
