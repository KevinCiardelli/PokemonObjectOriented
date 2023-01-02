/* Constructors and methods to design a pokemon
Builder method to account for decision being made by the user such as the nickname example
Methods to make sure we can access all factors of the pokemon object which we reference in other classes
*/

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class pokemon{

  private String name;
  private String nickname;


  public pokemon(Builder b){
    name = b.name;
    nickname = b.nickname;
  }

  public String getName(){
    return this.name;
  }

  public String getNickname(){
    return this.nickname;
  }

  public void setName(String n){
    this.name = n;
  }

  public void print_image(){
    try{
      Scanner file = new Scanner(new File(this.name.toLowerCase()+"_ascii.txt"));
      
      ArrayList<String> pokemon_ascii = new ArrayList<>();

      while (file.hasNextLine()) {
        pokemon_ascii.add(file.nextLine());
      }
      file.close();

      for (String character: pokemon_ascii) {
        System.out.println(character);
      }
    }
    catch (FileNotFoundException e){
      System.out.println("Unsupported");
    }
  }

  public static class Builder{
    private String name;
    private String nickname;

    public Builder(String n) {
      name = n;
    }

    public Builder nickname(String n) {
      nickname = n;
      return this;
    }


    public pokemon build() {
      return new pokemon(this);
    }
  }

}
