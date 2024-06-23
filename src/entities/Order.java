package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import enums.OrderStatus;

public class Order {
    private Date moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> items = new ArrayList<>();

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Order(Date moment, OrderStatus status, Client client){
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }

    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public Double total(){
        double sum = 0.0;
        for(OrderItem o: items){
            sum += o.sutTotal();
        } return sum;
    }
    
    public String toString(){
        StringBuilder pBuilder = new StringBuilder();
        pBuilder.append("Order moment: " + sdf.format(new Date()) + "\n");
        pBuilder.append("Order status: " + status + "\n");
        pBuilder.append("Client: " + client.getName() + " " + sdf.format(client.getBirthDate()) + " " + client.getEmail() + "\n");
        pBuilder.append("Order Items: \n");
        for(OrderItem item: items){
            pBuilder.append(item + "\n");
        }
        return pBuilder.toString();
    }

}
