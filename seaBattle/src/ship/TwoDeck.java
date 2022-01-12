package ship;

import java.util.Scanner;

import entity.CellDesignation;
import shiphalo.ShipHaloTwoDeck;
import validation.Validation;

public class TwoDeck {

	public TwoDeck() {
	}

	public String[][] buildTwoDeck(String[][] playingField) {
		Validation validation = new Validation();
		ShipHaloTwoDeck shipHaloTwoDeck = new ShipHaloTwoDeck();
		boolean flagWhile = true;
		while (flagWhile) {
			boolean flagBuildMatrix = true;
			System.out.println("Введи координаты двухпалубного коробля (формат: x,y;x,y) (от 0 до 9 включительно)");
			Scanner scan = new Scanner(System.in);
			String lineСoordinates = scan.nextLine();
			String[] arrayTwoСoordinates = lineСoordinates.split(";");
			flagBuildMatrix = validation.presenceTwoCoordinatesPointsInTwoDeck(lineСoordinates);
			if (flagBuildMatrix == true) {
				flagBuildMatrix = validation.presenceTwoXAndYInFourCoordinatesInTwoDeck(lineСoordinates);
				if (flagBuildMatrix == true) {
					flagBuildMatrix = validation.presenceNumbersInCoordinatesFromZeroToNineInTwoDeck(lineСoordinates);
					if (flagBuildMatrix == true) {
						flagBuildMatrix = validation.presenceEqualityXsOrYsInTwoDeck(lineСoordinates);
						if (flagBuildMatrix == true) {
							flagBuildMatrix = validation.ascendingOrDescendingCoordinatesInTwoDeck(lineСoordinates);
							if (flagBuildMatrix == true) {
								flagBuildMatrix = validation.presenceTwoElementsInCoordinateInTwoDeck(lineСoordinates);
								if (flagBuildMatrix == true) {
									flagBuildMatrix = validation
											.presenceInXAndYCoordinateLessTenInTwoDeck(lineСoordinates);
									if (flagBuildMatrix == true) {
										flagBuildMatrix = validation
												.presenceFreeSpaceOnFieldAtSpecifiedCoordinatesInTwoDeck(
														lineСoordinates, playingField);
										if (flagBuildMatrix == true) {
											flagWhile = false;
											playingField = puttingShipOnField(arrayTwoСoordinates, playingField);
											playingField = shipHaloTwoDeck
													.haloPlacementAfterShipPlacement(lineСoordinates, playingField);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return playingField;
	}

	private String[][] puttingShipOnField(String[] arrayTwoСoordinates, String[][] playingField) {
		for (int i = 0; i < 2; i++) {
			String lineTwoСoordinatePoint = arrayTwoСoordinates[i];
			String[] arrayСoordinateXAndY = lineTwoСoordinatePoint.split(",");
			int x = Integer.parseInt(arrayСoordinateXAndY[0]);
			int y = Integer.parseInt(arrayСoordinateXAndY[1]);
			playingField[y][x] = CellDesignation.SHIP_ONE.getDesignation();
		}
		return playingField;
	}

}