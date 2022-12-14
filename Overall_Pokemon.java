/* Flyweight class to get objects for the builder pokemon.java class and create  their own movset, hp, level*/

public class Overall_Pokemon {
  private pokemon poke;
  private int level;
  private int hp;
  private int battle_hp;
  private String[] moveset = new String[4];

  public Overall_Pokemon(pokemon p, int l, int h, String[] m) {
    poke = p;
    level = l;
    hp = h;
    battle_hp = h;
    moveset = m;
  }

  public pokemon getPoke(){
    return this.poke;
  }

  public void incrementLevel(){
    this.level+=1;
  }

  public int getLevel(){
    return this.level;
  }

  public void incrementHp(){
    this.hp = this.hp + 6;
  }

  public int getHp(){
    return this.hp;
  }

  public int getBattleHp(){
    return this.battle_hp;
  }

  public void setBattleHp(int i) {
    this.battle_hp = i;
  }

  public void getMoveSet(){
    for(String g: this.moveset){
      System.out.print(g+"  ");
    }
  }

  public String getMove(int i){
    return this.moveset[i];
  }

  public void subtractBattleHp(int i){
    this.battle_hp = battle_hp - i;
  }

  public void replaceMove(String g, String a){
    for(int i =0; i<moveset.length; i++){
      if(moveset[i].toLowerCase().equals(g.toLowerCase())){
        moveset[i] = a;
      }
    }
  }

  public String toString() {
    System.out.println("These are " + this.poke.getName() +"'s stats: ");
    System.out.print("Moveset: ");
    for(String g: this.moveset){
      System.out.print(g +" ");
    }
    System.out.println("\nLevel: "+ this.level);
    System.out.println("HP: " +this.hp);
    return "";
  }

}
