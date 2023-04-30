package com.cm6123.monopoly.dice;


/**
 * inherited from Dice class to create a mock dice for testing.
 */
public class TestDice extends Dice {
    /**
     * values  of dice  roll is an array  of integers.
     */
    private int[] valuesOfRoll;
    /**
     * index of dice value.
     */
    private int index;


    /**
     * @param thevaluesOfRoll the array of values the mock dice will have.
     */
    public TestDice (final int[] thevaluesOfRoll) {
        super(6);
        this.valuesOfRoll = thevaluesOfRoll;
        this.index = 0;
    }


    /**
     * Overriding roll method in Dice to be able to give the mock dice fixed values.
     * @return Rollvalue of roll
     */
    @Override
    public Integer roll() {
        int value = valuesOfRoll[index];
        index = (index + 1) % valuesOfRoll.length;
        if (value > 6){   // the highest value on dice that can be rolled is 6 therfore if a value higher than 6 is inpute then the output will default to 6
            value = 6;
        }
        return value;
    }

}
