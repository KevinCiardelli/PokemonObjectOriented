import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Date;

public class Battle {
    private Overall_Pokemon p1;
    private Overall_Pokemon p2;
    private user username;




    public Battle(Overall_Pokemon p, Overall_Pokemon q, user z){
        this.p1 = p;
        this.p2 = q;
        this.username = z;
    }

    public int randomNumber(){
      Random rand = new Random();
      int random = rand.nextInt(4);
      return random;
    }
    public void fight() {
        Scanner scan = new Scanner(System.in);
        try {
          Scanner file = new Scanner(new File("moves.txt"));
          ArrayList<String> moves = new ArrayList<>();
          while(file.hasNext()){
            moves.add(file.next());
          }
          System.out.println("Choose a move to use: ");
          p1.getMoveSet();
          String move = scan.nextLine();
          move = move.toLowerCase();
          while(!moves.contains(move)){
            System.out.print("Choose a move to use: ");
            p1.getMoveSet();
          }
          int index = moves.indexOf(move);
          System.out.println(move + " did " + moves.get(index+1) +" damage");


          p2.subtractBattleHp(Integer.valueOf(moves.get(index+1)));
          System.out.print("\n");
          String enemy_move = p2.getMove(randomNumber()).toLowerCase();

          try{
              Thread.sleep(2000);
          }

          catch(InterruptedException ex)
          {
              ex.printStackTrace();
          }
          if(p2.getBattleHp() > 0) {
            System.out.println(p2.getPoke().getName() + " uses the move " + enemy_move);
            System.out.println(enemy_move + " did " + moves.get(moves.indexOf(enemy_move) + 1) +" damage");
            p1.subtractBattleHp(Integer.valueOf(moves.get(moves.indexOf(enemy_move) + 1)));
            System.out.print("\n");
          }
          if(p2.getBattleHp() <= 0) {
            System.out.println(p1.getPoke().getName()+"'s hp: "+p1.getBattleHp()+"\t " + p2.getPoke().getName()+"'s hp: "+p2.getBattleHp());
            System.out.println("You have defeated "+ p2.getPoke().getName());
            p1.incrementHp();
            p1.incrementLevel();
            System.out.println(p1.getPoke().getName() + " is now level " + p1.getLevel() + " and now has "+ p1.getHp() +" HP");
          }
          else if(p1.getBattleHp() <= 0) {
            System.out.println(p1.getPoke().getName()+"'s hp: "+p1.getBattleHp()+"\t " + p2.getPoke().getName()+"'s hp: "+p2.getBattleHp());
            System.out.println("You have been defeated");
          }
        }
        catch (FileNotFoundException e){
          System.out.println("Unsupported");
        }

    }

    public void run() {
        if(p2.getPoke().getName().equals("Onix") || p2.getPoke().getName().equals("Geodude")) {
          System.out.println("You can't run away from a gym leader!\n");
        }
        else {
        System.out.println("You ran away successfully!");
        }
    }

    public void catching() {
        if(p2.getPoke().getName().equals("Onix") || p2.getPoke().getName().equals("Geodude")){
          System.out.println("You can't capture a gym leader's pokemon!\n");
        }
        else {
          System.out.println("Attempting to catch");
          int random = randomNumber();
          System.out.println(".");
          try{
              Thread.sleep(1000);
          }

          catch(InterruptedException ex)
          {
              ex.printStackTrace();
          }
          System.out.println("..");
          try{
              Thread.sleep(1000);
          }

          catch(InterruptedException ex)
          {
              ex.printStackTrace();
          }
          System.out.println("...");
          try{
              Thread.sleep(1000);
          }

          catch(InterruptedException ex)
          {
              ex.printStackTrace();
          }
          if(random <= 1) {
              System.out.println("You successfully caught " + p2.getPoke().getName());
              username.addMember(p2);
          }
          else {
              System.out.println("The attempt was not sucessfull");
          }
          username.usePokeBall();
          System.out.println("You now have " + username.getPokeballs() + " pokeballs left");
        }

    }
}
