package org.example.factory;

import org.example.model.*;
import org.example.shared.Constants;

import java.text.ParseException;

import static org.example.shared.Constants.ROLLS_VALUES;

public class FrameDecoder {

    /**
     * Decode frame to normal. Ex: 54 or -4 or 6-
     *
     * @param frameString
     * @param offset
     * @return
     * @throws ParseException
     */
    public static AbstractFrame decodeFrameToNormal(String frameString, int offset) throws ParseException {
        if (!isNormalFrame(frameString)) {
            throw new ParseException("This frame is not recognized: " + frameString, offset);
        } else {
            // Verify if frame is the last roll
            if (frameString.length() == 1) {
                return frameString.equals("-") ? new NormalFrame("") : new NormalFrame(frameString);
            }
            // Verify Zero frame point
            else if (frameString.equals("--")) {
                return new NormalFrame("");
            }
            // Verify first roll point
            else if (frameString.charAt(0) == '-') {
                return new NormalFrame(frameString.substring(1));
            }
            // Verify second roll point
            else if (frameString.charAt(1) == '-') {
                return new NormalFrame(frameString.substring(0, 1));
            }
            return new NormalFrame(frameString);
        }
    }

    /**
     *
     * @param frameString
     * @return
     */
    private static boolean isNormalFrame(String frameString) {
        return frameString.chars().allMatch(c -> ROLLS_VALUES.contains((char) c));
    }

    /**
     * Check if Frame is strike. Ex : X
     * @param frameString
     * @param currentRoll
     * @return
     */
    public static boolean isStrikeFrame(String frameString, int currentRoll) {
        return frameString.charAt(currentRoll) == Constants.STRIKE_PATTERN;
    }

    /**
     * Check if Frame is spare. Ex  : 7/
     *
     * @param frameString
     * @param currentRoll
     * @return
     */
    public static boolean isSpareFrame(String frameString, int currentRoll) {
        if (currentRoll + 1 >= frameString.length())
            return false;
        return frameString.charAt(currentRoll + 1) == Constants.SPARE_PATTERN;
    }

}
