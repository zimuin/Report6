package jp.ac.uryukyu.ie.e205736;
import java.util.Random;

/**
 * 実際にゲームを行う2人のプレイヤーの
 * 基本の行動が同じだったのでHumanクラスを実装して
 * 継承させるように実装しています
 */

public class Human {
    private String name;// 名前
    private int possessionChip = 100;// 初期所持チップ
    private Card possessionCard;//相手に見せている自分のカード
    private Random rand = new Random();//カードを引く時のための乱数のためのインスタンス
    private int randomCardNumber ;//カードの数字は１から１３の間のどれか
    private String battleWill;
    //プレイヤーの勝負する意思をString型で表現
    //この値が"yes""か"no"かでゲームの展開が変わる


    Human(String name){
        this.name = name;
    }
    
    /**プレーヤーがカードを引くためのメソッド*/
    public void drawCard(){
        randomCardNumber = rand.nextInt(13)+1;
        Card drawCard = new Card(randomCardNumber);
        possessionCard = drawCard;
        System.out.println(name+"のドロー");
       
    }

    /**賭け倍率を２倍にするためのメソッド
     *@param dealer ゲームを進行させるディーラーのインスタンス 
     */
    public void oddsDoubleUp(Dealer dealer){
        int changeNumber = dealer.getOdds()*2;
        dealer.setOdds(changeNumber); 
        System.out.println(name+"は掛け金を二倍にした");   
    }

    /**
     * プレイヤーが今所持しているカードで勝負するためのメソッド
     * このメソッドで勝負する意思の値を"yes"にします
     */
    public void battle(){
        battleWill = "yes";
    }

    /**
     * プレイヤーがこのゲームでの勝負を降りるためのメソッド
     * このメソッドで勝負する意思の値を"no"にします
     * 基本の掛け枚数と掛け倍率の乗算を現在の掛け金としています
     * @param dealer　ゲームを進行させるディーラーのインスタンス
     */
    public void fold(Dealer dealer){
        int nowOdds = dealer.getBetMagnification()*dealer.getOdds();
        loseChip(nowOdds/2);
        battleWill = "no";
    }

    /**
     * プレイヤーがチップを失う時のためのメソッド
     * @param value 失うチップの枚数
     */
    public void loseChip(int value){
        possessionChip -= value;
        System.out.println(name+"は"+value+"枚チップを失った");
    }

    /**
     * プレイヤーがチップを得る時のためのメソッド
     * @param value 得るチップの枚数
     */
    public void getChip(int value){
        possessionChip += value;
        System.out.println(name+"は"+value+"枚チップを得た");
        
    }


    /**
     * プレイヤーが今所持しているカードのインスタンスを返すためのメソッド 
     * @return possessionCard  
     */
    public Card getPossesionCard(){
        return possessionCard;
    }

    /**
     * プレイヤーの現在所持しているカードを破棄するためのメソッド
     * このメソッドで所持カードをnullにします
     * このメソッドはプレイヤーがカードを引き直す時に実行するように実装しています
     */
    public void resetPosessionCard(){
        possessionCard = null;
    }

    /**
     * プレイヤーの現在の所持チップを返すためのメソッド
     * @return possessionChip
     */
    public int getPossesionChip(){
        return possessionChip;
    }

    /**
     * プレイヤーの名前を返すためのメソッド
     * @return name
     */
    public String getName(){return name;}

    /**
     * プレイヤーの勝負する意思の変数を返すメソッド
     * @return battleWill
     */
    public String getBattleWill(){return battleWill;}

    /**
     * １ゲームが終わった後に2人のプレイヤーの
     * 勝負する意思をリセットするためのメソッド
     */
    public void resetBattleWill(){
        battleWill =null;
    }

}
