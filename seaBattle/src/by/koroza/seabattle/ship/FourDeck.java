package by.koroza.seabattle.ship;

import java.util.Scanner;

import by.koroza.seabattle.entity.CellDesignation;
import by.koroza.seabattle.shiphalo.ShipHaloFourDeck;
import by.koroza.seabattle.validation.Validation;

public class FourDeck {

	public FourDeck() {
	}

	public String[][] buildFourDeck(String[][] playingField) {
		Validation validation = new Validation();
		ShipHaloFourDeck shipHaloFourDeck = new ShipHaloFourDeck();
		boolean flag = true;
		while (flag) {
			boolean flagMatrix = true;
			System.out.println("Введи координаты четырёхпалубного коробля (формат: x,y;x,y;x,y;x,y)");
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			String lineСoordinates = scan.nextLine();
			flagMatrix = validation.presenceFourCoordinatesPointsInFourDeck(lineСoordinates);
			String[] arrayFourСoordinates = lineСoordinates.split(";");
			if (flagMatrix == true) {
				flagMatrix = validation.presenceFourXAndYInFourCoordinatesInFourDeck(lineСoordinates);
				if (flagMatrix == true) {
					flagMatrix = validation.presenceNumbersInCoordinatesFromZeroToNineInFourDeck(lineСoordinates);
					if (flagMatrix == true) {
						flagMatrix = validation.presenceEqualityXsOrYsInFourDeck(lineСoordinates);
						if (flagMatrix == true) {
							flagMatrix = validation.ascendingOrDescendingCoordinatesInFourDeck(lineСoordinates);
							if (flagMatrix == true) {
								flagMatrix = validation.presenceTwoElementsInCoordinateInFourDeck(lineСoordinates);
								if (flagMatrix == true) {
									flagMatrix = validation.presenceInXAndYCoordinateLessTenInFourDeck(lineСoordinates);
									if (flagMatrix == true) {
										flagMatrix = validation
												.presenceFreeSpaceOnFieldAtSpecifiedCoordinatesInFourDeck(
														lineСoordinates, playingField);
										if (flagMatrix == true) {
											flag = false;
											playingField = puttingShipOnField(arrayFourСoordinates, playingField);
											playingField = shipHaloFourDeck
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

	private String[][] puttingShipOnField(String[] arrayFourСoordinates, String[][] playingField) {
		for (int i = 0; i < 4; i++) {
			String lineCoordinatePoint = arrayFourСoordinates[i];
			String[] arrayXAndY = lineCoordinatePoint.split(",");
			int x = Integer.parseInt(arrayXAndY[0]);
			int y = Integer.parseInt(arrayXAndY[1]);
			playingField[y][x] = CellDesignation.SHIP_ONE.getDesignation();
		}
		return playingField;
	}
}