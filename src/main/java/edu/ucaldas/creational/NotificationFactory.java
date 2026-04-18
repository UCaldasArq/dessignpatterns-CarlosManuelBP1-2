package edu.ucaldas.creational;

import edu.ucaldas.structural.EmailNotifier;
import edu.ucaldas.structural.PushNotifier;
import edu.ucaldas.structural.SMSNotifierSimple;
import edu.ucaldas.structural.Notifier;

public class NotificationFactory {
    public Notifier createNotifier(String type) {
        if ("Email".equals(type)) {
            return new EmailNotifier();
        } else if ("SMS".equals(type)) {
            return new SMSNotifierSimple();
        } else if ("Push".equals(type)) {
            return new PushNotifier();
        }
        return null;
    }
}
