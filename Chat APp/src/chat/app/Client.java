/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.app;

import java.io.*;
import java.net.*;
import java.util.Scanner;
  
public class Client 
{
    public static void main(String args[]) throws UnknownHostException, IOException 
    {
        // getting localhost ip
        InetAddress ip = InetAddress.getByName("localhost");
          
        // establish the connection
        Socket s = new Socket(ip, 1234);
          
        // obtaining input and out streams
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
  
        // sendMessage thread
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = "",str2 = "";
        while(!str.equals("Exit1")){
            System.out.print("Aryan: ");
            str = br.readLine();
            dout.writeUTF(str);
            dout.flush();
            str2 = dis.readUTF();
            System.out.println("Server : "+str2);
        }
        dout.close();
        s.close();
    }
}