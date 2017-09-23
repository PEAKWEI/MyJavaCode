package org.dgw.socket;
import java.io.IOException;  
import java.net.ServerSocket;  
import java.net.Socket;  
  
  
public class Server {  
      
    private int port = 8000;  
    private int server_num = 3;  
    private static ServerSocket serverSocket;  
      
    public Server() throws IOException {  
        serverSocket = new ServerSocket(port, server_num);  
        System.out.println("The server is starting");  
          
    }  
    public void service() {  
        while(true) {  
            Socket socket = null;  
            try {  
                socket = serverSocket.accept();  
                System.out.println("new connection is completed " + socket.getInetAddress() + ":" + socket.getPort());  
            } catch(IOException e) {  
                e.printStackTrace();  
            } finally {  
                if(socket != null) {  
                    try {  
                        socket.close();  
                    } catch (IOException e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
        }  
    }  
      
    public static void main(String args[]) throws IOException, InterruptedException {  
        Server server = new Server();  
        Thread.sleep(60000*10);  
        server.service();  
    }  
}  