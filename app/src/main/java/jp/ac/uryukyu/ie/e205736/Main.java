package jp.ac.uryukyu.ie.e205736;
import java.util.Random;

public class Main{
    public static void main(String[] args){
        Random rand = new Random();
        int cardnumber = rand.nextInt(12)+1;
        var player1 = new Human("一郎");
        System.out.println(player1.name);
        System.out.println(player1.possessionChip);
        System.out.println(player1.betMagnification);
        var player1Card = new Card(cardnumber);
        player1.possesionCard = player1Card;
        System.out.println(player1.possesionCard.number);
    }
}