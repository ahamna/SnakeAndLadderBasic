package co.game.snakeandladder.driver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import co.game.snakeandladder.game.Game;

public class GameDriver {
	Game game;
	Random random;
	Map<String, Integer> playerPosition;
	boolean win = false;
	public GameDriver() throws IOException {
		game = new Game();
		random = new Random();
		playerPosition = new HashMap<String, Integer>();
		for(String s : game.getPlayers()) {
			playerPosition.put(s,0);
		}
	}
	public void startGame() {
		while(!win) {
			String currentPlayer = game.getPlayers().poll();
			Integer rolledNumber = rollDice();
			System.out.println(currentPlayer+" rolled a "+ rolledNumber +" and Moved from" + playerPosition.get(currentPlayer)+" to "+ getNewPosition(currentPlayer,rolledNumber));
			if(playerPosition.get(currentPlayer) == 100) {
				System.out.println(currentPlayer +" wins the game");
				win = true;
			}
			game.getPlayers().add(currentPlayer);
		}
	}
	private String getNewPosition(String currentPlayer, Integer rolledNumber) {
		Integer newPosition = playerPosition.get(currentPlayer)+rolledNumber;
		if(game.getLadders().get(newPosition) != null) {
			newPosition += game.getLadders().get(newPosition);
			System.out.println("Yeah!! "+currentPlayer+ " Got Ladder from"+ (playerPosition.get(currentPlayer)+rolledNumber)+" to "+ newPosition);
		}
		if(game.getSnakes().get(newPosition) != null) {
			newPosition -= game.getSnakes().get(newPosition);
			System.out.println("Hiss!! "+currentPlayer+ " Got bit dragged from"+ (playerPosition.get(currentPlayer)+rolledNumber)+" to "+ newPosition);
		}
		if(newPosition > 100) {
			return playerPosition.get(currentPlayer).toString();
		}
		playerPosition.put(currentPlayer, newPosition);
		return newPosition.toString();
	}
	private Integer rollDice() {
		return random.nextInt(6)+1;
	}
}
