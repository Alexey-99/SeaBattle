package by.koroza.seabattle.shiphalo;

import by.koroza.seabattle.entity.CellDesignation;

public class ShipHaloFourDeck {
	private static final int LAST_COORDINATE_POINT = 9;
	private static final int FIRST_COORDINATE_POINT = 0;
	private static final int DIFFERENCE_BETWEEN_POINTS_ONE = 1;
	private static final int DIFFERENCE_BETWEEN_POINTS_THREE = 3;

	public ShipHaloFourDeck() {
	}

	public String[][] haloPlacementAfterShipPlacement(String lineСoordinates, String[][] matrix) {
		String[] arrayFourСoordinates = lineСoordinates.split(";");
		String lineXAndYNumbers = arrayFourСoordinates[0] + "," + arrayFourСoordinates[1] + ","
				+ arrayFourСoordinates[2] + "," + arrayFourСoordinates[3];
		String[] arrayLineXAndYNumbers = lineXAndYNumbers.split(",");
		int xOne = Integer.parseInt(arrayLineXAndYNumbers[0]);
		int yOne = Integer.parseInt(arrayLineXAndYNumbers[1]);
		int xTwo = Integer.parseInt(arrayLineXAndYNumbers[2]);
		int yTwo = Integer.parseInt(arrayLineXAndYNumbers[3]);
		int xThree = Integer.parseInt(arrayLineXAndYNumbers[4]);
		int yThree = Integer.parseInt(arrayLineXAndYNumbers[5]);
		int xFour = Integer.parseInt(arrayLineXAndYNumbers[6]);
		int yFour = Integer.parseInt(arrayLineXAndYNumbers[7]);
		if ((yOne == yTwo && yThree == yFour && yTwo == yThree) && ((xFour - xOne == DIFFERENCE_BETWEEN_POINTS_THREE)
				&& (xThree - xTwo == DIFFERENCE_BETWEEN_POINTS_ONE)
				&& (xFour - xThree == DIFFERENCE_BETWEEN_POINTS_ONE))) {
			matrix = placingHaloInHorizontalPositionAndWithAscendingCoordinates(xOne, yOne, xFour, matrix);
		} else if ((yOne == yTwo && yThree == yFour && yTwo == yThree)
				&& ((xOne - xFour == DIFFERENCE_BETWEEN_POINTS_THREE)
						&& (xTwo - xThree == DIFFERENCE_BETWEEN_POINTS_ONE)
						&& (xOne - xTwo == DIFFERENCE_BETWEEN_POINTS_ONE))) {
			matrix = placementHaloInHorizontalPositionAndWithCoordinatesDescending(xOne, yOne, xFour, yFour, matrix);
		} else if ((((xOne == xTwo) && (xThree == xFour)) && xTwo == xThree)
				&& ((yFour - yOne == DIFFERENCE_BETWEEN_POINTS_THREE)
						&& (yThree - yTwo == DIFFERENCE_BETWEEN_POINTS_ONE)
						&& (yFour - yThree == DIFFERENCE_BETWEEN_POINTS_ONE))) {
			matrix = placementHaloInVerticalPositionAndWithCoordinatesInAscending(xOne, yOne, yFour, matrix);
		} else if ((((xOne == xTwo) && (xThree == xFour)) && xTwo == xThree)
				&& ((yOne - yFour == DIFFERENCE_BETWEEN_POINTS_THREE)
						&& (yTwo - yThree == DIFFERENCE_BETWEEN_POINTS_ONE)
						&& (yOne - yTwo == DIFFERENCE_BETWEEN_POINTS_ONE))) {
			matrix = placementHaloInVerticalPositionAndWithCoordinatesInDescending(xOne, yOne, xFour, yFour, matrix);
		}
		return matrix;
	}

	private String[][] placingHaloInHorizontalPositionAndWithAscendingCoordinates(int xOne, int yOne, int xFour,
			String[][] matrix) {
		if ((yOne != LAST_COORDINATE_POINT && yOne != FIRST_COORDINATE_POINT)
				&& (xOne != FIRST_COORDINATE_POINT && xFour != LAST_COORDINATE_POINT)) {
			matrix = horizontalAscendingXFirstNotEqualZeroXFourthNotEqualNineYNotEqualZeroOrNine(xOne, yOne, matrix);
		} else if (yOne == FIRST_COORDINATE_POINT && xOne == FIRST_COORDINATE_POINT) {
			matrix = horizontalAscendingXFirstEqualZeroYEqualZero(xOne, yOne, matrix);
		} else if ((yOne != FIRST_COORDINATE_POINT && yOne != LAST_COORDINATE_POINT)
				&& xOne == FIRST_COORDINATE_POINT) {
			matrix = horizontalAscendingXFirstEqualZeroAndYEqualZeroAndEqualNine(xOne, yOne, matrix);
		} else if (yOne == LAST_COORDINATE_POINT && xOne == FIRST_COORDINATE_POINT) {
			matrix = horizontalAscendingXFirstEqualZeroAndYEqualNine(xOne, yOne, matrix);
		} else if (yOne == LAST_COORDINATE_POINT
				&& (xOne != FIRST_COORDINATE_POINT && xFour != LAST_COORDINATE_POINT)) {
			matrix = horizontalAscendingXFourthNotEqualsNineAndXFirstNotEqualsZeroYEqualsNine(xOne, yOne, matrix);
		} else if (yOne == LAST_COORDINATE_POINT && xFour == LAST_COORDINATE_POINT) {
			matrix = horizontalAscendingXFourthEqualsNineAndYNine(xOne, yOne, matrix);
		} else if ((yOne != FIRST_COORDINATE_POINT && yOne != LAST_COORDINATE_POINT)
				&& xFour == LAST_COORDINATE_POINT) {
			matrix = horizontalAscendingXFourthNineAndYNotEqualsNineAndNotEqualsZero(xOne, yOne, matrix);
		} else if (yOne == FIRST_COORDINATE_POINT && xFour == LAST_COORDINATE_POINT) {
			matrix = horizontalAscendingXFourthEqualsNineAndYEqualsZero(xOne, yOne, matrix);
		} else if (yOne == FIRST_COORDINATE_POINT
				&& (xOne != FIRST_COORDINATE_POINT && xFour != LAST_COORDINATE_POINT)) {
			matrix = horizontalAscendingXFirstNotZeroAndXFourthNotNineYEqualsZero(xOne, yOne, matrix);
		}
		return matrix;
	}

	private String[][] placementHaloInHorizontalPositionAndWithCoordinatesDescending(int xOne, int yOne, int xFour,
			int yFour, String[][] matrix) {
		if ((yOne != LAST_COORDINATE_POINT && yOne != FIRST_COORDINATE_POINT)
				&& (xOne != LAST_COORDINATE_POINT && xFour != FIRST_COORDINATE_POINT)) {
			matrix = horizontalDescendingXFirstNotEqualNineXFourthNotEqualZeroYNotEqualZeroAndNine(xFour, yFour,
					matrix);
		} else if (yOne == FIRST_COORDINATE_POINT && xFour == FIRST_COORDINATE_POINT) {
			matrix = horizontalDescendingXFourthEqualZeroYEqualZero(xFour, yFour, matrix);
		} else if ((yOne != FIRST_COORDINATE_POINT && yOne != LAST_COORDINATE_POINT)
				&& xFour == FIRST_COORDINATE_POINT) {
			matrix = horizontalDescendingXFourthEqualZeroYNotEqualZeroAndNotEqualNine(xFour, yFour, matrix);
		} else if (yOne == LAST_COORDINATE_POINT && xFour == FIRST_COORDINATE_POINT) {
			matrix = horizontalDescendingXFourthZeroAndYEqualNine(xFour, yFour, matrix);
		} else if (yOne == LAST_COORDINATE_POINT
				&& (xOne != LAST_COORDINATE_POINT && xFour != FIRST_COORDINATE_POINT)) {
			matrix = horizontalDescendingXFirstNotEqualsNineAndXFourthNotEqualsZeroYEqualsNine(xFour, yFour, matrix);
		} else if (yOne == LAST_COORDINATE_POINT && xOne == LAST_COORDINATE_POINT) {
			matrix = horizontalDescendingXFirstNineAndYEqualsNine(xFour, yFour, matrix);
		} else if ((yOne != LAST_COORDINATE_POINT && yOne != FIRST_COORDINATE_POINT) && xOne == LAST_COORDINATE_POINT) {
			matrix = horizontalDescendingXFirstNineAndYNotEqualsNineAndNotEqualsZero(xFour, yFour, matrix);
		} else if (yOne == FIRST_COORDINATE_POINT && xOne == LAST_COORDINATE_POINT) {
			matrix = horizontalDescendingXFirstNineAndYEqualsZero(xFour, yFour, matrix);
		} else if (yOne == FIRST_COORDINATE_POINT
				&& (xOne != LAST_COORDINATE_POINT && xFour != FIRST_COORDINATE_POINT)) {
			matrix = horizontalDescendingXFirstNotEqualsNineAndXFourthNotEqualsZeroAndYEqualsZero(xFour, yFour, matrix);
		}
		return matrix;
	}

	private String[][] placementHaloInVerticalPositionAndWithCoordinatesInAscending(int xOne, int yOne, int yFour,
			String[][] matrix) {
		if ((yOne != FIRST_COORDINATE_POINT && yFour != LAST_COORDINATE_POINT)
				&& (xOne != FIRST_COORDINATE_POINT && xOne != LAST_COORDINATE_POINT)) {
			matrix = verticalAscendingXNotEqualsZeroAndNotEqualNineAndYFirstNotEqualZeroAndYFourthNotEqualNine(xOne,
					yOne, matrix);
		} else if (xOne == FIRST_COORDINATE_POINT && yOne == FIRST_COORDINATE_POINT) {
			matrix = verticalAscendingXEqualsZeroYFirstZero(xOne, yOne, matrix);
		} else if (xOne == FIRST_COORDINATE_POINT
				&& (yOne != FIRST_COORDINATE_POINT && yFour != LAST_COORDINATE_POINT)) {
			matrix = verticalAscendingXNotEqualZeroYFirstNotEqualZeroAndYFourthNotEqualNine(xOne, yOne, matrix);
		} else if (xOne == FIRST_COORDINATE_POINT && yFour == LAST_COORDINATE_POINT) {
			matrix = verticalAscendingXEqualsZeroYFourthEqualsNine(xOne, yOne, matrix);
		} else if ((xOne != FIRST_COORDINATE_POINT && xOne != LAST_COORDINATE_POINT)
				&& yFour == LAST_COORDINATE_POINT) {
			matrix = verticalAscendingXNotEqualZeroAndNotEqualsNineYFourthEqualNine(xOne, yOne, matrix);
		} else if (xOne == LAST_COORDINATE_POINT && yFour == LAST_COORDINATE_POINT) {
			matrix = verticalAscendingXEqualsNineYFourthEqualsNine(xOne, yOne, matrix);
		} else if ((yOne != FIRST_COORDINATE_POINT && yFour != LAST_COORDINATE_POINT)
				&& xOne == LAST_COORDINATE_POINT) {
			matrix = verticalAscendingXEqualsNineYFirstNotEqualsZeroAndYFourthNotEqualsNine(xOne, yOne, matrix);
		} else if (xOne == LAST_COORDINATE_POINT && yOne == FIRST_COORDINATE_POINT) {
			matrix = verticalAscendingXEqualsNineYFirstZero(xOne, yOne, matrix);
		} else if ((xOne != FIRST_COORDINATE_POINT && xOne != LAST_COORDINATE_POINT)
				&& yOne == FIRST_COORDINATE_POINT) {
			matrix = verticalAscendingXNotEqualsZeroAndNotEqualsNineYFirstZero(xOne, yOne, matrix);
		}
		return matrix;
	}

	private String[][] placementHaloInVerticalPositionAndWithCoordinatesInDescending(int xOne, int yOne, int xFour,
			int yFour, String[][] matrix) {
		if ((yOne != LAST_COORDINATE_POINT && yFour != FIRST_COORDINATE_POINT)
				&& (xOne != FIRST_COORDINATE_POINT && xOne != LAST_COORDINATE_POINT)) {
			matrix = verticalDescendingXNotEqualsZeroAndNotEqualsNineYFirstNotEqualNineAndYFourthNotEqualZero(xFour,
					yFour, matrix);
		} else if (xOne == FIRST_COORDINATE_POINT && yFour == FIRST_COORDINATE_POINT) {
			matrix = verticalDescendingXEqualsZeroYFourthEqualsZero(xFour, yFour, matrix);
		} else if (xOne == FIRST_COORDINATE_POINT
				&& (yFour != FIRST_COORDINATE_POINT && yOne != LAST_COORDINATE_POINT)) {
			matrix = verticalDescendingXEqualsZeroAndYFourthNotEqualsZeroYFirstNotEqualsNine(xFour, yFour, matrix);
		} else if (xOne == FIRST_COORDINATE_POINT && yOne == LAST_COORDINATE_POINT) {
			matrix = verticalDescendingXEqualsZeroYFirstEqualsNine(xFour, yFour, matrix);
		} else if ((xOne != FIRST_COORDINATE_POINT && xOne != LAST_COORDINATE_POINT) && yOne == LAST_COORDINATE_POINT) {
			matrix = verticalDescendingXNotEqualsZeroAndXFourthNotEqualsNineYFirstEqualsNine(xFour, yFour, matrix);
		} else if (xOne == LAST_COORDINATE_POINT && yOne == LAST_COORDINATE_POINT) {
			matrix = verticalDescendingXEqualsNineYFirstEqualsNine(xFour, yFour, matrix);
		} else if (xOne == LAST_COORDINATE_POINT
				&& (yOne != LAST_COORDINATE_POINT && yFour != FIRST_COORDINATE_POINT)) {
			matrix = verticalDescendingXEqualNineAndYFirstNotEqualNineYFourthNotEqualZero(xFour, yFour, matrix);
		} else if (xOne == LAST_COORDINATE_POINT && yFour == FIRST_COORDINATE_POINT) {
			matrix = verticalDescendingXEqualsNineYFourthEqualsZero(xFour, yFour, matrix);
		} else if ((xOne != FIRST_COORDINATE_POINT && xOne != LAST_COORDINATE_POINT)
				&& yFour == FIRST_COORDINATE_POINT) {
			matrix = verticalDescendingXNotEqualsZeroAndNotEqualsNineAndYFourthEqualsZero(xFour, yFour, matrix);
		}
		return matrix;
	}

	private String[][] horizontalAscendingXFirstNotEqualZeroXFourthNotEqualNineYNotEqualZeroOrNine(int xOne, int yOne,
			String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 4] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 4] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 4] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalAscendingXFirstEqualZeroYEqualZero(int xOne, int yOne, String[][] matrix) {
		matrix[yOne + 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 4] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 4] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalAscendingXFirstEqualZeroAndYEqualZeroAndEqualNine(int xOne, int yOne,
			String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 4] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 4] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 4] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalAscendingXFirstEqualZeroAndYEqualNine(int xOne, int yOne, String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 4] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 4] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalAscendingXFourthNotEqualsNineAndXFirstNotEqualsZeroYEqualsNine(int xOne, int yOne,
			String[][] matrix) {
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 4] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 4] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalAscendingXFourthEqualsNineAndYNine(int xOne, int yOne, String[][] matrix) {
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 3] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalAscendingXFourthNineAndYNotEqualsNineAndNotEqualsZero(int xOne, int yOne,
			String[][] matrix) {
		matrix[yOne - 1][xOne + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 3] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalAscendingXFourthEqualsNineAndYEqualsZero(int xOne, int yOne, String[][] matrix) {
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 3] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalAscendingXFirstNotZeroAndXFourthNotNineYEqualsZero(int xOne, int yOne,
			String[][] matrix) {
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 4] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 4] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXFirstNotEqualNineXFourthNotEqualZeroYNotEqualZeroAndNine(int xFour,
			int yFour, String[][] matrix) {
		matrix[yFour - 1][xFour] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour + 4] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour][xFour + 4] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 4] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXFourthEqualZeroYEqualZero(int xFour, int yFour, String[][] matrix) {
		matrix[yFour + 1][xFour] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 4] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour][xFour + 4] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXFourthEqualZeroYNotEqualZeroAndNotEqualNine(int xFour, int yFour,
			String[][] matrix) {
		matrix[yFour - 1][xFour] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour + 4] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour][xFour + 4] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 4] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXFourthZeroAndYEqualNine(int xFour, int yFour, String[][] matrix) {
		matrix[yFour - 1][xFour] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour + 4] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour][xFour + 4] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXFirstNotEqualsNineAndXFourthNotEqualsZeroYEqualsNine(int xFour, int yFour,
			String[][] matrix) {
		matrix[yFour][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour + 4] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour][xFour + 4] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXFirstNineAndYEqualsNine(int xFour, int yFour, String[][] matrix) {
		matrix[yFour][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour + 3] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXFirstNineAndYNotEqualsNineAndNotEqualsZero(int xFour, int yFour,
			String[][] matrix) {
		matrix[yFour - 1][xFour + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 3] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXFirstNineAndYEqualsZero(int xFour, int yFour, String[][] matrix) {
		matrix[yFour][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 3] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXFirstNotEqualsNineAndXFourthNotEqualsZeroAndYEqualsZero(int xFour,
			int yFour, String[][] matrix) {
		matrix[yFour][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 4] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour][xFour + 4] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalAscendingXNotEqualsZeroAndNotEqualNineAndYFirstNotEqualZeroAndYFourthNotEqualNine(
			int xOne, int yOne, String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 3][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 4][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 4][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 4][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 3][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalAscendingXEqualsZeroYFirstZero(int xOne, int yOne, String[][] matrix) {
		matrix[yOne][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 3][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 4][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 4][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalAscendingXNotEqualZeroYFirstNotEqualZeroAndYFourthNotEqualNine(int xOne, int yOne,
			String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 3][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 4][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 4][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalAscendingXEqualsZeroYFourthEqualsNine(int xOne, int yOne, String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 3][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalAscendingXNotEqualZeroAndNotEqualsNineYFourthEqualNine(int xOne, int yOne,
			String[][] matrix) {
		matrix[yOne + 3][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 3][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalAscendingXEqualsNineYFourthEqualsNine(int xOne, int yOne, String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 3][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalAscendingXEqualsNineYFirstNotEqualsZeroAndYFourthNotEqualsNine(int xOne, int yOne,
			String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 3][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 4][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 4][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalAscendingXEqualsNineYFirstZero(int xOne, int yOne, String[][] matrix) {
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 3][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 4][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 4][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalAscendingXNotEqualsZeroAndNotEqualsNineYFirstZero(int xOne, int yOne,
			String[][] matrix) {
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 3][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 4][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 4][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 4][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 3][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXNotEqualsZeroAndNotEqualsNineYFirstNotEqualNineAndYFourthNotEqualZero(
			int xFour, int yFour, String[][] matrix) {
		matrix[yFour - 1][xFour] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 2][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 3][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 4][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 4][xFour] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 4][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 3][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 2][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXEqualsZeroYFourthEqualsZero(int xFour, int yFour, String[][] matrix) {
		matrix[yFour][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 2][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 3][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 4][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 4][xFour] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXEqualsZeroAndYFourthNotEqualsZeroYFirstNotEqualsNine(int xFour, int yFour,
			String[][] matrix) {
		matrix[yFour - 1][xFour] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 2][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 3][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 4][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 4][xFour] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXEqualsZeroYFirstEqualsNine(int xFour, int yFour, String[][] matrix) {
		matrix[yFour - 1][xFour] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 2][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 3][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXNotEqualsZeroAndXFourthNotEqualsNineYFirstEqualsNine(int xFour, int yFour,
			String[][] matrix) {
		matrix[yFour + 3][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 2][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 2][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 3][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXEqualsNineYFirstEqualsNine(int xFour, int yFour, String[][] matrix) {
		matrix[yFour - 1][xFour] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 2][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 3][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXEqualNineAndYFirstNotEqualNineYFourthNotEqualZero(int xFour, int yFour,
			String[][] matrix) {
		matrix[yFour - 1][xFour] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour - 1][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 2][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 3][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 4][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 4][xFour] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXEqualsNineYFourthEqualsZero(int xFour, int yFour, String[][] matrix) {
		matrix[yFour][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 2][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 3][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 4][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 4][xFour] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXNotEqualsZeroAndNotEqualsNineAndYFourthEqualsZero(int xFour, int yFour,
			String[][] matrix) {
		matrix[yFour][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 2][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 3][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 4][xFour - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 4][xFour] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 4][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 3][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 2][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour + 1][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yFour][xFour + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}
}