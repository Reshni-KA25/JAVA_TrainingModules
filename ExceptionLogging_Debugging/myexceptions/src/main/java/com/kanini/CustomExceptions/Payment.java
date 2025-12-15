package com.kanini.CustomExceptions;
import com.kanini.CustomExceptions.PaymentExceptions.*;

public class Payment {

    public void pay(Order order, String upiId, int pin)
            throws PaymentFailedException {

        if (order.getAmount() <= 0) {
            throw new InvalidAmountException("Amount must be > 0",
                    1001);
        }

        if (!upiId.contains("@") || upiId.length() < 5) {
            throw new InvalidUPIIDException("Invalid UPI ID format(ex: reshni@upi)",
                    1002);
        }

        if (pin < 1000 || pin > 9999) {
            throw new InvalidPINException("PIN must be a 4-digit number",
                    1003);
        }

        boolean success = Math.random() > 0.3;  
        if (!success) {
            throw new UPIServiceFailedException("UPI server timeout",
                    1004);
        }

        System.out.println("Payment Successful");
    }
}

