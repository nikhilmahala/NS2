import java.util.Scanner;
public class p12
{
public static void main(String[] args) throws InterruptedException
{
Scanner in=new Scanner(System.in);
int n,incoming,outgoing,bs,s=0;
System.out.println("enter the bs,outgoing rate,inputs,incoming size");
bs=in.nextInt();
outgoing=in.nextInt();
n=in.nextInt();
incoming=in.nextInt();
while(n!=0)
{
System.out.println("incoming size is"+incoming);
if(incoming<=(bs-s))
{
s+=incoming;
System.out.println("bucket buffer size is"+s+"out of"+bs);
}
else
{
System.out.println("packet lost="+(incoming-(bs-s)));
s=bs;
System.out.println("bucket buffersize is"+s+"out of"+bs);
}
s-=outgoing;
System.out.println("after outgoing="+s+"packet left out of"+bs+"in buffer");
n--;
Thread.sleep(3000);
}
in.close();
}
}
