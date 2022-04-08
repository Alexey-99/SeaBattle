package by.koroza.seabattle.ship;

import java.util.Scanner;

import by.koroza.seabattle.entity.CellDesignation;
import by.koroza.seabattle.shiphalo.ShipHaloThreeDeck;
import by.koroza.seabattle.validation.Validation;

public class ThreeDeck {

	public ThreeDeck() {
	}

	public String[][] buildThreeDeck(String[][] playingField) {
		Validation validation = new Validation();
		ShipHaloThreeDeck shipHaloThreeDeck = new ShipHaloThreeDeck();
		boolean flagWhile = true;
		while (flagWhile) {
			boolean flagBuildMatrix = true;
			System.out.println("Введи координаты трёхпалубного коробля (формат: x,y;x,y;x,y) (от 0 до 9 включительно)");
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			String lineСoordinates = scan.nextLine();
			String[] arrayTreeСoordinates = lineСoordinates.split(";");
			flagBuildMatrix = validation.presenceThreeCoordinatesPointsInThreeDeck(lineСoordinates);
			if (flagBuildMatrix == true) {
				flagBuildMatrix = validation.presenceThreeXAndYInThreeCoordinatesInThreeDeck(lineСoordinates);
				if (flagBuildMatrix == true) {
					flagBuildMatrix = validation.presenceNumbersInCoordinatesFromZeroToNineInThreeDeck(lineСoordinates);
					if (flagBuildMatrix == true) {
						flagBuildMatrix = validation.presenceEqualityXsOrYsInThreeDeck(lineСoordinates);
						if (flagBuildMatrix == true) {
							flagBuildMatrix = validation.ascendingOrDescendingCoordinatesInThreeDeck(lineСoordinates);
							if (flagBuildMatrix == true) {
								flagBuildMatrix = validation
										.presenceTwoElementsInCoordinateInThreeDeck(lineСoordinates);
								if (flagBuildMatrix == true) {
									flagBuildMatrix = validation
											.presenceInXAndYCoordinateLessTenInThreeDeck(lineСoordinates);
									if (flagBuildMatrix == true) {
										flagBuildMatrix = validation
												.presenceFreeSpaceOnFieldAtSpecifiedCoordinatesInThreeDeck(
														lineСoordinates, playingField);
										if (flagBuildMatrix == true) {
											flagWhile = false;
											playingField = puttingShipOnField(arrayTreeСoordinates, playingField);
											playingField = shipHaloThreeDeck
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

	private String[][] puttingShipOnField(String[] arrayTreeСoordinates, String[][] playingField) {
		for (int i = 0; i < 3; i++) {
			String lineСoordinatePoint = arrayTreeСoordinates[i];
			String[] arrayСoordinateXAndY = lineСoordinatePoint.split(",");
			int x = Integer.parseInt(arrayСoordinateXAndY[0]);
			int y = Integer.parseInt(arrayСoordinateXAndY[1]);
			playingField[y][x] = CellDesignation.SHIP_ONE.getDesignation();
		}
		return playingField;
	}
}