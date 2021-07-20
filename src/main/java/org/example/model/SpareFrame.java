package org.example.model;


public class SpareFrame extends AbstractFrame {

    public SpareFrame(String frameString) {
        super(frameString);
        setIsSpareFrame(true);
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
        if (getFrame().charAt(0) == '/') {
            return getScore();
        }
        return Integer.parseInt(String.valueOf(getFrame().charAt(0)));
    }
}
