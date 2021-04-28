package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPCommunication {

    private String targetIP;

    public TCPCommunication(String targetIP) {
        this.targetIP = targetIP;
    }

    public String sendCommand(String command) throws IOException {

        Socket s = new Socket(targetIP, 5000);

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println(command);
        pr.flush();

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        return bf.readLine();
    }

}
