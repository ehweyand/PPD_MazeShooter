/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    private Maze maze;

    public GameServer() {
        this.maze = new Maze();
    }
    
    private static void handleConnections() throws IOException {
        ServerSocket ss = new ServerSocket(5000);

        while (true) {

            Socket s = ss.accept();

            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(in);

            String str = bf.readLine(); // Comando recebido

            PrintWriter pr = new PrintWriter(s.getOutputStream());

            pr.println("Sim"); // Comando de retorno
            pr.flush(); // limpa o buffer do PrintWriter
        }
    }

    public static void main(String[] args) throws IOException {
        handleConnections();
    }
}
