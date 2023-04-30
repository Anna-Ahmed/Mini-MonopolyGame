package com.cm6123.monopoly.game;

import com.cm6123.monopoly.app.GameLogicHandlers;

public class Properties extends MonopolyBoard {

    /**
     * price of old kent road.
     */

    private int oldkentprice;




    /**
     * rent price of old kent road.
     */
    private int oldkentRentprice;


    /**
     * price of pall mall.
     */



    private int pallmallprice;

    /**
     * rent price of pall mall.
     */


    private int pallmallrentprice;


    /**
     *  player1 is used to create player1 object.
     */


    private Player player1;

    /**
     *  player2 is used to create player2 object.
     */

    private Player player2;
    /**
     * A new GameLogicHandler object is created.
     */
    private GameLogicHandlers statement;


    /**
     * Constructor for properties class.
     */
    public Properties() {
        this.oldkentprice = 60;
        this.oldkentRentprice = 6;
        this.pallmallprice = 140;
        this.pallmallrentprice=14;
        this.statement = new GameLogicHandlers();


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
                statement.ownerOfOldKent();


                currentSpace.setOwner(player1);
                statement.confirmOwnerShipOfOldKent();

            } else if (!getCurrentPlayerIsPlayer1() && currentSpace.getOwner() == null) {
                player.payBanker(oldkentprice);
                statement.ownerOfOldKent();
                currentSpace.setOwner(player2);
                statement.confirmOwnershipOfPallMall();


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
                statement.displaypaidrent();
                currentSpace.setPayingrent(player2);


            } else if (!getCurrentPlayerIsPlayer1() && currentSpace.getOwner() != player2 && currentSpace.getPayingrent() == null) {
                player.payRent(oldkentRentprice);
               statement.displaypaidrent();
                currentSpace.setPayingrent(player1);

            }
        }

    }

    /**
     * Method to buy pall mall.
     * @param player
     */

    public void buyPallMall(final Player player) {
        player1 = getPlayer1();
        player2 = getPlayer2();
        int currentPosition = player.getPlayerPosition();
        BoardSpace currentSpace = getSpaces()[currentPosition];

        if (currentSpace == BoardSpace.PALL_MALL) {
            if (getCurrentPlayerIsPlayer1() && currentSpace.getOwner() == null && player.getPlayerBalance() >= pallmallprice) {
                player.payBanker(pallmallprice);
                statement.ownerOfPallMall();


                currentSpace.setOwner(player1);
                statement.confirmOwnershipOfPallMall();

            } else if (!getCurrentPlayerIsPlayer1() && currentSpace.getOwner() == null) {
                player.payBanker(pallmallprice);
                statement.ownerOfPallMall();
                currentSpace.setOwner(player2);
                statement.confirmOwnershipOfPallMall();


            }


        }
    }

    /**
     * Method to pay rent on pall mall.
     * @param player
     */
    public void payPallMallRent(final Player player) {
        int currentPosition = player.getPlayerPosition();
        BoardSpace currentSpace = getSpaces()[currentPosition];

        if (currentSpace == BoardSpace.PALL_MALL) {
            if (getCurrentPlayerIsPlayer1() && currentSpace.getOwner() != player1 &&  currentSpace.getPayingrent() == null) {
                player.payRent(pallmallrentprice);
                statement.displaypaidrent();
                currentSpace.setPayingrent(player2);


            } else if (!getCurrentPlayerIsPlayer1() && currentSpace.getOwner() != player2 && currentSpace.getPayingrent() == null) {
                player.payRent(pallmallprice);
                statement.displaypaidrent();
                currentSpace.setPayingrent(player1);

            }
        }

    }
}


