
package com.cm6123.monopoly.game;

/**
 * Class for Banker.
 */

 public class Banker {

        /**
         *bankerbalance is the amount banker has.
         */
        private int bankerbalance;

        /**
         * player used to create a Player object.
         */

        private Player player;
        /**
         * Constructor.
         *  bankerbalance is set to 5000.
         */
        public Banker(){

                bankerbalance = 5000;

        }

        /**
         * Method for banker to pay player.
         * @param amount amount is not a fixed value.
         */




        public void payPlayer(final int amount){
                bankerbalance -= amount;
                System.out.println("Player given" + amount);
                //player.receiveMoneyFromBanker(amount);

        }

        /**
         * Method created for banker to recieve money from player.
         * @param amount
         */

        public void receiveMoneyFromPlayer(final int amount){
                bankerbalance += amount;

                System.out.println("Received" + amount + "From Player");
                //player.payBanker(amount);
        }
}





