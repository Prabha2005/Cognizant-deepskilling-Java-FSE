import java.util.HashMap;


class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    public void display(){
        System.out.println(productId + " | " + productName + " | " + quantity + " $ |" + price);
    }
}
class InventoryManager {
    private HashMap<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product p){
        inventory.put(p.productId,p);
    }
    public void updateProduct(int id,int qty, double price){
        Product p = inventory.get(id);
        if(p!=null){
            p.quantity = qty;
            p.price = price;
        }
    }
    public void deleteProduct(int id){
        inventory.remove(id);
    }
    public void showInventory(){
        for(Product p : inventory.values()){
            p.display();
        }
    }
}
public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        manager.addProduct(new Product(1, "Keyboard", 10, 999.99));
        manager.addProduct(new Product(2, "Mouse", 25, 499.50));
        manager.updateProduct(1, 15, 950.00);
        manager.deleteProduct(2);

        manager.showInventory();
    }
}