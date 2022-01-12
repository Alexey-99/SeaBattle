package entity;

import shiphalo.ShipHaloFourDeck;
import shiphalo.ShipHaloOneDeck;
import shiphalo.ShipHaloThreeDeck;
import shiphalo.ShipHaloTwoDeck;

public class PlayingFieldOpponent {
	private String[][] playingFieldOpponent;

	public PlayingFieldOpponent() {
		this.playingFieldOpponent = new String[10][10];
	}

	public String[][] getPlayingFieldOpponent() {
		return playingFieldOpponent;
	}

	public void setPlayingFieldOpponent(String[][] playingFieldOpponent) {
		this.playingFieldOpponent = playingFieldOpponent;
	}

	public String[][] buildOpponentMatrix() {
		for (int i = 0; i < playingFieldOpponent.length; i++) {
			for (int j = 0; j < playingFieldOpponent[i].length; j++) {
				playingFieldOpponent[i][j] = CellDesignation.CELL.getDesignation();
			}
		}
		return playingFieldOpponent;
	}

	public void fieldPrint() {
		int yLineNumber = 0;
		for (int i = 0; i < playingFieldOpponent.length; i++) {
			System.out.print(yLineNumber);
			for (int j = 0; j < playingFieldOpponent[i].length; j++) {
				System.out.print(playingFieldOpponent[i][j]);
			}
			System.out.println("");
			yLineNumber++;
		}
	}

	public void markBoxFree(String lineCoordinate, Player player) {
		String[] arrayXAndYNumbers = lineCoordinate.split(",");
		int x = Integer.parseInt(arrayXAndYNumbers[0]);
		int y = Integer.parseInt(arrayXAndYNumbers[1]);
		player.getPlayingFieldOpponent().playingFieldOpponent[y][x] = CellDesignation.FREE.getDesignation();
	}

	public void markBoxWounded(String lineCoordinate, Player player) {
		String[] arrayXAndYNumbers = lineCoordinate.split(",");
		int x = Integer.parseInt(arrayXAndYNumbers[0]);
		int y = Integer.parseInt(arrayXAndYNumbers[1]);
		player.getPlayingFieldOpponent().playingFieldOpponent[y][x] = CellDesignation.WOUNDED.getDesignation();
	}

	public void placementHaloAroundKillOneDeck(String lineCoordinates, Player player) {
		ShipHaloOneDeck shipHaloOneDeck = new ShipHaloOneDeck();
		shipHaloOneDeck.haloPlacementAfterShipPlacement(lineCoordinates,
				player.getPlayingFieldOpponent().playingFieldOpponent);
	}

	public void placementHaloAroundKillTwoDeck(String lineCoordinates, Player player) {
		ShipHaloTwoDeck shipHaloTwoDeck = new ShipHaloTwoDeck();
		shipHaloTwoDeck.haloPlacementAfterShipPlacement(lineCoordinates,
				player.getPlayingFieldOpponent().playingFieldOpponent);
	}

	public void placementHaloAroundKillThreeDeck(String lineCoordinates, Player player) {
		ShipHaloThreeDeck shipHaloThreeDeck = new ShipHaloThreeDeck();
		shipHaloThreeDeck.haloPlacementAfterShipPlacement(lineCoordinates,
				player.getPlayingFieldOpponent().playingFieldOpponent);
	}

	public void placementHaloAroundKillFourDeck(String lineCoordinates, Player player) {
		ShipHaloFourDeck shipHaloFourDeck = new ShipHaloFourDeck();
		shipHaloFourDeck.haloPlacementAfterShipPlacement(lineCoordinates,
				player.getPlayingFieldOpponent().playingFieldOpponent);
	}

	@Override
	public int hashCode() {
		int result = 31;
		int prime = 1;
		result = result * prime + (playingFieldOpponent != null ? playingFieldOpponent.hashCode() : 0);
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
		PlayingFieldOpponent fieldOpponent = (PlayingFieldOpponent) object;
		if (playingFieldOpponent == null) {
			if (fieldOpponent.playingFieldOpponent != null) {
				return false;
			}
		}
		if (!playingFieldOpponent.equals(fieldOpponent.playingFieldOpponent)) {
			return false;
		}
		return true;
	}
}