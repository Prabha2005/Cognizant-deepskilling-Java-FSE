import java.util.Arrays;
import java.util.Comparator;
class Product {
    int productId;
    String productName;
    String category;
    
    public Product(int id,String productName, String category){
        this.productId = id;
        this.productName = productName;
        this.category = category;
    }
    public void display(){
        System.out.println(productId + " | " + productName + " | " + category);
    }
}
public class Main{
    public static Product linearSearch(Product[] products, String name){
    for(Product p: products){
        if(p.productName.equalsIgnoreCase(name)){
        return p;
    }
}
return null;
}
public static Product binarySearch(Product[] products, String name){
    Arrays.sort(products,Comparator.comparing(p->p.productName.toLowerCase()));
    int left = 0, right = products.length - 1;
    while(left <= right){
        int mid = (left+right)/2;
        int cmp = products[mid].productName.compareToIgnoreCase(name);
        if(cmp==0) return products[mid];
        if(cmp<0) left = mid + 1;
        else right = mid - 1;
    }
    return null;
}

public static void main(String[] args){
    Product[] catalog = {
        new Product(101,"Laptop","Electronics"),
        new Product(102,"Sneakers","Footwear"),
        new Product(103,"Mouse","Accessories"),
        new Product(104,"Backpack","Bags")
    };
    System.out.println("Linear Search Results: ");
    Product found1 = linearSearch(catalog,"Mouse");
    if(found1!=null) found1.display();
    
    System.out.println("\nBinary Search Results: ");
    Product found2 = binarySearch(catalog,"Backpack");
    if(found2!=null) found2.display();
}
}