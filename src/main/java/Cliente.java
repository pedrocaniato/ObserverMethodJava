
package main.java;

public class Cliente implements Observer {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String status) {
        System.out.println("Olá, " + nome + "! O status do seu pedido foi atualizado para: " + status);
    }

    public String getNome() {
        return nome;
    }
}