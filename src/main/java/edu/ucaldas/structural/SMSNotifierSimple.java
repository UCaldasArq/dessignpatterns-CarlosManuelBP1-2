package edu.ucaldas.structural;

public class SMSNotifierSimple implements Notifier {
    @Override
    public String send(String message) {
        return "SMS enviado: " + message;
    }
}
