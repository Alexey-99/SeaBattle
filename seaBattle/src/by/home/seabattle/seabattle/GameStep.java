package by.home.seabattle.seabattle;

import by.home.seabattle.entity.Player;
import by.home.seabattle.validation.Validation;

public class GameStep {
	private static final String X_AND_SPACE = " X - ";
	private static final String SPACE_AND_Y_AND_SPACE = " , Y - ";
	private static final String THE_PLAYER = " У игрока: ";

	public void gameStep(Player player, Player opponent) {
		boolean flagWhile = true;
		while (flagWhile) {
			Validation validation = new Validation();
			String lineCoordinate;
			String[] arrayCoordinatesShip = new String[8];
			boolean flagKill = true;
			boolean flagMiss = true;
			int size = 0;
			lineCoordinate = player.hitCoordinateInput();
			flagMiss = player.getPlayingField().checkForMiss(lineCoordinate, opponent);
			if (flagMiss == true) {
				missDuringTurn(lineCoordinate, player, opponent);
			} else if (flagMiss == false) {
				opponent.getPlayingField().markBoxWounded(lineCoordinate, opponent);
				player.getPlayingFieldOpponent().markBoxWounded(lineCoordinate, player);
				player.increaseWoundCounterByOne();
				arrayCoordinatesShip = player.getPlayingField().checkShipKillOrWoundReturnArray(arrayCoordinatesShip,
						lineCoordinate, opponent);
				flagKill = player.getPlayingField().checkShipKillOrWoundReturnFlag(lineCoordinate, opponent);
				if (flagKill == false) {
					player.getPlayingFieldOpponent().fieldPrint();
					System.out.println("Ранен корабль по координатам: [" + X_AND_SPACE + arrayCoordinatesShip[0]
							+ SPACE_AND_Y_AND_SPACE + arrayCoordinatesShip[1] + "]");
				} else if (flagKill == true) {
					size = validation.checkArrayBusy(arrayCoordinatesShip);
					if (size == 2) {
						printAndplacementHaloKillOneDeck(arrayCoordinatesShip, player, opponent);
					} else if (size == 4) {
						printAndplacementHaloKillTwoDeckInTwoPositions(arrayCoordinatesShip, player, opponent);
					} else if (size == 6) {
						printAndplacementHaloKillThreeDeckInTwoPositions(arrayCoordinatesShip, player, opponent);
					} else if (size == 8) {
						printAndplacementHaloKillFourDeckInTwoPositions(arrayCoordinatesShip, player, opponent);
					}
				}
			}
			if ((flagMiss == false) && (player.getCounterWounds() < 20)) {
				flagWhile = true;
			} else {
				flagWhile = false;
			}
		}
	}

	private void missDuringTurn(String lineCoordinate, Player player, Player opponent) {
		opponent.getPlayingField().markBoxFree(lineCoordinate, opponent);
		player.getPlayingFieldOpponent().markBoxFree(lineCoordinate, player);
		player.getPlayingFieldOpponent().fieldPrint();
		System.out.println("Мимо");
	}

	private void printAndplacementHaloKillOneDeck(String[] arrayCoordinatesShip, Player player, Player opponent) {
		String xString = arrayCoordinatesShip[0];
		String yString = arrayCoordinatesShip[1];
		String lineCoordinates = xString + "," + yString;
		placementHaloAfterKillOneDeck(lineCoordinates, player, opponent);
		player.getPlayingFieldOpponent().fieldPrint();
		printKillOneDeck(xString, yString, opponent);

	}

	private void printAndplacementHaloKillTwoDeckInTwoPositions(String[] arrayCoordinatesShip, Player player,
			Player opponent) {
		if (arrayCoordinatesShip[0].equals(arrayCoordinatesShip[2])) {
			printAndplacementHaloKillTwoDeckInVerticalPosition(arrayCoordinatesShip, player, opponent);
		} else if (arrayCoordinatesShip[1].equals(arrayCoordinatesShip[3])) {
			printAndplacementHaloKillTwoDeckInHorizontalPosition(arrayCoordinatesShip, player, opponent);
		}
	}

	private void printAndplacementHaloKillThreeDeckInTwoPositions(String[] arrayCoordinatesShip, Player player,
			Player opponent) {
		if (arrayCoordinatesShip[0].equals(arrayCoordinatesShip[2])
				&& arrayCoordinatesShip[4].equals(arrayCoordinatesShip[0])) {
			printAndplacementHaloKillThreeDeckInVerticalPosition(arrayCoordinatesShip, player, opponent);
		} else if (arrayCoordinatesShip[1].equals(arrayCoordinatesShip[3])
				&& arrayCoordinatesShip[5].equals(arrayCoordinatesShip[1])) {
			printAndplacementHaloKillThreeDeckInHorizontalPosition(arrayCoordinatesShip, player, opponent);
		}
	}

	private void printAndplacementHaloKillFourDeckInTwoPositions(String[] arrayCoordinatesShip, Player player,
			Player opponent) {
		if ((arrayCoordinatesShip[0].equals(arrayCoordinatesShip[2])
				&& arrayCoordinatesShip[4].equals(arrayCoordinatesShip[6]))
				&& arrayCoordinatesShip[0].equals(arrayCoordinatesShip[6])) {
			printAndplacementHaloKillFourDeckInVerticalPosition(arrayCoordinatesShip, player, opponent);
		} else if ((arrayCoordinatesShip[1].equals(arrayCoordinatesShip[3])
				&& arrayCoordinatesShip[5].equals(arrayCoordinatesShip[7]))
				&& arrayCoordinatesShip[1].equals(arrayCoordinatesShip[7])) {
			printAndplacementHaloKillFourDeckInHorizontalPosition(arrayCoordinatesShip, player, opponent);
		}
	}

	private void printAndplacementHaloKillTwoDeckInVerticalPosition(String[] arrayCoordinatesShip, Player player,
			Player opponent) {
		int[] coordinates = new int[2];
		coordinates[0] = Integer.parseInt(arrayCoordinatesShip[1]);
		coordinates[1] = Integer.parseInt(arrayCoordinatesShip[3]);
		sortingNumbersArray(coordinates);
		String xStringOne = arrayCoordinatesShip[0];
		String yStringOne = Integer.toString(coordinates[0]);
		String xStringTwo = arrayCoordinatesShip[2];
		String yStringTwo = Integer.toString(coordinates[1]);
		String lineCoordinates = xStringOne + "," + yStringOne + ";" + xStringTwo + "," + yStringTwo;
		placementHaloAfterKillTwoDeck(lineCoordinates, player, opponent);
		player.getPlayingFieldOpponent().fieldPrint();
		printKillTwoDeck(lineCoordinates, opponent);
	}

	private void printAndplacementHaloKillTwoDeckInHorizontalPosition(String[] arrayCoordinatesShip, Player player,
			Player opponent) {
		int[] coordinates = new int[2];
		coordinates[0] = Integer.parseInt(arrayCoordinatesShip[0]);
		coordinates[1] = Integer.parseInt(arrayCoordinatesShip[2]);
		coordinates = sortingNumbersArray(coordinates);
		String xStringOne = Integer.toString(coordinates[0]);
		String yStringOne = arrayCoordinatesShip[1];
		String xStringTwo = Integer.toString(coordinates[1]);
		String yStringTwo = arrayCoordinatesShip[3];
		String lineCoordinates = xStringOne + "," + yStringOne + ";" + xStringTwo + "," + yStringTwo;
		placementHaloAfterKillTwoDeck(lineCoordinates, player, opponent);
		player.getPlayingFieldOpponent().fieldPrint();
		printKillTwoDeck(lineCoordinates, opponent);
	}

	private void printAndplacementHaloKillThreeDeckInVerticalPosition(String[] arrayCoordinatesShip, Player player,
			Player opponent) {
		int[] coordinates = new int[3];
		coordinates[0] = Integer.parseInt(arrayCoordinatesShip[1]);
		coordinates[1] = Integer.parseInt(arrayCoordinatesShip[3]);
		coordinates[2] = Integer.parseInt(arrayCoordinatesShip[5]);
		coordinates = sortingNumbersArray(coordinates);
		String xStringOne = arrayCoordinatesShip[0];
		String yStringOne = Integer.toString(coordinates[0]);
		String xStringTwo = arrayCoordinatesShip[2];
		String yStringTwo = Integer.toString(coordinates[1]);
		String xStringThree = arrayCoordinatesShip[4];
		String yStringThree = Integer.toString(coordinates[2]);
		String lineCoordinates = xStringOne + "," + yStringOne + ";" + xStringTwo + "," + yStringTwo + ";"
				+ xStringThree + "," + yStringThree;
		placementHaloAfterKillThreeDeck(lineCoordinates, player, opponent);
		player.getPlayingFieldOpponent().fieldPrint();
		printKillThreeDeck(lineCoordinates, opponent);
	}

	private void printAndplacementHaloKillThreeDeckInHorizontalPosition(String[] arrayCoordinatesShip, Player player,
			Player opponent) {
		int[] coordinates = new int[3];
		coordinates[0] = Integer.parseInt(arrayCoordinatesShip[0]);
		coordinates[1] = Integer.parseInt(arrayCoordinatesShip[2]);
		coordinates[2] = Integer.parseInt(arrayCoordinatesShip[4]);
		coordinates = sortingNumbersArray(coordinates);
		String xStringOne = Integer.toString(coordinates[0]);
		String yStringOne = arrayCoordinatesShip[1];
		String xStringTwo = Integer.toString(coordinates[1]);
		String yStringTwo = arrayCoordinatesShip[3];
		String xStringThree = Integer.toString(coordinates[2]);
		String yStringThree = arrayCoordinatesShip[5];
		String lineCoordinates = xStringOne + "," + yStringOne + ";" + xStringTwo + "," + yStringTwo + ";"
				+ xStringThree + "," + yStringThree;
		placementHaloAfterKillThreeDeck(lineCoordinates, player, opponent);
		player.getPlayingFieldOpponent().fieldPrint();
		printKillThreeDeck(lineCoordinates, opponent);
	}

	private void printAndplacementHaloKillFourDeckInVerticalPosition(String[] arrayCoordinatesShip, Player player,
			Player opponent) {
		int[] coordinates = new int[4];
		coordinates[0] = Integer.parseInt(arrayCoordinatesShip[1]);
		coordinates[1] = Integer.parseInt(arrayCoordinatesShip[3]);
		coordinates[2] = Integer.parseInt(arrayCoordinatesShip[5]);
		coordinates[3] = Integer.parseInt(arrayCoordinatesShip[7]);
		coordinates = sortingNumbersArray(coordinates);
		String xStringOne = arrayCoordinatesShip[0];
		String yStringOne = Integer.toString(coordinates[0]);
		String xStringTwo = arrayCoordinatesShip[2];
		String yStringTwo = Integer.toString(coordinates[1]);
		String xStringThree = arrayCoordinatesShip[4];
		String yStringThree = Integer.toString(coordinates[2]);
		String xStringFour = arrayCoordinatesShip[6];
		String yStringFour = Integer.toString(coordinates[3]);
		String lineCoordinates = xStringOne + "," + yStringOne + ";" + xStringTwo + "," + yStringTwo + ";"
				+ xStringThree + "," + yStringThree + ";" + xStringFour + "," + yStringFour;
		placementHaloAfterKillFourDeck(lineCoordinates, player, opponent);
		player.getPlayingFieldOpponent().fieldPrint();
		printKillFourDeck(lineCoordinates, opponent);
	}

	private void printAndplacementHaloKillFourDeckInHorizontalPosition(String[] arrayCoordinatesShip, Player player,
			Player opponent) {
		int[] coordinates = new int[4];
		coordinates[0] = Integer.parseInt(arrayCoordinatesShip[0]);
		coordinates[1] = Integer.parseInt(arrayCoordinatesShip[2]);
		coordinates[2] = Integer.parseInt(arrayCoordinatesShip[4]);
		coordinates[3] = Integer.parseInt(arrayCoordinatesShip[6]);
		coordinates = sortingNumbersArray(coordinates);
		String xStringOne = Integer.toString(coordinates[0]);
		String yStringOne = arrayCoordinatesShip[1];
		String xStringTwo = Integer.toString(coordinates[1]);
		String yStringTwo = arrayCoordinatesShip[3];
		String xStringThree = Integer.toString(coordinates[2]);
		String yStringThree = arrayCoordinatesShip[5];
		String xStringFour = Integer.toString(coordinates[3]);
		String yStringFour = arrayCoordinatesShip[7];
		String lineCoordinates = xStringOne + "," + yStringOne + ";" + xStringTwo + "," + yStringTwo + ";"
				+ xStringThree + "," + yStringThree + ";" + xStringFour + "," + yStringFour;
		placementHaloAfterKillFourDeck(lineCoordinates, player, opponent);
		player.getPlayingFieldOpponent().fieldPrint();
		printKillFourDeck(lineCoordinates, opponent);
	}

	private void placementHaloAfterKillOneDeck(String lineCoordinates, Player player, Player opponent) {
		player.getPlayingField().placementHaloAroundKillOneDeck(lineCoordinates, opponent);
		player.getPlayingFieldOpponent().placementHaloAroundKillOneDeck(lineCoordinates, player);
	}

	private void placementHaloAfterKillTwoDeck(String lineCoordinates, Player player, Player opponent) {
		player.getPlayingField().placementHaloAroundKillTwoDeck(lineCoordinates, opponent);
		player.getPlayingFieldOpponent().placementHaloAroundKillTwoDeck(lineCoordinates, player);
	}

	private void placementHaloAfterKillThreeDeck(String lineCoordinates, Player player, Player opponent) {
		player.getPlayingField().placementHaloAroundKillThreeDeck(lineCoordinates, opponent);
		player.getPlayingFieldOpponent().placementHaloAroundKillThreeDeck(lineCoordinates, player);
	}

	private void placementHaloAfterKillFourDeck(String lineCoordinates, Player player, Player opponent) {
		player.getPlayingField().placementHaloAroundKillFourDeck(lineCoordinates, opponent);
		player.getPlayingFieldOpponent().placementHaloAroundKillFourDeck(lineCoordinates, player);
	}

	private void printKillOneDeck(String xString, String yString, Player opponent) {
		StringBuilder build = new StringBuilder();
		build.append("Убит однопалубный корабль с координатами: [" + X_AND_SPACE);
		build.append(xString).append(SPACE_AND_Y_AND_SPACE).append(yString).append("].");
		build.append(THE_PLAYER).append(opponent.getName());
		System.out.println(build);
	}

	private void printKillTwoDeck(String lineCoordinates, Player opponent) {
		String[] arrayTwoСoordinates = lineCoordinates.split(";");
		String lineXAndYNumbers = arrayTwoСoordinates[0] + "," + arrayTwoСoordinates[1];
		String[] arrayLineXAndYNumbers = lineXAndYNumbers.split(",");
		int xOne = Integer.parseInt(arrayLineXAndYNumbers[0]);
		int yOne = Integer.parseInt(arrayLineXAndYNumbers[1]);
		int xTwo = Integer.parseInt(arrayLineXAndYNumbers[2]);
		int yTwo = Integer.parseInt(arrayLineXAndYNumbers[3]);
		StringBuilder build = new StringBuilder();
		build.append("Убит двухпалубный корабль с координатами: [" + X_AND_SPACE);
		build.append(xOne).append(SPACE_AND_Y_AND_SPACE).append(yOne).append(";");
		build.append(X_AND_SPACE).append(xTwo).append(SPACE_AND_Y_AND_SPACE).append(yTwo).append("].");
		build.append(THE_PLAYER).append(opponent.getName());
		System.out.println(build);
	}

	private void printKillThreeDeck(String lineCoordinates, Player opponent) {
		String[] arrayThreeСoordinates = lineCoordinates.split(";");
		String lineXAndYNumbers = arrayThreeСoordinates[0] + "," + arrayThreeСoordinates[1] + ","
				+ arrayThreeСoordinates[2];
		String[] arrayLineXAndYNumbers = lineXAndYNumbers.split(",");
		int xOne = Integer.parseInt(arrayLineXAndYNumbers[0]);
		int yOne = Integer.parseInt(arrayLineXAndYNumbers[1]);
		int xTwo = Integer.parseInt(arrayLineXAndYNumbers[2]);
		int yTwo = Integer.parseInt(arrayLineXAndYNumbers[3]);
		int xThree = Integer.parseInt(arrayLineXAndYNumbers[4]);
		int yThree = Integer.parseInt(arrayLineXAndYNumbers[5]);
		StringBuilder build = new StringBuilder();
		build.append("Убит трёхпалубный корабль с координатами: [");
		build.append(X_AND_SPACE).append(xOne).append(SPACE_AND_Y_AND_SPACE).append(yOne).append(";");
		build.append(X_AND_SPACE).append(xTwo).append(SPACE_AND_Y_AND_SPACE).append(yTwo).append(";");
		build.append(X_AND_SPACE).append(xThree).append(SPACE_AND_Y_AND_SPACE).append(yThree).append("].");
		build.append(THE_PLAYER).append(opponent.getName());
		System.out.println(build);
	}

	private void printKillFourDeck(String lineCoordinates, Player opponent) {
		StringBuilder build = new StringBuilder();
		String[] arrayFourСoordinates = lineCoordinates.split(";");
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
		build.append("Убит четырёхпалубный корабль с координатами: ").append("[");
		build.append(X_AND_SPACE).append(xOne).append(SPACE_AND_Y_AND_SPACE).append(yOne).append(";");
		build.append(X_AND_SPACE).append(xTwo).append(SPACE_AND_Y_AND_SPACE).append(yTwo).append(";");
		build.append(X_AND_SPACE).append(xThree).append(SPACE_AND_Y_AND_SPACE).append(yThree).append(";");
		build.append(X_AND_SPACE).append(xFour).append(SPACE_AND_Y_AND_SPACE).append(yFour).append("].");
		build.append(THE_PLAYER).append(opponent.getName());
		System.out.println(build);
	}

	public int[] sortingNumbersArray(int[] coordinates) {
		for (int i = coordinates.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (coordinates[j] > coordinates[j + 1]) {
					int tmp = coordinates[j];
					coordinates[j] = coordinates[j + 1];
					coordinates[j + 1] = tmp;
				}
			}
		}
		return coordinates;
	}
}
