package client;

import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        final String IP = "127.0.0.1";
        final int PORT = 9876;

        // criação do socket e pedido de conexão
        try {
            socket = new Socket(IP, PORT);
            System.out.println("Conectado ao servidor!");
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o servidor: " + e.getMessage());
        }

        // comunicação

        // desconexão
        try {
            System.out.println("Encerrando o cliente");
            socket.close();
        } catch (Exception e) {
            System.out.println("Erro no closing: " + e.getMessage());
        }
    }
}
