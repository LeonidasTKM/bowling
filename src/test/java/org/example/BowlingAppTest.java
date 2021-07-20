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
        
        String frame5 = "11 11 11 11 11 11 11 11 11 X5/";
        int score5 = 38;
        assertEquals(score5, bowlingService.playBowling(frame5));
        
        String frame6 = "X X 9/ 00 00 00 00 00 00 00";
        int score6 = 29 + 20 + 10;
        assertEquals(score6, bowlingService.playBowling(frame6));
    }

    @Test(expected = ParseException.class)
    public void shouldNotCalculateScoreAndThrowException() throws ParseException {
        String frame1 = "AX X X X X X X X XXX";
        bowlingService.playBowling(frame1);
    }

    @Test
    public void testFranck() throws ParseException {
        String frame5 = "11 11 11 11 11 11 11 11 11 X5/";
        int score5 = 38;
        assertEquals(score5, bowlingService.playBowling(frame5));
    }

    @Test
    public void testFranck2() throws ParseException {
        String frame5 = "X X 9/ 80 X X 90 8/ 7/ 44";
        int score5 = 171;
        assertEquals(score5, bowlingService.playBowling(frame5));
    }

    @Test
    public void testFranck3() throws ParseException {
        String frame5 = "63 52 8/ 06 X X 3/ 7/ 8/ 53";
        int score5 = 133;
        assertEquals(score5, bowlingService.playBowling(frame5));
    }

    @Test
    public void testFranck4() throws ParseException {
        String frame5 = "11 11 11 11 11 11 11 11 11 5/X";
        int score5 = 38;
        assertEquals(score5, bowlingService.playBowling(frame5));
    }
}
