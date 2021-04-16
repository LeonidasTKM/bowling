package org.example.model;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractFrame {

    private final List<Roll> rolls = new LinkedList<>();

    public AbstractFrame(String frameString) {
        char[] chars = frameString.toCharArray();
        for (char aChar : chars) {
            rolls.add(new Roll(aChar + ""));
        }
    }

    public abstract int getScore();

    public abstract int getFirstRollBonus();

    public abstract int getStrikeBonus();

    public abstract boolean isStrikeFrame();

    public abstract boolean isSpareFrame();

    public List<Roll> getRolls() {
        return rolls;
    }
}
