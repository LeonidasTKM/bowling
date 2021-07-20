package org.example.model;

public class StrikeFrame extends AbstractFrame {

    public StrikeFrame() {
        super();
        setIsStrikeFrame(true);
    }

    @Override
    public int getScore() {
        return 10;
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
