package com.kanini.CustomExceptions;

import com.kanini.CustomExceptions.PaymentExceptions.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try( Scanner sc = new Scanner(System.in)) {
           
            System.out.print("Enter Order ID: ");
            String orderId = sc.nextLine();

            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter UPI ID: ");
            String upiId = sc.nextLine();

            System.out.print("Enter UPI PIN (4 digits): ");
            int pin = sc.nextInt();

            Order order = new Order(orderId, amount);
            Payment payment = new Payment();

            payment.pay(order, upiId, pin);
            System.out.println("Order Confirmed ");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid number for pin and amount");

        } catch (PaymentFailedException e) {

            System.out.println(" PAYMENT ERROR");
            System.out.println("Exception Type: " + e.getClass().getSimpleName());
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("Message: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }
}
