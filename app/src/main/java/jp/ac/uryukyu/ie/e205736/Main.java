package jp.ac.uryukyu.ie.e205736;


public class Main{
    
    public static void main(String[] args){
        Rival player2 = new Rival("金持ちおじさん");
        player2.drawCard();
        System.out.println(player2.getPossesionCard().getCardNumber());
        player2.resetPosessionCard();
        player2.drawCard();
        System.out.println(player2.getPossesionCard().getCardNumber());
        
        
        
        
        
        
    }
}