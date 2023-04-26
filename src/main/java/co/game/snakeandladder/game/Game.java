package co.game.snakeandladder.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
	Map<Integer, Integer> snakes;
	Map<Integer, Integer> ladders;
	Queue<String> players;
	
	Scanner scanner;
	
	public Game() throws IOException{
		String path = "C:/Users/anupr/OneDrive/Documents/java/SnakeAndLadder/src/main/resources/input.txt";
		snakes = new HashMap<Integer, Integer>();
		ladders = new HashMap<Integer, Integer>();
		players = new LinkedList<String>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			Integer numSnakes = Integer.valueOf(reader.readLine());
			for(int i=0;i<numSnakes;i++) {
				String [] snake = reader.readLine().split(" ");
				snakes.put(Integer.valueOf(snake[0]), Integer.valueOf(snake[1]));
			}
			Integer numLadders = Integer.valueOf(reader.readLine());
			for(int i=0;i<numLadders;i++) {
				String [] ladder = reader.readLine().split(" ");
				ladders.put(Integer.valueOf(ladder[0]), Integer.valueOf(ladder[1]));
			}
			Integer numPlayers = Integer.valueOf(reader.readLine());
			for(int i=0; i<numPlayers;i++) {
				players.offer(reader.readLine());
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public boolean win() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
