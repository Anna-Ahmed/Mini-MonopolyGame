package com.cm6123.monopoly.app;

public class GamesBoardSpacesHandler  implements GameBoardSpaces{

    /**
     * Prints Home space on board.
     */
    @Override
    public void space0() {
        System.out.println("You landed on Home");
    }
    /**
     * Prints Road space on board.
     */
    @Override
    public void space1() {
        System.out.println(" You landed on Road");
    }
    /**
     * Prints Old Kent Road space on board.
     */
    @Override
    public void space2() {
        System.out.println("You landed on Old Kent Road");

    }
    /**
     * Prints  Pall Mall space on board.
     */

    @Override
    public void space3() {
        System.out.println("You landed on Pall Mall");

    }
    /**
     * Prints Paddington space on board.
     */
    @Override
    public void space4() {
        System.out.println("You landed on Paddigton Station");
    }

    /**
     * Prints The Strand space on board.
     */

    @Override
    public void space5() {
        System.out.println("You landed on The Strand");
    }
    /**
     * Prints Tax Office space on board.
     */
    @Override
    public void space6() {
        System.out.println("You landed on Tax Office");

    }
    /**
     * Prints Waterloo space on board.
     */

    @Override
    public void space7() {
        System.out.println("You landed on Waterloo station");

    }
    /**
     * Prints Lecister Square space on board.
     */

    @Override
    public void space8() {
        System.out.println("You landed on Leicester Square");


    }
    /**
     * Prints Park Lane space on board.
     */
    @Override
    public void space9() {
        System.out.println("You landed on Park Lane");

    }

    /**
     * Prints Space doesnt exist.
     */
    @Override
    public void space10() {
        System.out.println("Space doesn't exist");


    }
}
