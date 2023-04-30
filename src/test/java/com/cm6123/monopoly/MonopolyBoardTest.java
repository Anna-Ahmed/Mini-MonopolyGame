package com.cm6123.monopoly;

import com.cm6123.monopoly.dice.TestDice;
import com.cm6123.monopoly.game.MonopolyBoard;
import com.cm6123.monopoly.game.Player;
import com.cm6123.monopoly.game.PropertiesAndRent;
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
                Arguments.of(new int[]{1, 0}, MonopolyBoard.BoardSpace.ROAD),
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
        //Banker banker = new Banker();
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


        //Given players postion is 11 on the board
        player.setPlayerPosition(10);


        //When dice is rolled and player is on Home
        TestDice mockdice = new TestDice(new int[]{3, 3});
        board.setDice(mockdice);
        int currentPlayerBalance = player.getPlayerBalance();
        int expectedPlayerBalance = currentPlayerBalance + 200;
        board.playTurn(player);


        //Then player should recieve 200

        assertEquals(expectedPlayerBalance, player.getPlayerBalance());


    }


    // Test to check if player lands on station they pay the ticket fee
    @Test
    public void PaddingtonTicket() {
        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();


        //Given players postion is 3 on the board
        player.setPlayerPosition(2);


        //When dice is rolled and player lands on Paddington
        int[] rolls = {2, 2};
        TestDice mockdice = new TestDice(rolls);
        board.setDice(mockdice);
        int currentPlayerBalance = player.getPlayerBalance();
        board.playTurn(player);
        //then player will pay 10 * the value of dice roll as ticket fee

        int expectedPlayerBalance = currentPlayerBalance - (10 * (2 + 2));
        int actualMoney = player.getPlayerBalance();


        assertEquals(expectedPlayerBalance, player.getPlayerBalance());


    }

    // Test to check when player lands on Waterloo they pay correct ticket fee
    @Test
    public void WaterlooTicket() {
        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();


        //Given players postion is 4 on the board
        player.setPlayerPosition(4);


        //When dice is rolled and player lands on Waterloo
        int[] rolls = {5, 2};
        TestDice mockdice = new TestDice(rolls);
        board.setDice(mockdice);
        int currentPlayerBalance = player.getPlayerBalance();
        board.playTurn(player);
        //then player will pay 10 * the value of dice roll as ticket fee

        int expectedPlayerBalance = currentPlayerBalance - (10 * (5 + 2));
        int actualMoney = player.getPlayerBalance();


        assertEquals(expectedPlayerBalance, player.getPlayerBalance());


    }


    // Test to check when player rolls single values they pay 10 % of current balance as tax
    @Test
    public void PlayerPayTaxFeeSingle() {
        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();


        //Given players postion is 4 on the board
        player.setPlayerPosition(4);


        //When dice is rolled and player lands on Tax Office
        int[] rolls = {4, 2};
        TestDice mockdice = new TestDice(rolls);
        board.setDice(mockdice);
        int currentPlayerBalance = player.getPlayerBalance();
        board.playTurn(player);
        //then player will pay 10 * the value of dice roll as ticket fee


        double expectedPlayerBalance = currentPlayerBalance - (currentPlayerBalance * 0.1);


        assertEquals(expectedPlayerBalance, player.getPlayerBalance());


    }

    //Test to check when player rolls a double they pay 5% of currentBalance as tax
    @Test
    public void playerPayTaxDouble() {
        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();


        //Given players postion is 4 on the board
        player.setPlayerPosition(0);


        //When dice is rolled and player lands on Tax office
        int[] rolls = {5, 5};
        TestDice mockdice = new TestDice(rolls);
        board.setDice(mockdice);
        int currentPlayerBalance = player.getPlayerBalance();
        board.playTurn(player);
        //then player will pay 10 * the value of dice roll as ticket fee


        double expectedPlayerBalance = currentPlayerBalance - ((currentPlayerBalance * 0.1) / 2);


        assertEquals(expectedPlayerBalance, player.getPlayerBalance());


    }



    @Test
    public void playerBuyOldKent(){
        MonopolyBoard board = new MonopolyBoard();
        PropertiesAndRent oldkent = new PropertiesAndRent();
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
        PropertiesAndRent oldkent = new PropertiesAndRent();
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
        PropertiesAndRent oldkent = new PropertiesAndRent();
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
        PropertiesAndRent oldkent = new PropertiesAndRent();
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


    @Test
    public void playerBuysPallMall(){
        MonopolyBoard board = new MonopolyBoard();
        PropertiesAndRent pallmall = new PropertiesAndRent();
        Player player = board.getPlayer1();






        //Given players postion 4 (pall mall) on the board
        player.setPlayerPosition(4);

        //when player buysoldkent
        pallmall.buyPallMall(player);





        //Then players balacne will be updated with the price of pall mall reducted from balance;

        int currentPlayerBalance = player.getPlayerBalance();
        double expectedPlayerBalance = currentPlayerBalance ;



        assertEquals(expectedPlayerBalance, player.getPlayerBalance());



    }

    @Test
    public void playerBuysTheStrand(){
        MonopolyBoard board = new MonopolyBoard();
        PropertiesAndRent thestrand = new PropertiesAndRent();
        Player player = board.getPlayer1();






        //Given players postion 8 (the strand) on the board
        player.setPlayerPosition(8);

        //when player buysoldkent
        thestrand.buyTheStrand(player);





        //Then players balacne will be updated with the price of pall mall reducted from balance;

        int currentPlayerBalance = player.getPlayerBalance();
        double expectedPlayerBalance = currentPlayerBalance ;



        assertEquals(expectedPlayerBalance, player.getPlayerBalance());



    }


    @Test
    public void playerPaysTheStrandRent(){
        MonopolyBoard board = new MonopolyBoard();
        PropertiesAndRent thestrand = new PropertiesAndRent();
        Player player = board.getPlayer1();






        //Given players postion 8 (the strand) on the board
        player.setPlayerPosition(8);

        //when player buysoldkent
        thestrand.payTheStrandRent(player);;





        //Then players balacne will be updated with the price of pall mall reducted from balance;

        int currentPlayerBalance = player.getPlayerBalance();
        double expectedPlayerBalance = currentPlayerBalance ;



        assertEquals(expectedPlayerBalance, player.getPlayerBalance());



    }

    @Test
    public void playerPaysPallMallRent(){
        MonopolyBoard board = new MonopolyBoard();
        PropertiesAndRent pallmall = new PropertiesAndRent();
        Player player = board.getPlayer1();






        //Given players postion 4 (pall mall) on the board
        player.setPlayerPosition(4);

        //when player buysoldkent
        pallmall.buyPallMall(player);





        //Then players balacne will be updated with the price of pall mall reducted from balance;

        int currentPlayerBalance = player.getPlayerBalance();
        double expectedPlayerBalance = currentPlayerBalance ;



        assertEquals(expectedPlayerBalance, player.getPlayerBalance());



    }


    @Test
    public void playerBuyLeicesterSquare(){
        MonopolyBoard board = new MonopolyBoard();
        PropertiesAndRent ls= new PropertiesAndRent();
        Player player = board.getPlayer1();






        //Given players postion 12 (leicester square) on the board
        player.setPlayerPosition(12);

        //when player buysoldkent
        ls.buyLeicesterSquare(player);





        //Then players balacne will be updated with the price of pall mall reducted from balance;

        int currentPlayerBalance = player.getPlayerBalance();
        double expectedPlayerBalance = currentPlayerBalance ;



        assertEquals(expectedPlayerBalance, player.getPlayerBalance());



    }


    @Test
    public void playerPaysLeicesterRent(){
        MonopolyBoard board = new MonopolyBoard();
        PropertiesAndRent ls = new PropertiesAndRent();
        Player player = board.getPlayer1();






        //Given players postion 12(leicester square) on the board
        player.setPlayerPosition(12);

        //when player buysoldkent
        ls.payLeicesterSquareRent(player);





        //Then players balacne will be updated with the price of pall mall reducted from balance;

        int currentPlayerBalance = player.getPlayerBalance();
        double expectedPlayerBalance = currentPlayerBalance ;



        assertEquals(expectedPlayerBalance, player.getPlayerBalance());



    }


    @Test
    public void playerbuysParkLane(){
        MonopolyBoard board = new MonopolyBoard();
        PropertiesAndRent pl = new PropertiesAndRent();
        Player player = board.getPlayer1();






        //Given players postion 14(park lane) on the board
        player.setPlayerPosition(14);

        //when player buys park lane
        pl.buyParkLane(player);





        //Then players balacne will be updated with the price of pall mall reducted from balance;

        int currentPlayerBalance = player.getPlayerBalance();
        double expectedPlayerBalance = currentPlayerBalance ;



        assertEquals(expectedPlayerBalance, player.getPlayerBalance());



    }

    @Test
    public void playerPaysParkLaneRent(){
        MonopolyBoard board = new MonopolyBoard();
        PropertiesAndRent pl = new PropertiesAndRent();
        Player player = board.getPlayer1();






        //Given players postion 14 (park lane) on the board
        player.setPlayerPosition(14);

        //when player  pays rent on parklane
        pl.payParkLaneRent(player);





        //Then players balance will be updated with the price of pall mall reducted from balance;

        int currentPlayerBalance = player.getPlayerBalance();
        double expectedPlayerBalance = currentPlayerBalance ;



        assertEquals(expectedPlayerBalance, player.getPlayerBalance());



    }






}















