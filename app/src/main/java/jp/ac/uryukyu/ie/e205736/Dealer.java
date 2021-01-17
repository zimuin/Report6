package jp.ac.uryukyu.ie.e205736;

import java.util.ArrayList;
import java.util.Scanner;

public class Dealer {
    private int betMagnification = 10;// 基本の賭ける枚数は10枚
    private int odds = 1;// 基本の賭ける倍率は等倍。
    private ArrayList<String> actions = new ArrayList<String>();// プレイヤーが取れる行動
    private Scanner scanner = new Scanner(System.in);

    public int getOdds() {
        return odds;
    }

    public void setOdds(int value) {
        odds = value;
    }

    public void setActions() {

        actions.add("カードを引き直す");
        actions.add("掛け金を二倍にする");
        actions.add("勝負を降りる");
        actions.add("今のカードで勝負する");
    }

    public ArrayList<String> getActions() {
        return actions;
    }

    public int getBetMagnification() {
        return betMagnification;
    }

    public void explainRule() {
        System.out.println("Enterを押すと進みます");
        scanner.nextLine();
        System.out.println("ゲスト様、今宵はお越しいただきありがとうございます");
        System.out.println("このゲームのルールを説明いたします。");
        scanner.nextLine();
        System.out.println("このゲームは二人のプレイヤーが1から13の数字のみが書かれたカードを");
        System.out.println("使用して行う簡単なインディアンポーカーです");
        System.out.println();
        scanner.nextLine();
        System.out.println("ゲーム開始時にお互いにカードを一枚引いて");
        System.out.println("頭の上に相手にしか見えない状態で掲げていただきます");
        System.out.println();
        scanner.nextLine();
        System.out.println("相手の表情や仕草などから自分のカードを予想してください");
        System.out.println("お互いに勝負することが決まった後、カードをお互いに明かして");
        System.out.println("数字の大きい方のプレイヤーが勝利です");
        System.out.println("");
        scanner.nextLine();
        System.out.println("お互いのカードの数字が同じだった場合は何も起きず、次のゲームに移ります");
        System.out.println("");
        scanner.nextLine();
        System.out.println("プレイヤーには最初にチップを１００枚お配り致します");
        System.out.println("基本の掛け金は１０枚。ゲームに負けたプレイヤーは相手に掛け金を払っていただきます");
        System.out.println("また、カードを引いたプレイヤーには取れるアクションが４つあります");
        System.out.println("");
        scanner.nextLine();
        System.out.println("1つ目はカードを引き直すことです");
        System.out.println("ゲーム中に対戦相手の会員様は1回、ゲスト様は1回だけカードを引き直すことができます");
        System.out.println("自分のカードの数字が低いと思われた場合は早々に引き直していただいて構いません");
        System.out.println("");
        scanner.nextLine();
        System.out.println("2つ目は勝負を降りることです。");
        System.out.println("自分のカードが明らかに相手のカードより数字が低いと思われた場合は");
        System.out.println("勝負を降りることもできます。");
        System.out.println("その場合、所持しているチップから");
        System.out.println("現在の掛け金の半分を没収いたします");
        System.out.println("");
        scanner.nextLine();
        System.out.println("３つ目は掛け金を二倍にすることです");
        System.out.println("自分のカードに自信がある場合は掛け金を二倍にすることができます");
        System.out.println("対戦相手の会員様はゲームごとに1回、ゲスト様は何回でも可能です");
        System.out.println("ですがあくまで程々にしないとチップが尽きてしまいますのでご注意を");
        System.out.println("");
        scanner.nextLine();
        System.out.println("４つ目は現在のカードで勝負することです");
        System.out.println("両プレイヤーの同意により勝負を行います");
        System.out.println("");
        scanner.nextLine();
        System.out.println("このゲームはどちらかのプレイヤーのチップが尽きるまで繰り返されます");
        System.out.println("ルールはよろしいですか？");
        System.out.println("");
        scanner.nextLine();
        System.out.println("では...");
        System.out.println("ゲームを開始します！");
        scanner.nextLine();

    }

    public void showBetMagnification(){
        int nowOdds = betMagnification*odds;
        System.out.println("現在の掛け金は"+nowOdds+"枚です");
    }

    public void showChipStatus(Player player1,Rival player2,Dealer dealer){
        System.out.println(player1.getName()+"様の現在のチップは"+player1.getPossesionChip()+"枚です。");
        System.out.println(player2.getName()+"様の現在のチップは"+player2.getPossesionChip()+"枚です。");
    }
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
            odds = 1;
            System.out.println("次のゲームに移ります");
        }
    }

    public void foldGame(Player player1, Rival player2) {
        if ((player1.getBattleWill() == "no") || (player2.getBattleWill() == "no")) {
            System.out.println("今回のゲームは勝負の同意が得られませんでした");
            System.out.println("次のゲームに移ります");
            odds = 1;
            scanner.nextLine();
        }
    }

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
