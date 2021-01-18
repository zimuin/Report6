package jp.ac.uryukyu.ie.e205736;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 実際にゲームの進行をさせるディーラーのクラス
 */
public class Dealer {
    private int betMagnification = 10;// 基本の賭ける枚数は10枚
    private int odds = 1;// 基本の賭けるチップ倍率は等倍
    private ArrayList<String> actions = new ArrayList<String>();// ゲームプレイヤーが取れる行動
    private Scanner scanner = new Scanner(System.in);//標準入力用のインスタンス

    /**
     * 呼び出した時点での掛け金倍率を返すためのメソッド
     * ゲームプレイヤーの行動によって掛け金が変動する機能を実装しているため実装しています
     * @return odds
     */
    public int getOdds() {
        return odds;
    }

    /**
     * 掛け金倍率を再設定するためのメソッド
     * このメソッドをゲームプレイヤー側のメソッドに組み込んで
     * 人物が取れる「掛け金倍率を二倍にする」
     * という行動を実装しています
     * @param value 実際にはvalueにはその時点での掛け金を計算して代入するように実装しています
     */
    public void setOdds(int value) {
        odds = value;
    }

    /**
     * プレイヤーが取れる行動を実際にフィールドactionsに
     * 追加するためのメソッド
     * プレイヤーに行動を選択させるメソッド
     * の中でこのメソッドで設定した内容を
     * 出力するように実装しています
     */
    public void setActions() {

        actions.add("カードを引き直す");
        actions.add("掛け金を二倍にする");
        actions.add("勝負を降りる");
        actions.add("今のカードで勝負する");
    }

    /**
     * プレイヤーが取れる行動を返すためのメソッド
     * @return actions
     */
    public ArrayList<String> getActions() {
        return actions;
    }

    /**
     * 基本の掛けるチップ枚数を返すためのメソッド
     * @return betMagnification
     */
    public int getBetMagnification() {
        return betMagnification;
    }

    /**
     * ゲーム冒頭のルール説明のためのメソッド
     * 読みやすいように文のまとまりごとに空白を入れ
     * Enterを押すと次の文に進むように実装しています
     */
    public void explainRule() {
        System.out.println("Enterを押すと進みます");
        scanner.nextLine();
        System.out.println("ゲスト様、今宵はお越しいただきありがとうございます");
        System.out.println("このゲームのルールを説明いたします。");
        scanner.nextLine();
        System.out.println("このゲームは二人のプレイヤーが1から13の数字のみが書かれたカードを");
        System.out.println("使用して行う簡単なインディアンポーカーです");
        scanner.nextLine();
        System.out.println("ゲーム開始時にお互いにカードを一枚引いて");
        System.out.println("頭の上に相手にしか見えない状態で掲げていただきます");
        scanner.nextLine();
        System.out.println("相手の表情や仕草などから自分のカードを予想してください");
        System.out.println("お互いに勝負することが決まった後、カードをお互いに明かして");
        System.out.println("数字の大きい方のプレイヤーが勝利です");
        scanner.nextLine();
        System.out.println("お互いのカードの数字が同じだった場合は何も起きず、次のゲームに移ります");
        scanner.nextLine();
        System.out.println("プレイヤーには最初にチップを１００枚お配り致します");
        System.out.println("基本の掛け金は１０枚。ゲームに負けたプレイヤーは相手に掛け金を払っていただきます");
        System.out.println("また、カードを引いたプレイヤーには取れるアクションが４つあります");
        scanner.nextLine();
        System.out.println("1つ目はカードを引き直すことです");
        System.out.println("ゲーム中に対戦相手の会員様は1回、ゲスト様は1回だけカードを引き直すことができます");
        System.out.println("自分のカードの数字が低いと思われた場合は早々に引き直していただいて構いません");
        scanner.nextLine();
        System.out.println("2つ目は勝負を降りることです。");
        System.out.println("自分のカードが明らかに相手のカードより数字が低いと思われた場合は");
        System.out.println("勝負を降りることもできます。");
        System.out.println("その場合、所持しているチップから");
        System.out.println("その時点での掛け金の半分を没収いたします");
        scanner.nextLine();
        System.out.println("３つ目は掛け金を二倍にすることです");
        System.out.println("自分のカードに自信がある場合は掛け金を二倍にすることができます");
        System.out.println("対戦相手の会員様はゲームごとに1回、ゲスト様は何回でも可能です");
        System.out.println("ですがあくまで程々にしないとチップが尽きてしまいますのでご注意を");
        scanner.nextLine();
        System.out.println("４つ目は現在のカードで勝負することです");
        System.out.println("両プレイヤーの同意により勝負を行います");
        scanner.nextLine();
        System.out.println("このゲームはどちらかのプレイヤーのチップが尽きるまで繰り返されます");
        System.out.println("ルールはよろしいですか？");
        scanner.nextLine();
        System.out.println("では...");
        System.out.println("ゲームを開始します！");
        scanner.nextLine();

    }

    /**
     * 現在の掛け金を出力するためのメソッド
     * ゲームプレイヤーが掛け金を増やした時に出力します
     * 基本の掛け枚数と掛け倍率の乗算を現在の掛け金としています
     */
    public void showBetMagnification(){
        int nowOdds = betMagnification*odds;
        System.out.println("現在の掛け金は"+nowOdds+"枚です");
    }

    /**
     * １ゲームが終わるたびに2人のゲームプレイヤーの
     * 所持チップ枚数を出力するためのメソッド
     * @param player1　ユーザーが実際に操作するプレイヤーのインスタンス
     * @param player2　ユーザーが実際に対戦するプレイヤーのインスタンス
     * @param dealer  ゲームを進行させるディーラーのインスタンス
     */
    public void showChipStatus(Player player1,Rival player2,Dealer dealer){
        System.out.println(player1.getName()+"様の現在のチップは"+player1.getPossesionChip()+"枚です。");
        System.out.println(player2.getName()+"様の現在のチップは"+player2.getPossesionChip()+"枚です。");
    }
    
    /**
     * 賭け金倍率をリセットするためのメソッド
     */
    public void resetOdds(){
        odds = 1;
    }

    /**
     * ゲームが勝負の段階を迎えたら勝敗判定をするためのメソッド
     * このメソッドは2人のプレイヤーの勝負する意思が
     * ともに"yes"の時だけ実行されます
     * @param player1 ユーザーが操作するプレイヤーのインスタンス
     * @param player2 ユーザーが対戦するプレイヤーのインスタンス
     */
    public void judgeButtle(Player player1, Rival player2) {
        if (player1.getBattleWill() == "yes" && player2.getBattleWill() == "yes") {
            int target1Result = player1.getPossesionCard().getCardNumber();
            int target2Result = player2.getPossesionCard().getCardNumber();
            int nowOdds = betMagnification * odds;

            System.out.println("それでは勝負！");
            System.out.println(player1.getName() + "様のカードは" + target1Result);
            System.out.println(player2.getName() + "様のカードは" + target2Result);

            if (target1Result > target2Result) {
                System.out.println(player1.getName() + "様の勝利です");
                player2.loseChip(nowOdds);
                player1.getChip(nowOdds);
                scanner.nextLine();
            }
            if (target1Result < target2Result) {
                System.out.println(player2.getName() + "様の勝利です");
                player1.loseChip(nowOdds);
                player2.getChip(nowOdds);
                scanner.nextLine();
            }
            if (target1Result == target2Result) {
                System.out.println("引き分けです");
                scanner.nextLine();
            }
            resetOdds();
            System.out.println("次のゲームに移ります");
        }
    }

    /**
     * ゲームを勝負をしないまま終わる時のためのメソッド
     * どちらかのプレイヤーの勝負する意思が"no"だった時に実行されます
     * @param player1 ユーザーが実際に操作するプレイヤーのインスタンス
     * @param player2 ユーザーが実際に対戦するプレイヤーのインスタンス
     */
    public void foldGame(Player player1, Rival player2) {
        if ((player1.getBattleWill() == "no") || (player2.getBattleWill() == "no")) {
            System.out.println("今回のゲームは勝負の同意が得られませんでした");
            System.out.println("次のゲームに移ります");
            resetOdds();
            scanner.nextLine();
        }
    }

    /**
     * どちらかのプレイヤーの所持チップが尽きた時に
     * インディアンポーカーを終わらせるためのメソッド
     * @param player1 ユーザーが実際に操作するプレイヤーのインスタンス
     * @param player2 ユーザーが実際に対戦するプレイヤーのインスタンス
     */
    public void finishGame(Player player1,Rival player2){
        if((player1.getPossesionChip()<=0)||(player2.getPossesionChip()<=0)){
            if(player1.getPossesionChip()<=0){
                System.out.println("おっと、"+player1.getName()+"様のチップが尽きてしまいました");
                System.out.println("これでインディアンポーカーは終了です");
                System.out.println(player1.getName()+"様はお引き取りください");
            }
            if(player2.getPossesionChip()<=0){
                System.out.println("おっと、"+player2.getName()+"様のチップが尽きてしまいました");
                System.out.println("これでインディアンポーカーは終了です");
                System.out.println(player2.getName()+"様はお引き取りください");
            }
        }
    }

}
