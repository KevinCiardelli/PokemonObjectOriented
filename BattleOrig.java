import java.util.Scanner;
import java.util.Date; /*Thread.sleep(7000) is seven seconds */


public class BattleOrig{

  private Overall_Pokemon p1;
  private Overall_Pokemon p2;
  private user username;

  public BattleOrig(Overall_Pokemon p, Overall_Pokemon x, user z){
        this.p1 = p;
        this.p2 = x;
        this.username = z;
  }

  public void BattleMode(){

        Battle battle = new Battle(p1, p2, username);
        Command fight = new FightCommand(battle);
        Command run = new RunCommand(battle);
        Command catching = new CatchCommand(battle);

        BattleTime battles = new BattleTime(fight,run,catching);

        while(p2.getBattleHp() > 0 && p1.getBattleHp() > 0){
          System.out.println(p1.getPoke().getName()+"'s hp: "+p1.getBattleHp()+"\t " + p2.getPoke().getName()+"'s hp: "+p2.getBattleHp());
          System.out.println("Do you want to fight, catch, or run");
          Scanner scan = new Scanner(System.in);
          String response = scan.nextLine();
          response  = response.toLowerCase();
          if(response.equals("fight")){
            battles.fighting();
          }

          else if(response.equals("catch")){
            battles.catching();
            try{
              if(username.getMember(1) != null){
                break;
              }
            }
            catch(IndexOutOfBoundsException e){
              System.out.println("Continuing the battle.");
            }


          }

          else if(response.equals("run")){
            battles.running();
            if(p2.getPoke().getName().equals("Onix") || p2.getPoke().getName().equals("Geodude")){
              System.out.print("");
            }
            else{
              break;
            }
          }
          else{
            System.out.println("Not a command try again");
          }

      }

    }
}
