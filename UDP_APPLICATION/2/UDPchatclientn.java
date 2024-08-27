import java.net.*;
import java.io.*;
class UDPchatclientn
{

public static void main(String[]args)throws Exception
{

//int i=3000,j=4000;
int j=4000;
while(true)
{

DatagramSocket ds=new DatagramSocket();
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
InetAddress ia=InetAddress.getByName("localhost");
byte[]  buf=new byte[1024];
System.out.println("Enter the string and operation(concatenate, reverse,find_common_letters,count_of_vowels) : ");
String str1=br.readLine();

DatagramPacket dp=new DatagramPacket(str1.getBytes(),str1.length(),ia,j);
ds.send(dp);
if(str1.equals("bye"))
       break;
DatagramPacket dpl =new DatagramPacket(buf, 1024);
ds.receive(dpl);
String res =new String(dpl.getData(),0,dpl.getLength());
if(res.equals("bye"))
     break;
//i++;
//j++;  
System.out.println("Received message= "+res);
ds.close();
}
}
}


