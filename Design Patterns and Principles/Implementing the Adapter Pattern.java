interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    public void makePayment(double amount) {
        System.out.println("Paid ₹" + amount + " via PayPal.");
    }
}

class StripeGateway {
    public void sendPayment(double amount) {
        System.out.println("Paid ₹" + amount + " via Stripe.");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway paypal = new PayPalGateway();

    public void processPayment(double amount) {
        paypal.makePayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripe = new StripeGateway();

    public void processPayment(double amount) {
        stripe.sendPayment(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPalAdapter();
        PaymentProcessor stripe = new StripeAdapter();

        paypal.processPayment(1000.0);
        stripe.processPayment(2500.0);
    }
}