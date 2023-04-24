package com.cm6123.monopoly.game;


import com.cm6123.monopoly.dice.Dice;

/**
 * Class created to represnt players in the game.
 */

public class Player {

    // Instance variables
    /**
     * @param dice is used to create an object for Dice class.
     */
    private Dice dice;
    /**
     * @param playerPosition.
     */
    private int playerPosition;
    /**
     * @param playerBalance.
     */
    private static int playerBalance;


    /**
     * Constructor created for player.
     */

    // Constructor player initalising player postion at 0 and player balance at 1000 at the start of the game
    public Player() {
        playerPosition = 0;
        playerBalance = 1000;
        dice = new Dice(6);




    }
    // Getter for playerPosition

    /**
     * Gets players position.
     * @return playerPosition
     */
    public int getPlayerPosition() {
        return playerPosition;
    }


    /**
     * Sets players position.
     * @param aPlayerPosition doesn't return param.
     */
    public  void setPlayerPosition(final int aPlayerPosition){
        this.playerPosition = aPlayerPosition;
    }

    // Getter for players balance
    /**
     * Gets players Balance.
     * @return playerBalance.
     */
    public int getPlayerBalance() {
        return playerBalance;
    }

    /**
     * adds to players balance.
     * @param amount
     */
    public static void addToPlayerBalancey(final int amount){
        playerBalance += amount;
    }

    /**
     * Subtracts from players balance.
     * @param amount
     */
    public static void subtractFromPlayerBalance(final int amount){
        playerBalance -= amount;
    }


}

