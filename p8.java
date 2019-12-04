import java.util.Scanner;
public class p8
{
  private int d[];
  private int num_ver;
  public static final int max_value=999;
  public p8(int num_ver)
  {
    this.num_ver=num_ver;
    d=new int [num_ver+1];
  }
  public void bellmanfordevaluation(int source,int a[][])
  {
    for(int node=1; node<=num_ver; node++)
    {
      d[node]=max_value;
    }
     d[source]=0;
     for(int node=1; node<=num_ver-1; node++)
     {
      for(int sn=1;sn<=num_ver;sn++)
      {
       for(int dn=1;dn<=num_ver;dn++)
        {
          if(a[sn][dn]!=max_value)
           {
             if(d[dn]>d[sn]+a[sn][dn])
               d[dn]=d[sn]+a[sn][dn];
           }
        }
      }
     }
    for(int sn=1;sn<=num_ver;sn++)
    {
      for(int dn=1;dn<=num_ver;dn++)
        {
          if(a[sn][dn]!=max_value)
            {  if(d[dn]>d[sn]+a[sn][dn])
                 System.out.println("the graph contains -ve edge cycle");
            }
        }
    }
    for(int vertex=1;vertex<=num_ver;vertex++)
     {
        System.out.println("disten of source"+source+"to"+vertex+"is"+d[vertex]);
     }
  }
  public static void main(String args[])
   {
     int num_ver=0;
     int source;
     Scanner scanner=new Scanner(System.in);
     System.out.println("enter the num of vertices");
     num_ver=scanner.nextInt();
     int a[][]=new int [num_ver+1] [num_ver+1];
     System.out.println("enter the adjacency matrix:");
     for(int sn=1;sn<=num_ver;sn++)
      {
        for(int dn=1;dn<=num_ver;dn++)
         {   a[sn][dn]=scanner.nextInt();
             if(sn==dn)
             {  a[sn][dn]=1;
                continue; 
             }
            if(a[sn][dn]==0)
           {
             a[sn][dn]=max_value;
           }
         }
      }
   System.out.println("enter the source vertex");
   source=scanner.nextInt();
   p8 b=new p8(num_ver);
   b.bellmanfordevaluation(source,a);
   scanner.close();
  }
 }
