package jp.ac.uryukyu.ie.e205736;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Humanクラスを継承させたユーザーが実際に操作するプレイヤーのクラス
 */
public class Player extends Human {

    private Scanner scanner = new Scanner(System.in);//標準入力用のインスタンス
   

    Player(String name){
       super(name);
    }
    
    /**
     * プレイヤーの行動を実際にユーザーが選択するためのメソッド
     * 行動一つ一つとともに数字を出力させて選んだ数字に対応する
     * メソッドを実行するよるように実装しています
     * @param dealer　ゲームを進行させるディーラーのインスタンス
     * @param actions　ディーラーが設定するプレイヤーの取れる行動のリスト
     */
    public void select(Dealer dealer,ArrayList<String> actions){
        System.out.println("どうしますか？");
        int index = 1;
        for (var action : actions){
            System.out.println(index+":"+action);
            index += 1;
        }

        
        int actionNumber = scanner.nextInt();
        selectAction(actionNumber, dealer);
    }

    public void selectAction(int actionNumber,Dealer dealer){
        if(actionNumber==1){drawCard();}
        if(actionNumber==2){oddsDoubleUp(dealer);}
        if(actionNumber==3){fold(dealer);}
        if(actionNumber==4){battle();}
    }

    /**
     * 相手プレイヤーのカードの数字を出力するためのメソッド
     * 相手のカードが見えるルールはこのメソッドで実装しています
     * @param player2　ユーザーが対戦するプレイヤーのインスタンス
     */
    public void showRivalCard(Rival player2){
        System.out.println("相手のカードは" + player2.getPossesionCard().getCardNumber());
    }
    
    

}
