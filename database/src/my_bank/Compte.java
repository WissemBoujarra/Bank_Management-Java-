package tp2_Beta;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 

public class Compte extends CompteStaticMethods  {
    public int i=Compte.accountcounter();
    public double sold;
    public String cin;
    public String username;
    public String password;
    public String Name;
    public String Email;
    public String FName;
    public String Date;
    public String sexe;
    public int ID;
   
    

    /**
     *
     * @param S
     * @param C
     * @param User
     * @param Pass
     * @param Name
     * @param FName
     */
    public Compte (int id,String cin)
    {
        this.ID=id;
        this.cin=cin;
    }
        public Compte (double S,String C,String User,String Pass,String Name,String FName,String email,String sex,String date)
    {   this.Name=Name;
        this.FName=FName;
        this.username=User;
        this.password=Pass;
    this.sold=S;
    this.cin=C;
    this.sexe=sex;
    this.Email=email;
    this.Date =date ;
    this.ID=i;
    
    }
         public Compte (double k,int S,String C,String User,String Pass,String Name,String FName,String email,String sex,String date)
    {   this.Name=Name;
        this.FName=FName;
        this.username=User;
        this.password=Pass;
    this.sold=k;
    this.cin=C;
    this.sexe=sex;
    this.Email=email;
    this.Date =date ;
    this.ID=S;
    
    }
          public Compte (double S,String C,String User,String Pass)
          {this.username=User;
        this.password=Pass;
        this.sold=S;
        this.cin=C;
          this.ID=i;
          
    }
   
    public Compte ()
    {
      
    }
 
    
  public void ajouter ( double k) {
  String Totype_inHostory="Current_sold="+sold;
     UpdateFileHistory(this,Totype_inHostory);
  sold=sold+k;
 Totype_inHostory="afterAdding_sold="+sold;
  UpdateFileHistory(this,Totype_inHostory);
  Totype_inHostory="-------------------------";
    UpdateFileHistory(this,Totype_inHostory);
  Main.Update(this);

  }
        public void retirer ( double k) throws CompteException {
       String Totype_inHostory="Current_sold="+sold;
     UpdateFileHistory(this,Totype_inHostory);
 
     if (sold<k) throw (new CompteException());
  sold=sold-k;
 
    Main.Update(this);
 Totype_inHostory="afterRetiring_sold="+sold;
  UpdateFileHistory(this,Totype_inHostory);
  Totype_inHostory="-------------------------";
    UpdateFileHistory(this,Totype_inHostory);
 
        }
    
    public void virer (double k, Compte c)throws CompteException{
            String Totype_inHostory="Current_sold="+sold;
         UpdateFileHistory(this,Totype_inHostory);
          Totype_inHostory="-------------------------";
            UpdateFileHistory(this,Totype_inHostory);
           if (this.sold<k) throw (new CompteException());
            this.sold=this.sold-k;
               Main.Update(this);
 Totype_inHostory="afterSending_sold="+sold+" to "+c.ID;
            UpdateFileHistory(this,Totype_inHostory);
            Totype_inHostory="-------------------------";
            UpdateFileHistory(this,Totype_inHostory);
              Totype_inHostory="Current_sold="+c.sold;
               UpdateFileHistory(c,Totype_inHostory);
           
              c.sold=c.sold+k;
              Main.Update(c);
 Totype_inHostory="Received sold="+sold+" from "+this.ID ;
             UpdateFileHistory(c,Totype_inHostory);
            Totype_inHostory="New Sold="+c.sold;
            UpdateFileHistory(c,Totype_inHostory);


             Totype_inHostory="-------------------------";
             UpdateFileHistory(c,Totype_inHostory);
           
  

        
    }
   
 

public String tostringCompteList (Compte c)
{
return c.username+":"+c.password+":"+c.Name+":"+c.FName+":"+c.cin+":"+c.sold;
}
public String tostring_username_and_password ()
{
return this.ID+":"+this.cin+":"+this.username+":"+this.password;
}
public String tostring_name_and_fname_and_cin_and_sold ()
{
    return this.Name+":"+this.FName+":"+this.cin+":"+this.sold+":"+this.Email+":"+this.Date+":"+this.sexe+":"+this.ID+":"+this.username+":"+this.password;
}


  public int VerifyExistingClient(ArrayList<Compte> AccountList, int cin)
{
int v=0;
 try {
     for (int i=0; i<AccountList.size();i++)
     { 
     if (AccountList.get(i).cin.equals(cin)) {
        v=1; }

     }
 } catch (Exception  e)
             { v=0;}
     return v;
}
  public  static void FileWriterInAccountList(Compte c,File file)
{   try {
    FileWriter myWriter =new FileWriter(file,true);
    
      myWriter.write(c.tostring_username_and_password()+"\n");
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred."); 
      e.printStackTrace();
    }
}
public static  void FileWriterAccount_Detials(Compte c,File file)
{   try {
    FileWriter myWriter =new FileWriter(file);
    
      myWriter.write(c.tostring_name_and_fname_and_cin_and_sold()+"\n");
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred."); 
      e.printStackTrace();
    }
}

public void CreateAccount(Compte c)
{  

i++; 
accountupdater(i);

}



public void UpdateFileHistory(Compte c,String value_SoldChanged)
{    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
   LocalDateTime now = LocalDateTime.now();  
  String filepath=Path_Getter.Get_Clients_Path();

   File Directory0= new File(filepath);

    if (Directory0.mkdirs()) {
        System.out.println("Directory created successfully");
    }
    else{
        System.out.println("Sorry couldnt create specified directory");
    }

  filepath=filepath+"\\"+c.cin;
        File Directory= new File(filepath);

    if (Directory.mkdirs()) {
        System.out.println("Directory created successfully");
    }
    else{
        System.out.println("Sorry couldnt create specified directory");
    }
     filepath=filepath+"\\"+c.ID;  
      Directory0= new File(filepath);

    if (Directory0.mkdirs()) {
        System.out.println("Directory created successfully");
    }
    else{
        System.out.println("Sorry couldnt create specified directory");
    }
   File Myobject=new File(Path_Getter.Get_One_ClientOrOneAccount_Path()+c.cin+"\\"+c.ID+"\\History.txt");
   
     try{
     if (!Myobject.exists()) Myobject.createNewFile();}
    catch (IOException e) {}
        FileWriterAccount_History(c,Myobject,dtf.format(now)+value_SoldChanged);
    
    
}
public void FileWriterAccount_History(Compte c,File file,String Value_SoldChanged)
{   try {
    FileWriter myWriter =new FileWriter(file,true);
    
      myWriter.write(Value_SoldChanged+"\n");
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred."); 
      e.printStackTrace();
    }
}


public static Compte creation () {
   


   
    return Main.Search1();
}
public static ArrayList<Compte> GetDetails ()
{  
    
    
    
   return Main.Search("all");
   
}

 public static int verifier_existance(String email) {
        int nb = 1;
        
 ArrayList<Compte> list=Compte.GetDetails();
 for (Compte k:list)
 {
     if (k.Email.equals(email)) {nb=0; break;}
     
     
     
 }
        
    return  nb;    
 }
 

}
