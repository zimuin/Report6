package jp.ac.uryukyu.ie.e205736;


public class Main{
    
    public static void main(String[] args){
        Dealer dealer = new Dealer();
        Player player1 = new Player("ゲスト");
        Rival player2 = new Rival("金持ちそうなおじさん");
        System.out.println(player1.getName());
        System.out.println(player2.getName());
        player1.drawCard();
        player2.drawCard();
        player2.facialExpression(player1);
        dealer.judgeButtle(player1, player2);
        
        
        
        
        
        
    }
}