/* Singleton Design for only one user to be created
Has a party of pokemon for each user
*/
import java.util.ArrayList;

public class user {

  private static user entity;
  private String user_name;

  private ArrayList<Overall_Pokemon> party = new ArrayList<>();
  private int number_of_pokeballs;

  private user(String name){
    this.user_name = name;
  }

  public static user getter(String name) {
    if(entity == null) {
      entity = new user(name);
    }
    else {
      System.out.println("You already have a name");
    }
    return entity;
  }

  public void healParty(){
    for(Overall_Pokemon p: party){
      p.setBattleHp(p.getHp());
    }
  }


  public void addMember(Overall_Pokemon p){
    party.add(p);
  }

  public Overall_Pokemon getMember(int i) {
    return party.get(i);
  }

  public void getParty(){
    for(Overall_Pokemon p: party){
      System.out.println(p.getPoke().getName());
    }
  }

  public void setPokeballs(){
    number_of_pokeballs = 10;
  }

  public boolean usePokeBall(){
    if(number_of_pokeballs > 0){
      number_of_pokeballs-=1;
      return true;
    }
    else {
      System.out.println("You dont have enough pokeballs left");
      return false;
    }
  }

  public int getPokeballs(){
    return number_of_pokeballs;
  }

  public String getName(){
    return this.user_name;
  }
}
