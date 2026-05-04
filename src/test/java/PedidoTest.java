package test.java;

import main.java.Pedido;
import main.java.Observer;

public class PedidoTest {

    public static void main(String[] args) {
        System.out.println("Iniciando testes do Pedido...");
        
        try {
            deveNotificarClientesAoMudarStatus();
            System.out.println("TESTE PASSOU: deveNotificarClientesAoMudarStatus");
        } catch (Exception e) {
            System.err.println("TESTE FALHOU: deveNotificarClientesAoMudarStatus");
            e.printStackTrace();
        }
    }

    static void deveNotificarClientesAoMudarStatus() {
        Pedido pedido = new Pedido("X-Salada");
        
        // Simulação de um observer para teste
        class ClienteMock implements Observer {
            String statusRecebido;
            @Override
            public void atualizar(String status) {
                this.statusRecebido = status;
            }
        }

        ClienteMock clienteMock = new ClienteMock();
        pedido.registrarObserver(clienteMock);

        pedido.setStatus("Pronto");

        if (!"Pronto".equals(clienteMock.statusRecebido)) {
            throw new RuntimeException("Esperado: Pronto, mas recebeu: " + clienteMock.statusRecebido);
        }
    }
}