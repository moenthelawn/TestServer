/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.TimeUnit; 
/**
 *
 * @author Chris
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void sleep(int time){
      try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        try{
           
        Socket s = new Socket("192.168.2.13",7800);
     //   PrintWriter pw = new PrintWriter(s.getOutputStream()); 
        
        //Packets are in the form of 
        //Air Humidity, Height, Angle, Air Temperature, water tank left,day number,PlantSlot, soil humidity
        ClientSendMessage("100;15;45;1;.021;150;3;5",s); 
         ClientSendMessage("100;15;45;1;.021;150;35;69",s); 
       // pw.flush(); 
      //  pw.write("100;15;45;1;.021;150;35;69");
      //  pw.flush(); 
        s.close(); 
                
        
        }catch(IOException e){
            e.printStackTrace();
        }
        
    
 
}
public static void ClientSendMessage(String msg, Socket socket) throws IOException{

    Writer bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    bw.write(msg);
    bw.write("\r\n");
    bw.flush();
}

}

//String IPAdress = '192.168.232.2'; 



