//Connor Reilly 
//ITMD 515

package calculator_server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
 
public class Calculator_Server
{
    public static void main(String args[]) throws IOException
    {
 
        //socket connection
        ServerSocket ss = new ServerSocket(3333);
        Socket s = ss.accept();
 
        DataInputStream dataInput = new DataInputStream(s.getInputStream());
        DataOutputStream dataOutput = new DataOutputStream(s.getOutputStream());
 
        while (true)
        {
            
            String input = dataInput.readUTF();
 
            if(input.equals("exit"))
                break;
 
            System.out.println("Server equation recieved: " + input);
            int result;
 
      
            StringTokenizer stt = new StringTokenizer(input);
 
            int value1 = Integer.parseInt(stt.nextToken());
            String operation = stt.nextToken();
            int value2 = Integer.parseInt(stt.nextToken());
 
          
            if (operation.equals("+"))
            {
                result = value1 + value2;
            }
            else if (operation.equals("-"))
            {
                result = value1 - value2;
            }
            else if (operation.equals("*"))
            {
                result = value1 * value2;
            }
            else
            {
                result = value1 / value2;
            }
            System.out.println("515OK \nSending the result...");
 
            // send the result back to the client.
            dataOutput.writeUTF(Integer.toString(result));
        }
    }
}