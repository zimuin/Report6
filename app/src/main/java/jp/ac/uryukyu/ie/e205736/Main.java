package jp.ac.uryukyu.ie.e205736;
import java.util.Scanner;

/**
 * 実際にゲームを進行させるクラス
 */
public class Main {
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dealer dealer = new Dealer();
        dealer.setActions();
        dealer.explainRule();
        Player player1 = new Player("ゲスト");
        Rival player2 = new Rival("金持ちおじさん");

        while (true) {
            while ((player1.getPossesionChip()>0)&&(player2.getPossesionChip()>0)) {
                player1.drawCard();
                player2.drawCard();
                player1.showRivalCard(player2);
                player2.facialExpression(player1);
                player2.reDrawCard(player1);
                scanner.nextLine();
                player1.showRivalCard(player2);
                player2.oddsUp(player1, dealer);
                player2.thinkBattle(player1, dealer);
                scanner.nextLine();
                while((player1.getBattleWill()==null)||player2.getBattleWill()==null){
                    System.out.println("番号を入力後、Enterを押してください");
                    player1.select(dealer, dealer.getActions());
                    player2.facialExpression(player1);
                    dealer.showBetMagnification();
                    scanner.nextLine();
                }
                dealer.judgeButtle(player1, player2);
                dealer.foldGame(player1, player2);
                player1.resetBattleWill();
                player2.resetBattleWill();
                dealer.showChipStatus(player1, player2, dealer);
                scanner.nextLine();
            }
            dealer.finishGame(player1, player2);
            break;
        }

        scanner.close();
    }
}