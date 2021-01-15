package jp.ac.uryukyu.ie.e205736;

public class Dealer {
    private int betMagnification = 10;// 基本の賭ける枚数は10枚
    private int odds = 1;//基本の賭ける倍率は等倍。

    public int getOdds(){
        return odds;
    }

    public void setOdds(int value){
        odds = value;
    }
    

    public void gameStart(){}
}
