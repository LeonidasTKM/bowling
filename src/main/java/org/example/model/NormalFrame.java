package org.example.model;

import java.util.List;

public class NormalFrame extends AbstractFrame {

    public NormalFrame(String frameString) {
        super(frameString);
    }

    @Override
    public int getScore() {
        int score = 0;
        List<Roll> rolls = super.getRolls();
        for (Roll roll : rolls) {
            score += Integer.parseInt(roll.getPin());
        }
        return score;
    }

    @Override
    public boolean isStrikeFrame() {
        return false;
    }

    @Override
    public boolean isSpareFrame() {
        return false;
    }

    @Override
    public int getStrikeBonus() {
        return getScore();
    }

    @Override
    public int getFirstRollBonus() {
        return Integer.parseInt(super.getRolls().get(0).getPin());
    }
}
