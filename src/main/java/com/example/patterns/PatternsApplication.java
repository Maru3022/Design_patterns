package com.example.patterns;

import com.example.patterns.adapter.OldEuropeanSocket;
import com.example.patterns.adapter.SocketAdapter;
import com.example.patterns.adapter.UsbCCharger;
import com.example.patterns.bridge.*;
import com.example.patterns.builder.Builder;
import com.example.patterns.builder.Laptop;
import com.example.patterns.chain.*;
import com.example.patterns.decorator.Coffee;
import com.example.patterns.decorator.MilkDecorator;
import com.example.patterns.decorator.SimpleCoffee;
import com.example.patterns.decorator.SugarDecorator;
import com.example.patterns.facade.UserFacade;
import com.example.patterns.factory.EmailFactory;
import com.example.patterns.factory.NotificationFactory;
import com.example.patterns.factory.SMSFactory;
import com.example.patterns.observer.DeliveryService;
import com.example.patterns.observer.EmailNotificationService;
import com.example.patterns.observer.Observer;
import com.example.patterns.observer.OrderStatusManager;
import com.example.patterns.proxy.Internet;
import com.example.patterns.proxy.ProxyInternet;
import com.example.patterns.strategy.CreditCardPayment;
import com.example.patterns.strategy.Order;
import com.example.patterns.strategy.PayPalPayment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PatternsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatternsApplication.class, args);
    }

    // --- 1. FACADE ---
    @Bean
    public CommandLineRunner runFacade() {
        return args -> {
            System.out.println("\n=== FACADE PATTERN DEMO ===");
            UserFacade userFacade = new UserFacade();
            userFacade.registerUser("vitaliy_dev");
            System.out.println("===========================\n");
        };
    }

    // --- 2. BRIDGE ---
    @Bean
    public CommandLineRunner runBridge() {
        return args -> {
            System.out.println("\n=== BRIDGE PATTERN DEMO ===");

            // Теперь классы будут видны благодаря импорту
            RemoteControl radioRemote = new BasicRemote(new Radio());
            radioRemote.togglePower();

            RemoteControl tvRemote = new BasicRemote(new TV());
            tvRemote.togglePower();

            System.out.println("===========================\n");
        };
    }

    // --- 3. CHAIN OF RESPONSIBILITY ---
    @Bean
    public CommandLineRunner runChain() {
        return args -> {
            System.out.println("\n=== CHAIN OF RESPONSIBILITY DEMO ===");
            Handler authChain = Handler.link(
                    new UserExistsHandler(),
                    new PasswordHandler()
            );

            System.out.println("Attempting login with correct credentials:");
            authChain.check("admin_12345");

            System.out.println("\nAttempting login with wrong user:");
            authChain.check("guest_12345");
            System.out.println("====================================\n");
        };
    }

    // --- 4. DECORATOR ---
    @Bean
    public CommandLineRunner runDecorator() {
        return args -> {
            System.out.println("\n=== DECORATOR PATTERN DEMO ===");
            Coffee myOrder = new SimpleCoffee();
            myOrder = new MilkDecorator(myOrder);
            myOrder = new SugarDecorator(myOrder);

            System.out.println("Order: " + myOrder.getDescription());
            System.out.println("Price: " + myOrder.getCost());
            System.out.println("==============================\n");
        };
    }

    // --- 5. STRATEGY ---
    @Bean
    public CommandLineRunner runStrategy() {
        return args -> {
            System.out.println("\n=== STRATEGY PATTERN DEMO ===");
            Order myOrder = new Order(1500.0);

            System.out.println("Selecting Credit Card payment...");
            myOrder.setPaymentStrategy(new CreditCardPayment());
            myOrder.processOrder();

            System.out.println("\nSwitching to PayPal...");
            myOrder.setPaymentStrategy(new PayPalPayment());
            myOrder.processOrder();
            System.out.println("==============================\n");
        };
    }

    // --- 6. FACTORY METHOD ---
    @Bean
    public CommandLineRunner runFactory() {
        return args -> {
            System.out.println("\n=== FACTORY METHOD PATTERN DEMO ===");
            NotificationFactory smsFactory = new SMSFactory();
            smsFactory.send();

            NotificationFactory emailFactory = new EmailFactory();
            emailFactory.send();
            System.out.println("====================================\n");
        };
    }

    // --- 7. ADAPTER ---
    @Bean
    public CommandLineRunner runAdapter(){
        return args -> {
            System.out.println("\n=== ADAPTER PATTERN DEMO ===");
            OldEuropeanSocket oldSocket = new OldEuropeanSocket();
            UsbCCharger myAdapter = new SocketAdapter(oldSocket);
            myAdapter.charge();
            System.out.println("=========================\n");
        };
    }

    // --- 8. BUILDER ---
    @Bean
    public CommandLineRunner runBuilder() {
        return args -> {
            System.out.println("\n=== BUILDER PATTERN DEMO ===");
            Laptop gamingLaptop = new Builder("Intel i9")
                    .setRam(32)
                    .setHasSsd(true)
                    .build();
            System.out.println(gamingLaptop.toString());
            System.out.println("============================\n");
        };
    }

    // --- 9. PROXY ---
    @Bean
    public CommandLineRunner runProxy() {
        return args -> {
            System.out.println("\n=== PROXY PATTERN DEMO ===");
            Internet internet = new ProxyInternet();
            internet.connectTo("google.com");
            internet.connectTo("facebook.com");
            System.out.println("==========================\n");
        };
    }

    // --- 10. OBSERVER ---
    @Bean
    public CommandLineRunner runObserver() {
        return args -> {
            System.out.println("\n=== OBSERVER PATTERN DEMO ===");
            OrderStatusManager orderManager = new OrderStatusManager();
            orderManager.subscribe(new EmailNotificationService());
            orderManager.subscribe(new DeliveryService());

            orderManager.setStatus("PAYMENT_RECEIVED");
            System.out.println();
            orderManager.setStatus("READY_FOR_SHIPPING");
            System.out.println("==============================\n");
        };
    }
}