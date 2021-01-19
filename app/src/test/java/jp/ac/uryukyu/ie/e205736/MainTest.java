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
        testPlayer1.selectAction(2, testDealer);
        int expectedOdds = 2;
        assertEquals(expectedOdds,testDealer.getOdds());
        testDealer.resetOdds();
        testPlayer1.selectAction(3, testDealer);
        int expectedChip = 95;
        String expectedWill1 = "no";
        assertEquals(expectedChip,testPlayer1.getPossesionChip());
        assertEquals(expectedWill1,testPlayer1.getBattleWill());
        testPlayer1.resetPossessionChip();
        testPlayer1.resetBattleWill();
        testPlayer1.selectAction(4, testDealer);
        String expectedWill2 = "yes";
        assertEquals(expectedWill2, testPlayer1.getBattleWill());
    }
}
