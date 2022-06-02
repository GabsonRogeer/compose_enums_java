package com.exercicio.program;

import com.exercicio.entities.Client;
import com.exercicio.entities.Order;
import com.exercicio.entities.OrderItem;
import com.exercicio.entities.Product;
import com.exercicio.entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data: ");
        System.out.println("Name:");
        String name = sc.nextLine();
        System.out.println("E-Mail: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());

        Client client = new Client(name,email, birthDate);

        System.out.println("Enter order data: ");
        System.out.println("Status: (PENDING_PAYMENT, PROCESSING, SHIPPED, DELIVERED)");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(), status, client);
        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        for (int i=1; i<=n; i++) {
            System.out.println("Enter #" + i + " item data:");
            System.out.println("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.println("Product Price: ");
            Double price = sc.nextDouble();

            Product product = new Product(productName, price);

            System.out.println("Quantity: ");
            int quantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(quantity, price, product);

            order.addItems(orderItem);
        }

        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.println(order);
    }
}
