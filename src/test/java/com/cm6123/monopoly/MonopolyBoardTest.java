package com.cm6123.monopoly;

import com.cm6123.monopoly.dice.TestDice;
import com.cm6123.monopoly.game.MonopolyBoard;
import com.cm6123.monopoly.game.Player;
import com.cm6123.monopoly.game.Properties;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonopolyBoardTest {

    // Parammeterized Test for Landing on Spaces 2-12
    @ParameterizedTest
    @MethodSource("LandingOnBoardSpaces")
    public void playerRollsDiceOnGOAndLandsOnCorrectSpace(int[] rollValues, MonopolyBoard.BoardSpace spaceResult) {
        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();

        //Given
        player.setPlayerPosition(0);

        //When
        TestDice mockdice = new TestDice(rollValues);
        board.setDice(mockdice);
        board.playTurn(player);

        //Then

        assertEquals(spaceResult, board.getSpaces()[player.getPlayerPosition()]);
    }

    private static Stream<Arguments> LandingOnBoardSpaces() {
        return Stream.of(
                Arguments.of(new int[]{1, 1}, MonopolyBoard.BoardSpace.ROAD),
                Arguments.of(new int[]{2, 1}, MonopolyBoard.BoardSpace.OLD_KENT_ROAD),
                Arguments.of(new int[]{2, 2}, MonopolyBoard.BoardSpace.PALL_MALL),
                Arguments.of(new int[]{4, 1}, MonopolyBoard.BoardSpace.ROAD),
                Arguments.of(new int[]{3, 3}, MonopolyBoard.BoardSpace.PADDIGTON),
                Arguments.of(new int[]{5, 2}, MonopolyBoard.BoardSpace.ROAD),
                Arguments.of(new int[]{6, 2}, MonopolyBoard.BoardSpace.THE_STRAND),
                Arguments.of(new int[]{5, 4}, MonopolyBoard.BoardSpace.ROAD),
                Arguments.of(new int[]{5, 5}, MonopolyBoard.BoardSpace.TAX_OFFICE),
                Arguments.of(new int[]{6, 6}, MonopolyBoard.BoardSpace.LEICESTER_SQUARE)

        );

    }

    //Parameterized test for landing on spaces 13-15 and on Go from space 11.
    @ParameterizedTest
    @MethodSource("LandingOnBoardSpaces2")
    public void playerRollsDiceAndLandsOnCorrectSpace(int[] rollValues, MonopolyBoard.BoardSpace spaceResult) {
        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();

        //Given
        player.setPlayerPosition(10);

        //When
        TestDice mockdice = new TestDice(rollValues);
        board.setDice(mockdice);
        board.playTurn(player);

        //Then

        assertEquals(spaceResult, board.getSpaces()[player.getPlayerPosition()]);
    }

    private static Stream<Arguments> LandingOnBoardSpaces2() {
        return Stream.of(
                Arguments.of(new int[]{1, 1}, MonopolyBoard.BoardSpace.LEICESTER_SQUARE),
                Arguments.of(new int[]{1, 2}, MonopolyBoard.BoardSpace.ROAD),
                Arguments.of(new int[]{3, 1}, MonopolyBoard.BoardSpace.PARK_LANE),
                Arguments.of(new int[]{4, 2}, MonopolyBoard.BoardSpace.HOME),
                Arguments.of(new int[]{3, 2}, MonopolyBoard.BoardSpace.ROAD)


        );


    }

    @Test
    public void PlayerRecieveMoneyOnHomeSpace() {
        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();


        //Given
        player.setPlayerPosition(10);


        //When
        TestDice mockdice = new TestDice(new int[]{3, 3});
        board.setDice(mockdice);
        int currentPlayerBalance = player.getPlayerBalance();
        int expectedPlayerBalance = currentPlayerBalance + 200;
        board.playTurn(player);


        //Then

        assertEquals(expectedPlayerBalance, player.getPlayerBalance());


    }


    // Test to check if player lands on station they pay the ticket fee
    @Test
    public void PaddingtonTicket() {
        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();


        //Given
        player.setPlayerPosition(2);


        //When
        int[] rolls = {2, 2};
        TestDice mockdice = new TestDice(rolls);
        board.setDice(mockdice);
        int currentPlayerBalance = player.getPlayerBalance();
        board.playTurn(player);

        //Then

        int expectedPlayerBalance = currentPlayerBalance - (10 * (2 + 2));
        int actualMoney = player.getPlayerBalance();


        assertEquals(expectedPlayerBalance, player.getPlayerBalance());


    }

    // Test to check when player lands on Waterloo they pay correct ticket fee
    @Test
    public void WaterlooTicket() {
        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();


        //Given
        player.setPlayerPosition(4);


        //When
        int[] rolls = {5, 2};
        TestDice mockdice = new TestDice(rolls);
        board.setDice(mockdice);
        int currentPlayerBalance = player.getPlayerBalance();
        board.playTurn(player);

        //Then

        int expectedPlayerBalance = currentPlayerBalance - (10 * (5 + 2));
        int actualMoney = player.getPlayerBalance();


        assertEquals(expectedPlayerBalance, player.getPlayerBalance());


    }


    // Test to check when player rolls single values they pay 10 % of current balance as tax
    @Test
    public void PlayerPayTaxFeeSingle() {
        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();


        //Given
        player.setPlayerPosition(4);


        //When
        int[] rolls = {4, 2};
        TestDice mockdice = new TestDice(rolls);
        board.setDice(mockdice);
        int currentPlayerBalance = player.getPlayerBalance();
        board.playTurn(player);

        //Then


        double expectedPlayerBalance = currentPlayerBalance - (currentPlayerBalance * 0.1);


        assertEquals(expectedPlayerBalance, player.getPlayerBalance());


    }

    //Test to check when player rolls a double they pay 5% of currentBalance as tax
    @Test
    public void playerPayTaxDouble() {
        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();


        //Given
        player.setPlayerPosition(0);


        //When
        int[] rolls = {5, 5};
        TestDice mockdice = new TestDice(rolls);
        board.setDice(mockdice);
        int currentPlayerBalance = player.getPlayerBalance();
        board.playTurn(player);

        //Then


        double expectedPlayerBalance = currentPlayerBalance - ((currentPlayerBalance * 0.1) / 2);


        assertEquals(expectedPlayerBalance, player.getPlayerBalance());


    }



    //Test for player buying old kent
    @Test
    public void playerBuyOldKent() {
        MonopolyBoard board = new MonopolyBoard();
        Properties oldkent = new Properties();
        Player player = board.getPlayer1();


        //Given
        player.setPlayerPosition(3);

        //When
        oldkent.buyOldKent(player);


        //Then

        int currentPlayerBalance = player.getPlayerBalance();
        int expectedPlayerBalance = currentPlayerBalance;


        assertEquals(expectedPlayerBalance, player.getPlayerBalance());


    }


    @Test
    public void player2BuyOldKent() {
        MonopolyBoard board = new MonopolyBoard();
        Properties oldkent = new Properties();
        Player player = board.getPlayer2();


        //Given
        player.setPlayerPosition(3);

        //When
        oldkent.buyOldKent(player);


        //Then

        int currentPlayerBalance = player.getPlayerBalance();
        int expectedPlayerBalance = currentPlayerBalance;


        assertEquals(expectedPlayerBalance, player.getPlayerBalance());


    }


    @Test
    public void playerBuysPallMall() {
        MonopolyBoard board = new MonopolyBoard();
        Properties pallmall = new Properties();
        Player player = board.getPlayer1();


        //Given
        player.setPlayerPosition(4);

        //When
        pallmall.buyPallMall(player);


        //Then

        int currentPlayerBalance = player.getPlayerBalance();
        int expectedPlayerBalance = currentPlayerBalance;


        assertEquals(expectedPlayerBalance, player.getPlayerBalance());


    }

    @Test
    public void playerBuysTheStrand() {
        MonopolyBoard board = new MonopolyBoard();
        Properties thestrand = new Properties();
        Player player = board.getPlayer1();


        //Given
        player.setPlayerPosition(8);

        //When
        thestrand.buyTheStrand(player);


        //Then

        int currentPlayerBalance = player.getPlayerBalance();
        double expectedPlayerBalance = currentPlayerBalance;


        assertEquals(expectedPlayerBalance, player.getPlayerBalance());


    }


    @Test
    public void playerBuyLeicesterSquare() {
        MonopolyBoard board = new MonopolyBoard();
        Properties ls = new Properties();
        Player player = board.getPlayer1();


        //Given
        player.setPlayerPosition(12);

        //When
        ls.buyLeicesterSquare(player);


        //Then
        int currentPlayerBalance = player.getPlayerBalance();
        int expectedPlayerBalance = currentPlayerBalance;


        assertEquals(expectedPlayerBalance, player.getPlayerBalance());


    }


    @Test
    public void playerbuysParkLane() {
        MonopolyBoard board = new MonopolyBoard();
        Properties pl = new Properties();
        Player player = board.getPlayer1();


        //Given
        player.setPlayerPosition(14);

        //When
        pl.buyParkLane(player);


        //Then

        int currentPlayerBalance = player.getPlayerBalance();
        int expectedPlayerBalance = currentPlayerBalance;


        assertEquals(expectedPlayerBalance, player.getPlayerBalance());


    }


    @Test
    public void playercantBuyOldKent() {
        MonopolyBoard board = new MonopolyBoard();
        Properties oldkent = new Properties();
        Player player = board.getPlayer1();


        //Given
        player.setPlayerPosition(3);
        player.setPlayerBalance(30);

        //When
        oldkent.buyOldKent(player);


        //Then

        int currentPlayerBalance = player.getPlayerBalance();
        int expectedPlayerBalance = currentPlayerBalance;


        assertEquals(expectedPlayerBalance, player.getPlayerBalance());


    }


    @Test
    public void playercantBuyPallMall() {
        MonopolyBoard board = new MonopolyBoard();
        Properties pm = new Properties();
        Player player = board.getPlayer1();


        //Given
        player.setPlayerPosition(4);
        player.setPlayerBalance(60);

        //When
        pm.buyPallMall(player);


        //Then

        int currentPlayerBalance = player.getPlayerBalance();
        int expectedPlayerBalance = currentPlayerBalance;


        assertEquals(expectedPlayerBalance, player.getPlayerBalance());


    }

    @Test
    public void playercantBuyTheStrand() {
        MonopolyBoard board = new MonopolyBoard();
        Properties ts = new Properties();
        Player player = board.getPlayer1();


        //Given
        player.setPlayerPosition(8);
        player.setPlayerBalance(80);

        //When
        ts.buyTheStrand(player);


        //Then
        int currentPlayerBalance = player.getPlayerBalance();
        int expectedPlayerBalance = currentPlayerBalance;


        assertEquals(expectedPlayerBalance, player.getPlayerBalance());


    }


    @Test
    public void playercantBuyParkLane() {
        MonopolyBoard board = new MonopolyBoard();
        Properties pl = new Properties();
        Player player = board.getPlayer1();


        //Given
        player.setPlayerPosition(14);
        player.setPlayerBalance(120);

        //When
        pl.buyParkLane(player);


        //Then

        int currentPlayerBalance = player.getPlayerBalance();
        int expectedPlayerBalance = currentPlayerBalance;


        assertEquals(expectedPlayerBalance, player.getPlayerBalance());


    }



    @Test
    public void playercantBuyLeicesterSquare() {
        MonopolyBoard board = new MonopolyBoard();
        Properties ls = new Properties();
        Player player = board.getPlayer1();


        //Given
        player.setPlayerPosition(12);
        player.setPlayerBalance(100);

        //When
        ls.buyLeicesterSquare(player);


        //Then

        int currentPlayerBalance = player.getPlayerBalance();
        int expectedPlayerBalance = currentPlayerBalance;


        assertEquals(expectedPlayerBalance, player.getPlayerBalance());


    }




}

























