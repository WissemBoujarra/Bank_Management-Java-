/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2_Beta;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author rupu
 */
public class Path_Getter {
    public static String Get_Clients_Path()
    {
    return System.getProperty("user.dir")+"\\Clients";
    }
    public static String Get_Active_Account_path()
    {
        return System.getProperty("user.dir")+"\\Compte_Online.txt";
    }
    public static String Get_One_ClientOrOneAccount_Path()
    {
        return System.getProperty("user.dir")+"\\Clients\\";
    }
    public static String Get_All_Accounts_Path()
    {
        return System.getProperty("user.dir")+"\\Compte.txt";
    }
     public static  String path_finder (String Cin,int ID)
 {
     return Path_Getter.Get_One_ClientOrOneAccount_Path()+Cin+"\\"+ID+"\\";
 }
     public static String Path_Editer()
     {
      File file1=new File(Path_Getter.Get_Clients_Path()+"\\editer.txt");
     String filecontent="";
    try {
      Scanner myReader = new Scanner(file1);
     
      filecontent=myReader.next();
    
      
    }catch (IOException e)
              { System.out.println("An error occurred."); 
}
    return filecontent;
     }
     
     public static String get_lock_pic() {
         return "C:\\Users\\user\\Desktop\\testihm1\\Webp.net-resizeimage (2)";
     }
     public static String get_pass_pic() {
         return "C:\\Users\\user\\Desktop\\testihm1\\Webp.net-resizeimage (3)";
     }
     public static String get_money_pic() {
         return "C:\\Users\\user\\Desktop\\testihm1\\Webp.net-resizeimage (8)";
     }
     public static String get_return_pic() {
         return "C:\\Users\\user\\Desktop\\testihm1\\Webp.net-resizeimage (4)";
     }
     
    }
    

