package org.example.model;

public abstract class AbstractFrame {
    
    private String frame = null;
    private Boolean isSpareFrame = false;
    private Boolean isStrikeFrame = false;
    
    public abstract int getScore();
    public abstract int getStrikeBonus();
    public abstract int getFirstRollBonus();

    public AbstractFrame() {
    }

    public AbstractFrame(String frame) {
        this.frame = frame; 
    }

    public boolean isStrikeFrame() {
        return isStrikeFrame;
    };
    
    public boolean isSpareFrame() {
        return isSpareFrame;
    };
    
    public String getFrame() {
        return this.frame;
    }
    
    public void setIsSpareFrame(Boolean isSpareFrame) {
        this.isSpareFrame = isSpareFrame;
    }

    public void setIsStrikeFrame(Boolean isStrikeFrame) {
        this.isStrikeFrame = isStrikeFrame;
    }
}
