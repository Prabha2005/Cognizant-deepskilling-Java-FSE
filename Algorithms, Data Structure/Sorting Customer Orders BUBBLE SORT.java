class Order{
    int orderId;
    String customerName;
    double totalPrice;
    
    public Order(int orderId,String customerName,double totalPrice){
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }
    public String toString(){
        return orderId + " " + customerName + " $ " + totalPrice; 
    }
}

// Bubble Sort
public class Main{
static void bubbleSort(Order[] orders){
    int len = orders.length;
    for(int i=0;i<len-1;i++){
        for(int j=0;j<len-i-1;j++){
            if(orders[j].totalPrice > orders[j+1].totalPrice){
                Order tmp = orders[j];
                orders[j] = orders[j+1];
                orders[j+1] = tmp;
            }
    }
    }
}
public static void main(String[] args){
    Order[] orders = {
        new Order(101,"Alice",99.99),
        new Order(102,"Prabha",149.99),
        new Order(103,"Karthick",79.75)
    };
    bubbleSort(orders);
    for(Order o: orders){
        System.out.println(o);
    }
}
}