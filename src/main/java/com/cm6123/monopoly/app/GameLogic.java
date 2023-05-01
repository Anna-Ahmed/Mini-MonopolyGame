package com.cm6123.monopoly.app;

import com.cm6123.monopoly.game.MonopolyBoard;
import com.cm6123.monopoly.game.Player;
import com.cm6123.monopoly.game.Properties;


/**
 * Interface for game logic.
 */
public interface GameLogic {

    /**
     * Created board object.
     */

    MonopolyBoard BOARD = new MonopolyBoard();


    /**
     * Created property object.
     */

    Properties PROPERTIES = new Properties();
    /**
     * created  player object using Player class.
     */

    Player PLAYER = new Player();

    /**
     * method for rolling the dice for player 1.
     */
    void player1Turn();

    /**
     * method for rolling the dice for player2.
     */
     void player2Turn();

    /**
     * method to ask player if they want to buy property.
     */
     void ask();

    /**
     * method for asking player 1s name.
     */
     void Askplayer1sName();

    /**
     * method for asking player 2s name.
     */

    void Askplayer2sName();


    /**
     * method for printing who purchased old kent .
     */
     void ownerOfOldKent();


    /**
     * method for printing confirmation of who owns old kent .
     */

     void confirmOwnerShipOfOldKent();

    /**
     * method for printing who purchased pall mall .
     */
     void ownerOfPallMall();

    /**
     * method for printing confirmation of who owns pall mall .
     */

     void confirmOwnershipOfPallMall();


    /**
     * method for printing player paid rent.
     */

     void displaypaidrent();


    /**
     * method for printing player has no funds.
     */
     void dipslayNoFunds();

    /**
     * method for printing player has no funds to pay rent.
     */

    void dipslayNoFundsforrent();



    /**
     * method for printing who purchased the strand .
     */
    void ownerOfTheStrand();

    /**
     * method for printing confirmation of who owns the strand .
     */

    void confirmOwnershipOfTheStrand();


    /**
     * method for printing who purchased parklane.
     */
    void ownerOfParkLane();

    /**
     * method for printing confirmation of who owns parklane.
     */

    void confirmOwnershipOfParkLane();



    /**
     * method for printing who purchased leicester square.
     */
    void ownerOfLeicesterSquare();

    /**
     * method for printing confirmation of who owns leicester square .
     */

    void confirmOwnershipOfLeicesterSquare();






}
