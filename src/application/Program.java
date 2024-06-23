package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Program {
    public static void main(String [] args) throws ParseException{
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("ENTER CLIENTE DATA:");

        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next().toUpperCase());

        Order order = new Order(birthDate, status, new Client(name, email, birthDate));

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            System.out.println("Enter #" + (i + 1) + " item data:");
            System.out.print("Product name: ");
            String nameProduct = sc.next().toUpperCase();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int qtd = sc.nextInt();

            order.addItem(new OrderItem(qtd,productPrice,new Product(nameProduct,productPrice)));

        }

        System.out.println();
        System.out.println("Order Summary: ");
        System.out.println(order);
        System.out.println("Total price: $" + order.total());


        sc.close();
    }
}
