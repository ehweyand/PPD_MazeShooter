/*
 Servidor basicamente valida os comandos e passa para os outros jogadores
Desafios:
* Como comunicar entre jogadores
* Como validar os movimentos
 */
package server;

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

    private static void handleConnections() throws IOException {
        ServerSocket ss = new ServerSocket(5000);
        Socket socket = null;
        Maze maze = new Maze();
        while (true) {

            Socket s = ss.accept();

            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(in);

            String str = bf.readLine(); // Comando recebido

            //Quebrando a String
            String[] quebras = str.split("-");

            // Aglomeração de ifs abaixo
            if (quebras[1].equals("L")) {
                // player novo chegando
                Player player = new Player(quebras[0]);
                maze.addPlayerToGame(player);
            }

            PrintWriter pr = new PrintWriter(s.getOutputStream());

            pr.println("Sim"); // Comando de retorno
            pr.flush(); // limpa o buffer do PrintWriter
        }
    }

    public static void main(String[] args) throws IOException {
        handleConnections();
    }
}
