package com.cm6123.monopoly.app;

import com.cm6123.monopoly.game.MonopolyBoard;
import com.cm6123.monopoly.game.Player;



/**
 * Interface for game logic.
 */
public interface GameLogic {

    /**
     * Created board object.
     */

    MonopolyBoard BOARD = new MonopolyBoard();
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

    //public void Ask();


    /**
     * method for printing who purchased property .
     */
     void ownerOfHouse();


    /**
     * method for printing confirmation of who owns property .
     */

     void confirmOwnerShip();






}
