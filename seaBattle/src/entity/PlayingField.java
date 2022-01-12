package entity;

import ship.FourDeck;
import ship.OneDeck;
import ship.ThreeDeck;
import ship.TwoDeck;
import shiphalo.ShipHaloFourDeck;
import shiphalo.ShipHaloOneDeck;
import shiphalo.ShipHaloThreeDeck;
import shiphalo.ShipHaloTwoDeck;
import validation.Validation;

public class PlayingField {
	private String[][] playingField;

	public PlayingField() {
		this.playingField = new String[10][10];
	}

	public String[][] getPlayingField() {
		return playingField;
	}

	public void setPlayingField(String[][] playingField) {
		this.playingField = playingField;
	}

	public String[][] buildField() {
		for (int i = 0; i < playingField.length; i++) {
			for (int j = 0; j < playingField[i].length; j++) {
				playingField[i][j] = CellDesignation.FREE.getDesignation();
			}
		}
		return playingField;
	}

	public void fieldPrint() {
		int yLineNumber = 0;
		for (int i = 0; i < playingField.length; i++) {
			System.out.print(yLineNumber);
			for (int j = 0; j < playingField[i].length; j++) {
				System.out.print(playingField[i][j]);
			}
			System.out.println("");
			yLineNumber++;
		}
	}

	public void placementShips(String name) {
		placementFourDeckShip();
		placementThreeDeckShip();
		placementTwoDeckShip();
		placementOneDeckShip();
	}

	private void placementFourDeckShip() {
		FourDeck fourDeck = new FourDeck();
		fourDeck.buildFourDeck(playingField);
		fieldPrint();
	}

	private void placementThreeDeckShip() {
		ThreeDeck threeDeck = new ThreeDeck();
		for (int i = 0; i < 2; i++) {
			threeDeck.buildThreeDeck(playingField);
			fieldPrint();
		}
	}

	private void placementTwoDeckShip() {
		TwoDeck twoDeck = new TwoDeck();
		for (int i = 0; i < 3; i++) {
			twoDeck.buildTwoDeck(playingField);
			fieldPrint();
		}
	}

	private void placementOneDeckShip() {
		OneDeck oneDeck = new OneDeck();
		for (int i = 0; i < 4; i++) {
			oneDeck.buildOneDeck(playingField);
			fieldPrint();
		}
	}

	public boolean checkForMiss(String lineCoordinate, Player opponent) {
		boolean flagMiss = true;
		String[] arrayXAndYNumbers = lineCoordinate.split(",");
		int x = Integer.parseInt(arrayXAndYNumbers[0]);
		int y = Integer.parseInt(arrayXAndYNumbers[1]);
		if (opponent.getPlayingField().getPlayingField()[y][x].equals(CellDesignation.FREE.getDesignation())
				|| opponent.getPlayingField().getPlayingField()[y][x]
						.equals(CellDesignation.SHIP_HALO.getDesignation())) {
			flagMiss = true;
		} else {
			flagMiss = false;
		}
		return flagMiss;
	}

	public void markBoxFree(String lineCoordinate, Player opponent) {
		String[] arrayXAndYNumbers = lineCoordinate.split(",");
		int x = Integer.parseInt(arrayXAndYNumbers[0]);
		int y = Integer.parseInt(arrayXAndYNumbers[1]);
		opponent.getPlayingField().playingField[y][x] = CellDesignation.FREE.getDesignation();
	}

	public void markBoxWounded(String lineCoordinate, Player opponent) {
		String[] arrayXAndYNumbers = lineCoordinate.split(",");
		int x = Integer.parseInt(arrayXAndYNumbers[0]);
		int y = Integer.parseInt(arrayXAndYNumbers[1]);
		opponent.getPlayingField().playingField[y][x] = CellDesignation.WOUNDED.getDesignation();
	}

	public String[] checkShipKillOrWoundReturnArray(String[] arrayCoordinatesShip, String lineCoordinate,
			Player opponent) {
		Validation validation = new Validation();
		int indexX = 0;
		int indexY = 1;
		arrayCoordinatesShip = checkingLeftSideReturnArray(indexX, indexY, lineCoordinate, arrayCoordinatesShip,
				opponent);
		indexX = validation.checkArrayBusy(arrayCoordinatesShip);
		indexY = indexX + 1;
		arrayCoordinatesShip = checkingDownReturnArray(indexX, indexY, lineCoordinate, arrayCoordinatesShip, opponent);
		indexX = validation.checkArrayBusy(arrayCoordinatesShip);
		indexY = indexX + 1;
		arrayCoordinatesShip = сheckingRightSideReturnArray(indexX, indexY, lineCoordinate, arrayCoordinatesShip,
				opponent);
		indexX = validation.checkArrayBusy(arrayCoordinatesShip);
		indexY = indexX + 1;
		arrayCoordinatesShip = сheckTopReturnArray(indexX, indexY, lineCoordinate, arrayCoordinatesShip, opponent);
		return arrayCoordinatesShip;
	}

	public boolean checkShipKillOrWoundReturnFlag(String lineCoordinate, Player opponent) {
		boolean flagKill = true;
		flagKill = checkingLeftSideReturnFlag(lineCoordinate, flagKill, opponent);
		flagKill = checkingDownReturnFlag(lineCoordinate, flagKill, opponent);
		flagKill = сheckingRightSideReturnFlag(lineCoordinate, flagKill, opponent);
		flagKill = сheckTopReturnFlag(lineCoordinate, flagKill, opponent);
		return flagKill;
	}

	private String[] checkingLeftSideReturnArray(int indexX, int indexY, String lineCoordinate,
			String[] arrayCoordinatesShip, Player opponent) {
		boolean flagWhile = true;
		boolean flagReplenishment = true;
		String[] arrayXAndYNumbers = lineCoordinate.split(",");
		int x = Integer.parseInt(arrayXAndYNumbers[0]);
		int y = Integer.parseInt(arrayXAndYNumbers[1]);
		while ((x >= 0 && opponent.getPlayingField().playingField[y][x].equals(CellDesignation.WOUNDED.getDesignation())
				&& flagWhile)
				|| (x >= 0 && opponent.getPlayingField().playingField[y][x]
						.equals(CellDesignation.SHIP_ONE.getDesignation()) && flagWhile)) {
			flagReplenishment = false;
			if (opponent.getPlayingField().playingField[y][x].equals(CellDesignation.WOUNDED.getDesignation())) {
				arrayCoordinatesShip[indexX] = Integer.toString(x);
				arrayCoordinatesShip[indexY] = Integer.toString(y);
				flagReplenishment = true;
			} else if (opponent.getPlayingField().playingField[y][x]
					.equals(CellDesignation.SHIP_ONE.getDesignation())) {
				flagWhile = false;
			}
			if (flagWhile == true) {
				x -= 1;
				if (flagReplenishment == true) {
					indexX += 2;
					indexY += 2;
				}
			}
		}
		return arrayCoordinatesShip;
	}

	private String[] checkingDownReturnArray(int indexX, int indexY, String lineCoordinate,
			String[] arrayCoordinatesShip, Player opponent) {
		int count = 0;
		boolean flagWhile = true;
		boolean flagReplenishment = true;
		String[] arrayXAndYNumbers = lineCoordinate.split(",");
		int x = Integer.parseInt(arrayXAndYNumbers[0]);
		int y = Integer.parseInt(arrayXAndYNumbers[1]);
		while ((y <= 9 && opponent.getPlayingField().playingField[y][x].equals(CellDesignation.WOUNDED.getDesignation())
				&& flagWhile)
				|| (y <= 9 && opponent.getPlayingField().playingField[y][x]
						.equals(CellDesignation.SHIP_ONE.getDesignation()) && flagWhile)) {
			flagReplenishment = false;
			if (opponent.getPlayingField().playingField[y][x].equals(CellDesignation.WOUNDED.getDesignation())
					&& count > 0) {
				arrayCoordinatesShip[indexX] = Integer.toString(x);
				arrayCoordinatesShip[indexY] = Integer.toString(y);
				flagReplenishment = true;
			} else if (opponent.getPlayingField().playingField[y][x].equals(CellDesignation.SHIP_ONE.getDesignation())
					&& count > 0) {
				flagWhile = false;
			}
			if (flagWhile == true) {
				count++;
				y += 1;
				if (flagReplenishment == true) {
					indexX += 2;
					indexY += 2;
				}
			}
		}
		return arrayCoordinatesShip;
	}

	private String[] сheckingRightSideReturnArray(int indexX, int indexY, String lineCoordinate,
			String[] arrayCoordinatesShip, Player opponent) {
		int count = 0;
		boolean flagWhile = true;
		boolean flagReplenishment = true;
		String[] arrayXAndYNumbers = lineCoordinate.split(",");
		int x = Integer.parseInt(arrayXAndYNumbers[0]);
		int y = Integer.parseInt(arrayXAndYNumbers[1]);
		while ((x <= 9 && opponent.getPlayingField().playingField[y][x].equals(CellDesignation.WOUNDED.getDesignation())
				&& flagWhile)
				|| (x <= 9 && opponent.getPlayingField().playingField[y][x]
						.equals(CellDesignation.SHIP_ONE.getDesignation()) && flagWhile)) {
			flagReplenishment = false;
			if (opponent.getPlayingField().playingField[y][x].equals(CellDesignation.WOUNDED.getDesignation())
					&& count > 0) {
				arrayCoordinatesShip[indexX] = Integer.toString(x);
				arrayCoordinatesShip[indexY] = Integer.toString(y);
				flagReplenishment = true;
			} else if (opponent.getPlayingField().playingField[y][x].equals(CellDesignation.SHIP_ONE.getDesignation())
					&& count > 0) {
				flagWhile = false;
			}
			count++;
			x += 1;
			if (flagReplenishment == true) {
				indexX += 2;
				indexY += 2;
			}
		}
		return arrayCoordinatesShip;
	}

	private String[] сheckTopReturnArray(int indexX, int indexY, String lineCoordinate, String[] arrayCoordinatesShip,
			Player opponent) {
		int count = 0;
		boolean flagWhile = true;
		boolean flagReplenishment = true;
		String[] arrayXAndYNumbers = lineCoordinate.split(",");
		int x = Integer.parseInt(arrayXAndYNumbers[0]);
		int y = Integer.parseInt(arrayXAndYNumbers[1]);
		while ((y >= 0 && opponent.getPlayingField().playingField[y][x].equals(CellDesignation.WOUNDED.getDesignation())
				&& flagWhile)
				|| (y >= 0 && opponent.getPlayingField().playingField[y][x]
						.equals(CellDesignation.SHIP_ONE.getDesignation()) && flagWhile)) {
			flagReplenishment = false;
			if (opponent.getPlayingField().playingField[y][x].equals(CellDesignation.WOUNDED.getDesignation())
					&& count > 0) {
				arrayCoordinatesShip[indexX] = Integer.toString(x);
				arrayCoordinatesShip[indexY] = Integer.toString(y);
				flagReplenishment = true;
			} else if (opponent.getPlayingField().playingField[y][x].equals(CellDesignation.SHIP_ONE.getDesignation())
					&& count > 0) {
				flagWhile = false;
			}
			count++;
			y -= 1;
			if (flagReplenishment == true) {
				indexX += 2;
				indexY += 2;
			}
		}
		return arrayCoordinatesShip;
	}

	private boolean checkingLeftSideReturnFlag(String lineCoordinate, boolean flagArrayCoordinatesShip,
			Player opponent) {
		String[] arrayXAndYNumbers = lineCoordinate.split(",");
		int x = Integer.parseInt(arrayXAndYNumbers[0]);
		int y = Integer.parseInt(arrayXAndYNumbers[1]);
		boolean flagWhile = true;
		while ((x >= 0 && opponent.getPlayingField().playingField[y][x].equals(CellDesignation.WOUNDED.getDesignation())
				&& flagWhile)
				|| (x >= 0 && opponent.getPlayingField().playingField[y][x]
						.equals(CellDesignation.SHIP_ONE.getDesignation()) && flagWhile)) {
			if (opponent.getPlayingField().playingField[y][x].equals(CellDesignation.SHIP_ONE.getDesignation())) {
				flagArrayCoordinatesShip = false;
				flagWhile = false;
			}
			x -= 1;
		}
		return flagArrayCoordinatesShip;
	}

	private boolean checkingDownReturnFlag(String lineCoordinate, boolean flagArrayCoordinatesShip, Player opponent) {
		String[] arrayXAndYNumbers = lineCoordinate.split(",");
		int x = Integer.parseInt(arrayXAndYNumbers[0]);
		int y = Integer.parseInt(arrayXAndYNumbers[1]);
		boolean flagWhile = true;
		while ((y <= 9 && opponent.getPlayingField().playingField[y][x].equals(CellDesignation.WOUNDED.getDesignation())
				&& flagWhile)
				|| (y <= 9 && opponent.getPlayingField().playingField[y][x]
						.equals(CellDesignation.SHIP_ONE.getDesignation()) && flagWhile)) {
			if (opponent.getPlayingField().playingField[y][x].equals(CellDesignation.SHIP_ONE.getDesignation())) {
				flagArrayCoordinatesShip = false;
				flagWhile = false;
			}
			y += 1;
		}
		return flagArrayCoordinatesShip;
	}

	private boolean сheckingRightSideReturnFlag(String lineCoordinate, boolean flagArrayCoordinatesShip,
			Player opponent) {
		int count = 0;
		boolean flagWhile = true;
		String[] arrayXAndYNumbers = lineCoordinate.split(",");
		int x = Integer.parseInt(arrayXAndYNumbers[0]);
		int y = Integer.parseInt(arrayXAndYNumbers[1]);
		while ((x <= 9 && opponent.getPlayingField().playingField[y][x].equals(CellDesignation.WOUNDED.getDesignation())
				&& flagWhile)
				|| (x <= 9 && opponent.getPlayingField().playingField[y][x]
						.equals(CellDesignation.SHIP_ONE.getDesignation()) && flagWhile)) {
			if (opponent.getPlayingField().playingField[y][x].equals(CellDesignation.SHIP_ONE.getDesignation())
					&& count > 0) {
				flagArrayCoordinatesShip = false;
				flagWhile = false;
			}
			count++;
			x += 1;

		}
		return flagArrayCoordinatesShip;
	}

	private boolean сheckTopReturnFlag(String lineCoordinate, boolean flagArrayCoordinatesShip, Player opponent) {
		int count = 0;
		boolean flagWhile = true;
		String[] arrayXAndYNumbers = lineCoordinate.split(",");
		int x = Integer.parseInt(arrayXAndYNumbers[0]);
		int y = Integer.parseInt(arrayXAndYNumbers[1]);
		while ((y >= 0 && opponent.getPlayingField().playingField[y][x].equals(CellDesignation.WOUNDED.getDesignation())
				&& flagWhile)
				|| (y >= 0 && opponent.getPlayingField().playingField[y][x]
						.equals(CellDesignation.SHIP_ONE.getDesignation()) && flagWhile)) {
			if (opponent.getPlayingField().playingField[y][x].equals(CellDesignation.SHIP_ONE.getDesignation())
					&& count > 0) {
				flagArrayCoordinatesShip = false;
				flagWhile = false;
			}
			count++;
			y -= 1;
		}
		return flagArrayCoordinatesShip;
	}

	public void placementHaloAroundKillOneDeck(String lineCoordinates, Player opponent) {
		ShipHaloOneDeck shipHaloOneDeck = new ShipHaloOneDeck();
		shipHaloOneDeck.haloPlacementAfterShipPlacement(lineCoordinates, opponent.getPlayingField().playingField);
	}

	public void placementHaloAroundKillTwoDeck(String lineCoordinates, Player opponent) {
		ShipHaloTwoDeck shipHaloTwoDeck = new ShipHaloTwoDeck();
		shipHaloTwoDeck.haloPlacementAfterShipPlacement(lineCoordinates, opponent.getPlayingField().playingField);
	}

	public void placementHaloAroundKillThreeDeck(String lineCoordinates, Player opponent) {
		ShipHaloThreeDeck shipHaloThreeDeck = new ShipHaloThreeDeck();
		shipHaloThreeDeck.haloPlacementAfterShipPlacement(lineCoordinates, opponent.getPlayingField().playingField);
	}

	public void placementHaloAroundKillFourDeck(String lineCoordinates, Player opponent) {
		ShipHaloFourDeck shipHaloFourDeck = new ShipHaloFourDeck();
		shipHaloFourDeck.haloPlacementAfterShipPlacement(lineCoordinates, opponent.getPlayingField().playingField);
	}

	@Override
	public int hashCode() {
		int result = 31;
		int prime = 1;
		result = result * prime + (playingField != null ? playingField.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null) {
			return false;
		}
		if (!getClass().equals(object.getClass())) {
			return false;
		}
		PlayingField field = (PlayingField) object;
		if (playingField == null) {
			if (field.playingField != null) {
				return false;
			}
		} else if (!playingField.equals(field.playingField)) {
			return false;
		}
		return true;
	}
}
