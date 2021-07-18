package simpletcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

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

        out_socket.println("Welcome to "+port); //send welcome to client
        String mess = in_socket.readLine();
        System.out.println("[Client] :"+mess);//display client message


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
