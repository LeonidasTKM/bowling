package org.example.service;

import org.example.model.AbstractFrame;
import org.example.model.Bowling;
import org.example.shared.Constants;

import java.text.ParseException;
import java.util.List;

public class BowlingService {

    public BowlingService() {
    }

    public int playBowling(String framesString) throws ParseException {
        int score = 0, i = 0;
        Bowling bowling = new Bowling();
        bowling.setFramesList(framesString);
        List<AbstractFrame> abstractFrameList = bowling.getAbstractFrames();

        int lastIndex = abstractFrameList.size() - 1;
        AbstractFrame nextFrame;
        do {
            AbstractFrame frame = abstractFrameList.get(i);
            if (frame.isStrikeFrame()) {
                nextFrame = abstractFrameList.get(i + 1);
                score += frame.getScore() + nextFrame.getStrikeBonus();
                if (nextFrame.isStrikeFrame()) {
                    score += abstractFrameList.get(Math.min(i + 2, lastIndex)).getFirstRollBonus();
                }
            } else if (frame.isSpareFrame()) {
                nextFrame = abstractFrameList.get(i + 1);
                score += frame.getScore() + nextFrame.getFirstRollBonus();
            } else {
                score += frame.getScore();
            }
            i++;
        } while (i < Constants.FRAME_SIZE);


        return score;
    }

}
