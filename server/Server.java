package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        final int PORT = 9876;
        ServerSocket serverSocket = null;
        Socket socketClient = null;
        Scanner scanner = null;

        // criação do socket e binding
        // pode ocorrer uma excessão em que o SO nega acesso à porta, usaremos um
        // try-catch
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Servidor disponível na porta " + PORT);
        } catch (Exception e) {
            System.out.println("Erro no binding: " + e.getMessage());
            return; // caso o serverSocket não consiga abrir ele sairá da função
        }

        // conexão com o client
        try {
            System.out.println("Aguardando o cliente...");
            socketClient = serverSocket.accept(); // isso equivale a um scanner.next. O código vai parar
                                                  // até que receba a conexão
            System.out.println("Conectado ao cliente!");
            scanner = new Scanner(socketClient.getInputStream());
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o cliente: " + e.getMessage());
            return;
        }

        // comunicação
        try {
            String message = scanner.nextLine();
            System.out.println("recebida a mensagem do cliente: " + message);
        } catch (Exception e) {
            System.out.println("Erro na comunicação: " + e.getMessage());
        }

        // desconexão
        // socket aberto sem fechar dá erro.
        try {
            System.out.println("Encerrando o servidor.");
            scanner.close();
            socketClient.close();
            serverSocket.close();
        } catch (Exception e) {
            System.out.println("Erro no closing: " + e.getMessage());
        }
    }
}
