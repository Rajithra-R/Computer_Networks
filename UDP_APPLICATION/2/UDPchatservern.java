import java.net.*;
import java.io.*;
public class UDPchatservern
{

public static void main(String[] args)throws Exception
{
int i = 4000;
while(true)
{

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
System.out.println("Received strings " + words[0] + "  " +words[1] + " , operation : "+words[2]);
String s1 = words[0] ;
String s2 = words[1] ;
String cur = "";
switch(option)
{
  case "reverse":
		StringBuilder b = new StringBuilder(s1);
		b.reverse();
		String c= b.toString();
		StringBuilder b1 = new StringBuilder(s2);
		b1.reverse();
		String c1= b1.toString();
		cur ="Reverse of s1 : " c + "    Reverse of s2 : " + c1;
		break;
case "concatenate":
		cur = s1 +  s2;
		break;
case "find_common_letters":
		StringBuilder b2 = new StringBuilder();
		//int j = 0;
		for (int k = 0; k < s1.length(); k++) {
			for(int j=0;j<s2.length();j++)
			{
    			if (j < s2.length() && s1.charAt(k) == s2.charAt(j)) {
        		b2.append(s1.charAt(k));
           		}
		}
		}
		cur = b2.toString();
		break;
case "count_of_vowels":
		String vowels = "aeiou";
		int x = 0;
		for (int k = 0; k < s1.length(); k++) {
			for(int j=0;j<vowels.length();j++)
			{
			if (j < vowels.length() && s1.charAt(k) == vowels.charAt(j)) {
				x++;
		}}}
		int x1 = 0;
		for (int k = 0; k < s2.length(); k++) {
			for(int j=0;j<vowels.length();j++)
			{
			if (j < vowels.length() && s2.charAt(k) == vowels.charAt(j)) {
				x1++;
		}}}
		cur ="Count of s1 : "+ Integer.toString(x) +"   Count of s2 : " + Integer.toString(x1); 
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
