import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args)  {
        String host = "127.0.0.1";
        int port = 7779;
        Scanner scanner = new Scanner(System.in);

        try (Socket clientSocket = new Socket(host,port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
            String resp = in.readLine();
            System.out.println(resp);
            String username = scanner.nextLine();
            out.println(username);
            String resp1 = in.readLine();
            System.out.println(resp1);
            String answer = scanner.nextLine();
            out.println(answer);
            String resp2 = in.readLine();
            System.out.println(resp2);
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}