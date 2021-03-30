package chat.app;


import java.io.*;
import java.util.*;
import java.net.*;
  
// Server class
public class Server 
{
  
    public static void main(String[] args) throws IOException 
    {
        // server is listening on port 1234
        ServerSocket ss = new ServerSocket(1234);
        
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = "",str2 = "";
        while(!str.equals("Exit1")) {
            System.out.println("Type Exit1 to stop");
            str = din.readUTF();
            System.out.println("Aryan: "+str);
            System.out.print("Server: ");
            str2 = br.readLine();
            dout.writeUTF(str2);
            dout.flush();
        }
        din.close();
        s.close();
        ss.close();
    }  
}