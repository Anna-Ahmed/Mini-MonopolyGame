package com.cm6123.monopoly;

import com.cm6123.monopoly.dice.TestDice;
import com.cm6123.monopoly.game.MonopolyBoard;
import com.cm6123.monopoly.game.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonopolyBoardTest {
    @Test
    public void playerRolls2ShouldLandOnRoad() {

        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();
        //Given
        player.setPlayerPosition(0);

        //When
        TestDice mockdice = new TestDice(new int[]{1,1});
        board.setDice(mockdice);

        board.playTurn(player);

        //Then
        assertEquals(MonopolyBoard.BoardSpace.ROAD, board.getSpaces()[player.getPlayerPosition()]);
    }

    @Test
    public void playerRolls3ShouldLandOnRoad() {

        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();
        //Given
        player.setPlayerPosition(0);

        //When
        TestDice mockdice = new TestDice(new int[]{1,2});
        board.setDice(mockdice);
        board.playTurn(player);

        //Then
        assertEquals(MonopolyBoard.BoardSpace.ROAD, board.getSpaces()[player.getPlayerPosition()]);
    }

    @Test
    public void playerRolls4ShouldLandOnOldKentRoad() {

        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();

        //Given
        player.setPlayerPosition(0);

        //When
        TestDice mockdice = new TestDice(new int[]{2,2});
        board.setDice(mockdice);

        board.playTurn(player);

        //Then
        assertEquals(MonopolyBoard.BoardSpace.OLD_KENT_ROAD, board.getSpaces()[player.getPlayerPosition()]);
    }

    @Test
    public void playerRolls5ShouldLandOnPallMall() {

        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();

        //Given
        player.setPlayerPosition(0);


        //When
        TestDice mockdice = new TestDice(new int[]{3,2});
        board.setDice(mockdice);
        board.playTurn(player);

        //Then
        assertEquals(MonopolyBoard.BoardSpace.PALL_MALL, board.getSpaces()[player.getPlayerPosition()]);
    }
    @Test
    public void playerRolls6ShouldLandOnRoad() {

        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();

        //Given
        player.setPlayerPosition(0);

        //When
        TestDice mockdice = new TestDice(new int[]{3,3});
        board.setDice(mockdice);
        board.playTurn(player);

        //Then
        assertEquals(MonopolyBoard.BoardSpace.ROAD, board.getSpaces()[player.getPlayerPosition()]);
    }
    @Test
    public void playerRolls7ShouldLandOnPaddigton() {

        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();

        //Given
        player.setPlayerPosition(0);

        //When
        TestDice mockdice = new TestDice(new int[]{4,3});
        board.setDice(mockdice);
        board.playTurn(player);


        //Then
        assertEquals(MonopolyBoard.BoardSpace.PADDIGTON, board.getSpaces()[player.getPlayerPosition()]);
    }
    @Test
    public void playerRolls8ShouldLandOnRoad() {

        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();

        //Given
        player.setPlayerPosition(0);


        //When
        TestDice mockdice = new TestDice(new int[]{3,5});
        board.setDice(mockdice);
        board.playTurn(player);

        //Then

        assertEquals(MonopolyBoard.BoardSpace.ROAD, board.getSpaces()[player.getPlayerPosition()]);
    }

    @Test
    public void playerRolls9ShouldLandOnTheStrand() {


        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();

        //Given
        player.setPlayerPosition(0);

        //When
        TestDice mockdice = new TestDice(new int[]{4,5});
        board.setDice(mockdice);
        board.playTurn(player);

        //Then

        assertEquals(MonopolyBoard.BoardSpace.THE_STRAND, board.getSpaces()[player.getPlayerPosition()]);
    }

    @Test
    public void playerRolls10ShouldLandRoad() {
        ;
        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();

        //Given
        player.setPlayerPosition(0);

        //When
        TestDice mockdice = new TestDice(new int[]{5,5});
        board.setDice(mockdice);
        board.playTurn(player);

        //Then

        assertEquals(MonopolyBoard.BoardSpace.ROAD, board.getSpaces()[player.getPlayerPosition()]);
    }
    @Test
    public void playerRolls11ShouldLandTaxOffice() {


        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();

        //Given
        player.setPlayerPosition(0);


        //When
        TestDice mockdice = new TestDice(new int[]{6,5});
        board.setDice(mockdice);
        board.playTurn(player);

        //Then
        assertEquals(MonopolyBoard.BoardSpace.TAX_OFFICE, board.getSpaces()[player.getPlayerPosition()]);
    }
    @Test
    public void playerRolls12houldLandOnWaterloo() {

        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();

        //Given
        player.setPlayerPosition(0);

        //When
        TestDice mockdice = new TestDice(new int[]{6,6});
        board.setDice(mockdice);
        board.playTurn(player);

        //Then

        assertEquals(MonopolyBoard.BoardSpace.WATERLOO, board.getSpaces()[player.getPlayerPosition()]);
    }
    @Test
    public void playerOnTaxOfficeRollsa2ShouldLandOnLecisterSquare() {

        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();

        //Given
        player.setPlayerPosition(11);


        //When
        TestDice mockdice = new TestDice(new int[]{1,1});
        board.setDice(mockdice);
        board.playTurn(player);

        //Then
        assertEquals(MonopolyBoard.BoardSpace.LECISTER_SQUARE, board.getSpaces()[player.getPlayerPosition()]);
    }
    @Test
    public void playerOnTaxOfficeRollsa3ShouldLandOnRoad() {


        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();

        //Given
        player.setPlayerPosition(11);


        //When
        TestDice mockdice = new TestDice(new int[]{2,1});
        board.setDice(mockdice);
        board.playTurn(player);

        //Then
        assertEquals(MonopolyBoard.BoardSpace.ROAD, board.getSpaces()[player.getPlayerPosition()]);
    }
    @Test
    public void playerOnTaxOfficeRollsa4ShouldLandOnParkLane() {


        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();

        //Given
        player.setPlayerPosition(11);

        //When
        TestDice mockdice = new TestDice(new int[]{3,1});
        board.setDice(mockdice);
        board.playTurn(player);

        //Then

        assertEquals(MonopolyBoard.BoardSpace.PARK_LANE, board.getSpaces()[player.getPlayerPosition()]);
    }
    @Test
    public void playerOnRoadRollsa3ShouldLandOnGo() {

        MonopolyBoard board = new MonopolyBoard();
        Player player = board.getPlayer1();

        //Given
        player.setPlayerPosition(14);

        //When
        TestDice mockdice = new TestDice(new int[]{2,1});
        board.setDice(mockdice);
        board.playTurn(player);

        //Then


        assertEquals(MonopolyBoard.BoardSpace.GO, board.getSpaces()[player.getPlayerPosition()]);
    }
}
