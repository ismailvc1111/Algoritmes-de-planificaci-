import java.util.*;
 
public class SRTF {
public static void main (String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println ("Introdice el proceso");
int n= sc.nextInt();
int pid[] = new int[n]; 
int at[] = new int[n]; 
int bt[] = new int[n]; 
int ct[] = new int[n]; 
int ta[] = new int[n];
int wt[] = new int[n];  
int f[] = new int[n];  
int k[]= new int[n];   
    int i, st=0, tot=0;
    float avgwt=0, avgta=0;
 
    for (i=0;i<n;i++)
    {
     pid[i]= i+1;
     System.out.println ("introduce " +(i+1)+ " el tiempo de llegada:");
     at[i]= sc.nextInt();
     System.out.println("introduce " +(i+1)+ " tiempo de rafagada:");
     bt[i]= sc.nextInt();
     k[i]= bt[i];
     f[i]= 0;
    }
    
    while(true){
     int min=99,c=n;
     if (tot==n)
     break;
    
     for ( i=0;i<n;i++)
     {
     if ((at[i]<=st) && (f[i]==0) && (bt[i]<min))
     {
     min=bt[i];
     c=i;
     }
     }
    
     if (c==n)
     st++;
     else
     {
     bt[c]--;
     st++;
     if (bt[c]==0)
     {
     ct[c]= st;
     f[c]=1;
     tot++;
     }
     }
    }
    
    for(i=0;i<n;i++)
    {
     ta[i] = ct[i] - at[i];
     wt[i] = ta[i] - k[i];
     avgwt+= wt[i];
     avgta+= ta[i];
    }
    
    System.out.println("Esperando el turno");
    for(i=0;i<n;i++)
    {
     System.out.println(pid[i] +"\t"+ at[i]+"\t"+ k[i] +"\t"+ ct[i] +"\t"+ ta[i] +"\t"+ wt[i]);
    }
    
    System.out.println("\n el promedio es  "+ (float)(avgta/n));
    System.out.println(" la media de espera es  "+ (float)(avgwt/n));
    sc.close();
}
}