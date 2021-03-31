import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception{
    Scanner scan = new Scanner(System.in);
    File file = new File("ListadoProducto.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));
    String linea;
    int op;
    Factory<String, String> factory = new Factory<String,String>();
    Map<String, String> inventario = new HashMap<String,String>();
    Map<String, String> coleccion = new HashMap<String, String>();
  
    while (true){
      try{
      op = scan.nextInt();
        if(op > 0 & op < 4){
          break;
        }else{
          System.out.println("Ingrese un valor válido");
        }
      }catch(Exception E){
        System.out.println("Ingrese un valor válido");
        scan.next();
				continue;
      }
    }
    
    inventario = factory.gethash(op);
    coleccion = factory.gethash(op);


    while ((linea = br.readLine()) != null){
      String[] productos = linea.split("\\s\\|\\s");
      System.out.println(productos[0]);
      inventario.put(productos[1], productos[0]);
    }
  }
}