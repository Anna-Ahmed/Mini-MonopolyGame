package com.cm6123.monopoly.game;

/**
 * Class for Banker.
 */
public class Banker {
    /**
     *@param bankerbalance is the amount banker has.
     */
    private int bankerbalance;

    /**
     * @param player used to create a Player object.
     */

    private Player player;
    /**
     * Constructor.
     *  bankerbalance is set to 5000.
     */

    public Banker(){

        bankerbalance = 5000;

    }

    /**
     * Gets the bankers balance.
     * @return bankerbalance
     */
    public  int getBankerBalance() {
        return bankerbalance;
    }


    /**
     * Method for banker to pay player.
     * @param aplayer player called on receive money method.
     * @param amount amount is not a fixed value.
     */




    public void payPlayer(final Player aplayer,final int amount){
        bankerbalance -= amount;
        System.out.println("Player given" + amount);
        aplayer.recieveMoneyFromBanker(amount);

    }

    /**
     * Method created for banker to recieve money from player.
     * @param amount
     */

    public void recieveMoneyFromPlayer(final int amount){
        bankerbalance += amount;

        System.out.println("Received" + amount + "From Player");
        player.payBanker(amount);
    }
}
