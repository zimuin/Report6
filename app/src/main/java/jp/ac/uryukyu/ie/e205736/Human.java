package jp.ac.uryukyu.ie.e205736;
import java.util.Random;

public class Human {
    private String name;// 名前
    private int possessionChip = 100;// 初期所持チップ
    private Card possesionCard;//相手に見せている自分のカード
    Random rand = new Random();
    private int randomCardNumber ;//カードの数字は１から１３の間のどれか

    Human(String name){
        this.name = name;
    }
    
    //カードを引くためのメソッド
    public void drawCard(){
        randomCardNumber = rand.nextInt(13)+1;
        Card drawCard = new Card(randomCardNumber);
        possesionCard = drawCard;
        System.out.println(name+"のドロー");
       
    }

    //賭け倍率を２倍にするためのメソッド
    public void oddsDoubleUp(Dealer target){
        int changeNumber = target.getOdds()*2;
        target.setOdds(changeNumber);    
    }

    //今所持しているカードで勝負するためのメソッド
    public void battle(){}

    //このゲームでの勝負を降りるためのメソッド
    public void fold(Dealer target){
        int nowOdds = target.getBetMagnification()*target.getOdds();
        loseChip(nowOdds/2);
    }

    public void loseChip(int value){
        possessionChip -= value;
    }

    public void getChip(int value){
        possessionChip += value;
    }


    //今所持しているカードのインスタンスを返すためのメソッド
    public Card getPossesionCard(){
        return possesionCard;
    }

    public void resetPosessionCard(){
        possesionCard = null;
    }

    public int getPossesionChip(){
        return possessionChip;
    }

    public void setPossesionCard(Card card){
        card = this.possesionCard;
    }

    

    public String getName(){return name;}

}
