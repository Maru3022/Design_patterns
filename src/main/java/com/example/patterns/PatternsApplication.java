package com.example.patterns;

import com.example.patterns.decorator.Coffee;
import com.example.patterns.decorator.MilkDecorator;
import com.example.patterns.decorator.SimpleCoffee;
import com.example.patterns.decorator.SugarDecorator;
import com.example.patterns.factory.EmailFactory;
import com.example.patterns.factory.NotificationFactory;
import com.example.patterns.factory.SMSFactory;
import com.example.patterns.strategy.CreditCardPayment;
import com.example.patterns.strategy.Order;
import com.example.patterns.strategy.PayPalPayment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//ToDo: Strategy and Decorator patterns
@SpringBootApplication
public class PatternsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatternsApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            // Теперь ошибки не будет, так как MilkDecorator ЯВЛЯЕТСЯ типом Coffee
            Coffee myOrder = new SimpleCoffee();
            myOrder = new MilkDecorator(myOrder);
            myOrder = new SugarDecorator(myOrder);

            System.out.println("Order: " + myOrder.getDescription());
            System.out.println("Price: " + myOrder.getCost());
        };
    }

    @Bean
    public CommandLineRunner run1() {
        return args -> {
            System.out.println("\n=== STRATEGY PATTERN DEMO ===");

            // Create an order with a specific amount
            Order myOrder = new Order(1500.0);

            // User selects Credit Card
            System.out.println("Selecting Credit Card payment...");
            myOrder.setPaymentStrategy(new CreditCardPayment());
            myOrder.processOrder();

            // User changes mind and selects PayPal
            System.out.println("\nSwitching to PayPal...");
            myOrder.setPaymentStrategy(new PayPalPayment());
            myOrder.processOrder();

            System.out.println("==============================\n");
        };
    }

    @Bean
    public CommandLineRunner runFactory() {
        return args -> {
            System.out.println("\n=== FACTORY METHOD PATTERN DEMO ===");

            // Создаем фабрику для SMS
            NotificationFactory smsFactory = new SMSFactory();
            System.out.println("Factory: Requesting SMS delivery...");
            smsFactory.send();

            // Создаем фабрику для Email
            NotificationFactory emailFactory = new EmailFactory();
            System.out.println("\nFactory: Requesting Email delivery...");
            emailFactory.send();

            System.out.println("====================================\n");
        };
    }
}