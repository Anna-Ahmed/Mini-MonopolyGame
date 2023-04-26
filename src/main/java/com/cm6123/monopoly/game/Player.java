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
     * @param ticketprice used to store the value of ticket price for stations.
     */

    private int ticketPrice;

    /**
     * @param rollValue1 is used to store roll1 value of the dice.
     */
    private int rollValue1;

    /**
     * @param rollValue2 is used to store roll2 value of dice.
     */
    private int rollValue2;

    /**
     * @param taxprice used to store value of tax.
     */
    private int taxprice;

    /**
     * @param board used to create a monopoly board object.
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
        banker = new Banker();


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


    public void receiveMoneyFromBanker(final int amount) {
        playerBalance += amount;


    }

    /**
     * Player gives money to banker.
     *
     * @param amount
     */
    public void payBanker(final int amount) {
        playerBalance -= amount;

    }

    /**
     * Sets current roll of dice.
     *
     * @param roll1
     * @param roll2
     */
    public void setCurrentRoll(final int roll1, final int roll2) {

        this.rollValue1 = roll1;
        this.rollValue2 = roll2;
    }


    /**
     * Method to calcuate amount for ticket price that player needs to pay.
     */
    public void payTicket() {
        ticketPrice = 10 * (rollValue1 + rollValue2);  //Ticket fee is 10 * the value of last roll
        payBanker(ticketPrice);  // player then pays ticket fee to Banker
        System.out.println(" Player paid " + ticketPrice + " at station ");
    }


    /**
     * Method to calculate tax price based on player balance and if play rolled a double or single.
     */
    public void payTax() {
        if (rollValue1 == rollValue2) {
            taxprice = (int) ((playerBalance * 0.1) / 2);
            payBanker(taxprice);

        } else {
            taxprice = (int) (playerBalance * 0.1);
            payBanker(taxprice);
        }


    }
}


