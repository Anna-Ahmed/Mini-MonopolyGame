package com.cm6123.monopoly.app;


import com.cm6123.monopoly.game.MonopolyBoard;

import java.util.Scanner;

public class GameLogicHandlers implements GameLogic {


    /**
     * Asks player 1 to roll dice for their turn.
     */
    @Override
    public void player1Turn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("          ");
        System.out.println("Player 1s Turn: Press enter to roll the dice");
        sc.nextLine();


    }

    /**
     * Asks player 2 to roll dice for their turn.
     */

    @Override
    public void player2Turn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("          ");
        System.out.println("Player 2s Turn: Press enter to roll the dice");
        String userinput = sc.nextLine();

        if (userinput.isEmpty() || !userinput.equals("/n")) {
            System.out.println("You didnt press enter. " + " Please press enter to roll dice");

        }


    }

    /**
     * Asks player if they want to purchase old kent.
     */


    @Override
    public void ask() {
        int currentPosition = PLAYER.getPlayerPosition();
        MonopolyBoard.BoardSpace currentSpace = BOARD.getSpaces()[currentPosition];
        if (currentSpace.getOwner() == null) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Do you want to buy Old Kent? : Y/N");
            String input = sc.nextLine();

            if (input.equals("Y")) {
                currentSpace.setOwner(PLAYER);
            } else if (input.equals("Y") && PLAYER.getPlayerBalance() < 60) {
                System.out.print("You dont have enough to purchase this property");
            } else if (input.equals("N")) {
                currentSpace.setOwner(null);
                System.out.println("You chose not to buy this property");
            }
        }
    }

    /**
     * Asks player 1 to enter their name.
     */


    @Override
    public void player1Name() {
        Scanner scanner = new Scanner(System.in);
        String player1name = "";
        boolean blankname = false;


        while (!blankname) {
            System.out.println("Player 1 : Enter your name");
            player1name = scanner.nextLine();
            if (player1name.isEmpty()) {
                System.out.println("Player name cannot be empty. Please enter  your name. ");
            } else {
                blankname = true;

            }
        }
        System.out.println(player1name + " is Player 1");
    }







    /**
     * Asks player 2 to enter their name.
     */

    @Override
    public void player2Name() {
        Scanner scanner = new Scanner(System.in);
        String player1name = "";
        boolean blankname = false;


        while (!blankname) {
            System.out.println("Player 2 : Enter your name");
            player1name = scanner.nextLine();
            if (player1name.isEmpty()) {
                System.out.println("Player name cannot be empty. Please enter  your name. ");
            } else {
                blankname = true;

            }



        }
        System.out.println(player1name + " is Player 2");
    }



    /**
     * Prints that player has purchased old kent.
     */
    @Override
    public void ownerOfOldKent() {
        System.out.println("Player purchased Old Kent Road for £60");

    }


    /**
     * prints player owns old kent.
     */

    @Override
    public void confirmOwnerShipOfOldKent() {
        System.out.println("Player now owns Old Kent Road");

    }
    /**
     * Prints player purchased pall mall.
     */


    @Override
    public void ownerOfPallMall() {
        System.out.println("Player purchased Pall Mall for £140");

    }

    /**
     * Prints player owns pall mall.
     */

    @Override
    public void confirmOwnershipOfPallMall() {
        System.out.println("Player now owns Pall Mall");

    }

    /**
     * Prints player paid rent.
     */

    @Override
    public void displaypaidrent() {
        System.out.println("Player has paid rent");

    }

    /**
     * Prints player doesn't have enough to buy property.
     */

    @Override
    public void dipslayNoFunds() {
        System.out.println("You don't have enough funds to purchase this property");


    }

    /**
     * Prints player doesn't have enough to pay rent.
     */

    @Override
    public void dipslayNoFundsforrent() {
        System.out.println("You don't have enough funds to pay rent for this property");


    }
    /**
     * Prints player purchased the strand.
     */
    @Override
    public void ownerOfTheStrand() {
        System.out.println("Player purchased The Strand for 220");
    }

    /**
     * Prints player owns the strand.
     */

    @Override
    public void confirmOwnershipOfTheStrand() {
        System.out.println("Player owns The Strand");

    }

    /**
     * Prints player purchased park lane.
     */

    @Override
    public void ownerOfParkLane() {
        System.out.println("Player purchased Park Lane for £350 ");

    }
    /**
     * Prints player owns park lane.
     */
    @Override
    public void confirmOwnershipOfParkLane() {
        System.out.println("Player owns Park Lane");

    }
    /**
     * Prints player purchased leicester square.
     */

    @Override
    public void ownerOfLeicesterSquare() {
        System.out.println("Player purchased Leicester Square for £260");

    }
    /**
     * Prints player owns leicester square.
     */
    @Override
    public void confirmOwnershipOfLeicesterSquare() {
        System.out.println("Player owns Leicester Square");

    }


}



