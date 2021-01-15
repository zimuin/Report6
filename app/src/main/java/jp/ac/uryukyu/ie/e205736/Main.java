package jp.ac.uryukyu.ie.e205736;


public class Main{
    
    public static void main(String[] args){
        Dealer dealer = new Dealer();
        Player player1 = new Player();
        System.out.println(dealer.getOdds());
        player1.oddsDoubleUp(dealer);
        System.out.println(dealer.getOdds());
        player1.drawCard();
        System.out.println(player1.getPossesionCard().getCardNumber());
        dealer.gameStart();
        
        
        
        
        
        
    }
}