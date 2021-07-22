package simpletcp_bonus_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable{
    private Socket socket;
    private ServerMain serverMain;

    public ServerThread(Socket socket, ServerMain serverMain) {
        this.socket = socket;
        this.serverMain=serverMain;
    }

    @Override
    public void run(){
        try{
            int clientNumber = serverMain.getClientNumber();
            System.out.println("Client " +clientNumber+" has connected.");
            //I/O buffer
            BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            int secretNumber = (int) (Math.random()*10+1);
            do{
                out_socket.println("guess");
            }
            while(Integer.parseInt(in_socket.readLine())!=secretNumber);

            out_socket.println("right");
            socket.close();
            System.out.println("Client " +clientNumber+" has disconnected.");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}


