package org.example.service;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import org.example.model.AbstractFrame;
import org.example.model.NormalFrame;
import org.example.model.SpareFrame;
import org.example.model.StrikeFrame;

public class BowlingService {
    
    private List<AbstractFrame> abstractFrames = null;
    
    public final static Integer FRAME_SIZE = 10;
    public final static String STRIKE = "X";

    public BowlingService() {}
    
    public int playBowling(String framesString) throws ParseException {
        abstractFrames = new LinkedList<>();
                
        String[] frames = framesString.replace("-", "0").split(" ");
       
        if (frames.length != FRAME_SIZE) {
            throw new ParseException("You didn't play all the rounds", frames.length);
        }
        
        buildFrames(frames);
        return computeScore();
    }

    private void buildFrames(String[] frames) {
        for (int i = 0; i < FRAME_SIZE - 1; i++) {
            String frame = frames[i];
            addFrame(frame);
        }
        
        String frame = frames[9];
        if (frame.length() == 2) {
            addFrame(frame);
        } else {
            char[] chars = frame.toCharArray();
            if (chars[0] == 'X') { 
                addFrame(STRIKE);
                
                if (chars[1] == 'X') {
                    addFrame(STRIKE);
                    addFrame(String.valueOf(chars[2]));
                } else {
                    addFrame(String.valueOf(chars, 1, 2));
                }
                
            } else {
                String spareFrame = String.valueOf(chars, 0, 2);

                addFrame(spareFrame);
                addFrame(String.valueOf(chars[2]));
            }
        }
    }
    
    private void addFrame(String frame) {
        if (frame.contains("X")) {
            abstractFrames.add(new StrikeFrame());
            
        } else if (frame.contains("/")) {
            abstractFrames.add(new SpareFrame(frame));
            
        } else {
            abstractFrames.add(new NormalFrame(frame));
        }
    }
    
    private int computeScore() {
        int score = 0;
        
        for (int i = 0; i < FRAME_SIZE; i++) {
            AbstractFrame frame = abstractFrames.get(i);
            AbstractFrame nextFrame = i + 1 < abstractFrames.size() ? abstractFrames.get(i + 1) : null;
            
            score += frame.getScore();
            
            if (frame.isStrikeFrame()) {
                score += nextFrame.getStrikeBonus();
                
                if (nextFrame.isStrikeFrame()) {
                    score += abstractFrames.get(i + 2).getFirstRollBonus();
                }
            } else if (frame.isSpareFrame()) {
                score += nextFrame.getFirstRollBonus();
            }
        }
        
        return score;
    }

}
