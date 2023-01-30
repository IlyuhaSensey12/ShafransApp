import java.io.Serializable;
import java.util.ArrayList;

public class   PackageData implements Serializable {
     private String operationType;/// ADD, List
     private Order order;
     private ArrayList<Order> orders;

     public PackageData(String operationType, Order order){ //// Send to server info about
          this.operationType = operationType;
          this.order = order;
     }

     public PackageData(String operationType) {
          this.operationType = operationType;
     }

     public PackageData(ArrayList<Order> orders) {
          this.orders = orders;
     }

     public String getOperationType() {
          return operationType;
     }

     public void setOperationType(String operationType) {
          this.operationType = operationType;
     }

     public Order getOrder() {
          return order;
     }

     public void setOrder(Order order) {
          this.order = order;
     }

     public ArrayList<Order> getOrders() {
          return orders;
     }

     public void setOrders(ArrayList<Order> orders) {
          this.orders = orders;
     }
}
