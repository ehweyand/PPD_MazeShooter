/*
 Servidor basicamente valida os comandos e passa para os outros jogadores
Desafios:
* Como comunicar entre jogadores
* Como validar os movimentos
 */
package shootergame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author evand
 */
public class GameServer {

    private Socket socket = null;

    public GameServer() {
    }

    private static void handleConnections() throws IOException {
        ServerSocket ss = new ServerSocket(5000);

        while (true) {

            Socket s = ss.accept();

            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(in);

            String str = bf.readLine(); // Comando recebido
            System.out.println(str);

            PrintWriter pr = new PrintWriter(s.getOutputStream());

            pr.println("Sim"); // Comando de retorno
            pr.flush(); // limpa o buffer do PrintWriter
        }
    }

    public static void main(String[] args) throws IOException {
        handleConnections();
    }
}
