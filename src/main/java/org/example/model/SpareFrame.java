package org.example.model;


public class SpareFrame extends AbstractFrame {

    public SpareFrame(String frameString) {
        super(frameString);
    }

    @Override
    public int getScore() {
        return 10;
    }

    @Override
    public boolean isStrikeFrame() {
        return false;
    }

    @Override
    public boolean isSpareFrame() {
        return true;
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
