import java.net.*;
import java.io.*;
import java.util.Scanner;
public class p9tcpclient
{
  public static void main(String args[])
  { 
     Socket s;
     while(true)
     {
      try
       {
          s=new Socket("127.0.0.1",3000);
          OutputStream ostream=s.getOutputStream();
          System.out.println("enter filename");
          Scanner input= new Scanner(System.in);
          String fname= input.nextLine();
          PrintWriter pwrite = new  PrintWriter(ostream, true);
          pwrite.println(fname);
          InputStream istream= s.getInputStream();
          Scanner cRead= new Scanner (new InputStreamReader(istream));
          while(cRead.hasNext())
             System.out.println(cRead.nextLine());
          pwrite.close();
          s.close();
       }
       catch(Exception e)
           { e.printStackTrace();}
     }
  }
}

import java.util.Scanner;
import java.net.*;
import java.io.*;
public class p9tcpserver
{
  public static void main(String args[]) throws IOException
  {
    ServerSocket ss=null;
    Socket s=null;
    try
    {
      ss=new ServerSocket(3000);
    }
    catch(Exception e)
    { e.printStackTrace();
       }
     while(true)
     {
       try
       {
         System.out.println("SERVER READY!!..");
         s=ss.accept();
         System.out.println("CLIENT CONNECTED..");
         InputStream istream = s.getInputStream();
         Scanner fread= new Scanner(new InputStreamReader(istream));
         String fileName= fread.nextLine();
         System.out.println("reading contents of "+fileName);
         Scanner contentRead= new Scanner(new FileReader(fileName));
         OutputStream ostream= s.getOutputStream();
         PrintWriter pwrite = new PrintWriter(ostream,true);
         String str;
         while(contentRead.hasNext())
            pwrite.println(contentRead.nextLine());
         pwrite.close();
         s.close();
       }
       catch(FileNotFoundException e1)
       {
          System.out.println("file not found");
          OutputStream ostream =s.getOutputStream();
          PrintWriter pwrite= new PrintWriter(ostream,true);
          pwrite.close();
       }
       catch(Exception e)
       {}
     }
   }
  }
