/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2_Beta;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
//feha methods (get_id_from_list/exist(eli tlawej si mdp w user mawjoudin fi locks)
public class CompteStaticMethods {
    
    
    public static void accountupdater(int i)
{       File file=new File ("IDCounter.txt");
    
     try {
        
      if (file.createNewFile()) {
        System.out.println("File created: " + file.getName());
      } else {
        System.out.println("File already exists.");
      }
}
     catch (IOException e1) {
      System.out.println("An error occurred.");
      e1.printStackTrace();
    }
     try{
      FileWriter myWriter =new FileWriter(file);
      myWriter.write(i+"\n");
      myWriter.close();
      System.out.println("Successfully wrote to the ID File.");
    } catch (IOException e) {
      System.out.println("An error occurred."); 
      e.printStackTrace();
    }
    
}
public static int accountcounter ()
{     File file=new File ("IDCounter.txt");
        int x=0;
   
    try {
      
      Scanner myReader = new Scanner(file);
      
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
            x=Integer.valueOf(data);
      }
    }catch (IOException e)
              { System.out.println("An error occurred."); 
      e.printStackTrace();}
    
    finally{
        
        return x;
           }
}
public static Compte GetAccountDetails(File myObj)
{ 
    Compte J=new Compte();
    try {
      
      Scanner myReader = new Scanner(myObj);
        String data = myReader.next();
        String data1[]=data.split(":");
        
        J.Name=data1[1];
        J.FName=data1[0];
        
        J.cin=data1[2];
        J.sold=Double.valueOf(data1[3]);
        J.Email=data1[4];
        J.sexe=data1[6];
        J.Date=data1[5];
        J.ID=Integer.valueOf(data1[7]);
        J.username=data1[8];
        J.password=data1[9];
      myReader.close();
    } catch (Exception e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 
    return J;
}
    public static boolean tests_inscription(String nom, String prenom, String email, String mdp, String confirmation, String genre, String tel, String dn) {
String msg = "";
        if (nom.equals("") || prenom.equals("") || email.equals("") || mdp.equals("") || confirmation.equals("") || genre.equals("") || tel.equals("") || dn.equals("")) {
            JOptionPane.showMessageDialog(null, "vous devez remplir tout les champs obligatoires", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!(tel.matches("^[259]{1}[0-9]{7}$")) || !(email.matches("^.+@[A-Za-z]{5,}\\.[A-Za-z]{2,}$") || !(mdp.equals(confirmation)))) {
            
            if (!(tel.matches("^[01]{1}[0-9]{7}$")))
                msg += "le numero de cin saisi est invalide\n";
            if (!(email.matches("^.+@[A-Za-z]{4,}\\.[A-Za-z]{2,}$")))
                msg += "l'email saisi est invalide\n";
            if (!(mdp.equals(confirmation)))    
                msg += "vous devez saisir le meme mot de passe pour lui confirmer";
            
            if (!msg.equals(""))
            JOptionPane.showMessageDialog(null, msg, "Erreur", JOptionPane.ERROR_MESSAGE);
            
        }
            return msg.equals("");
    }
        

    public static boolean tests_connexion(String email, String mdp) {

        if (email.equals("") || mdp.equals("")) {
            JOptionPane.showMessageDialog(null, "vous devez remplir tout les champs obligatoires", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!(email.matches("^.+@[A-Za-z]{5,}\\.[A-Za-z]{2,}$"))) {
            JOptionPane.showMessageDialog(null, "l'email saisi est invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        } else
            return true;
    }
}
