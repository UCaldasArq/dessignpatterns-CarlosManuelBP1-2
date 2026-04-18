package edu.ucaldas.structural;

// TODO: Implementa el patrón Decorator.
// 1. Crea una clase abstracta NotifierDecorator que implemente Notifier.
// 2. Debe tener un campo protegido Notifier wrappee y delegar la llamada a send().

public abstract class NotifierDecorator implements Notifier {
    protected final Notifier wrappee;

    protected NotifierDecorator(Notifier wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public String send(String message) {
        if (wrappee == null) return null;
        return wrappee.send(message);
    }
}

// TODO: Crea la clase SMSNotifier que extienda NotifierDecorator
// Debe agregar el comportamiento adicional:
// "SMS enviado: " + message + " | " + resultado_del_email

class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public String send(String message) {
        String result = super.send(message);
        return "SMS enviado: " + message + " | " + result;
    }
}
