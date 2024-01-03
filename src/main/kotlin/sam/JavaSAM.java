package sam;

import java.util.ArrayList;
import java.util.List;

public interface JavaSAM {
  public void play(String input);
}

class Generics {

  public void check() {
    List names = new ArrayList<String>();
    names.add("Alex");
    names.add("Ben");
    names.add(123); // this is incorrect, but compiles
    for(int i = 0; i < names.size(); i++){
      String name= (String) names.get(i); // exception at i==2
      System.out.println(name.toUpperCase());
    }
  }
}
