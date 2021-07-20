package org.example.model;

public class NormalFrame extends AbstractFrame {

    public NormalFrame(String frameString) {
        super(frameString);
    }

    @Override
    public int getScore() {
        String frame = getFrame();

        int score = Integer.parseInt(String.valueOf(frame.charAt(0)));
        
        if (frame.length() > 1) {
            score += Integer.parseInt(String.valueOf(frame.charAt(1)));
        }
        
        return score;
    }
    
    @Override
    public int getStrikeBonus() {
        return getScore();
    }
    
    @Override
    public int getFirstRollBonus() {
        return Integer.parseInt(String.valueOf(getFrame().charAt(0)));
    }
}
