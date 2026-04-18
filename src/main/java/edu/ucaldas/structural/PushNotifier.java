package edu.ucaldas.structural;

public class PushNotifier implements Notifier {
    @Override
    public String send(String message) {
        return "Push enviado: " + message;
    }
}
