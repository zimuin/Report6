package jp.ac.uryukyu.ie.e205736;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    void startTest() {
        int defaultChip = 100;
        int defaultodds = 1;
        int defaultbetMagnification = 10;
        Dealer testDealer = new Dealer();
        Player testPlayer1 = new Player("テスト男１");
        Rival testPlayer2 = new Rival("テスト用男２");
        assertEquals(defaultChip,testPlayer1.getPossesionChip());
        assertEquals(defaultChip,testPlayer2.getPossesionChip());
        assertEquals(defaultodds,testDealer.getOdds());
        assertEquals(defaultbetMagnification,testDealer.getBetMagnification());
    }
}
