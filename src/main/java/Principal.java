
package main.java;

public class Principal {
    public static void main(String[] args) {
        // Cria o nosso subject (pedido)
        Pedido pedido = new Pedido("X-Burger + Batata Frita");

        // Cria os observers (clientes)
        Cliente cliente1 = new Cliente("Pedro");
        Cliente cliente2 = new Cliente("Matheus");

        // Registra os observadores
        pedido.registrarObserver(cliente1);
        pedido.registrarObserver(cliente2);

        // Altera o estado e dispara as notificações
        pedido.setStatus("Em preparação");
        
        System.out.println("--- Atualizando para pronto ---");
        pedido.setStatus("Pronto para entrega");
    }
}