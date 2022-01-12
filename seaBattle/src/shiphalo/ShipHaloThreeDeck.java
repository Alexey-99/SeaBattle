package shiphalo;

import entity.CellDesignation;

public class ShipHaloThreeDeck {
	private static final int LAST_COORDINATE_POINT = 9;
	private static final int FIRST_COORDINATE_POINT = 0;
	private static final int DIFFERENCE_BETWEEN_POINTS_ONE = 1;
	private static final int DIFFERENCE_BETWEEN_POINTS_TWO = 2;

	public ShipHaloThreeDeck() {
	}

	public String[][] haloPlacementAfterShipPlacement(String lineСoordinates, String[][] matrix) {
		String[] arrayTreeСoordinates = lineСoordinates.split(";");
		String lineXAndYNumbers = arrayTreeСoordinates[0] + "," + arrayTreeСoordinates[1] + ","
				+ arrayTreeСoordinates[2];
		String[] arrayLineXAndYNumbers = lineXAndYNumbers.split(",");
		int xOne = Integer.parseInt(arrayLineXAndYNumbers[0]);
		int yOne = Integer.parseInt(arrayLineXAndYNumbers[1]);
		int xTwo = Integer.parseInt(arrayLineXAndYNumbers[2]);
		int yTwo = Integer.parseInt(arrayLineXAndYNumbers[3]);
		int xThree = Integer.parseInt(arrayLineXAndYNumbers[4]);
		int yThree = Integer.parseInt(arrayLineXAndYNumbers[5]);
		if ((yOne == yTwo && yThree == yTwo) && ((xThree - xOne == DIFFERENCE_BETWEEN_POINTS_TWO)
				&& (xThree - xTwo == DIFFERENCE_BETWEEN_POINTS_ONE))) {
			matrix = placementHaloInHorizontalPositionAndWithCoordinatesInAscending(xOne, yOne, xThree, matrix);
		} else if ((yOne == yTwo && yThree == yTwo) && ((xOne - xThree == DIFFERENCE_BETWEEN_POINTS_TWO)
				&& (xOne - xTwo == DIFFERENCE_BETWEEN_POINTS_ONE))) {
			matrix = placementHaloInHorizontalPositionAndWithCoordinatesInDescending(xOne, yOne, xThree, yThree,
					matrix);
		} else if ((xOne == xTwo && xThree == xTwo) && ((yThree - yOne == DIFFERENCE_BETWEEN_POINTS_TWO)
				&& (yThree - yTwo == DIFFERENCE_BETWEEN_POINTS_ONE))) {
			matrix = placementHaloInVerticalPositionAndWithCoordinatesInAscending(xOne, yOne, yThree, matrix);
		} else if ((xOne == xTwo && xThree == xTwo) && ((yOne - yThree == DIFFERENCE_BETWEEN_POINTS_TWO)
				&& (yOne - yTwo == DIFFERENCE_BETWEEN_POINTS_ONE))) {
			matrix = placementHaloInVerticalPositionAndWithCoordinatesInDescending(xOne, yOne, xThree, yThree, matrix);
		}
		return matrix;
	}

	private String[][] placementHaloInHorizontalPositionAndWithCoordinatesInAscending(int xOne, int yOne, int xThree,
			String[][] matrix) {
		if ((yOne != FIRST_COORDINATE_POINT && yOne != LAST_COORDINATE_POINT)
				&& (xOne != FIRST_COORDINATE_POINT && xThree != LAST_COORDINATE_POINT)) {
			matrix = horizontalAscendingXFirstNotEqualZeroAndXThirdNotEqualNineAndYNotEqualNineAndNotEqualZero(xOne,
					yOne, matrix);
		} else if (yOne == FIRST_COORDINATE_POINT && xOne == FIRST_COORDINATE_POINT) {
			matrix = horizontalAscendingXFirstEqualsZeroAndYEqualsZero(xOne, yOne, matrix);
		} else if ((yOne != FIRST_COORDINATE_POINT && yOne != LAST_COORDINATE_POINT)
				&& xOne == FIRST_COORDINATE_POINT) {
			matrix = horizontalAscendingXFirstEqualsZeroAndYNotEqualsZeroAndNotEqualsNine(xOne, yOne, matrix);
		} else if (yOne == LAST_COORDINATE_POINT && xOne == FIRST_COORDINATE_POINT) {
			matrix = horizontalAscendingXFirstEqualZeroAndYEqualNine(xOne, yOne, matrix);
		} else if (yOne == LAST_COORDINATE_POINT
				&& (xOne != FIRST_COORDINATE_POINT && xThree != LAST_COORDINATE_POINT)) {
			matrix = horizontalAscendingXThirdEqualNineAndYNotEqualZeroAndNine(xOne, yOne, matrix);
		} else if (yOne == LAST_COORDINATE_POINT && xThree == LAST_COORDINATE_POINT) {
			matrix = horizontalAscendingXThirdEqualNineAndYEqualNine(xOne, yOne, matrix);
		} else if ((yOne != LAST_COORDINATE_POINT && yOne != FIRST_COORDINATE_POINT)
				&& xThree == LAST_COORDINATE_POINT) {
			matrix = horizontalAscendingXThirdEqualNineAndYNotEqualZeroAndNotEqualNine(xOne, yOne, matrix);
		} else if (yOne == FIRST_COORDINATE_POINT && xThree == LAST_COORDINATE_POINT) {
			matrix = horizontalAscendingXThirdEqualNineAndYEqualZero(xOne, yOne, matrix);
		} else if (yOne == FIRST_COORDINATE_POINT
				&& (xOne != FIRST_COORDINATE_POINT && xThree != LAST_COORDINATE_POINT)) {
			matrix = horizontalAscendingXFirstNotEqualZeroAndXThirdNotEqualNineYEqualZero(xOne, yOne, matrix);
		}
		return matrix;
	}

	private String[][] placementHaloInHorizontalPositionAndWithCoordinatesInDescending(int xOne, int yOne, int xThree,
			int yThree, String[][] matrix) {
		if ((yOne != LAST_COORDINATE_POINT && yOne != FIRST_COORDINATE_POINT)
				&& (xOne != LAST_COORDINATE_POINT && xThree != FIRST_COORDINATE_POINT)) {
			matrix = horizontalDescendingXFirstEqualNineXThirdNotEqualZeroAndYNotEqualZeroAndNotEqualNine(xThree,
					yThree, matrix);
		} else if (yOne == FIRST_COORDINATE_POINT && xThree == FIRST_COORDINATE_POINT) {
			matrix = horizontalDescendingXThirdEqualZeroAndYEqualZero(xThree, yThree, matrix);
		} else if ((yOne != FIRST_COORDINATE_POINT && yOne != LAST_COORDINATE_POINT)
				&& xThree == FIRST_COORDINATE_POINT) {
			matrix = horizontalDescendingXThirdNotEqualZeroAndYNotEqualsZeroAndNotEqualsNine(xThree, yThree, matrix);
		} else if (yOne == LAST_COORDINATE_POINT && xThree == FIRST_COORDINATE_POINT) {
			matrix = horizontalDescendingXThirdEqualsZeroAndYEqualsNine(xThree, yThree, matrix);
		} else if (yOne == LAST_COORDINATE_POINT
				&& (xOne != LAST_COORDINATE_POINT && xThree != FIRST_COORDINATE_POINT)) {
			matrix = horizontalDescendingXFirstNotEqualNineAndXThirdNotEqualZeroAndYEqualNine(xThree, yThree, matrix);
		} else if (yOne == LAST_COORDINATE_POINT && xOne == LAST_COORDINATE_POINT) {
			matrix = horizontalDescendingXFirstEqualsNineAndYEqualsNine(xThree, yThree, matrix);
		} else if ((yOne != LAST_COORDINATE_POINT && yOne != FIRST_COORDINATE_POINT) && xOne == LAST_COORDINATE_POINT) {
			matrix = horizontalDescendingXFirstEqualNineAndYNotEqualNineAndNotEqualZero(xThree, yThree, matrix);
		} else if (yOne == FIRST_COORDINATE_POINT && xOne == LAST_COORDINATE_POINT) {
			matrix = horizontalDescendingXFirstEqualNineAndYEqualZero(xThree, yThree, matrix);
		} else if (yOne == FIRST_COORDINATE_POINT
				&& (xOne != LAST_COORDINATE_POINT && xThree != FIRST_COORDINATE_POINT)) {
			matrix = horizontalDescendingXFirstNotEqualNineXThirdNotEqualZeroAndYEqualZero(xThree, yThree, matrix);
		}
		return matrix;
	}

	private String[][] placementHaloInVerticalPositionAndWithCoordinatesInAscending(int xOne, int yOne, int yThree,
			String[][] matrix) {
		if ((xOne != LAST_COORDINATE_POINT && xOne != FIRST_COORDINATE_POINT)
				&& (yOne != FIRST_COORDINATE_POINT && yThree != LAST_COORDINATE_POINT)) {
			matrix = verticalAscendingXNotEqualZeroAndNotEqualNineAndYFirstNotEqualZeroAndYThirdNotEqualNine(xOne, yOne,
					matrix);
		} else if (yOne == FIRST_COORDINATE_POINT && xOne == FIRST_COORDINATE_POINT) {
			matrix = verticalAscendingXEqualsZeroAndYFirstEqualsZero(xOne, yOne, matrix);
		} else if ((yOne != FIRST_COORDINATE_POINT && yThree != LAST_COORDINATE_POINT)
				&& xOne == FIRST_COORDINATE_POINT) {
			matrix = verticalAscendingXEqualZeroAndYFirstNotEqualZeroAndYThirdNotEqualNine(xOne, yOne, matrix);
		} else if (yThree == LAST_COORDINATE_POINT && xOne == FIRST_COORDINATE_POINT) {
			matrix = verticalAscendingXEqualsZeroAndYThirdEqualsNine(xOne, yOne, matrix);
		} else if (yThree == LAST_COORDINATE_POINT
				&& (xOne != LAST_COORDINATE_POINT && xOne != FIRST_COORDINATE_POINT)) {
			matrix = verticalAscendingXNotEqualNineAndNotEqualZeroAndYThirdEqualNine(xOne, yOne, matrix);
		} else if (yThree == LAST_COORDINATE_POINT && xOne == LAST_COORDINATE_POINT) {
			matrix = verticalAscendingXEqualsNineAndYThirdEqualsNine(xOne, yOne, matrix);
		} else if ((yOne != FIRST_COORDINATE_POINT && yThree != LAST_COORDINATE_POINT)
				&& xOne == LAST_COORDINATE_POINT) {
			matrix = verticalAscendingXEqualNineAndYThirdNotEqualNineAndYFirstNotEqualZero(xOne, yOne, matrix);
		} else if (yOne == FIRST_COORDINATE_POINT && xOne == LAST_COORDINATE_POINT) {
			matrix = verticalAscendingXEqualsNineAndYFirstEqualsZero(xOne, yOne, matrix);
		} else if (yOne == FIRST_COORDINATE_POINT
				&& (xOne != LAST_COORDINATE_POINT && xOne != FIRST_COORDINATE_POINT)) {
			matrix = verticalAscendingXNotEqualsZeroAndNotEqualsNineAndYFirstEqualsZero(xOne, yOne, matrix);
		}
		return matrix;
	}

	private String[][] placementHaloInVerticalPositionAndWithCoordinatesInDescending(int xOne, int yOne, int xThree,
			int yThree, String[][] matrix) {
		if ((yOne != LAST_COORDINATE_POINT && yThree != FIRST_COORDINATE_POINT)
				&& (xOne != LAST_COORDINATE_POINT && xOne != FIRST_COORDINATE_POINT)) {
			matrix = verticalDescendingXNotEqualsZeroAndNotEqualsNineAndYFirstNotEqualsNineAndYThirdNotEqualsZero(
					xThree, yThree, matrix);
		} else if (yThree == FIRST_COORDINATE_POINT && xOne == FIRST_COORDINATE_POINT) {
			matrix = verticalDescendingXEqualsZeroAndYThirdEqualsZero(xThree, yThree, matrix);
		} else if ((yOne != LAST_COORDINATE_POINT && yThree != FIRST_COORDINATE_POINT)
				&& xOne == FIRST_COORDINATE_POINT) {
			matrix = verticalDescendingXEqualsZeroAndYThirdNotEqualsZeroAndYFirstNotEqualsNine(xThree, yThree, matrix);
		} else if (yOne == LAST_COORDINATE_POINT && xOne == FIRST_COORDINATE_POINT) {
			matrix = verticalDescendingXEqualsZeroAndYFirstEqualsNine(xThree, yThree, matrix);
		} else if (yOne == LAST_COORDINATE_POINT && (xOne != FIRST_COORDINATE_POINT && xOne != LAST_COORDINATE_POINT)) {
			matrix = verticalDescendingXNotEqualNineAndNotEqualZeroAndYFirstEqualNine(xThree, yThree, matrix);
		} else if (yOne == LAST_COORDINATE_POINT && xOne == LAST_COORDINATE_POINT) {
			matrix = verticalDescendingXEqualsNineAndYFirstEqualsNine(xThree, yThree, matrix);
		} else if ((yOne != LAST_COORDINATE_POINT && yThree != FIRST_COORDINATE_POINT)
				&& xOne == LAST_COORDINATE_POINT) {
			matrix = verticalDescendingXEqualsNineAndYFirstNotEqualsNineAndYThirdNotEqualsZero(xThree, yThree, matrix);
		} else if (yThree == FIRST_COORDINATE_POINT && xOne == LAST_COORDINATE_POINT) {
			matrix = verticalDescendingXEqualsNineAndYFirstEqualsZero(xThree, yThree, matrix);
		} else if (yThree == FIRST_COORDINATE_POINT
				&& (xOne != FIRST_COORDINATE_POINT && xOne != LAST_COORDINATE_POINT)) {
			matrix = verticalDescendingXNotEqualsZeroAndNotEqualsNineAndYThirdEqualsZero(xThree, yThree, matrix);
		}
		return matrix;
	}

	private String[][] horizontalAscendingXFirstNotEqualZeroAndXThirdNotEqualNineAndYNotEqualNineAndNotEqualZero(
			int xOne, int yOne, String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalAscendingXFirstEqualsZeroAndYEqualsZero(int xOne, int yOne, String[][] matrix) {
		matrix[yOne + 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 3] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalAscendingXFirstEqualsZeroAndYNotEqualsZeroAndNotEqualsNine(int xOne, int yOne,
			String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 3] = CellDesignation.SHIP_HALO.getDesignation();
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
		matrix[yOne][xOne + 3] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalAscendingXThirdEqualNineAndYNotEqualZeroAndNine(int xOne, int yOne,
			String[][] matrix) {
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 3] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalAscendingXThirdEqualNineAndYEqualNine(int xOne, int yOne, String[][] matrix) {
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalAscendingXThirdEqualNineAndYNotEqualZeroAndNotEqualNine(int xOne, int yOne,
			String[][] matrix) {
		matrix[yOne - 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalAscendingXThirdEqualNineAndYEqualZero(int xOne, int yOne, String[][] matrix) {
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalAscendingXFirstNotEqualZeroAndXThirdNotEqualNineYEqualZero(int xOne, int yOne,
			String[][] matrix) {
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 3] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXFirstEqualNineXThirdNotEqualZeroAndYNotEqualZeroAndNotEqualNine(int xThree,
			int yThree, String[][] matrix) {
		matrix[yThree - 1][xThree] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree][xThree + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXThirdEqualZeroAndYEqualZero(int xThree, int yThree, String[][] matrix) {
		matrix[yThree + 1][xThree] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree][xThree + 3] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXThirdNotEqualZeroAndYNotEqualsZeroAndNotEqualsNine(int xThree, int yThree,
			String[][] matrix) {
		matrix[yThree - 1][xThree] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree][xThree + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXThirdEqualsZeroAndYEqualsNine(int xThree, int yThree, String[][] matrix) {
		matrix[yThree - 1][xThree] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree][xThree + 3] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXFirstNotEqualNineAndXThirdNotEqualZeroAndYEqualNine(int xThree, int yThree,
			String[][] matrix) {
		matrix[yThree][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree][xThree + 3] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXFirstEqualsNineAndYEqualsNine(int xThree, int yThree, String[][] matrix) {
		matrix[yThree][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree + 2] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXFirstEqualNineAndYNotEqualNineAndNotEqualZero(int xThree, int yThree,
			String[][] matrix) {
		matrix[yThree - 1][xThree + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree + 2] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXFirstEqualNineAndYEqualZero(int xThree, int yThree, String[][] matrix) {
		matrix[yThree][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree + 2] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] horizontalDescendingXFirstNotEqualNineXThirdNotEqualZeroAndYEqualZero(int xThree, int yThree,
			String[][] matrix) {
		matrix[yThree][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree + 2] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree + 3] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree][xThree + 3] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalAscendingXNotEqualZeroAndNotEqualNineAndYFirstNotEqualZeroAndYThirdNotEqualNine(int xOne,
			int yOne, String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 3][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 3][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 3][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
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
		matrix[yOne + 3][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 3][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalAscendingXEqualZeroAndYFirstNotEqualZeroAndYThirdNotEqualNine(int xOne, int yOne,
			String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 3][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 3][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalAscendingXEqualsZeroAndYThirdEqualsNine(int xOne, int yOne, String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalAscendingXNotEqualNineAndNotEqualZeroAndYThirdEqualNine(int xOne, int yOne,
			String[][] matrix) {
		matrix[yOne + 2][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalAscendingXEqualsNineAndYThirdEqualsNine(int xOne, int yOne, String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalAscendingXEqualNineAndYThirdNotEqualNineAndYFirstNotEqualZero(int xOne, int yOne,
			String[][] matrix) {
		matrix[yOne - 1][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne - 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 3][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 3][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalAscendingXEqualsNineAndYFirstEqualsZero(int xOne, int yOne, String[][] matrix) {
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 3][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 3][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalAscendingXNotEqualsZeroAndNotEqualsNineAndYFirstEqualsZero(int xOne, int yOne,
			String[][] matrix) {
		matrix[yOne][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 3][xOne - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 3][xOne] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 3][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 2][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne + 1][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yOne][xOne + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXNotEqualsZeroAndNotEqualsNineAndYFirstNotEqualsNineAndYThirdNotEqualsZero(
			int xThree, int yThree, String[][] matrix) {
		matrix[yThree - 1][xThree] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 2][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 3][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 3][xThree] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 3][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 2][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXEqualsZeroAndYThirdEqualsZero(int xThree, int yThree, String[][] matrix) {
		matrix[yThree][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 2][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 3][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 3][xThree] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXEqualsZeroAndYThirdNotEqualsZeroAndYFirstNotEqualsNine(int xThree, int yThree,
			String[][] matrix) {
		matrix[yThree - 1][xThree] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 2][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 3][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 3][xThree] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXEqualsZeroAndYFirstEqualsNine(int xThree, int yThree, String[][] matrix) {
		matrix[yThree - 1][xThree] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 2][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXNotEqualNineAndNotEqualZeroAndYFirstEqualNine(int xThree, int yThree,
			String[][] matrix) {
		matrix[yThree + 2][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 2][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXEqualsNineAndYFirstEqualsNine(int xThree, int yThree, String[][] matrix) {
		matrix[yThree - 1][xThree] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 2][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXEqualsNineAndYFirstNotEqualsNineAndYThirdNotEqualsZero(int xThree, int yThree,
			String[][] matrix) {
		matrix[yThree - 1][xThree] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree - 1][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 2][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 3][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 3][xThree] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXEqualsNineAndYFirstEqualsZero(int xThree, int yThree, String[][] matrix) {
		matrix[yThree][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 2][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 3][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 3][xThree] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}

	private String[][] verticalDescendingXNotEqualsZeroAndNotEqualsNineAndYThirdEqualsZero(int xThree, int yThree,
			String[][] matrix) {
		matrix[yThree][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 2][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 3][xThree - 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 3][xThree] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 3][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 2][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree + 1][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		matrix[yThree][xThree + 1] = CellDesignation.SHIP_HALO.getDesignation();
		return matrix;
	}
}