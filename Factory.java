import java.util.*;

public class Factory<E, T>{
  public Map gethash(int valor){
    if (valor == 1){
      return new HashMap();
    }else if (valor == 2){
      return new TreeMap();
    }else {
      return new LinkedHashMap();
    }
  }
}