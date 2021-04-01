import java.util.*;

public class Factory<E, T>{
  public Map gethash(int valor){
    if (valor == 1){
      return new HashMap<E,T>();
    }else if (valor == 2){
      return new TreeMap<E,T>();
    }else {
      return new LinkedHashMap<E,T>();
    }
  }
}