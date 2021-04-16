package org.example.model;

public class StrikeFrame extends AbstractFrame {

    public StrikeFrame(String frameString) {
        super(frameString);
    }

    @Override
    public int getScore() {
        return 10;
    }

    @Override
    public boolean isStrikeFrame() {
        return true;
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
        return getScore();
    }
}
