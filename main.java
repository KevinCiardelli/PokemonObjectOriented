import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;

public abstract class main{

  public static String[] movesetCreator(String first, String second, String third, String fourth){
    String[] moveset = new String[4];

    moveset[0] = first;
    moveset[1] = second;
    moveset[2] = third;
    moveset[3] = fourth;

    return moveset;
  }

  public static void main(String args[]){

    //Getting User Information
    System.out.println("Welcome to your very own Object Oriented Pokemon adventure.");
    System.out.println("What is your name?");
    Scanner scan = new Scanner(System.in);
    String user_name = scan.nextLine();
    user new_user = user.getter(user_name);


    //Selecting Starting Pokemon and naming
    System.out.println("Okay "+ new_user.getName() +", you now get to pick your starter pokemon:\n");
    System.out.println("You can choose from three options: \tChamander the fire type \tBulbasaur the grass type \tSquirtle the water type\n");
    System.out.println("Please type the name of the starter you would like.");
    String starter = scan.nextLine();
    while(!starter.toLowerCase().equals("charmander") && !starter.toLowerCase().equals("bulbasaur") && !starter.toLowerCase().equals("squirtle")) {
      System.out.println("PLease make sure you type in either: Charmander, Squirtle, or Bulbasaur");
      starter = scan.nextLine();
    }
    System.out.println("You have chosen: " + starter + ". Would you like to give it a nickname? Yes or no");
    String request = scan.nextLine();
    Overall_Pokemon p2;
    if(request.toLowerCase().equals("yes")) {
      System.out.println("What name would you like?");
      String name = scan.nextLine();

      //Building Pokemon with nickname
      pokemon p1 = new pokemon.Builder(starter).nickname(name).build();
      System.out.println("Successfully renamed "+ starter + " to " + p1.getNickname());
      p1.print_image();
      if(starter.equals("Charmander")){
        p2 = new Overall_Pokemon(PokeFactory.makePokemon(starter),5 ,34 , movesetCreator("Pound", "Tackle", "Scratch","Ember"));
      }
      else if(starter.equals("Bulbasaur")){
        p2 = new Overall_Pokemon(PokeFactory.makePokemon(starter),5 ,34 , movesetCreator("Pound", "Tackle", "Scratch","Razor_Leaf"));
      }
      else{
        p2 = new Overall_Pokemon(PokeFactory.makePokemon(starter),5 ,34 , movesetCreator("Pound", "Tackle", "Scratch","Splash"));
      }
      p2.getPoke().setName(name);
      System.out.println(p2);
      new_user.addMember(p2);
    }
    else {

      //Building Pokemon without nickname
      pokemon p1 = new pokemon.Builder(starter).build();
      p1.print_image();
      if(starter.equals("Charmander")){
        p2 = new Overall_Pokemon(PokeFactory.makePokemon(starter),5 ,34 , movesetCreator("Pound", "Tackle", "Scratch","Ember"));
      }
      else if(starter.equals("Bulbasaur")){
        p2 = new Overall_Pokemon(PokeFactory.makePokemon(starter),5 ,34 , movesetCreator("Pound", "Tackle", "Scratch","Razor_Leaf"));
      }
      else{
        p2 = new Overall_Pokemon(PokeFactory.makePokemon(starter),5 ,34 , movesetCreator("Pound", "Tackle", "Scratch","Splash"));
      }
      System.out.println(p2);
      new_user.addMember(p2);
    }
    new_user.setPokeballs();

    //List of all the moves the pokemon can learn
    try{
      Scanner file = new Scanner(new File("pokemon.txt"));
      ArrayList<String> pokedex = new ArrayList<>();
      while(file.hasNext()){
        pokedex.add(file.next());
      }


      //Confirming Ready
      System.out.println("Are now ready to start your object oreinted pokemon adventure?");
      String answer = scan.nextLine();
      while(!(answer.toLowerCase().equals("yes"))) {
        System.out.println(answer.toLowerCase().equals("yes"));
        System.out.println("Won't take no for an answer!");
        answer = scan.nextLine();
      }


      //Pidgey Battle
      Overall_Pokemon pidgey = new Overall_Pokemon(PokeFactory.makePokemon(pokedex.get(20)), 5, 18, movesetCreator(pokedex.get(23),pokedex.get(24),pokedex.get(25),pokedex.get(26)));
      System.out.println("You're first encounter in the wild is Pidgey and it decides to battle.\n\n\n");
      try{
          Thread.sleep(2000);
      }

      catch(InterruptedException ex)
      {
          ex.printStackTrace();
      }
      pidgey.getPoke().print_image();
      System.out.println("\nThese are Pidgey's stats: HP:" + pidgey.getHp() + " Level:" + pidgey.getLevel()+"\n");

      //Calling Command Pattern for the fight using the users pokemon and the created enemy
      BattleOrig b = new BattleOrig(new_user.getMember(0), pidgey, new_user);
      b.BattleMode();



      System.out.println("On your way to the first gym you run into another pokemon...");


      //Weedle Battle
      Overall_Pokemon weedle = new Overall_Pokemon(PokeFactory.makePokemon(pokedex.get(27)), 6, 24, movesetCreator(pokedex.get(30),pokedex.get(31),pokedex.get(32),pokedex.get(33)));
      System.out.println("You're second encounter in the wild is Weedle and it decides to battle.\n\n\n");
      System.out.println("Are you ready?");
      String response = scan.nextLine();
      while(!(response.toLowerCase().equals("yes"))) {
        System.out.println("Won't take no for an answer!");
        response = scan.nextLine();
      }
      try{
          Thread.sleep(2000);
      }

      catch(InterruptedException ex)
      {
          ex.printStackTrace();
      }
      weedle.getPoke().print_image();
      System.out.println("\nThese are Weedle's stats: HP:" + weedle.getHp() + " Level:" + weedle.getLevel()+"\n");

      //Calling Command Pattern for the fight using the users pokemon and the created enemy
      BattleOrig c = new BattleOrig(new_user.getMember(0), weedle, new_user);
      c.BattleMode();

      System.out.println("\n" + new_user.getMember(0).getPoke().getName() + " can learn a new move: Bite");
      System.out.print("Type what move do you want to replace: ");
      new_user.getMember(0).getMoveSet();
      String new_move = scan.nextLine();
      new_user.getMember(0).replaceMove(new_move, "Bite");
      System.out.println("Successfully removed " + new_move + " and learned Bite that does 15 damage");
      try{
          Thread.sleep(1000);
      }

      catch(InterruptedException ex)
      {
          ex.printStackTrace();
      }

      //Healing all the members of the part
      System.out.println("Let's heal all your pokemon");
      new_user.healParty();
      System.out.println(".");
      try{
          Thread.sleep(2000);
      }
      catch(InterruptedException ex)
      {
          ex.printStackTrace();
      }
      System.out.println("..");
      try{
          Thread.sleep(2000);
      }
      catch(InterruptedException ex)
      {
          ex.printStackTrace();
      }
      System.out.println("...");
      System.out.println("HP back to full");


      //Gym Battle
      System.out.println("You have reached the first gym where you need to battle Brock to gain the first gym badge in your journey \n Are you ready?");
      response = scan.nextLine();
      while(!(response.toLowerCase().equals("yes"))) {
        System.out.println(answer.toLowerCase().equals("yes"));
        System.out.println("Won't take no for an answer!");
        response = scan.nextLine();
      }


      System.out.println("He has a total of 2 pokemon that you need to defeat");
      try{
          Thread.sleep(1000);
      }

      catch(InterruptedException ex)
      {
          ex.printStackTrace();
      }
      //Geodude fight
      Overall_Pokemon geodude = new Overall_Pokemon(PokeFactory.makePokemon(pokedex.get(34)), 6, 24, movesetCreator(pokedex.get(37),pokedex.get(38),pokedex.get(39),pokedex.get(40)));
      geodude.getPoke().print_image();
      System.out.println("\nThese are Geodude's stats: HP:" + geodude.getHp() + " Level:" + geodude.getLevel()+"\n");
      //Calling Command Pattern for the fight using the users pokemon and the created enemy
      BattleOrig d = new BattleOrig(new_user.getMember(0), geodude, new_user);
      d.BattleMode();


      //Onix fight
      System.out.println("You must now face his main pokemon, Onix! Healing all your pokemon.");
      System.out.println(".");
      try{
          Thread.sleep(2000);
      }
      catch(InterruptedException ex)
      {
          ex.printStackTrace();
      }
      System.out.println("..");
      try{
          Thread.sleep(2000);
      }
      catch(InterruptedException ex)
      {
          ex.printStackTrace();
      }
      System.out.println("...");
      new_user.healParty();
      System.out.println("Healed to full");

      Overall_Pokemon onix = new Overall_Pokemon(PokeFactory.makePokemon(pokedex.get(41)), 7, 30, movesetCreator(pokedex.get(44),pokedex.get(45),pokedex.get(46),pokedex.get(47)));
      onix.getPoke().print_image();
      System.out.println("\nThese are Onix's stats: HP:" + onix.getHp() + " Level:" + onix.getLevel()+"\n");
      //Calling Command Pattern for the fight using the users pokemon and the created enemy
      BattleOrig e = new BattleOrig(new_user.getMember(0), onix, new_user);
      e.BattleMode();

      System.out.println("You have sucessfully beat the gym and can continue your way through the region!");
      System.out.println("Thanks for playing!");

    }
    catch (FileNotFoundException e){
      System.out.println("Unsupported");
    }


  }
}
