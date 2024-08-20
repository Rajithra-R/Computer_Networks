import java.io.*;
import java.net.*;
class client2n
{
public static void main(String[] args) throws Exception
{
Socket s = new Socket("localhost",6666);
System.out.println("Connected....");
DataInputStream din = new DataInputStream(s.getInputStream());
DataOutputStream dout = new DataOutputStream(s.getOutputStream());
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String option = "";

String s1 = din.readUTF();
System.out.println("From server : ");
System.out.println(s1);
String s2 = br.readLine();
dout.writeUTF(s2);
dout.flush(); 
String s3 = din.readUTF();
System.out.println(s3);
String dep1 = din.readUTF();
int seat1 = din.readInt();
String dep2 = din.readUTF();
int seat2 = din.readInt();
String dep3 = din.readUTF();
int seat3 = din.readInt();

System.out.println(1 + " ** "+dep1+" **  : "+seat1);
System.out.println(2 + " ** "+dep2+" **  : "+seat2);
System.out.println(3 + " ** "+dep3+" **  : "+seat3);

do
{
System.out.println("Enter the department you want admission with : ");
String dep = br.readLine();
dout.writeUTF(dep);
dout.flush();

String s7 = din.readUTF();
System.out.println("Server says : "+s7);

System.out.println("Enter the Maths mark : ");
int m1 = Integer.parseInt(br.readLine());
System.out.println("Enter the Physics mark : ");
int m2 = Integer.parseInt(br.readLine());
System.out.println("Enter the Chemistry mark : ");
int m3 = Integer.parseInt(br.readLine());
//System.out.println("To Server: ");
dout.writeInt(m1);
dout.flush();
dout.writeInt(m2);
dout.flush();
dout.writeInt(m3);
dout.flush();

System.out.println("Enter ThankYou to end...");
option = br.readLine();
}while(!option.equals("ThankYou"));

dout.close();
s.close();
}
}
