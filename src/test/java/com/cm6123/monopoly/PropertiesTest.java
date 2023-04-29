package com.cm6123.monopoly;

import com.cm6123.monopoly.dice.TestDice;
import com.cm6123.monopoly.game.MonopolyBoard;
import com.cm6123.monopoly.game.Player;
import com.cm6123.monopoly.game.Properties;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropertiesTest {

    @Test
    public void playerBuyOldKent(){
        MonopolyBoard board = new MonopolyBoard();
        Properties oldkent = new Properties();
        Player player = board.getPlayer1();
        int currentPosition = player.getPlayerPosition();
        MonopolyBoard.BoardSpace currentSpace = oldkent.getSpaces()[currentPosition];
        currentSpace.setOwner(player);




        //Given players postion is 4 on the board
        player.setPlayerPosition(1);





        //When dice is rolled and player lands on Tax office
        int[] rolls = {1,1};
        TestDice mockdice = new TestDice(rolls);
        board.setDice(mockdice);

        int currentPlayerBalance = player.getPlayerBalance();
        int cost = oldkent.getOldkentprice();

        board.playTurn(player);
        //then player will pay 10 * the value of dice roll as ticket fee


        double expectedPlayerBalance = currentPlayerBalance - cost;



        assertEquals(expectedPlayerBalance, player.getPlayerBalance());



    }


    @Test
    public void playerPayRentOnOldKent(){
        MonopolyBoard board = new MonopolyBoard();
        Properties oldkent = new Properties();
        Player player = board.getPlayer1();
        int currentPosition = player.getPlayerPosition();
        MonopolyBoard.BoardSpace currentSpace = oldkent.getSpaces()[currentPosition];
        currentSpace.setPayingrent(player);




        //Given players postion is 4 on the board
        player.setPlayerPosition(1);





        //When dice is rolled and player lands on Tax office
        int[] rolls = {1,1};
        TestDice mockdice = new TestDice(rolls);
        board.setDice(mockdice);

        int currentPlayerBalance = player.getPlayerBalance();
        int rentcost = oldkent.getOldkentRentprice();

        board.playTurn(player);
        //then player will pay 10 * the value of dice roll as ticket fee


        double expectedPlayerBalance = currentPlayerBalance - rentcost;



        assertEquals(expectedPlayerBalance, player.getPlayerBalance());



    }



}





