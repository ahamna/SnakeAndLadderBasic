package co.game.snakeandladder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.game.snakeandladder.driver.GameDriver;

@SpringBootApplication
public class SnakeAndLadderApplication implements CommandLineRunner{
	private static Logger LOG = LoggerFactory.getLogger(SnakeAndLadderApplication.class);
	GameDriver gameDriver;
	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(SnakeAndLadderApplication.class, args);
		LOG.info("APPLICATION FINISHED");
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("EXECUTING : command line runner");
		for(int i=0; i<args.length;i++) {
			LOG.info("args[{}] : {}",i,args[i]);
		}
		gameDriver = new GameDriver();
		gameDriver.startGame();
	}

}
