package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author abc
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket= new Socket("localhost", 5004);
			DataOutputStream dout= new DataOutputStream(socket.getOutputStream());
			 Scanner sc =new Scanner(System.in);
			 String line="";
			 new ReadThread(socket);
			while(!(line.equals("end"))){				
            System.out.println("Enter any line");
            line= sc.nextLine(); 
            dout.writeUTF(line);
			}
           
        } catch (IOException ex) {
			ex.printStackTrace();
                    }
    }
}


class ReadThread extends Thread{
    Socket socket;
    DataInputStream din;
    ReadThread(Socket s){
        socket=s;
        try {
            din= new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            System.out.println("Caught");
        }
		start();
    }
    public void run(){
        String data="";
        while(!(data.equals("end"))){
            try {
                data= din.readUTF();
            } catch (IOException ex) {
                System.out.println("caught");
                try {
                    din.close();
                } catch (IOException ex1) {
                    System.out.println("caught");
                }
            }
            System.out.println(data);
        }
        try {
                    din.close();
                } catch (IOException ex1) {
                    System.out.println("caught");
                }
    }
}
