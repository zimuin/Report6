package jp.ac.uryukyu.ie.e205736;

/**
 * Humanクラスを継承させているユーザーが対戦するプレイヤーのクラス
 * ユーザーが操作するプレイヤーの所持しているカードの数字によって
 * 振る舞いが変わるように実装しています
 */
public class Rival extends Human {
    
    Rival(String name){
        super(name);
    }
    
    /**
     * ユーザーが対戦するプレイヤーの表情を出力するためのメソッド
     * @param player1　ユーザーが操作するプレイヤーのインスタンス
     * ユーザーにはこのメソッドの結果をヒントにゲームをプレイしてもらう
     */
    public void facialExpression(Player player1) {
        if(player1.getPossesionCard().getCardNumber()<=5){
            System.out.println(getName()+"は勝気な表情を浮かべている...");
        }
        if(6<=player1.getPossesionCard().getCardNumber()&&player1.getPossesionCard().getCardNumber()<=10){
            System.out.println(getName()+"は微妙な顔をしている...");
        }

        if(11<=player1.getPossesionCard().getCardNumber()){
            System.out.println(getName()+"は不満げな表情を浮かべている...");
        }
        
    }

    

    /**
     * ユーザーが対戦するプレイヤーがカードを引き直すためのメソッド
     * @param player1　ユーザーが操作するプレイヤーのインスタンス
     */
    public void reDrawCard(Player player1){
        if(8<=player1.getPossesionCard().getCardNumber()){
            drawCard();
            System.out.println(getName()+"は引き直した...");
        }
    }

    /**
     * ユーザーが対戦するプレイヤーが賭け金を上げるためのメソッド
     * @param player1　ユーザーが操作するプレイヤーのインスタンス
     * @param dealer　 ゲームを進行させるディーラーのインスタンス
     */
    public void oddsUp(Player player1,Dealer dealer){
        if(player1.getPossesionCard().getCardNumber()<=10){
            oddsDoubleUp(dealer);
        }
    }

    /**
     * ユーザーが対戦するプレイヤーが勝負をするか降りるか決めるためのメソッド
     */
    public void thinkBattle(Player player1,Dealer dealer){
        if(player1.getPossesionCard().getCardNumber()==13){
            fold(dealer);
            System.out.println(getName()+"は降りる気らしい...");
        }else{
            battle();
            System.out.println(getName()+"は勝負する気満々だ！");
        }
    }






    
    
}
