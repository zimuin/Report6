package jp.ac.uryukyu.ie.e205736;

public class Human {
    private String name;// 名前
    private int possessionChip = 100;// 初期所持チップ
    private Card possesionCard;//相手に公開する自分のカード

    
    public void drawCard(){}

    public void oddsDoubleUp(Dealer target){
        target.getOdds();
        target.odds = target.odds*2;
        target.setOdds(target.odds);
    }

    public void battle(){}




}
