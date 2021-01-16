package jp.ac.uryukyu.ie.e205736;
import java.util.ArrayList;

public class Dealer {
    private int betMagnification = 10;// 基本の賭ける枚数は10枚
    private int odds = 1;// 基本の賭ける倍率は等倍。
    private ArrayList<String> actions = new ArrayList<String>();

    public int getOdds() {
        return odds;
    }

    public void setOdds(int value) {
        odds = value;
    }

    public void setActions(){
       
        actions.add("カードを引き直す");
        actions.add("掛け金を二倍にする");
        actions.add("勝負を降りる");
        actions.add("今のカードで勝負する");
    }

    public ArrayList<String> getActions(){return actions;}

    public int getBetMagnification(){return betMagnification;}

    public void explainRule() {
        System.out.println("このゲームは二人のプレイヤーが数字のみが書かれたカードを");
        System.out.println("使用して行う簡単なインディアンポーカーです。");
        System.out.println();
        System.out.println("ゲーム開始時にお互いにカードを一枚引いて");
        System.out.println("頭の上に相手にしか見えない状態で掲げていただきます。");
        System.out.println();
        System.out.println("相手の表情や仕草などから自分のカードを予想してください。");
        System.out.println("お互いに勝負することが決まった後、カードをお互いに明かして");
        System.out.println("数字の大きい方のプレイヤーが勝利です。");
        System.out.println("");
        System.out.println("お互いのカードの数字が同じだった場合は何も起きず、次のゲームに移ります。");
        System.out.println("");
        System.out.println("プレイヤーには最初にチップを１００枚お配り致します。");
        System.out.println("基本の掛け金は１０枚。ゲームに負けたプレイヤーは相手に掛け金を払っていただきます。");
        System.out.println("また、カードを引いたプレイヤーには取れるアクションが４つあります。");
        System.out.println("");
        System.out.println("1つ目はカードを引き直すことです。");
        System.out.println("ゲーム中に1回だけカードを引き直すことができます。");
        System.out.println("自分のカードの数字が低いと思われた場合は早々に引き直していただいて構いません。");
        System.out.println("");
        System.out.println("2つ目は勝負を降りることです。");
        System.out.println("自分のカードが明らかに相手のカードより数字が低いと思われた場合は");
        System.out.println("勝負を降りることもできます。");
        System.out.println("その場合、所持しているチップから");
        System.out.println("現在の掛け金の半分を相手に支払っていただきます。");
        System.out.println("");
        System.out.println("３つ目は掛け金を二倍にすることです。");
        System.out.println("自分のカードに自信がある場合は掛け金を二倍にすることができます。");
        System.out.println("またこのアクションはゲーム中、お互いに一回づつ行うことができます。");
        System.out.println("");
        System.out.println("４つ目は現在のカードで勝負することです。");
        System.out.println("両プレイヤーの同意により勝負を行います。");
        System.out.println("");
        System.out.println("このゲームはどちらかのプレイヤーのチップが尽きるまで繰り返されます。");
        System.out.println("今回はあなたは後攻です");
        System.out.println("ルールはよろしいですか？");
        System.out.println("");
        System.out.println("では...");
        System.out.println("ゲームを開始します！");

    }

    public void judgeButtle(Player player1, Rival player2) {
        int target1Result = player1.getPossesionCard().getCardNumber();
        int target2Result = player2.getPossesionCard().getCardNumber();
        int nowOdds = betMagnification*odds;
        

        System.out.println("それでは勝負！");
        System.out.println(player1.getName() + "様のカードは" + target1Result);
        System.out.println(player2.getName() + "様のカードは" + target2Result);
        
        if (target1Result > target2Result) {
            System.out.println(player1.getName() + "様の勝利です");
            player2.loseChip(nowOdds);
            player1.getChip(nowOdds);
            System.out.println("チップを"+nowOdds+"枚手に入れた！");
        }
        if(target1Result < target2Result){
            System.out.println(player2.getName()+"様の勝利です");
            player1.loseChip(nowOdds);
            player2.getChip(nowOdds);
            System.out.println("チップを"+nowOdds+"枚失った...");
        }
        if(target1Result == target2Result){
            System.out.println("引き分けです");
        }
        odds = 1;
    }

   
}
