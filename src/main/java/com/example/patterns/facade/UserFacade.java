package com.example.patterns.facade;

public class UserFacade {
    private final DatabaseService db = new DatabaseService();
    private final NotificationService notification = new NotificationService();

    public void registerUser(String username){
        System.out.println("UserFacade: Starting registration for user: " + username);
        db.connect();;
        notification.sendWelcomeEmail();
        System.out.println("UserFacade: User registration completed successfully.");
    }
}
