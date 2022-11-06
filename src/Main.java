import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
 int port = 7779;

 try (ServerSocket serverSocket=new ServerSocket(port)){
   while (true){
       try (Socket clientSocket = serverSocket.accept();
       PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
       BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
       ) {
           System.out.printf("New connection. Port %d%n", clientSocket.getPort());
           out.println("Your name:");
           final String username = in.readLine();
           out.println("Are you child? Yes -1, No - 2");
           final String answer = in.readLine();
           if (answer.equals("1")){
               out.println(String.format("Welcome to the kids area," + username+  "! Lets play!"));
           }
           else if (answer.equals("2")){
               out.println(String.format("Welcome to the adult zone," + username + "! Have a good rest, or a good working day!"));
           }
           else out.println("Error");

              }

            }
       }
    }
}