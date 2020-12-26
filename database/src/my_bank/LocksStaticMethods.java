/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2_Beta;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rupu
 */
public class LocksStaticMethods {
    public static int exist(ArrayList<Compte> k,String u,String p)
 {  int v=0;
 try {
     for (int i=0; i<k.size();i++)
     { 
     if ((k.get(i).username.equals(u)) && (k.get(i).password.equals(p)) ){
        v=1; break;}

     }
 } catch (Exception  e)
             { v=0;}
     return v;
}
    public static int Get_Position_From_List(ArrayList<Compte> k,String u,String p)
{ int c=-1;
 try {
     for (int i=0;i<k.size();i++)
     { 
     if (k.get(i).username.toLowerCase().equals(u.toLowerCase())==true) {
         if (  k.get(i).password.toLowerCase().equals(p.toLowerCase())==true) 
         c=i;}

 }
 } catch (Exception  e)
             {   }//add later
     return c;
    
}
    public static Compte Locks_Getter_From_ID(ArrayList<Compte> l,int id1)
    {  int k=0;
       

     for (k=0; k<l.size();k++)
     { 
     if (l.get(k).ID==id1)
     {
        break;}

     }
     return l.get(k);
    }
    public static ArrayList<Compte> Lockslist(File myObj)
{ 
    ArrayList<Compte> List=new ArrayList<Compte>();
    Compte J;
     try {
      
      Scanner myReader = new Scanner(myObj);
      int i=0;
      try{
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        J=new Compte();
        String data1[]=data.split(":");
        for (String k:data1)
        
        J.username=data1[2];
        J.password=data1[3];
        J.ID=Integer.valueOf(data1[0]);
        J.cin=data1[1];
        List.add(J);
   
       i++;
      }}
      catch (Exception e){}
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred...");
      e.printStackTrace();
    } 
        return List;
    
}
   
 public static Compte Get_AccountOnline_From_LocksFIle(File Object)
 { 
     Compte K=new Compte();
     try {Scanner MyReader=new Scanner(Object);
        String data = MyReader.next();
        Locks J=new Locks();
        String data1[]=data.split(":");
        J.cin=data1[3];
        J.id=Integer.valueOf(data1[0]);
        
     File Account=new File(Path_Getter.path_finder(J.cin,Integer.valueOf(J.id))+"\\Details.txt");
        
     K=Compte.GetAccountDetails(Account);
     } catch (FileNotFoundException e) {
      System.out.println("An error occurred...");
      e.printStackTrace();
            
    }
     return K;
 }
 public static ArrayList<Compte> Get_AllAccounts_From_LocksFIle(File Object)
 {   ArrayList<Compte> l=new ArrayList<Compte>();
     Compte n;
     Locks J;
     try {Scanner MyReader=new Scanner(Object);
     while (MyReader.hasNext())
     {  n= new Compte();
         String data = MyReader.next();
         J=new Locks();
        String data1[]=data.split(":");
     J.id=Integer.valueOf(data1[0]);
        J.cin=data1[1];
     File Account=new File(Path_Getter.path_finder(J.cin, J.id)+"\\Details.txt");
     n=Compte.GetAccountDetails(Account);
     l.add(n);
     }
     } catch (FileNotFoundException e) {
      System.out.println("An error occurred...");
      e.printStackTrace();
            
    }
     return l;
 }
}
