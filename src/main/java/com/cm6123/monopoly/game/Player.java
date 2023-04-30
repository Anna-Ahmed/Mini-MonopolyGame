package com.cm6123.monopoly.game;


import com.cm6123.monopoly.dice.Dice;


/**
 * Class created to represnt players in the game.
 */

public class Player {

    // Instance variables
    /**
     * dice is used to create an object for Dice class.
     */
    private Dice dice;
    /**
     *  the postion of player .
     */
    private int playerPosition;
    /**
     * the players balance.
     */
    private int playerBalance;

    /**
     * the value of ticket price for stations.
     */

    private int ticketPrice;

    /**
     *  first roll value of the dice.
     */
    private int rollValue1;

    /**
     * second roll value of dice.
     */
    private int rollValue2;

    /**
     * value of tax.
     */
    private int taxprice;

    /**
     * board used to create a monopoly board object.
     */

    private MonopolyBoard board;

    /**
     * banker used to create banker object for Banker class.
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
     * Player pays rent.
     * @param rent
     */

    public void payRent(final int rent){
        playerBalance -= rent;
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


