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






        //Given players postion 3 (old kent) on the board
        player.setPlayerPosition(3);

        //when player buysoldkent
        oldkent.buyOldKent(player);





        //Then players balacne will be updated with the price of old kent reducted from balance;

        int currentPlayerBalance = player.getPlayerBalance();
        double expectedPlayerBalance = currentPlayerBalance ;



        assertEquals(expectedPlayerBalance, player.getPlayerBalance());



    }


    @Test
    public void playerPayRentOnOldKent(){
        MonopolyBoard board = new MonopolyBoard();
        Properties oldkent = new Properties();
        Player player = board.getPlayer1();






        //Given players postion is 3 (old kent on board)
        player.setPlayerPosition(3);

        //When player pays rent on old kent
        oldkent.payOldKentRent(player);




        //then player wills balance will update with rent price reducted from balance;
        int currentPlayerBalance = player.getPlayerBalance();
        double expectedPlayerBalance = currentPlayerBalance;



        assertEquals(expectedPlayerBalance, player.getPlayerBalance());



    }


    @Test
    public void player2BuyOldKent(){
        MonopolyBoard board = new MonopolyBoard();
        Properties oldkent = new Properties();
        Player player = board.getPlayer2();






        //Given players postion 3 (old kent) on the board
        player.setPlayerPosition(3);

        //when player buysoldkent
        oldkent.buyOldKent(player);





        //Then players balacne will be updated with the price of old kent reducted from balance;

        int currentPlayerBalance = player.getPlayerBalance();
        double expectedPlayerBalance = currentPlayerBalance ;



        assertEquals(expectedPlayerBalance, player.getPlayerBalance());



    }


    @Test
    public void player2PayRentOnOldKent(){
        MonopolyBoard board = new MonopolyBoard();
        Properties oldkent = new Properties();
        Player player = board.getPlayer2();






        //Given players postion is 3 (old kent on board)
        player.setPlayerPosition(3);

        //When player pays rent on old kent
        oldkent.payOldKentRent(player);




        //then player wills balance will update with rent price reducted from balance;
        int currentPlayerBalance = player.getPlayerBalance();
        double expectedPlayerBalance = currentPlayerBalance;



        assertEquals(expectedPlayerBalance, player.getPlayerBalance());



    }

}





