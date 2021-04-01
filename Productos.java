public class Productos{

  String name;
  String category;
  int amount = 0;

  public Productos(String a, String b){
        name =a; 
        category=b;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int n) {
        amount = amount + n;
    }

    public void compareTo() {

    }

    public void printInfo(){
      System.out.println("\nCategoria: " + category + "\t\tProducto: " + name + "\t\tCantidad: " + amount);
    }

     public void printNombreCategoria(){
      System.out.println("\nCategoria: " + category + "\t\tProducto: " + name);
    }

    public void printCategoria(){
      System.out.println("\nCategoría de "+name+": "+category+".");
    }


}