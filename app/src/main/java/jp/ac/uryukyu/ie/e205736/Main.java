package jp.ac.uryukyu.ie.e205736;
import java.util.Scanner;

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
                System.out.println("相手のカードは" + player2.getPossesionCard().getCardNumber());
                player2.facialExpression(player1);
                player2.reDrawCard(player1);
                scanner.nextLine();
                System.out.println("相手のカードは" + player2.getPossesionCard().getCardNumber());
                player2.oddsUp(player1, dealer);
                player2.thinkBattle(player1, dealer);
                scanner.nextLine();
                while(player1.getBattleWill()!="yes"){
                    player1.select(dealer, dealer.getActions());
                    player2.facialExpression(player1);
                    scanner.nextLine();
                }
                dealer.judgeButtle(player1, player2);
                dealer.foldGame(player1, player2);
                player1.resetBattleWill();
                player2.resetBattleWill();
            }
            dealer.finishGame(player1, player2);
            break;
        }

        scanner.close();
    }
}