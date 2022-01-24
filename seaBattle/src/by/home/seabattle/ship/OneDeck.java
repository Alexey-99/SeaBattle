package by.home.seabattle.ship;

import java.util.Scanner;

import by.home.seabattle.entity.CellDesignation;
import by.home.seabattle.shiphalo.ShipHaloOneDeck;
import by.home.seabattle.validation.Validation;

public class OneDeck {

	public OneDeck() {
	}

	public String[][] buildOneDeck(String[][] playingField) {
		Validation validation = new Validation();
		ShipHaloOneDeck shipHaloOneDeck = new ShipHaloOneDeck();
		boolean flagWhile = true;
		while (flagWhile) {
			boolean flagBuildMatrix = true;
			System.out.println("Введи координаты однопалубного коробля (формат: x,y) (от 0 до 9 включительно)");
			Scanner scan = new Scanner(System.in);
			String lineСoordinates = scan.nextLine();
			flagBuildMatrix = validation.presenceOneCoordinatesPointsInOneDeck(lineСoordinates);
			if (flagBuildMatrix == true) {
				flagBuildMatrix = validation.presenceOneXAndYInOneCoordinateInOneDeck(lineСoordinates);
				if (flagBuildMatrix == true) {
					flagBuildMatrix = validation.presenceNumbersInCoordinateFromZeroToNineInOneDeck(lineСoordinates);
					if (flagBuildMatrix == true) {
						flagBuildMatrix = validation.presenceInXAndYCoordinateLessTenInOneDeck(lineСoordinates);
						if (flagBuildMatrix == true) {
							flagBuildMatrix = validation.presenceFreeSpaceOnFieldAtSpecifiedCoordinatesInOneDeck(
									lineСoordinates, playingField);
							if (flagBuildMatrix == true) {
								flagWhile = false;
								playingField = puttingShipOnField(lineСoordinates, playingField);
								playingField = shipHaloOneDeck.haloPlacementAfterShipPlacement(lineСoordinates,
										playingField);
							}
						}
					}
				}
			}
		}
		return playingField;
	}

	private String[][] puttingShipOnField(String lineСoordinates, String[][] playingField) {
		String[] arrayXAndYNumbers = lineСoordinates.split(",");
		int xOne = Integer.parseInt(arrayXAndYNumbers[0]);
		int yOne = Integer.parseInt(arrayXAndYNumbers[1]);
		playingField[yOne][xOne] = CellDesignation.SHIP_ONE.getDesignation();
		return playingField;
	}
}