package com.cm6123.monopoly;

import com.cm6123.monopoly.dice.TestDice;
import com.cm6123.monopoly.game.MonopolyBoard;
import com.cm6123.monopoly.game.Player;
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
                Arguments.of(new int[]{2, 1}, MonopolyBoard.BoardSpace.ROAD),
                Arguments.of(new int[]{2, 2}, MonopolyBoard.BoardSpace.OLD_KENT_ROAD),
                Arguments.of(new int[]{2, 3}, MonopolyBoard.BoardSpace.PALL_MALL),
                Arguments.of(new int[]{4, 2}, MonopolyBoard.BoardSpace.ROAD),
                Arguments.of(new int[]{3, 4}, MonopolyBoard.BoardSpace.PADDIGTON),
                Arguments.of(new int[]{5, 3}, MonopolyBoard.BoardSpace.ROAD),
                Arguments.of(new int[]{6, 3}, MonopolyBoard.BoardSpace.THE_STRAND),
                Arguments.of(new int[]{5, 5}, MonopolyBoard.BoardSpace.ROAD),
                Arguments.of(new int[]{5, 5}, MonopolyBoard.BoardSpace.ROAD),
                Arguments.of(new int[]{6, 5}, MonopolyBoard.BoardSpace.TAX_OFFICE),
                Arguments.of(new int[]{6, 6}, MonopolyBoard.BoardSpace.WATERLOO)

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
        player.setPlayerPosition(11);

        //When
        TestDice mockdice = new TestDice(rollValues);
        board.setDice(mockdice);
        board.playTurn(player);

        //Then

        assertEquals(spaceResult, board.getSpaces()[player.getPlayerPosition()]);
    }

    private static Stream<Arguments> LandingOnBoardSpaces2() {
        return Stream.of(
                Arguments.of(new int[]{1, 1}, MonopolyBoard.BoardSpace.LECISTER_SQUARE),
                Arguments.of(new int[]{1, 2}, MonopolyBoard.BoardSpace.ROAD),
                Arguments.of(new int[]{3, 1}, MonopolyBoard.BoardSpace.PARK_LANE),
                Arguments.of(new int[]{4, 2}, MonopolyBoard.BoardSpace.HOME)


        );


    }
    @Test
    public void PlayerRecieveMoneyOnHomeSpace(){
        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();


        //Given players postion is 11 on the board
        player.setPlayerPosition(11);


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
    public void PaddingtonTicket(){
        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();


        //Given players postion is 3 on the board
        player.setPlayerPosition(2);


        //When dice is rolled and player lands on Paddington
        int[] rolls = {2,3};
        TestDice mockdice = new TestDice(rolls);
        board.setDice(mockdice);
        int currentPlayerBalance = player.getPlayerBalance();
        board.playTurn(player);
        //then player will pay 10 * the value of dice roll as ticket fee

        int expectedPlayerBalance = currentPlayerBalance - (10 *( 2 +  3));
        int actualMoney = player.getPlayerBalance();



        assertEquals(expectedPlayerBalance, player.getPlayerBalance());



    }

// Test to check when player lands on Waterloo they pay correct ticket fee
    @Test
    public void WaterlooTicket(){
        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();


        //Given players postion is 4 on the board
        player.setPlayerPosition(4);


        //When dice is rolled and player lands on Waterloo
        int[] rolls = {5,3};
        TestDice mockdice = new TestDice(rolls);
        board.setDice(mockdice);
        int currentPlayerBalance = player.getPlayerBalance();
        board.playTurn(player);
        //then player will pay 10 * the value of dice roll as ticket fee

        int expectedPlayerBalance = currentPlayerBalance - (10 *( 5 +  3));
        int actualMoney = player.getPlayerBalance();



        assertEquals(expectedPlayerBalance, player.getPlayerBalance());



    }






}




















