package com.cm6123.monopoly.app;


import java.util.Scanner;

public class GameLogicHandlers implements GameLogic {

    /**
     * Asks player 1 to roll dice for their turn.
     */
    @Override
    public void player1Turn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("          ");
        System.out.println("Player 1 .Press enter to roll the dice");
        sc.nextLine();


    }

    /**
     * Asks player 2 to roll dice for their turn.
     */

    @Override
    public void player2Turn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("          ");
        System.out.println("Player 2 .Press enter to roll the dice");
        sc.nextLine();


    }

    //@Override
   // public void Ask() {
       // int currentPosition = player.getPlayerPosition();
     //   MonopolyBoard.BoardSpace currentSpace = board.getSpaces()[currentPosition];

        //Scanner sc = new Scanner(System.in);
        //System.out.println("Want to Buy");
        //String input = sc.nextLine();{
          //  if(input.equals("Y")){
            ///        System.out.println("Player now owns the Property.");
              //  System.out.println("bought");
            //}else if(input.equals("N")){
              //  System.out.println("You chose not to buy this property");
            //}
        //}

        //}


    /**
     * Prints that player has purchased old kent.
     */
    @Override
    public void ownerOfHouse() {
        System.out.println("Player purchased Old Kent Road");

    }


    /**
     * prints player owns old kent.
     */

    @Override
    public void confirmOwnerShip() {
        System.out.println("Player now owns Old Kent Road");

    }




}



