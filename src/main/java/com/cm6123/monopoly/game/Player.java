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
    private int playerBalance;

    /**
     @param board used to create a monopoly board object.
     */

    private MonopolyBoard board;

    /**
     * @paraam banker used to create banker object for Banker class.
     */
    private Banker banker;


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
     *
     * @return playerPosition
     */
    public int getPlayerPosition() {
        return playerPosition;
    }


    /**
     * Sets players position.
     *
     * @param aPlayerPosition doesn't return param.
     */
    public void setPlayerPosition(final int aPlayerPosition) {
        this.playerPosition = aPlayerPosition;
    }

    // Getter for players balance

    /**
     * Gets players Balance.
     *
     * @return playerBalance.
     */
    public int getPlayerBalance() {
        return playerBalance;
    }

    /**
     * Banker gives money  to player.
     *
     * @param amount
     */
    public void recieveMoneyFromBanker(final int amount) {
        playerBalance += amount;



    }

    /**
     * Player gives money to banker.
     *
     * @param amount
     */
    public void payBanker(final int amount) {
        playerBalance -= amount;
        banker.recieveMoneyFromPlayer(amount);
    }




    }


