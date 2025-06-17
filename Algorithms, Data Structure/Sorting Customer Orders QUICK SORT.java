class Order {
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
public class Main{
static void quickSort(Order[] orders, int low, int high){
    if(low < high){
        int pi = partition(orders,low,high);
        quickSort(orders,low,pi-1);
        quickSort(orders,pi+1,high);
    }
}

static int partition(Order[] orders, int low, int high){
    double pivot = orders[high].totalPrice;
    int i = low - 1;
    for(int j=low;j<high;j++){
        if(orders[j].totalPrice<=pivot){
            i++;
            Order tmp = orders[i];
            orders[i] = orders[j];
            orders[j] = tmp;
        }
    }
    Order tmp = orders[i+1];
    orders[i+1] = orders[high];
    orders[high] = tmp;
    return i+1;
}

 public static void main(String[] args) {
        Order[] orders = {
            new Order(101, "Alice", 99.99),
            new Order(102, "Bob", 149.49),
            new Order(103, "Charlie", 79.75)
        };

        quickSort(orders,0,orders.length-1);

        for (Order o : orders) {
            System.out.println(o);
        }
    }
}