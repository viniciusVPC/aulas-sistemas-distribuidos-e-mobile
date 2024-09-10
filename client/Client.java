package client;

import java.io.PrintStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        final String IP = "127.0.0.1";
        final int PORT = 9876;
        PrintStream printStream = null;

        // criação do socket e pedido de conexão
        try {
            socket = new Socket(IP, PORT);
            System.out.println("Conectado ao servidor!");
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o servidor: " + e.getMessage());
        }

        // comunicação
        try {
            printStream = new PrintStream(socket.getOutputStream());
            printStream.println("Hello world!");
        } catch (Exception e) {
            System.out.println("Erro na comunicação: " + e.getMessage());
        }

        // desconexão
        try {
            System.out.println("Encerrando o cliente");
            socket.close();
        } catch (Exception e) {
            System.out.println("Erro no closing: " + e.getMessage());
        }
    }
}
