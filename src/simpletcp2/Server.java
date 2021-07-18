package simpletcp2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.Random;

public class Server {
    public Server() throws IOException {
        int port =2021;
        ServerSocket server_socket = new ServerSocket(port); // opening a new port
        System.out.println("Port :"+port+" is open now.");

        Socket socket = server_socket.accept();
        System.out.println("Client :"+socket.getInetAddress() + " has connected.");

        //i/o buffer
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        int secretNum = (int)(Math.random()*10+1);

        do {
            out_socket.println("Guess");
        }while (Integer.parseInt(in_socket.readLine()) != secretNum);
        out_socket.println("Done");
        System.out.println("Client guessed the num !!!");

        //socket closing
        socket.close();;//socket is closed
        System.out.println("Socket is closed");
    }

    public static void main(String[] args) {
        try {
           new Server();
        }
        catch (Exception e){
           e.printStackTrace();
        }
    }
}
