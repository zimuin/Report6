package jp.ac.uryukyu.ie.e205736;


public class Main{
    
    public static void main(String[] args){
        Dealer dealer = new Dealer();
        dealer.setActions();
        dealer.explainRule();
        Player player1 = new Player("僕");
        Rival player2 = new Rival("金持ちおじさん");
        player1.drawCard();
        player2.drawCard();
        System.out.println("相手のカードは"+player2.getPossesionCard().getCardNumber());
        player2.facialExpression(player1);
        player1.select(dealer, dealer.getActions());
        player2.reDrawCard(player1);
        System.out.println("相手のカードは"+player2.getPossesionCard().getCardNumber());
        player2.facialExpression(player1);
        player2.oddsUp(player1,dealer);
        dealer.judgeButtle(player1, player2);


        
        
        
        
        
        
    }
}