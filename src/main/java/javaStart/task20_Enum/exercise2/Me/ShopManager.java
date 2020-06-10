package javaStart.task20_Enum.exercise2.Me;

import java.util.ArrayList;
import java.util.Scanner;

public class ShopManager {
    public static void main(String[] args) {
        ArrayList<Order> orders = createOrders();
        OrderStatus selectedStatus = selectStatus();
        filterOrders(orders, selectedStatus);
    }

    private static ArrayList<Order> createOrders() {
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(new Order("Computer Apple MacBook Pro 2018", 4999, OrderStatus.PAID));
        orders.add(new Order("Smartphone Samsung Galaxy s10", 2499, OrderStatus.SHIPPED));
        orders.add(new Order("Smartphone Apple iPhone X", 2999, OrderStatus.PAID));
        orders.add(new Order("Washing Machine Beko X2000", 1499, OrderStatus.DELIVERED));
        orders.add(new Order("Fridge Samsung AT200", 1199, OrderStatus.DELIVERED));
        orders.add(new Order("Loudspeaker JBL z100", 199, OrderStatus.NEW));
        orders.add(new Order("Home Cinema Yamaha XBC900", 3499, OrderStatus.CANCELLED));
        orders.add(new Order("Console Sony Playstation 4", 1499, OrderStatus.SHIPPED));
        orders.add(new Order("Adapter USBC - HDMI", 149, OrderStatus.PAID));
        orders.add(new Order("Iron Zelmer PRIMO", 99.99, OrderStatus.SHIPPED));
        return orders;
    }

    private static OrderStatus selectStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the status of orders to display (");
        for (OrderStatus orderStatus:
             OrderStatus.values()) {
            System.out.print(orderStatus.name() + " ");
        }
        System.out.println("):");
        OrderStatus orderStatus = OrderStatus.valueOf(scanner.nextLine());
        return orderStatus;
    }

    private static void filterOrders(ArrayList<Order> orders, OrderStatus orderStatus) {
        orders.stream()
                .filter(order -> order.getOrderStatus() == orderStatus)
                .forEach(System.out::println);
    }
}
