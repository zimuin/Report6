package jp.ac.uryukyu.ie.e205736;
import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Human {

    private Scanner scanner = new Scanner(System.in);
   

    Player(String name){
       super(name);
    }
    
    public void select(Dealer target,ArrayList<String> actions){
        System.out.println("どうしますか？");
        int index = 1;
        for (var action : actions){
            System.out.println(index+":"+action);
            index += 1;
        }

        
        int actionNumber = scanner.nextInt();
        if(actionNumber==1){drawCard();}
        if(actionNumber==2){oddsDoubleUp(target);}
        if(actionNumber==3){fold(target);}
        if(actionNumber==4){battle();}
    }

    
    
    

}
