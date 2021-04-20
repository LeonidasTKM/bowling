package org.example;

import org.example.service.BowlingService;

import java.text.ParseException;

/**
 * Hello world!
 *
 */
public class BowlingApp
{
    public static void main( String[] args ) throws Exception {
        if (args.length == 0) {
            throw new IllegalArgumentException("No Frame were provided");
        }
        String frameString = args[0];
        BowlingService bowlingService = new BowlingService();
        int score = bowlingService.playBowling(frameString);
        System.out.printf( "Frames : " + frameString + "%n Score : " + score );
    }

}
