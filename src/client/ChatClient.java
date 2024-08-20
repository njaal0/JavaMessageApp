package client;

import java.io.*;
import java.net.*;

public class ChatClient {
    private Socket socket = null;
    private BufferedReader inputConsole = null;
    private PrintWriter out = null;
    private BufferedReader in = null;

    public ChatClient(String adress, int port) {
        try {
            socket = new Socket(adress, port);
            System.out.println("Connected to server.");
            inputConsole = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = "";
            while (!line.equals("exit")) {
                line = inputConsole.readLine();
                out.println(line);
                System.out.println(in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + adress);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + adress);
            System.exit(1);
        }
    }
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 2000);
        System.out.println("Connected to server.");
        
    }
}
