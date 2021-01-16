package jp.ac.uryukyu.ie.e205736;

public class Rival extends Human {
    
    Rival(String name){
        super(name);
    }
    
    public void facialExpression(Player target) {
        if(target.getPossesionCard().getCardNumber()<=5){
            System.out.println(getName()+"は勝気な表情を浮かべている...");
        }
        if(6<=target.getPossesionCard().getCardNumber()&&target.getPossesionCard().getCardNumber()<=10){
            System.out.println(getName()+"は微妙な顔をしている...");
        }

        if(11<=target.getPossesionCard().getCardNumber()){
            System.out.println(getName()+"は不満げな表情を浮かべている...");
        }
        
    }

    


    public void reDrawCard(Player target){
        if(8<=target.getPossesionCard().getCardNumber()){
            drawCard();
            System.out.println(getName()+"は引き直した...");
        }
    }

    




    
    
}
