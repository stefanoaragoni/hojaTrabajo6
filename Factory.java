/********************************************
Universidad del Valle de Guatemala
Hoja de Trabajo #6

Stefano Aragoni - 20261
Roberto Vallecillos - 20441
Clase: Factory       Fecha: 31-03-2021
********************************************/

import java.util.*;

//Clase factory para elegir la clase de Map que usar
public class Factory<E, T>{
  //Si elige 1 el usuario, crea un HashMap
  //Si elige 2 el usuario, crea un TreeMap
  //Si elige 3 el usuario, crea un LinkedHashMap
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