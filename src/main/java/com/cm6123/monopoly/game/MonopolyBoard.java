package com.cm6123.monopoly.game;


import com.cm6123.monopoly.app.GameLogicHandlers;
import com.cm6123.monopoly.app.GamesBoardSpacesHandler;
import com.cm6123.monopoly.dice.Dice;



/**
 * A class reprenting a Monopoly Board.
 */
public class MonopolyBoard {

    /**
     * creating the board for the monopoly game.
     *
     * @param boardsize is the size of the monopoly game.
     */
    private int boardsize = 16;
    /**
     * @param spaces is an array of the Space object for spaces on the board.
     */
    private BoardSpace[] spaces;
    /**
     * @param dice is used to create an object of the Dice class.
     */
    private Dice dice;
    /**
     * @param player1  is used to create an object player1 of the Player class.
     */
    private Player player1;
    /**
     * @param player2  is used to create an object player2 of the Player class.
     */
    private Player player2;
    /**
     * @param space is used to create a space object for the GamesboardSpacesHandler.
     */

    private GamesBoardSpacesHandler space;


    /**
     * @param logic is used to create a space object for the GameLogicHandler.
     */

    private GameLogicHandlers logic;


    /**
     * @param roll is used to stored an integer for dice roll value.
     */


    private int roll;


    /**
     * @param banker is used to create a banker object for Banker class.
     */


    private Banker banker;

    /**
     * @param currentPlayerIsPlayer1 is inialziated as boolean for playerturns.
     */
    private boolean currentPlayerIsPlayer1;






    /**
     * enum represting the spaces on the board.
     */
    public enum BoardSpace {

        /**
         * Set of spaces definied as enums.
         */
        HOME, ROAD, OLD_KENT_ROAD, PALL_MALL, PADDIGTON, THE_STRAND, TAX_OFFICE, WATERLOO, LECISTER_SQUARE, PARK_LANE;

        /**
         * using Player class to create a owner object.
         */
        private Player owner;
        /**
         * @param player is used to set the owner of property spaces.
         */
        public void setOwner(Player player) {
            this.owner = player;
        }

        /**
         *
         * @return owner is used to get the owner of space.
         */

        public Player getOwner() {
            return owner;
        }

        /**
         * @param payingrent is used to created a player object of player who pays rent.
         */

        private Player payingrent;


        /**
         *
         * @return paying rent is used to get the player paying rent.
         */

        public Player getPayingrent(){
            return payingrent;
        }

        /**
         *
         * @param player is used to set player paying rent.
         */

        public void setPayingrent(Player player){
            this.payingrent = player;
        }
    }


    /**
     * Constructing  a new  board with instances.
     */
    public MonopolyBoard() {
        this.spaces = new BoardSpace[boardsize];
        for (int i = 0; i < boardsize; i++) { // looping through the boardsize
            if (i % 16 == 0) {   // assigning  positions to the board spaces on the board
                spaces[i] = BoardSpace.HOME;
            } else if (i % 16 == 1 || i % 16 == 2 || i % 16 == 5 || i % 16 == 7 || i % 16 == 9 || i % 16 == 13 || i % 16 == 15 || i % 16 == 16)   {
                spaces[i] = BoardSpace.ROAD;
            } else if (i % 16 == 3) {
                spaces[i] = BoardSpace.OLD_KENT_ROAD;
            } else if (i % 16 == 4) {
                spaces[i] = BoardSpace.PALL_MALL;
            } else if (i % 16 == 6) {
                spaces[i] = BoardSpace.PADDIGTON;
            } else if (i % 16 == 8) {
                spaces[i] = BoardSpace.THE_STRAND;
            } else if (i % 16 == 10) {
                spaces[i] = BoardSpace.TAX_OFFICE;
            } else if (i % 16 == 11) {
                spaces[i] = BoardSpace.WATERLOO;
            } else if (i % 16 == 12) {
                spaces[i] = BoardSpace.LECISTER_SQUARE;
            } else if (i % 16 == 14) {
                spaces[i] = BoardSpace.PARK_LANE;


            }
        }


        this.player1 = new Player();
        this.player2 = new Player();
        this.space = new GamesBoardSpacesHandler();
        this.banker = new Banker();
        this.currentPlayerIsPlayer1 = true;
        this.logic = new GameLogicHandlers();





    }





    /**
     * sets Dice object to be used  for this board game.
     *
     * @param aDice doesn't return param
     */
    public void setDice(final Dice aDice) {
        this.dice = aDice;     // setting the dice for this board.
    }

    /**
     * Returns an array of spaces  representing the spaces on the board.
     *
     * @return An array of Spaces.
     */
    public BoardSpace[] getSpaces() {

        return spaces;
    }

    /**
     * Sets array of spaces on the board.
     * An array of Space objects  here for future use.
     *
     * @param aSpaces doesn't use param
     */
    public void setSpaces(final BoardSpace[] aSpaces) {
        this.spaces = aSpaces;
    }

    /**
     * Gets player1.
     *
     * @return player1.
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * Gets player 2.
     * @return player 2.
     */

    public Player getPlayer2(){
        return player2;
    }

    /**
     * boolean created to get current player equal  to player1.
     * @return currentPlayerisPlayer1.
     */
    public boolean getCurrentPlayerIsPlayer1(){
        return currentPlayerIsPlayer1;

    }

    /**
     * Method created for players to play their turn in the game.
     *
     * @param player The Player object represnts the player.
     * @return A boolean indicating if its players turn or if game is over.
     */
    public boolean playTurn(final Player player) {


        int roll1 = dice.roll();
        int roll2 = dice.roll();
        roll = roll1 + roll2;   // rolling two dice to get total roll
        System.out.println("You rolled a  " + roll1 + " and " + roll2 + " for a " + roll);

        int currentPosition = player.getPlayerPosition();
        currentPosition = (currentPosition + roll) % boardsize;
        player.setPlayerPosition(currentPosition);// setting the players position to the current position on the board.




        player.setCurrentRoll(roll1, roll2);


        BoardSpace currentSpace = spaces[currentPosition];



        switch (currentSpace) {

            case HOME:
                space.space0();
                player.receiveMoneyFromBanker(200);
                banker.payPlayer(200);
                break;

            case ROAD:
                space.space1();

                break;

            case OLD_KENT_ROAD:
                space.space2();
                Properties oldkent = new Properties();
                oldkent.buyOldKent(player);
                break;
            case PALL_MALL:
                space.space3();
                break;
            case PADDIGTON:
                space.space4();
                player.payTicket();
                break;
            case THE_STRAND:
                space.space5();

                break;
            case TAX_OFFICE:
                space.space6();
                player.payTax();
                break;
            case WATERLOO:
                space.space7();

                player.payTicket();
                break;
            case LECISTER_SQUARE:
                space.space8();
                break;
            case PARK_LANE:
                space.space9();
                break;
            default:
                space.space10();
                break;
        }


        System.out.println("Player" + (currentPlayerIsPlayer1 ? " 1 " : " 2 ") + " Balance: " + player.getPlayerBalance());
        currentPlayerIsPlayer1 = !currentPlayerIsPlayer1;
        return player.getPlayerBalance() <= 0;


    }


    /**
     * Method for playing monoploy until game is over.
     */
    public void play() {

        while (true) {
            logic.player1Turn();

            boolean gameover = playTurn(player1);
            if (gameover) {
                System.out.println("Gameover");


            }

            logic.player2Turn();




            gameover = playTurn(player2);
            if (gameover) {
                System.out.println("Game Over");
                return;
            }

            }
        }

    }


