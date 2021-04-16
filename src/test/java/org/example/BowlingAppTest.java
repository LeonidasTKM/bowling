package org.example;

import org.example.service.BowlingService;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;


/**
 * Unit test for simple App.
 */
public class BowlingAppTest {

    private final BowlingService bowlingService = new BowlingService();

    @Test
    public void shouldCalculateTotalScore() throws ParseException {
        String frame1 = "X X X X X X X X X XXX";
        int score1 = 300;
        assertEquals(score1, bowlingService.playBowling(frame1));

        String frame2 = "9- 9- 9- 9- 9- 9- 9- 9- 9- 9-";
        int score2 = 90;
        assertEquals(score2, bowlingService.playBowling(frame2));

        String frame3 = "5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5";
        int score3 = 150;
        assertEquals(score3, bowlingService.playBowling(frame3));

        String frame4 = "11 11 11 11 11 11 11 11 11 11";
        int score4 = 20;
        assertEquals(score4, bowlingService.playBowling(frame4));
    }

    @Test(expected = ParseException.class)
    public void shouldNotCalculateScoreAndThrowException() throws ParseException {
        String frame1 = "AX X X X X X X X XXX";
        bowlingService.playBowling(frame1);
    }
}
