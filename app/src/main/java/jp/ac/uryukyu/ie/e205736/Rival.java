package jp.ac.uryukyu.ie.e205736;

public class Rival extends Human {
    
    Rival(String name){
        super(name);
    }
    
    public void facialExpression(Player target1) {
        if(target1.getPossesionCard().getCardNumber()<=5){
            System.out.println(getName()+"は勝気な表情を浮かべている...");
        }
        if(6<=target1.getPossesionCard().getCardNumber()&&target1.getPossesionCard().getCardNumber()<=10){
            System.out.println(getName()+"は微妙な顔をしている...");
        }

        if(11<=target1.getPossesionCard().getCardNumber()){
            System.out.println(getName()+"は不満げな表情を浮かべている...");
        }
        
    }

    

    public void reDrawCard(Player target1){
        if(8<=target1.getPossesionCard().getCardNumber()){
            drawCard();
            System.out.println(getName()+"は引き直した...");
        }
    }

    public void oddsUp(Player target1,Dealer target){
        if(target1.getPossesionCard().getCardNumber()<=10){
            oddsDoubleUp(target);
            System.out.println(getName()+"は掛け金を二倍にした！");
        }
    }

    public void thinkBattle(Player player1,Dealer target){
        if(player1.getPossesionCard().getCardNumber()==13){
            fold(target);
            System.out.println(getName()+"は降りる気らしい...");
        }else{
            battle();
            System.out.println(getName()+"はやる気満々だ！");
        }
    }






    
    
}
