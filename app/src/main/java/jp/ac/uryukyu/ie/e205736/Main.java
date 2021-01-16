package jp.ac.uryukyu.ie.e205736;


public class Main{
    
    public static void main(String[] args){
        Dealer dealer = new Dealer();
        Player player1 = new Player();
        Rival enemy1 = new Rival();
        player1.drawCard();
        System.out.println(player1.getPossesionCard().getCardNumber());
        enemy1.facialExpression(player1);
        
        
        
        
        
        
    }
}