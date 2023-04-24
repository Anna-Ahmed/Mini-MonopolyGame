package com.cm6123.monopoly.app;

import com.cm6123.monopoly.dice.Dice;
import com.cm6123.monopoly.game.MonopolyBoard;
import com.cm6123.monopoly.game.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public final class Application {
    /**
     * Create a logger for the class.
     */
    private static Logger logger = LoggerFactory.getLogger(Application.class);


    private Application() {
    }

    /**
     * main entry point.  If args provided, result is displayed and program exists. Otherwise, user is prompted for
     * input.
     *
     * @param args command line args.
     */
    public static void main(final String[] args) {


        logger.info("Application Started with args:{}", String.join(",", args));

        System.out.println("Hello. Welcome to Monopoly.");


        MonopolyBoard board = new MonopolyBoard();
        Player player = new Player();
        Dice dice = new Dice(6);
        board.setDice(dice);

        //board.play();
        board.playTurn(player);


        logger.info("Application closing");
    }


}
