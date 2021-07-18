package simpletcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public  Client() throws Exception{
        int port= 2021;
        Socket socket = new Socket("localhost", port);
        System.out.println("[Successful] Connection to server");

        //I/O buffers
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        //Protocol
        String mess = in_socket.readLine();
        System.out.println("[server] : "+mess);

        out_socket.println("Thank you");

        socket.close();
        System.out.println("Socket closed.");
    }



    public static void main(String[] args) {
        try {
            new Client();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
