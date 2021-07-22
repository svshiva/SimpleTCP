package simpletcp_bonus_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public Client() throws Exception{
        int port= 2021;
        Socket socket = new Socket("192.168.29.103", port);
        System.out.println("Successful Connection to the server.");

        //I/O buffers
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        Scanner sc  = new Scanner(System.in);
        String message = "message";
        System.out.println("To quit, type 'EXIT'");
        while(!message.equalsIgnoreCase("tixe")){
            System.out.print("Enter your text: ");
            out_socket.println(sc.nextLine());
            message = in_socket.readLine();
            System.out.println("Result: "+message);

        }

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
