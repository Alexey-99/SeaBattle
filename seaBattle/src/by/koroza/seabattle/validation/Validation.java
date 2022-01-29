package by.koroza.seabattle.validation;

import by.koroza.seabattle.entity.CellDesignation;

public class Validation {
	private static final String COORDINATES_INCORRECTLY_ENTERED_NUMBER_ONE = "Некорректно введены координаты. 1";
	private static final String COORDINATES_INCORRECTLY_ENTERED_NUMBER_TWO = "Некорректно введены координаты. 2";
	private static final String COORDINATES_INCORRECTLY_ENTERED_NUMBER_THREE = "Некорректно введены координаты. 3";
	private static final String COORDINATES_INCORRECTLY_ENTERED_NUMBER_fOUR = "Некорректно введены координаты. 4";
	private static final String COORDINATES_INCORRECTLY_ENTERED_NUMBER_FIVE = "Некорректно введены координаты. 5";
	private static final String COORDINATES_INCORRECTLY_ENTERED_NUMBER_SIX = "Некорректно введены координаты. 6";
	private static final String COORDINATES_INCORRECTLY_ENTERED_NUMBER_SEVEN = "Некорректно введены координаты. 7";
	private static final String TO_POINT_BY_COORDINATES_Y_MISTAKE_NUMBER_EIGHT = "8 На точку по координатам: Y - ";
	private static final String X_AND_SPACE = " X - ";
	private static final String MISTAKE_NUMBER_EIGHT = " нельзя поставить корабль так как она занята либо "
			+ "радом с ней в близи 1 клетки находится корабль.";
	private static final String TO_POINT_BY_COORDINATES_Y_MISTAKE_NUMBER_FIVE = "5 На точку по координатам: Y - ";

	public boolean presenceFourCoordinatesPointsInFourDeck(String lineСoordinates) {
		boolean flagMatrix = true;
		String[] arrayFourСoordinates = lineСoordinates.split(";");
		if (arrayFourСoordinates.length == 4) {
			flagMatrix = true;
		} else {
			flagMatrix = false;
			System.out.println(COORDINATES_INCORRECTLY_ENTERED_NUMBER_ONE);
		}
		return flagMatrix;
	}

	public boolean presenceFourXAndYInFourCoordinatesInFourDeck(String lineСoordinates) {
		boolean flagMatrix = true;
		String[] array = lineСoordinates.split(";");
		String arrayLine = array[0] + "," + array[1] + "," + array[2] + "," + array[3];
		String[] arrayLines = arrayLine.split(",");
		if (arrayLines.length == 8) {
			flagMatrix = true;
		} else {
			flagMatrix = false;
			System.out.println(COORDINATES_INCORRECTLY_ENTERED_NUMBER_TWO);
		}
		return flagMatrix;
	}

	public boolean presenceNumbersInCoordinatesFromZeroToNineInFourDeck(String lineСoordinates) {
		boolean flagMatrix = true;
		String[] array = lineСoordinates.split(";");
		String arrayLine = array[0] + "," + array[1] + "," + array[2] + "," + array[3];
		String[] arrayLines = arrayLine.split(",");
		for (String element : arrayLines) {
			if ((element.equals("1") || element.equals("2")) || (element.equals("3") || element.equals("4"))
					|| (element.equals("5") || element.equals("6"))
					|| (element.equals("7") || element.equals("8") || (element.equals("9") || element.equals("0")))) {
			} else {
				flagMatrix = false;
				System.out.println(COORDINATES_INCORRECTLY_ENTERED_NUMBER_THREE);
			}
		}
		return flagMatrix;
	}

	public boolean presenceEqualityXsOrYsInFourDeck(String lineСoordinates) {
		boolean flagMatrix = true;
		String[] arrayFourСoordinates = lineСoordinates.split(";");
		String arrayLine = arrayFourСoordinates[0] + "," + arrayFourСoordinates[1] + "," + arrayFourСoordinates[2] + ","
				+ arrayFourСoordinates[3];
		String[] arrayLines = arrayLine.split(",");
		int xOne = Integer.parseInt(arrayLines[0]);
		int yOne = Integer.parseInt(arrayLines[1]);
		int xTwo = Integer.parseInt(arrayLines[2]);
		int yTwo = Integer.parseInt(arrayLines[3]);
		int xThree = Integer.parseInt(arrayLines[4]);
		int yThree = Integer.parseInt(arrayLines[5]);
		int xFour = Integer.parseInt(arrayLines[6]);
		int yFour = Integer.parseInt(arrayLines[7]);
		if ((xOne == xTwo && xThree == xFour && xTwo == xThree)
				|| (yOne == yTwo && yThree == yFour && yTwo == yThree)) {
			flagMatrix = true;
		} else {
			flagMatrix = false;
			System.out.println(COORDINATES_INCORRECTLY_ENTERED_NUMBER_fOUR);
		}
		return flagMatrix;
	}

	public boolean ascendingOrDescendingCoordinatesInFourDeck(String lineСoordinates) {
		boolean flagMatrix = true;
		String[] arrayFourСoordinates = lineСoordinates.split(";");
		String arrayLine = arrayFourСoordinates[0] + "," + arrayFourСoordinates[1] + "," + arrayFourСoordinates[2] + ","
				+ arrayFourСoordinates[3];
		String[] arrayLines = arrayLine.split(",");
		int xOne = Integer.parseInt(arrayLines[0]);
		int yOne = Integer.parseInt(arrayLines[1]);
		int xTwo = Integer.parseInt(arrayLines[2]);
		int yTwo = Integer.parseInt(arrayLines[3]);
		int xThree = Integer.parseInt(arrayLines[4]);
		int yThree = Integer.parseInt(arrayLines[5]);
		int xFour = Integer.parseInt(arrayLines[6]);
		int yFour = Integer.parseInt(arrayLines[7]);
		if (((yFour - yOne == 3) && (yThree - yTwo == 1) && (yFour - yThree == 1))
				|| ((xFour - xOne == 3) && (xThree - xTwo == 1) && (xFour - xThree == 1))
				|| ((yOne - yFour == 3) && (yTwo - yThree == 1) && (yOne - yTwo == 1))
				|| ((xOne - xFour == 3) && (xTwo - xThree == 1 && (xOne - xTwo == 1)))) {
			flagMatrix = true;
		} else {
			flagMatrix = false;
			System.out.println(COORDINATES_INCORRECTLY_ENTERED_NUMBER_FIVE);
		}
		return flagMatrix;
	}

	public boolean presenceTwoElementsInCoordinateInFourDeck(String lineСoordinates) {
		boolean flagMatrix = true;
		String[] arrayFourСoordinates = lineСoordinates.split(";");
		for (int i = 0; i < 4; i++) {
			String lineCootdinate = arrayFourСoordinates[i];
			String[] arrayXAndY = lineCootdinate.split(",");
			if (arrayXAndY.length == 2) {
			} else {
				flagMatrix = false;
				System.out.println(COORDINATES_INCORRECTLY_ENTERED_NUMBER_SIX);
			}
		}
		return flagMatrix;
	}

	public boolean presenceInXAndYCoordinateLessTenInFourDeck(String lineСoordinates) {
		boolean flagMatrix = true;
		String[] arrayFourСoordinates = lineСoordinates.split(";");
		for (int i = 0; i < 4; i++) {
			String lineCootdinate = arrayFourСoordinates[i];
			String[] arrayXAndY = lineCootdinate.split(",");
			int x = Integer.parseInt(arrayXAndY[0]);
			int y = Integer.parseInt(arrayXAndY[1]);
			if (x < 10 && y < 10) {
			} else {
				flagMatrix = false;
				System.out.println(COORDINATES_INCORRECTLY_ENTERED_NUMBER_SEVEN);
			}
		}
		return flagMatrix;
	}

	public boolean presenceFreeSpaceOnFieldAtSpecifiedCoordinatesInFourDeck(String lineСoordinates, String[][] matrix) {
		boolean flagMatrix = true;
		String[] arrayFourСoordinates = lineСoordinates.split(";");
		for (int i = 0; i < 4; i++) {
			String lineCootdinate = arrayFourСoordinates[i];
			String[] arrayXAndY = lineCootdinate.split(",");
			int x = Integer.parseInt(arrayXAndY[0]);
			int y = Integer.parseInt(arrayXAndY[1]);
			if (!matrix[y][x].equals(CellDesignation.FREE.getDesignation())
					|| matrix[y][x].equals(CellDesignation.SHIP_HALO.getDesignation())) {
				flagMatrix = false;
				System.out.println(
						TO_POINT_BY_COORDINATES_Y_MISTAKE_NUMBER_EIGHT + y + X_AND_SPACE + x + MISTAKE_NUMBER_EIGHT);
			}
		}
		return flagMatrix;
	}

	public boolean presenceThreeCoordinatesPointsInThreeDeck(String lineСoordinates) {
		boolean flagBuildMatrix = true;
		String[] arrayTreeСoordinates = lineСoordinates.split(";");
		if (arrayTreeСoordinates.length == 3) {
			flagBuildMatrix = true;
		} else {
			flagBuildMatrix = false;
			System.out.println(COORDINATES_INCORRECTLY_ENTERED_NUMBER_ONE);
		}
		return flagBuildMatrix;
	}

	public boolean presenceThreeXAndYInThreeCoordinatesInThreeDeck(String lineСoordinates) {
		boolean flagBuildMatrix = true;
		String[] arrayTreeСoordinates = lineСoordinates.split(";");
		String lineXAndYNumbers = arrayTreeСoordinates[0] + "," + arrayTreeСoordinates[1] + ","
				+ arrayTreeСoordinates[2];
		String[] arrayLineXAndYNumbers = lineXAndYNumbers.split(",");
		if (arrayLineXAndYNumbers.length == 6) {
			flagBuildMatrix = true;
		} else {
			flagBuildMatrix = false;
			System.out.println(COORDINATES_INCORRECTLY_ENTERED_NUMBER_TWO);
		}
		return flagBuildMatrix;
	}

	public boolean presenceNumbersInCoordinatesFromZeroToNineInThreeDeck(String lineСoordinates) {
		boolean flagBuildMatrix = true;
		String[] arrayTreeСoordinates = lineСoordinates.split(";");
		String lineXAndYNumbers = arrayTreeСoordinates[0] + "," + arrayTreeСoordinates[1] + ","
				+ arrayTreeСoordinates[2];
		String[] arrayLineXAndYNumbers = lineXAndYNumbers.split(",");
		for (String element : arrayLineXAndYNumbers) {
			if ((element.equals("1") || element.equals("2")) || (element.equals("3") || element.equals("4"))
					|| (element.equals("5") || element.equals("6"))
					|| (element.equals("7") || element.equals("8") || (element.equals("9") || element.equals("0")))) {
			} else {
				flagBuildMatrix = false;
				System.out.println(COORDINATES_INCORRECTLY_ENTERED_NUMBER_THREE);
			}
		}
		return flagBuildMatrix;
	}

	public boolean presenceEqualityXsOrYsInThreeDeck(String lineСoordinates) {
		boolean flagBuildMatrix = true;
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
		if ((xOne == xTwo && xThree == xOne) || (yOne == yTwo && yThree == yOne)) {
			flagBuildMatrix = true;
		} else {
			flagBuildMatrix = false;
			System.out.println(COORDINATES_INCORRECTLY_ENTERED_NUMBER_fOUR);
		}
		return flagBuildMatrix;
	}

	public boolean ascendingOrDescendingCoordinatesInThreeDeck(String lineСoordinates) {
		boolean flagBuildMatrix = true;
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
		if (((yThree - yOne == 2) && (yThree - yTwo == 1)) || ((xThree - xOne == 2) && (xThree - xTwo == 1))
				|| ((yOne - yThree == 2) && (yTwo - yThree == 1)) || ((xOne - xThree == 2) && (xTwo - xThree == 1))) {
			flagBuildMatrix = true;
		} else {
			flagBuildMatrix = false;
			System.out.println(COORDINATES_INCORRECTLY_ENTERED_NUMBER_FIVE);
		}
		return flagBuildMatrix;
	}

	public boolean presenceTwoElementsInCoordinateInThreeDeck(String lineСoordinates) {
		boolean flagBuildMatrix = true;
		String[] arrayTreeСoordinates = lineСoordinates.split(";");
		for (int i = 0; i < 3; i++) {
			String lineTreeСoordinates = arrayTreeСoordinates[i];
			String[] arrayСoordinateXAndY = lineTreeСoordinates.split(",");
			if (arrayСoordinateXAndY.length == 2) {
			} else {
				flagBuildMatrix = false;
				System.out.println(COORDINATES_INCORRECTLY_ENTERED_NUMBER_SIX);
			}
		}
		return flagBuildMatrix;
	}

	public boolean presenceInXAndYCoordinateLessTenInThreeDeck(String lineСoordinates) {
		boolean flagBuildMatrix = true;
		String[] arrayTreeСoordinates = lineСoordinates.split(";");
		for (int i = 0; i < 3; i++) {
			String lineTreeСoordinates = arrayTreeСoordinates[i];
			String[] arrayСoordinateXAndY = lineTreeСoordinates.split(",");
			int x = Integer.parseInt(arrayСoordinateXAndY[0]);
			int y = Integer.parseInt(arrayСoordinateXAndY[1]);
			if (x < 10 && y < 10) {
			} else {
				flagBuildMatrix = false;
				System.out.println(COORDINATES_INCORRECTLY_ENTERED_NUMBER_SEVEN);
			}
		}
		return flagBuildMatrix;
	}

	public boolean presenceFreeSpaceOnFieldAtSpecifiedCoordinatesInThreeDeck(String lineСoordinates,
			String[][] matrix) {
		boolean flagBuildMatrix = true;
		String[] arrayTreeСoordinates = lineСoordinates.split(";");
		for (int i = 0; i < 3; i++) {
			String lineTreeСoordinates = arrayTreeСoordinates[i];
			String[] arrayСoordinateXAndY = lineTreeСoordinates.split(",");
			int x = Integer.parseInt(arrayСoordinateXAndY[0]);
			int y = Integer.parseInt(arrayСoordinateXAndY[1]);
			if (!matrix[y][x].equals(CellDesignation.FREE.getDesignation())
					|| matrix[y][x].equals(CellDesignation.SHIP_HALO.getDesignation())) {
				flagBuildMatrix = false;
				System.out.println(
						TO_POINT_BY_COORDINATES_Y_MISTAKE_NUMBER_EIGHT + y + X_AND_SPACE + x + MISTAKE_NUMBER_EIGHT);
			}
		}
		return flagBuildMatrix;
	}

	public boolean presenceTwoCoordinatesPointsInTwoDeck(String lineСoordinates) {
		boolean flagBuildMatrix = true;
		String[] arrayTwoСoordinates = lineСoordinates.split(";");
		if (arrayTwoСoordinates.length == 2) {
			flagBuildMatrix = true;
		} else {
			flagBuildMatrix = false;
			System.out.println(COORDINATES_INCORRECTLY_ENTERED_NUMBER_ONE);
		}
		return flagBuildMatrix;
	}

	public boolean presenceTwoXAndYInFourCoordinatesInTwoDeck(String lineСoordinates) {
		boolean flagBuildMatrix = true;
		String[] arrayTwoСoordinates = lineСoordinates.split(";");
		String lineXAndYNumbers = arrayTwoСoordinates[0] + "," + arrayTwoСoordinates[1];
		String[] arrayLineXAndYNumbers = lineXAndYNumbers.split(",");
		if (arrayLineXAndYNumbers.length == 4) {
			flagBuildMatrix = true;
		} else {
			flagBuildMatrix = false;
			System.out.println(COORDINATES_INCORRECTLY_ENTERED_NUMBER_TWO);
		}
		return flagBuildMatrix;
	}

	public boolean presenceNumbersInCoordinatesFromZeroToNineInTwoDeck(String lineСoordinates) {
		boolean flagBuildMatrix = true;
		String[] arrayTwoСoordinates = lineСoordinates.split(";");
		String lineXAndYNumbers = arrayTwoСoordinates[0] + "," + arrayTwoСoordinates[1];
		String[] arrayLineXAndYNumbers = lineXAndYNumbers.split(",");
		for (String element : arrayLineXAndYNumbers) {
			if ((element.equals("1") || element.equals("2")) || (element.equals("3") || element.equals("4"))
					|| (element.equals("5") || element.equals("6"))
					|| (element.equals("7") || element.equals("8") || (element.equals("9") || element.equals("0")))) {
			} else {
				flagBuildMatrix = false;
				System.out.println(COORDINATES_INCORRECTLY_ENTERED_NUMBER_THREE);
			}
		}
		return flagBuildMatrix;
	}

	public boolean presenceEqualityXsOrYsInTwoDeck(String lineСoordinates) {
		boolean flagBuildMatrix = true;
		String[] arrayTwoСoordinates = lineСoordinates.split(";");
		String lineXAndYNumbers = arrayTwoСoordinates[0] + "," + arrayTwoСoordinates[1];
		String[] arrayLineXAndYNumbers = lineXAndYNumbers.split(",");
		int xOne = Integer.parseInt(arrayLineXAndYNumbers[0]);
		int yOne = Integer.parseInt(arrayLineXAndYNumbers[1]);
		int xTwo = Integer.parseInt(arrayLineXAndYNumbers[2]);
		int yTwo = Integer.parseInt(arrayLineXAndYNumbers[3]);
		if ((xOne == xTwo) || (yOne == yTwo)) {
			flagBuildMatrix = true;
		} else {
			flagBuildMatrix = false;
			System.out.println(COORDINATES_INCORRECTLY_ENTERED_NUMBER_fOUR);
		}
		return flagBuildMatrix;
	}

	public boolean ascendingOrDescendingCoordinatesInTwoDeck(String lineСoordinates) {
		boolean flagBuildMatrix = true;
		String[] arrayTwoСoordinates = lineСoordinates.split(";");
		String lineXAndYNumbers = arrayTwoСoordinates[0] + "," + arrayTwoСoordinates[1];
		String[] arrayLineXAndYNumbers = lineXAndYNumbers.split(",");
		int xOne = Integer.parseInt(arrayLineXAndYNumbers[0]);
		int yOne = Integer.parseInt(arrayLineXAndYNumbers[1]);
		int xTwo = Integer.parseInt(arrayLineXAndYNumbers[2]);
		int yTwo = Integer.parseInt(arrayLineXAndYNumbers[3]);
		if (((yTwo - yOne == 1) || (xTwo - xOne == 1)) || ((yOne - yTwo == 1) || (xOne - xTwo == 1))) {
			flagBuildMatrix = true;
		} else {
			flagBuildMatrix = false;
			System.out.println(COORDINATES_INCORRECTLY_ENTERED_NUMBER_FIVE);
		}
		return flagBuildMatrix;
	}

	public boolean presenceTwoElementsInCoordinateInTwoDeck(String lineСoordinates) {
		boolean flagBuildMatrix = true;
		String[] arrayTwoСoordinates = lineСoordinates.split(";");
		for (int i = 0; i < 2; i++) {
			String lineСoordinatePoint = arrayTwoСoordinates[i];
			String[] arrayСoordinateXAndY = lineСoordinatePoint.split(",");
			if (arrayСoordinateXAndY.length == 2) {
			} else {
				flagBuildMatrix = false;
				System.out.println(COORDINATES_INCORRECTLY_ENTERED_NUMBER_SIX);
			}
		}
		return flagBuildMatrix;
	}

	public boolean presenceInXAndYCoordinateLessTenInTwoDeck(String lineСoordinates) {
		boolean flagBuildMatrix = true;
		String[] arrayTwoСoordinates = lineСoordinates.split(";");
		for (int i = 0; i < 2; i++) {
			String lineСoordinatePoint = arrayTwoСoordinates[i];
			String[] arrayСoordinateXAndY = lineСoordinatePoint.split(",");
			int x = Integer.parseInt(arrayСoordinateXAndY[0]);
			int y = Integer.parseInt(arrayСoordinateXAndY[1]);
			if (x < 10 && y < 10) {
			} else {
				flagBuildMatrix = false;
				System.out.println(COORDINATES_INCORRECTLY_ENTERED_NUMBER_SEVEN);
			}
		}
		return flagBuildMatrix;
	}

	public boolean presenceFreeSpaceOnFieldAtSpecifiedCoordinatesInTwoDeck(String lineСoordinates, String[][] matrix) {
		boolean flagBuildMatrix = true;
		String[] arrayTwoСoordinates = lineСoordinates.split(";");
		for (int i = 0; i < 2; i++) {
			String lineСoordinatePoint = arrayTwoСoordinates[i];
			String[] arrayСoordinateXAndY = lineСoordinatePoint.split(",");
			int x = Integer.parseInt(arrayСoordinateXAndY[0]);
			int y = Integer.parseInt(arrayСoordinateXAndY[1]);
			if (!matrix[y][x].equals(CellDesignation.FREE.getDesignation())
					|| matrix[y][x].equals(CellDesignation.SHIP_HALO.getDesignation())) {
				flagBuildMatrix = false;
				System.out.println(
						TO_POINT_BY_COORDINATES_Y_MISTAKE_NUMBER_EIGHT + y + X_AND_SPACE + x + MISTAKE_NUMBER_EIGHT);
			}
		}
		return flagBuildMatrix;
	}

	public boolean presenceOneCoordinatesPointsInOneDeck(String lineСoordinates) {
		boolean flagBuildMatrix = true;
		String[] arrayOneСoordinates = lineСoordinates.split(";");
		if (arrayOneСoordinates.length == 1) {
			flagBuildMatrix = true;
		} else {
			flagBuildMatrix = false;
			System.out.println(COORDINATES_INCORRECTLY_ENTERED_NUMBER_ONE);
		}
		return flagBuildMatrix;
	}

	public boolean presenceOneXAndYInOneCoordinateInOneDeck(String lineСoordinates) {
		boolean flagBuildMatrix = true;
		String[] arrayXAndYNumbers = lineСoordinates.split(",");
		if (arrayXAndYNumbers.length == 2) {
			flagBuildMatrix = true;
		} else {
			flagBuildMatrix = false;
			System.out.println(COORDINATES_INCORRECTLY_ENTERED_NUMBER_TWO);
		}
		return flagBuildMatrix;
	}

	public boolean presenceNumbersInCoordinateFromZeroToNineInOneDeck(String lineСoordinates) {
		boolean flagBuildMatrix = true;
		String[] arrayXAndYNumbers = lineСoordinates.split(",");
		for (String element : arrayXAndYNumbers) {
			if ((element.equals("1") || element.equals("2")) || (element.equals("3") || element.equals("4"))
					|| (element.equals("5") || element.equals("6"))
					|| (element.equals("7") || element.equals("8") || (element.equals("9") || element.equals("0")))) {
			} else {
				flagBuildMatrix = false;
				System.out.println(COORDINATES_INCORRECTLY_ENTERED_NUMBER_THREE);
			}
		}
		return flagBuildMatrix;
	}

	public boolean presenceInXAndYCoordinateLessTenInOneDeck(String lineСoordinates) {
		boolean flagBuildMatrix = true;
		String[] arrayXAndYNumbers = lineСoordinates.split(",");
		int x = Integer.parseInt(arrayXAndYNumbers[0]);
		int y = Integer.parseInt(arrayXAndYNumbers[1]);
		if (x < 10 && y < 10) {
			flagBuildMatrix = true;
		} else {
			flagBuildMatrix = false;
			System.out.println(COORDINATES_INCORRECTLY_ENTERED_NUMBER_fOUR);
		}
		return flagBuildMatrix;
	}

	public boolean presenceFreeSpaceOnFieldAtSpecifiedCoordinatesInOneDeck(String lineСoordinates, String[][] matrix) {
		boolean flagBuildMatrix = true;
		String[] arrayXAndYNumbers = lineСoordinates.split(",");
		int x = Integer.parseInt(arrayXAndYNumbers[0]);
		int y = Integer.parseInt(arrayXAndYNumbers[1]);
		if (!matrix[y][x].equals(CellDesignation.FREE.getDesignation())
				|| matrix[y][x].equals(CellDesignation.SHIP_HALO.getDesignation())) {
			flagBuildMatrix = false;
			System.out.println(
					TO_POINT_BY_COORDINATES_Y_MISTAKE_NUMBER_FIVE + y + X_AND_SPACE + x + MISTAKE_NUMBER_EIGHT);
		}
		return flagBuildMatrix;
	}

	public boolean presenceRepetitiveMoves(String lineСoordinates, String[][] playingFieldOpponent) {
		boolean flagBuildMatrix = true;
		String[] arrayXAndYNumbers = lineСoordinates.split(",");
		int x = Integer.parseInt(arrayXAndYNumbers[0]);
		int y = Integer.parseInt(arrayXAndYNumbers[1]);
		if (playingFieldOpponent[y][x].equals(CellDesignation.WOUNDED.getDesignation())
				|| playingFieldOpponent[y][x].equals(CellDesignation.FREE.getDesignation())) {
			flagBuildMatrix = false;
			System.out.println("Вы по этим координатам стреляли ранее");
		} else if (playingFieldOpponent[y][x].equals(CellDesignation.SHIP_HALO.getDesignation())) {
			flagBuildMatrix = false;
			System.out.println("По этим координатам находится ОРЕОЛ");
		}
		return flagBuildMatrix;
	}

	public int checkArrayBusy(String[] arrayCoordinatesShip) {
		int countElementNotNull = 0;
		for (String element : arrayCoordinatesShip) {
			if (element != null) {
				countElementNotNull++;
			}
		}
		return countElementNotNull;
	}
}