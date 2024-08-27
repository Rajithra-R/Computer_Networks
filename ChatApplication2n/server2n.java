import java.io.*;
import java.net.*;
class server2n
{
public static void main(String[] args) throws Exception
{
System.out.println("Waiting for the client...");

ServerSocket ss  =  new ServerSocket(6666);
Socket s = ss.accept();

System.out.println("Connected....");
DataInputStream din = new DataInputStream(s.getInputStream());
DataOutputStream dout = new DataOutputStream(s.getOutputStream());
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

String option = "";

System.out.println("To client : ");
String s1 = "What can I do for you..?";
dout.writeUTF(s1);
dout.flush();

String s2 = din.readUTF();
System.out.println(s2);

System.out.println("To client : ");
String s3 = "There are 3 branches in MSc..";
dout.writeUTF(s3);
dout.flush();
System.out.println(s3);

System.out.println("Enter the department 1: " );
String dep1 = br.readLine();
System.out.println("Enter the available seats in dep1 : " );
int seat1 = Integer.parseInt(br.readLine());
System.out.println("Enter the department 2: " );
String dep2 = br.readLine();
System.out.println("Enter the available seats dep2 : " );
int seat2 = Integer.parseInt(br.readLine());
System.out.println("Enter the department 3 " );
String dep3 = br.readLine();
System.out.println("Enter the available seats dep3 : " );
int seat3 = Integer.parseInt(br.readLine());

dout.writeUTF(dep1);
dout.flush();
dout.writeInt(seat1);
dout.flush();
dout.writeUTF(dep2);
dout.flush();
dout.writeInt(seat2);
dout.flush();
dout.writeUTF(dep3);
dout.flush();
dout.writeInt(seat3);
dout.flush();

System.out.println(1 + " ** "+dep1+" **  : "+seat1);
System.out.println(2 + " ** "+dep2+" **  : "+seat2);
System.out.println(3 + " ** "+dep3+" **  : "+seat3);

do
{
String dep = din.readUTF();
String s6 = "Need admission for " + dep;
System.out.println(s6);

String s7 = "Please send the mark details of the student";
dout.writeUTF(s7);
dout.flush();
System.out.println(s7);

int m1 = din.readInt();
int m2 = din.readInt();
int m3 = din.readInt();

System.out.println("Client says : ");
System.out.println("Maths mark : " + m1);
System.out.println("Physics mark : " + m2);
System.out.println("Chemistry mark : " + m3);

int total = m1+m2+m3;
int percentage = (total * 100)/300;
System.out.println("The cutoff percentage is : " + percentage + "%");
System.out.println("Department : " + dep1 + " | | " + "Seats : " + seat1); 
System.out.println("Department : " + dep2 + " | | " + "Seats : " + seat2); 
System.out.println("Department : " + dep3 + " | | " + "Seats : " + seat3); 

if(percentage > 45 )
{
if(dep.equals(dep1)  && seat1>0)
{
	System.out.println("Student is Eligible ." );
       seat1--;
       System.out.println( seat1+"  seats are available for " +dep1 );
}
else if(dep.equals(dep2)  && seat2>0)
{
	System.out.println("Student is Eligible ." );
       seat2--;
       System.out.println( seat2+"  seats are available for " +dep2 );

}
else if(dep.equals(dep3)  && seat3>0)
{
	System.out.println("Student is Eligible .");   
       seat3--;
        System.out.println(seat3+"  seats are available for " +dep3);
}
else
{
	System.out.println("Sorry , Not Eligible as the seats are not available... ");
}
}
else
{
	System.out.println("Sorry , Not Eligible as the percentage is not valid... ");

}
System.out.println("Enter ThankYou to end...");
option = br.readLine();
}while(!option.equals("ThankYou"));

din.close();
ss.close();
s.close();
}
}
