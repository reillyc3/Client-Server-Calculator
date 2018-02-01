//Connor Reilly 
//ITMD 515
package calulator_client;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.net.InetAddress;
import java.io.DataOutputStream;
 
public class Calculator_Client
{
    public static void main(String[] args) throws IOException
    {
        InetAddress ip = InetAddress.getLocalHost();
        int port = 3333;
        Scanner sc = new Scanner(System.in);
 
        //Socket Connection
        Socket s = new Socket(ip, port);
 
        DataInputStream dataInput = new DataInputStream(s.getInputStream());
        DataOutputStream dataOutput = new DataOutputStream(s.getOutputStream());
 
        while (true)
        {
           
            System.out.print("Enter the equation (x + x): ");
        
            String input1 = sc.nextLine();
 
            if (input1.equals("exit"))
                break;
 
            //Equation is sent to the server
            dataOutput.writeUTF(input1);
 
         
            String ans = dataInput.readUTF();
            System.out.println("The answer is: " + ans);
        }
    }
}
