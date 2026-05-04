
package main.java;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements Subject {
    private List<Observer> observers;
    private String status;
    private String itensPedido;

    public Pedido(String itensPedido) {
        this.observers = new ArrayList<>();
        this.itensPedido = itensPedido;
        this.status = "Aguardando confirmação";
    }

    @Override
    public void registrarObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notificarObservers() {
        for (Observer observer : observers) {
            observer.atualizar(this.status);
        }
    }

    public void setStatus(String status) {
        this.status = status;
        notificarObservers();
    }

    public String getStatus() {
        return status;
    }

    public String getItensPedido() {
        return itensPedido;
    }
}