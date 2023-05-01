package com.cm6123.monopoly.game;

import com.cm6123.monopoly.app.GameLogicHandlers;

public class PropertiesAndRent extends MonopolyBoard {

    /**
     * price of old kent road.
     */

    private int oldkentprice;
    /**
     * price of pall mall.
     */


    private int pallmallprice;
    /**
     * price of the strand.
     */


    private int thestrandprice;

    /**
     * price of lecister square.
     */

    private int lecistersquareprice;

    /**
     * price of parklane.
     */

    private int parklaneprice;


    /**
     * player1 is used to create player1 object.
     */


    private Player player1;

    /**
     * player2 is used to create player2 object.
     */

    private Player player2;
    /**
     * A new GameLogicHandler object is created.
     */
    private GameLogicHandlers statement;


    /**
     * Constructor for properties class.
     */
    public PropertiesAndRent() {
        this.oldkentprice = 60;
        this.pallmallprice = 140;
        this.thestrandprice = 220;
        this.lecistersquareprice = 260;
        this.parklaneprice = 350;
        this.statement = new GameLogicHandlers();


    }

    /**
     * Method to buy Old Kent.
     *
     * @param player The Player object representing the player who wants to buy the house.
     */
    public void buyOldKent(final Player player) {
        player1 = getPlayer1();
        player2 = getPlayer2();
        int currentPosition = player.getPlayerPosition();
        BoardSpace currentSpace = getSpaces()[currentPosition];

        if (currentSpace == BoardSpace.OLD_KENT_ROAD) {
            if (currentSpace.getOwner() == null && player.getPlayerBalance() >= oldkentprice) {
                player.payBanker(oldkentprice);
                statement.ownerOfOldKent();


                currentSpace.setOwner(player);
                statement.confirmOwnerShipOfOldKent();


            }
        }
    }

    /**
     * Method to buy pall mall.
     *
     * @param player
     */

    public void buyPallMall(final Player player) {
        player1 = getPlayer1();
        player2 = getPlayer2();
        int currentPosition = player.getPlayerPosition();
        BoardSpace currentSpace = getSpaces()[currentPosition];

        if (currentSpace == BoardSpace.PALL_MALL) {
            if (currentSpace.getOwner() == null && player.getPlayerBalance() >= pallmallprice) {
                player.payBanker(pallmallprice);
                statement.ownerOfPallMall();


                currentSpace.setOwner(player);
                statement.confirmOwnershipOfPallMall();


            } else if (player.getPlayerBalance() < pallmallprice) {
                statement.dipslayNoFunds();

            }
        }
    }

    /**
     * Method to buy the strand.
     *
     * @param player
     */

    public void buyTheStrand(final Player player) {
        player1 = getPlayer1();
        player2 = getPlayer2();
        int currentPosition = player.getPlayerPosition();
        BoardSpace currentSpace = getSpaces()[currentPosition];

        if (currentSpace == BoardSpace.THE_STRAND) {
            if (currentSpace.getOwner() == null && player.getPlayerBalance() >= thestrandprice) {
                player.payBanker(thestrandprice);
                statement.ownerOfTheStrand();


                currentSpace.setOwner(player);
                statement.confirmOwnershipOfTheStrand();


            } else if (player.getPlayerBalance() < thestrandprice) {
                statement.dipslayNoFunds();
            }

        }
    }


    /**
     * Method to buy Leister Square.
     *
     * @param player The Player object representing the player who wants to buy the house.
     */
    public void buyLeicesterSquare(final Player player) {
        player1 = getPlayer1();
        player2 = getPlayer2();
        int currentPosition = player.getPlayerPosition();
        BoardSpace currentSpace = getSpaces()[currentPosition];

        if (currentSpace == BoardSpace.LEICESTER_SQUARE) {
            if (currentSpace.getOwner() == null && player.getPlayerBalance() >= lecistersquareprice) {
                player.payBanker(lecistersquareprice);
                statement.ownerOfLeicesterSquare();


                currentSpace.setOwner(player);
                statement.confirmOwnershipOfLeicesterSquare();


            } else if (player.getPlayerBalance() < lecistersquareprice) {
                statement.dipslayNoFunds();
            }

        }
    }


    /**
     * Method to buy parklane.
     *
     * @param player
     */

    public void buyParkLane(final Player player) {
        player1 = getPlayer1();
        player2 = getPlayer2();
        int currentPosition = player.getPlayerPosition();
        BoardSpace currentSpace = getSpaces()[currentPosition];

        if (currentSpace == BoardSpace.PARK_LANE) {
            if (currentSpace.getOwner() == null && player.getPlayerBalance() >= parklaneprice) {
                player.payBanker(parklaneprice);
                statement.ownerOfParkLane();


                currentSpace.setOwner(player);
                statement.confirmOwnershipOfParkLane();


            } else if (player.getPlayerBalance() < parklaneprice) {
                statement.dipslayNoFunds();
            }

        }
    }
}

