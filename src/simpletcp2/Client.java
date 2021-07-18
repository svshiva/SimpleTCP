package simpletcp2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Client {

    public  Client() throws Exception{
        int port= 2021;
        Socket socket = new Socket("192.168.29.103", port);
        System.out.println("[Successful] Connection to server");

        //I/O buffers
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        Scanner sc = new Scanner(System.in);


        while((in_socket.readLine()).startsWith("Guess")){
            System.out.print("[server]: Guess a number [1-10]: ");
            out_socket.println(sc.nextInt());
        }
        System.out.println("You Guessed it");

        //socket closing
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
