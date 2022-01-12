package seabattle;

import java.util.Scanner;

import entity.Player;

public class SeaBattle {
	private static final String START_PLACING_SHIPS_IN_FIELD = "Начнём расстовлять коробли на поле.";
	private static final String DOT_AND_SPACE_PLAYER_PLUS_SPACE = "Игрок ";
	private static final String PLAYER_PLUS_SPACE = "Игрок ";
	private static final String PLAYER_WITH_NAME_PLAYCES_SHIPS = "Расставляет коробли игрок с именем";
	private static final String SPACE_AND_TOURNS_AWAY = " отварачивается";
	private static final String GEME_OVER = "ИГРА ОКОНЧЕНА !!!";
	private static final String SPACE_WON_DOT = "победил.";

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Player player1 = new Player();
		String name = assigningNamePlayer(scan);
		player1.setName(name);

		Player player2 = new Player();
		name = assigningNamePlayer(scan);
		player2.setName(name);

		System.out.println(START_PLACING_SHIPS_IN_FIELD);
		System.out.println(PLAYER_WITH_NAME_PLAYCES_SHIPS + player1.getName() + DOT_AND_SPACE_PLAYER_PLUS_SPACE
				+ player2.getName() + SPACE_AND_TOURNS_AWAY);
		player1.preparationPlayingFieldsForGame();

		System.out.println(PLAYER_WITH_NAME_PLAYCES_SHIPS + player2.getName() + DOT_AND_SPACE_PLAYER_PLUS_SPACE
				+ player1.getName() + SPACE_AND_TOURNS_AWAY);
		player2.preparationPlayingFieldsForGame();

		boolean flagFinishGame = true;
		GameStep gameStep = new GameStep();
		while (flagFinishGame) {
			gameStep.gameStep(player1, player2);
			if (player1.getCounterWounds() == 20) {
				System.out.println(GEME_OVER);
				System.out.println(PLAYER_PLUS_SPACE + player1.getName() + SPACE_WON_DOT);
				flagFinishGame = false;
			} else {
				gameStep.gameStep(player2, player1);
			}
			if (player2.getCounterWounds() == 20) {
				System.out.println(GEME_OVER);
				System.out.println(PLAYER_PLUS_SPACE + player2.getName() + SPACE_WON_DOT);
				flagFinishGame = false;
			}
		}
	}

	private static String assigningNamePlayer(Scanner scan) {
		System.out.println("Игрок введите ИМЯ: ");
		String namePlayer = scan.nextLine();
		return namePlayer;
	}
}
