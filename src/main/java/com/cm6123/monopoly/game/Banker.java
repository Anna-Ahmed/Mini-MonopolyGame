package com.cm6123.monopoly.game;

/**
 * Class for Banker.
 */
public class Banker {
    /**
     *@param bankerbalance is the amount banker has.
     */
    private int bankerbalance = 50000;

    /**
     * @param player used to create a Player object.
     */

    private Player player;
    /**
     * Constructor.
     * @param thebankerbalance
     */

    public Banker(final int thebankerbalance){
        this.bankerbalance = thebankerbalance;
    }

    /**
     * Method for banker to pay player.
     * @param aplayer player called on receive money method.
     * @param amount amount is not a fixed value.
     */

    public void payPlayer(final Player aplayer,final int amount){
        System.out.println("Player given" + amount);
        aplayer.recieveMoneyFromBanker(amount);

    }

    /**
     * Method created for banker to recieve money from player.
     * @param amount
     */

    public static void recieveMoneyFromPlayer(final int amount){

        System.out.println("Received" + amount + "From Player");
    }
}
