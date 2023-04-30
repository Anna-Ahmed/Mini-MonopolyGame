package com.cm6123.monopoly.game;

import com.cm6123.monopoly.app.GameLogicHandlers;

public class PropertiesAndRent extends MonopolyBoard {

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
     * price of the strand.
     */



    private int thestrandprice;

    /**
     * rent price of the strand.
     */



    private int thestrandrentprice;

    /**
     * price of lecister square.
     */

    private int lecistersquareprice;


    /**
     *  rent price of parklane.
     */

    private int lecistersquarerentprice;

    /**
     * price of parklane.
     */

    private int parklaneprice;

    /**
     * rent price of parklane.
     */


    private int parklanerentprice;


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
    public PropertiesAndRent() {
        this.oldkentprice = 60;
        this.oldkentRentprice = 6;
        this.pallmallprice = 140;
        this.pallmallrentprice=14;
        this.thestrandprice = 220;
        this.thestrandrentprice = 22;
        this.lecistersquareprice=260;
        this.lecistersquarerentprice=26;
        this.parklaneprice = 350;
        this.pallmallrentprice = 35;
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
                //   } else if (player.getPlayerBalance() < oldkentprice)
                //     statement.dipslayNoFunds();

                //}
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

            }else if(player.getPlayerBalance() < oldkentRentprice){
                statement.dipslayNoFundsforrent();
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
            }else if (player.getPlayerBalance() < pallmallprice) {
                statement.dipslayNoFunds();

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

            }else if(player.getPlayerBalance() < pallmallrentprice) {
                statement.dipslayNoFundsforrent();
            }
        }

    }

    /**
     * Method to buy the strand.
     * @param player
     */

    public void buyTheStrand(final Player player) {
        player1 = getPlayer1();
        player2 = getPlayer2();
        int currentPosition = player.getPlayerPosition();
        BoardSpace currentSpace = getSpaces()[currentPosition];

        if (currentSpace == BoardSpace.THE_STRAND) {
            if (getCurrentPlayerIsPlayer1() && currentSpace.getOwner() == null && player.getPlayerBalance() >= thestrandprice) {
                player.payBanker(thestrandprice);
                statement.ownerOfTheStrand();


                currentSpace.setOwner(player1);
                statement.confirmOwnershipOfTheStrand();

            } else if (!getCurrentPlayerIsPlayer1() && currentSpace.getOwner() == null) {
                player.payBanker(thestrandprice);
                statement.ownerOfTheStrand();
                currentSpace.setOwner(player2);
                statement.confirmOwnershipOfTheStrand();


            }else if (player.getPlayerBalance() < thestrandprice) {
                statement.dipslayNoFunds();
            }

        }
    }

    /**
     * Method to pay rent on The Strand.
     * @param player
     */
    public void payTheStrandRent(final Player player) {
        int currentPosition = player.getPlayerPosition();
        BoardSpace currentSpace = getSpaces()[currentPosition];

        if (currentSpace == BoardSpace.THE_STRAND) {
            if (getCurrentPlayerIsPlayer1() && currentSpace.getOwner() != player1 && currentSpace.getPayingrent() == null) {
                player.payRent(thestrandrentprice);
                statement.displaypaidrent();
                currentSpace.setPayingrent(player2);


            } else if (!getCurrentPlayerIsPlayer1() && currentSpace.getOwner() != player2 && currentSpace.getPayingrent() == null) {
                player.payRent(thestrandrentprice);
                statement.displaypaidrent();
                currentSpace.setPayingrent(player1);

            } else if (player.getPlayerBalance() < thestrandrentprice) {
                statement.dipslayNoFundsforrent();
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
            if (getCurrentPlayerIsPlayer1() && currentSpace.getOwner() == null && player.getPlayerBalance() >= lecistersquareprice) {
                player.payBanker(lecistersquareprice);
                statement.ownerOfLeicesterSquare();


                currentSpace.setOwner(player1);
                statement.confirmOwnershipOfLeicesterSquare();

            } else if (!getCurrentPlayerIsPlayer1() && currentSpace.getOwner() == null) {
                player.payBanker(lecistersquareprice);
                statement.ownerOfLeicesterSquare();
                currentSpace.setOwner(player2);
                statement.confirmOwnershipOfLeicesterSquare();


            } else if(player.getPlayerBalance() < lecistersquareprice) {
                statement.dipslayNoFunds();
            }

        }
    }

    /**
     * Method for player to pay rent on Leicester Square.
     * @param player
     */
    public void payLeicesterSquareRent(final Player player) {
        int currentPosition = player.getPlayerPosition();
        BoardSpace currentSpace = getSpaces()[currentPosition];

        if (currentSpace == BoardSpace.LEICESTER_SQUARE) {
            if (getCurrentPlayerIsPlayer1() && currentSpace.getOwner() != player1 &&  currentSpace.getPayingrent() == null) {
                player.payRent(lecistersquarerentprice);
                statement.displaypaidrent();
                currentSpace.setPayingrent(player2);


            } else if (!getCurrentPlayerIsPlayer1() && currentSpace.getOwner() != player2 && currentSpace.getPayingrent() == null) {
                player.payRent(lecistersquarerentprice);
                statement.displaypaidrent();
                currentSpace.setPayingrent(player1);

            }else if(player.getPlayerBalance() < lecistersquarerentprice){
                statement.dipslayNoFundsforrent();
            }
        }

    }



    /**
     * Method to buy parklane.
     * @param player
     */

    public void buyParkLane(final Player player) {
        player1 = getPlayer1();
        player2 = getPlayer2();
        int currentPosition = player.getPlayerPosition();
        BoardSpace currentSpace = getSpaces()[currentPosition];

        if (currentSpace == BoardSpace.PARK_LANE) {
            if (getCurrentPlayerIsPlayer1() && currentSpace.getOwner() == null && player.getPlayerBalance() >= parklaneprice) {
                player.payBanker(parklaneprice);
                statement.ownerOfParkLane();


                currentSpace.setOwner(player1);
                statement.confirmOwnershipOfParkLane();

            } else if (!getCurrentPlayerIsPlayer1() && currentSpace.getOwner() == null) {
                player.payBanker(parklaneprice);
                statement.ownerOfParkLane();
                currentSpace.setOwner(player2);
                statement.confirmOwnershipOfParkLane();


            }else if (player.getPlayerBalance() < parklaneprice) {
                statement.dipslayNoFunds();
            }

        }
    }

    /**
     * Method to pay rent on park lane.
     * @param player
     */
    public void payParkLaneRent(final Player player) {
        int currentPosition = player.getPlayerPosition();
        BoardSpace currentSpace = getSpaces()[currentPosition];

        if (currentSpace == BoardSpace.PARK_LANE) {
            if (getCurrentPlayerIsPlayer1() && currentSpace.getOwner() != player1 && currentSpace.getPayingrent() == null) {
                player.payRent(parklanerentprice);
                statement.displaypaidrent();
                currentSpace.setPayingrent(player2);


            } else if (!getCurrentPlayerIsPlayer1() && currentSpace.getOwner() != player2 && currentSpace.getPayingrent() == null) {
                player.payRent(parklaneprice);
                statement.displaypaidrent();
                currentSpace.setPayingrent(player1);

            } else if (player.getPlayerBalance() < parklanerentprice) {
                statement.dipslayNoFundsforrent();
            }
        }
    }
}


