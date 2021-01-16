package jp.ac.uryukyu.ie.e205736;

public class Rival extends Human {
    
    String name = "金持ちそうなおじさん";
    
    public void facialExpression(Player target) {
        if(target.getPossesionCard().getCardNumber()<=5){
            System.out.println(name+"は勝気な表情を浮かべている...");
        }
        if(6<=target.getPossesionCard().getCardNumber()&&target.getPossesionCard().getCardNumber()<=10){
            System.out.println(name+"は微妙な顔をしている...");
        }

        if(11<=target.getPossesionCard().getCardNumber()){
            System.out.println(name+"は不満げな表情を浮かべている...");
        }
        
    }




    
    
}
