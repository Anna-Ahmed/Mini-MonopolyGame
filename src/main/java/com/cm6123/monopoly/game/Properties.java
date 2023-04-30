package com.cm6123.monopoly.game;

import com.cm6123.monopoly.app.GameLogicHandlers;

public class Properties extends MonopolyBoard {

    /**
     * @param oldkentprice is used to store integer for price of old kent road.
     */

    private int oldkentprice;


    /**
     * @param player1 is used to create player1 object.
     */


    private Player player1;

    /**
     * @param player2 is used to create player2 object.
     */

    private Player player2;
    /**
     * A new GameLogicHandler object is created.
     */
    private GameLogicHandlers statement;


    /**
     * @param oldkentRentprice is used to store rent price of old kent road.
     */
    private int oldkentRentprice;


    /**
     * Constructor for properties class.
     */
    public Properties() {
        this.oldkentprice = 60;
        this.oldkentRentprice = 6;
        this.statement = new GameLogicHandlers();


    }

    /**
     * Gets oldkentprice.
     *
     * @return oldkentprice.
     */
    public int getOldkentprice() {
        return oldkentprice;
    }

    /**
     * Gets oldkentRentprice.
     *
     * @return oldkentRentprice.
     */
    public int getOldkentRentprice() {
        return oldkentRentprice;
    }


    /**
     * Method to buy Old Kent and Pay rent.
     *
     * @param player The Player object representing the player who wants to buy the house.
     */
    public void buyOldKent(final Player player) {
        player1 = getPlayer1();
        player2 = getPlayer2();
        int currentPosition = player.getPlayerPosition();
        BoardSpace currentSpace = getSpaces()[currentPosition];

        if (currentSpace == BoardSpace.OLD_KENT_ROAD) {
            if (getCurrentPlayerIsPlayer1() && currentSpace.getOwner() == null && player.getPlayerBalance() >= oldkentprice) {
                player.payBanker(oldkentprice);
                statement.ownerOfHouse();


                currentSpace.setOwner(player1);
                statement.confirmOwnerShip();

            } else if (!getCurrentPlayerIsPlayer1() && currentSpace.getOwner() == null) {
                player.payBanker(oldkentprice);
                statement.ownerOfHouse();
                currentSpace.setOwner(player2);
                statement.confirmOwnerShip();


            }


        }
    }

    /**
     * Method for player to pay rent on oldkent.
     * @param player
     */
    public void payOldKentRent(final Player player) {
        int currentPosition = player.getPlayerPosition();
        BoardSpace currentSpace = getSpaces()[currentPosition];

        if (currentSpace == BoardSpace.OLD_KENT_ROAD) {
            if (getCurrentPlayerIsPlayer1() && currentSpace.getOwner() != player1 &&  currentSpace.getPayingrent() == null) {
                player.payRent(oldkentRentprice);
                System.out.println("Player paid rent");
                currentSpace.setPayingrent(player2);


            } else if (!getCurrentPlayerIsPlayer1() && currentSpace.getOwner() != player2 && currentSpace.getPayingrent() == null) {
                player.payRent(oldkentRentprice);
                System.out.println("Player paid rent");
                currentSpace.setPayingrent(player1);

            }
        }

    }
}


