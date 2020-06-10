package Test;

import java.util.Scanner;

public class ExecutiveApp {
    public static void main(String[] args) {
        Order[] orders = createOrders();
        String status = selectOrder();
        orders = filterOrders(orders, status);
        printFilteredStatus(orders);
    }

    private static Order[] createOrders() {
        Order[] orders = new Order[10];
        orders[0] = new Order("Grand Cherokee IV 3.0 D", "NEW");
        orders[1] = new Order("Mercedes G 350" , "PAID");
        orders[2] = new Order("Audi A6 50 TDi", "SHIPPED");
        orders[3] = new Order("Golf VIII 1.5 TSI", "DELIVERED");
        orders[4] = new Order("Jaguar F-Pace 2.0 i4D", "NEW");
        orders[5] = new Order("Citroën C4 1.6 BlueHDi", "PAID");
        orders[6] = new Order("Ford Mondeo 2.0 TDCi", "SHIPPED");
        orders[7] = new Order("Opel Astra K 1.4", "DELIVERED");
        return orders;
    }

    private static String selectOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a status to filter: ");
        printStatus();
        String status = scanner.nextLine();
        return status;
    }

    private static void printStatus() {
        System.out.print("NEW, PAID, SHIPPED, DELIVERED");
    }

    private static Order[] filterOrders(Order[] orders, String status) {
        Order[] filteredOrders = new Order[0];
        for (Order order:
             orders) {
            if (order.getStatus().equals(status)) {
                for (Order orderStatus:
                     orders) {
                    System.out.println(orderStatus);
                }
            }
        }
        return filteredOrders;
    }

    private static void printFilteredStatus(Order[] orders) {
        for (Order order:
                orders) {
            System.out.println(order);
        }
    }
}
