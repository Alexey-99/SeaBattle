package entity;

import java.util.Scanner;
import validation.Validation;

public class Player {
	private String name;
	private PlayingField playingField;
	private PlayingFieldOpponent playingFieldOpponent;
	private int counterWounds;

	public Player() {
		this.playingField = new PlayingField();
		this.playingFieldOpponent = new PlayingFieldOpponent();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayingField getPlayingField() {
		return playingField;
	}

	public void setPlayingField(PlayingField playingField) {
		this.playingField = playingField;
	}

	public PlayingFieldOpponent getPlayingFieldOpponent() {
		return playingFieldOpponent;
	}

	public void setPlayingFieldOpponent(PlayingFieldOpponent playingFieldOpponent) {
		this.playingFieldOpponent = playingFieldOpponent;
	}

	public int getCounterWounds() {
		return counterWounds;
	}

	public void setCounterWounds(int counterWounds) {
		this.counterWounds = counterWounds;
	}

	public void preparationPlayingFieldsForGame() {
		playingField.buildField();
		playingFieldOpponent.buildOpponentMatrix();
		playingField.fieldPrint();
		playingField.placementShips(this.name);
		for (int i = 0; i < 100; i++) {
			System.out.println(" ");
		}
	}

	public String hitCoordinateInput() {
		Validation validation = new Validation();
		boolean flagWhile = true;
		boolean flagBuildMatrix = true;
		String lineCoordinate = null;
		while (flagWhile) {
			System.out.println("Введите координаты боя " + name);
			Scanner scan = new Scanner(System.in);
			lineCoordinate = scan.nextLine();
			flagBuildMatrix = validation.presenceOneXAndYInOneCoordinateInOneDeck(lineCoordinate);
			if (flagBuildMatrix == true) {
				flagBuildMatrix = validation.presenceNumbersInCoordinateFromZeroToNineInOneDeck(lineCoordinate);
				if (flagBuildMatrix == true) {
					flagBuildMatrix = validation.presenceInXAndYCoordinateLessTenInOneDeck(lineCoordinate);
					if (flagBuildMatrix == true) {
						flagBuildMatrix = validation.presenceRepetitiveMoves(lineCoordinate,
								playingFieldOpponent.getPlayingFieldOpponent());
					}
				}
			}
			if (flagBuildMatrix == true) {
				flagWhile = false;
			}
		}
		return lineCoordinate;
	}

	public void increaseWoundCounterByOne() {
		counterWounds++;
	}

	@Override
	public int hashCode() {
		int result = 31;
		int prime = 1;
		result = result * prime + (name != null ? name.hashCode() : 0);
		result = result * prime + (playingField != null ? playingFieldOpponent.hashCode() : 0);
		result = result * prime + (playingFieldOpponent != null ? playingFieldOpponent.hashCode() : 0);
		result = result * prime + counterWounds;
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
		Player player = (Player) object;
		if (name == null) {
			if (player.name != null) {
				return false;
			}
		} else if (!name.equals(player.name)) {
			return false;
		}
		if (playingField == null) {
			if (player.playingField != null) {
				return false;
			}
		} else if (!playingField.equals(player.playingField)) {
			return false;
		}
		if (playingFieldOpponent == null) {
			if (player.playingFieldOpponent != null) {
				return false;
			}
		} else if (!playingFieldOpponent.equals(player.playingFieldOpponent)) {
			return false;
		}
		if (counterWounds != player.counterWounds) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append("Игрока зовут ").append(name).append("\n");
		build.append("У игрока ").append(counterWounds).append(" попаданий");
		return build.toString();
	}
}