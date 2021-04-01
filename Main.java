import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception{
    
    System.out.println("--Bienvenidx a la tienda online--");


    Scanner scan = new Scanner(System.in);
    File file = new File("ListadoProducto.txt");
    Scanner scan2 = new Scanner(file);

    String linea;
    int op;


    Factory<String,Productos> factory = new Factory<String,Productos>();
    Map<String, Productos> inventario = null;
    Map<String, Productos> coleccion = null;
    
    ArrayList categoryStore = new ArrayList();

  
    while (true){
      try{
      System.out.println("Ingresar el número del Map a utilizar\n1) HashMap\n2) LinkedHashMap\n3) TreeMap");
      op = scan.nextInt();
      scan.nextLine();
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

    while (scan2.hasNextLine()){
      linea = scan2.nextLine();
      String[] lineaMod = linea.split("\\|");
      String categoria = ((lineaMod[0]).trim()).toLowerCase();
      String producto = ((lineaMod[1]).trim()).toLowerCase();
      Productos temp;

      if(inventario.isEmpty()){
        temp = new Productos(producto, categoria);
        inventario.put(producto,temp);
      }else{
        if(inventario.containsKey(producto)){
          Productos temp2 = inventario.get(producto);
          temp2.setAmount(1);
        }else{
          temp = new Productos(producto, categoria);
          inventario.put(producto,temp);
        }
      }

      categoryStore.add(categoria);

    }

    int op2 = 0;
    

    boolean a = true;
    while(a){
      System.out.println("---------------------\n");
      while (true){
        try{
          System.out.println("\nIngrese la opcion que desee:" +
            "\n\t1) Agregar producto a su coleccion." +
            "\n\t2) Mostrar categoria de producto específico." +
            "\n\t3) Mostrar la informacion de cada producto y categoría en su coleccion." +
            "\n\t4) Mostrar la informacion de cada producto y categoría en su coleccion, ordenados por tipo." +
            "\n\t5) Mostrar productos y categorías de todo el inventario." +
            "\n\t6) Mostrar productos y categorías de todo el inventario, ordenados por tipo."+
            "\n\t7) Salir."
          );
                    
          op2 = scan.nextInt();
          scan.nextLine();
            if(op2 > 0 & op2 < 8){
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

      System.out.println("---------------------\n");
      switch(op2){
        case 1:
          System.out.println("\nIngrese la categoria del producto que desea agregar a su coleccion");

          String colName = scan.nextLine();
          String colName2 = colName.toLowerCase();

          if (categoryStore.contains(colName2)){

            System.out.println("\nIngrese el nombre del producto.");
            String proName = scan.nextLine();
            String proName2 = proName.toLowerCase();
            int cant = 0;
            while (true){
              try{
                System.out.println("\nIngrese la cantidad de artículos que desea de ese producto.");
                cant = scan.nextInt();
                scan.nextLine();
                  if(cant > 0 & cant < 100){
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

            if (!coleccion.containsKey(proName2)){
                if (inventario.containsKey(proName2)){

                  Productos temp3 = inventario.get(proName2);

                  temp3.setAmount(cant);

                  coleccion.put(proName2, temp3);
                }else{
                  Productos temp32 = new Productos(proName2, colName2);

                  temp32.setAmount(cant);

                  coleccion.put(proName2, temp32);
                }
                

            }else {
                coleccion.get(proName2).setAmount(cant);
            }

            System.out.println("\nSe ha almacenado " +proName2+" correctamente en su colección personal.");
          } else {
            System.out.println("\nEl nombre del producto que ha ingresado no se encuentra en la base de datos.");
          }
          break;
        case 2:
          System.out.println("\nIngrese el nombre del producto a buscar");
          String productName = scan.nextLine();
          String productName2 = productName.toLowerCase();

          if(coleccion.containsKey(productName2)){
            System.out.println("\nProducto encotrado en coleccion personal...");
            coleccion.get(productName2).printCategoria();
          }else if(inventario.containsKey(productName2)){
            System.out.println("\nProducto encotrado en inventario general...");
            inventario.get(productName2).printCategoria();
          }else{
            System.out.println("\nEste producto no se encuentra en el sistema.");
          }
          break;
        case 3:
          if(coleccion.isEmpty()){
            System.out.println("\nNo hay nada que imprimir. Su coleccion personal esta vacia.");
          }else{
            System.out.println("\nListado de Objetos en coleccion:");
            for (Map.Entry<String,Productos> entry : coleccion.entrySet()){
             entry.getValue().printInfo();
            }
          }
          break;
        case 4:
          Set<Map.Entry<String, Productos>> entrySet1 = coleccion.entrySet();
          List<Map.Entry<String, Productos>> list1 = new ArrayList<>(entrySet1);
          Collections.sort(list1, (o1, o2) -> o1.getValue().getCategory().compareTo(o2.getValue().getCategory()));
          if(list1.isEmpty()){
            System.out.println("\nNo hay nada que imprimir. Su coleccion personal esta vacia.");
          }else{
            list1.forEach(e->{
            System.out.println("\nCategoría: " + e.getValue().getCategory() + "             Producto: " + e.getKey());
            });
          }
          break;
        case 5:
          for (Map.Entry<String,Productos> entry : inventario.entrySet()){
             entry.getValue().printNombreCategoria();
            }
          break;
        case 6:
          Set<Map.Entry<String, Productos>> entrySet2 = inventario.entrySet();
          List<Map.Entry<String, Productos>> list2 = new ArrayList<>(entrySet2);
          Collections.sort(list2, (o1, o2) -> o1.getValue().getCategory().compareTo(o2.getValue().getCategory()));
          list2.forEach(e->{
            System.out.println("\nCategoría: " + e.getValue().getCategory() + "             Producto: " + e.getKey());
          });
          break;
        case 7:
          a = false;
          break;
      }
    }
    
  }
}