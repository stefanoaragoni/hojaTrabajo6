/********************************************
Universidad del Valle de Guatemala
Hoja de Trabajo #6

Stefano Aragoni - 20261
Roberto Vallecillos - 20441
Clase: Producto       Fecha: 31-03-2021
********************************************/

public class Productos{


  //Clase donde se guarda la información del producto(el producto en sí, 
  String name;
  String category;
  int amount = 0;

  //Constructor 
  public Productos(String a, String b){
        name =a; 
        category=b;
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getAmount() {
        return amount;
    }

    //Setter
    public void setAmount(int n) {
        amount = amount + n;
    }

    //Imprime el producto, la categoria del producto, y cuantos de ese producto hay
    public void printInfo(){
      System.out.println("\nCategoria: " + category + "\t\tProducto: " + name + "\t\tCantidad: " + amount);
    }

    //Imprime el producto y la categoria del producto
     public void printNombreCategoria(){
      System.out.println("\nCategoria: " + category + "\t\tProducto: " + name);
    }

    //Imprime la categoria de un producto
    public void printCategoria(){
      System.out.println("\nCategoría de "+name+": "+category+".");
    }


}