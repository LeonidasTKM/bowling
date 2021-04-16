package org.example.model;

import org.example.factory.FrameDecoder;
import org.example.shared.Constants;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

public class Bowling {

    private final List<AbstractFrame> abstractFrames = new LinkedList<>();

    public Bowling() {
    }

    /**
     * Transform frame string to a frame list
     *
     * @param framesString
     * @throws ParseException
     */
    public void setFramesList(String framesString) throws ParseException {
        int currentRoll = 0;
        framesString = framesString.replaceAll("\\s", "");

        // Verify frame length
        if (framesString.length() < 11 || framesString.length() > 21) {
            System.out.println("You didn't play all the rounds");
            throw new ParseException("The frames string provided are out of the scope length : 11<l<21", framesString.length());
        }

        while (currentRoll < framesString.length()) {
            if (FrameDecoder.isStrikeFrame(framesString, currentRoll)) {
                abstractFrames.add(new StrikeFrame(Constants.STRIKE_PATTERN + ""));
                currentRoll++;
            } else if (FrameDecoder.isSpareFrame(framesString, currentRoll)) {
                abstractFrames.add(new SpareFrame(framesString.substring(currentRoll, currentRoll + 2)));
                currentRoll += 2;
            } else {
                String frameToDecode = framesString.substring(currentRoll, Math.min(framesString.length(), currentRoll + 2));
                abstractFrames.add(FrameDecoder.decodeFrameToNormal(frameToDecode, currentRoll));
                currentRoll += 2;
            }
        }

    }

    public List<AbstractFrame> getAbstractFrames() {
        return abstractFrames;
    }
}
