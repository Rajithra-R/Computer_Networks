import java.net.*;
import java.io.*;
public class UDPchatserver
{

public static void main(String[] args)throws Exception
{
int i = 4000;
while(true)
{
System.out.println("Waiting for the client....");
DatagramSocket ds=new DatagramSocket(i);
byte[] buf=new byte[1024];
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
InetAddress ia=InetAddress.getByName("localhost");
DatagramPacket dp=new DatagramPacket(buf, 1024);
ds.receive(dp);
String str1=new String(dp.getData(),0,dp.getLength());
if(str1.equals("bye"))
     break;
String words[] = str1.split(" +");
String option = words[2];
System.out.println("Received operands " + words[0] + "  " +words[1] + " , operation : "+words[2]);
double c = 0;
double number1 = Double.parseDouble(words[0]);
double number2 = Double.parseDouble(words[1]);
String cur = "";
switch(option)
{
  case "+":
		c = number1  + number2; 
		cur = Double.toString(c);
		break;
  case "-":
		if(number1 > number2){
		       c = number1  - number2; 
		}
		else {
			c = number2  - number1;
		}
     		cur = Double.toString(c);
		break;
   case "*":
	        c = number1  * number2; 
		cur = Double.toString(c);
		break;
  case "/":
		if(number2 != 0){
		     c = number1  / number2; 
		}
		cur = Double.toString(c);
		break;
  case "pow":
		c = Math.pow(number1,number2); 
		cur =Double.toString(c);
		break;
  case "min":
		c = Math.min(number1,number2);
		cur = Double.toString(c);
		break;
case "max":
		c = Math.max(number1,number2);
		cur = Double.toString(c);
		break;

case "sin":
		double c1 = Math.sin(Math.toRadians(number1));
		double c2 = Math.sin(Math.toRadians(number2));
		cur = Double.toString(c1)+" " +Double.toString(c2);
		break;

case "cos":
		double d1 = Math.cos(Math.toRadians(number1));
		double d2 = Math.cos(Math.toRadians(number2));
		cur = Double.toString(d1)+" " +Double.toString(d2);
		break;

case "tan":
		double x1 = Math.tan(Math.toRadians(number1));
		double x2 = Math.tan(Math.toRadians(number2));
		cur = Double.toString(x1)+" " +Double.toString(x2);
		break;

case "sqroot":
		double y1 =  Math.sqrt(number1);
		double y2 = Math.sqrt(number2);
		cur = Double.toString(y1)+ " "+Double.toString(y2);
		break;

case "cbroot":
		double z1 =  Math.cbrt(number1);
		double z2 = Math.cbrt(number2);
		cur = Double.toString(z1)+ " "+Double.toString(z2);
		break;
default:
		cur = "Invalid option..try again";
		break;
}
//String res = Integer.toString(c);
String res = cur;
DatagramPacket dp1=new DatagramPacket(res.getBytes(),res.length(),ia,dp.getPort());
ds.send(dp1);
if(res.equals("bye"))
break;
//i++;
//j++;
ds.close();

}}
}
