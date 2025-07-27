package com.yameen;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class OrderTimeRange {
    public static void main(String[] args) {
        OrderService service = new OrderService();

        // Add some sample orders
        service.addOrder(new Order(1, LocalDateTime.of(2024, 1, 1, 10, 0)));
        service.addOrder(new Order(2, LocalDateTime.of(2024, 1, 1, 12, 30)));
        service.addOrder(new Order(3, LocalDateTime.of(2024, 1, 1, 23, 0)));

        // Define time range
        LocalDateTime start = LocalDateTime.of(2024, 1, 1, 10, 0);
        LocalDateTime end   = LocalDateTime.of(2024, 1, 1, 16, 0);

        List<Order> outputList = service.listAllOrders(start, end);

        outputList.forEach(System.out::println);
    }

}

class OrderService{
    List<Order> allOrders = new ArrayList<>();

    public void addOrder(Order order){
        allOrders.add(order);
    }

    public List<Order> listAllOrders(LocalDateTime startTime, LocalDateTime endTime){
        List<Order> result = new ArrayList<>();

        for(Order order: allOrders){
            LocalDateTime time = order.getOrderTime();

            if((time.equals(startTime) || time.isAfter(startTime)) &&
                (time.equals(endTime) || time.isBefore(endTime))){
                result.add(order);
            }
        }
        return result;
    }
}

class Order{
    private int orderId;
    private LocalDateTime orderTime;

    public Order(int orderId, LocalDateTime time){
        this.orderId=orderId;
        this.orderTime=time;
    }
    public int getOrderId() {
        return orderId;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public String toString(){
        return orderId+ " at "+orderTime;
    }
}
