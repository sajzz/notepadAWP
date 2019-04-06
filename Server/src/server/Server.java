/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Shikhin
 */
public class Server {

    /**
     *
     * @param args
     */
    public static synchronized void main(String[] args) {
        try {
            ServerSocket server= new ServerSocket(5000);
			while(true){
                            System.out.println("Server is waiting for the request");
                            Socket socket= server.accept();
                            System.out.println("Connection established");
                            new MyThread(socket);
			}
			
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    public static String sendString(){
        return data;                        //This function is to be called in GUI function
    }
    public static String data="";
static class MyThread extends Thread{
	Socket socket;
	MyThread(Socket s){
		socket=s;
		start();
	}
        @Override
	public void run(){
		try{
			DataInputStream din= new DataInputStream(socket.getInputStream());
                            
			    while(!(data.equals("stop"))){
				data= din.readUTF();
			    }
		}
                catch(Exception e2){
			e2.printStackTrace();
		}
	}
}
}


