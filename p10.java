import java.util.Scanner;
import java.net.*;
import java.io.*;
public class p10udpclient
{
 public static void main(String args[])
 {
  Scanner in=new Scanner(System.in);
  DatagramSocket skt;
  try
  {
skt=new DatagramSocket();
InetAddress host=InetAddress.getByName("127.0.0.1");
int s_port=3780;
while(true)
{
System.out.println("Client");
String msg=in.nextLine();
byte[] b = msg.getBytes();
DatagramPacket request=new DatagramPacket(b,b.length,host,s_port);
skt.send(request);
byte buffer[]=new byte[1024];
DatagramPacket reply=new DatagramPacket(buffer,buffer.length);
skt.receive(reply);
System.out.println("Server:"+new String(reply.getData()));
}
}
catch(Exception e)
{
e.printStackTrace();
}
}
}



import java.util.Scanner;
import java.net.*;
import java.io.*;
public class p10udpserver
{
 public static void main(String args[])
 {
  Scanner in=new Scanner(System.in);
  DatagramSocket skt=null;
  try
  {
skt=new DatagramSocket(3780);
System.out.println("Server is ready");
while(true)
{
byte buffer[]=new byte[1024];
DatagramPacket req= new DatagramPacket(buffer,buffer.length);
skt.receive(req);
String msg=new String(req.getData());
System.out.println("Client:" +msg);
System.out.println("Server");
String m=in.nextLine();
byte[] sendmsg = m.getBytes();
DatagramPacket reply=new DatagramPacket(sendmsg,sendmsg.length,req.getAddress(),req.getPort());
skt.send(reply);
}
}
catch(Exception e)
{
e.printStackTrace();
}
}
}
