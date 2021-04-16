package org.example;

import org.example.service.BowlingService;

import java.text.ParseException;

/**
 * Hello world!
 *
 */
public class BowlingApp
{
    public static void main( String[] args ) throws ParseException {
        String frameString = args[0];
        BowlingService bowlingService = new BowlingService();

        Integer score = bowlingService.playBowling(frameString);
        System.out.printf( "Frames : " + frameString + "%n Score : " + score );
    }

}
