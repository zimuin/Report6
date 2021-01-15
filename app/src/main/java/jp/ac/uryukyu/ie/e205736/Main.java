package jp.ac.uryukyu.ie.e205736;
import java.util.Random;

public class Main{
    Random rand = new Random();
    int cardnumber = rand.nextInt(12)+1;
    public static void main(String[] args){
        Dealer dealer = new Dealer();
        Human player1 = new Human();
        System.out.println(dealer.getOdds());
        player1.oddsDoubleUp(dealer);
        System.out.println(dealer.getOdds());
        
        
        
        
        
        
    }
}