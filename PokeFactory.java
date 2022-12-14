/* used for storing the Overall_Pokemon in memory and make them accessible from the Flyweight class */

import java.util.*;

public class PokeFactory {
  private static final Map <pokemon, String> pokemons = new HashMap<>();

  public static pokemon makePokemon(String name) {
    pokemon p = null;
    if(pokemons.get(name) == null) {
      p = new pokemon.Builder(name).build();
      pokemons.put(p, name);
    }
    return p;
  }
}
