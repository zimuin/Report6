package jp.ac.uryukyu.ie.e205736;
import java.util.Random;

public class Human {
    private String name;// 名前
    private int possessionChip = 100;// 初期所持チップ
    private Card possesionCard;//相手に公開する自分のカード
    Random rand = new Random();
    private int randomCardNumber = rand.nextInt(13)+1;//カードの数字は１から１３の間のどれか

    //カードを引くためのメソッド
    public void drawCard(){
        Card drawCard = new Card(randomCardNumber);
        this.possesionCard = drawCard;
       
    }

    //賭け倍率を２倍にするためのメソッド
    public void oddsDoubleUp(Dealer target){
        int changeNumber = target.getOdds()*2;
        target.setOdds(changeNumber);    
    }

    //今所持しているカードで勝負するためのメソッド
    public void battle(){}


    //今所持しているカードのインスタンスを返すためのメソッド
    public Card getPossesionCard(){
        return possesionCard;
    }

    public void setPossesionCard(Card card){
        card = possesionCard;
    }


}
