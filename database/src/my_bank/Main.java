/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2_Beta;
import java.sql.*;  
import java.util.ArrayList;
import javax.swing.JOptionPane;
class Main{  
    public static  Connection Connect(){
       Connection con=null;

        try{
         //step1 load the driver class  
Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","0123"); 
System.out.println("connected");
     }catch (Exception e){}
    return con;
    }
    
    public static Compte Search1 ()
    { int m=0;
Compte k=new Compte();
        try{  

  Connection con=Connect();
//step3 create the statement object  
Statement stmt=con.createStatement(); 
//step4 execute query  
ResultSet rs;

 rs=stmt.executeQuery("select * from Active" );  
  
 

if(rs.next()) 
{    m=rs.getInt(1);
 rs=stmt.executeQuery("select * from Compte where Compte_ID="+m );
 if(rs.next())
k=new Compte ( Double.valueOf(rs.getString(9)),rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(7),rs.getString(6),rs.getString(5),rs.getString(10),rs.getString(8)) ; 

System.out.println(k.tostringCompteList(k));
//step5 close the conn  ection object  
}
con.close();  
  
}catch(Exception e){ System.out.println(    e);}  
    return k;
}    
    
    
    
    public static ArrayList<Compte> Search (String alpha)
    {
        ArrayList<Compte> l=new ArrayList<Compte>();

        try{  
  Connection con=Connect();

  
//step3 create the statement object  
Statement stmt=con.createStatement(); 
//step4 execute query  
ResultSet rs=null;
 if (alpha=="all")
  rs=stmt.executeQuery("select * from Compte");
 else {
     
  rs=stmt.executeQuery("select * from Compte where (Compte_ID='"+alpha+
                               "' or cin='"+alpha+"' or username='"+alpha+
                               "' or Email='"+alpha+"' or Fname='"+alpha+"' or Rname='"+alpha+"' or Date_Naissance='"+alpha+"')");  
     
 }
Compte k;
while(rs.next())  
{k=new Compte ( Double.valueOf(rs.getString(9)),rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(7),rs.getString(6),rs.getString(5),rs.getString(10),rs.getString(8)) ; 
l.add(k);
System.out.println(k.tostringCompteList(k));
//step5 close the conn  ection object  
}
con.close();  
  
}catch(Exception e){ System.out.println(    e);}  
    return l;
}    
        
    
    public static void Add(Compte c)
    { try{  
  Connection con=Connect();

  String query="INSERT INTO Compte (COMPTE_ID,CIN,USERNAME,COMPTE_PASSWORD,EMAIL,FNAME,RNAME,DATE_NAISSANCE,SOLD,SEXE) "+ 
                    "VALUES ("
                     +c.ID+",'"+  c.cin+"','"+c.username+
                      "','"+c.password+"','"+c.Email+
                     "','"+c.FName+"','"+c.Name+"','"+
                      c.Date+"','"+Double.toString(c.sold)+"','"+c.sexe+"')";
//step3 create the statement object  
Statement st=con.createStatement();  
    st.executeUpdate(query);
    //  insert into COMPTE (COMPTE_ID,CIN,USERNAME,COMPTE_PASSWORD,EMAIL,FNAME,RNAME,DATE_NAISSANCE,SOLD,SEXE)
    // values   ()  
      con.close();  
  
}catch(Exception e){ System.out.println(    e);}  
    
}      
    
    public static void Update(Compte c)
    {  
         try{
             //step1 load the driver class  
  Connection con=Connect();

        String query = "SELECT * FROM Compte WHERE COMPTE_ID=?";
       PreparedStatement       pst = con.prepareStatement(query);
            pst.setInt(1, c.ID); 
             ResultSet rs = pst.executeQuery();
           
           
       
         if(rs.next()){
             System.out.println("lena");
         Statement     st = con.createStatement();
          String sql ="UPDATE Compte  "+
                    "Set "
                     +"COMPTE_ID="+c.ID+","+"CIN='"+  c.cin+"',USERNAME='"+c.username+
                      "',COMPTE_PASSWORD='"+c.password+"',EMAIL='"+c.Email+
                     "',FNAME='"+c.FName+"',RNAME='"+c.Name+"',DATE_NAISSANCE='"+
                      c.Date+"',SOLD='"+Double.toString(c.sold)+"',SEXE='"+c.sexe+"' WHERE Compte_ID="+c.ID;
             
          st.executeUpdate(sql);
           JOptionPane.showMessageDialog(null, "Updated With Sucess");
         }
         else {
             JOptionPane.showMessageDialog(null, "Not Founded");
         }
         }
         catch (Exception ex)
         {
              JOptionPane.showMessageDialog(null, ex);
         }
    }
     public static void Update1(Compte c)
    {  
         try{
             
         
             //step1 load the driver class  
  Connection con=Connect();

  
           
    
             System.out.println("lena");
         Statement     st = con.createStatement();
          String sql ="UPDATE Active  "+ 
                    "Set "
                     +"COMPTE_ID="+c.ID;
             
          st.executeUpdate(sql);
           JOptionPane.showMessageDialog(null, "Updated With Sucess");
         con.close();
       
         }
         catch (Exception ex)
         {
              JOptionPane.showMessageDialog(null, ex);
         }
         
     }
    public static void Delete(int c){
       try {
            Connection con=Connect();

             
              String query = "SELECT * FROM Compte WHERE Compte_ID=?";
        PreparedStatement      pst = con.prepareStatement(query);
            pst.setInt(1, c);
             ResultSet rs= pst.executeQuery();
           
           
       
         if(rs.next()){
           Statement   st = con.createStatement();
        String sql = "DELETE FROM Compte WHERE Compte_ID="+c;
        st.executeUpdate(sql);
        JOptionPane.showMessageDialog(null, "Deleted Scuccessfully");
       
       
        }
         else {
             JOptionPane.showMessageDialog(null, "Key Invalid");
         }
    }
  catch (Exception ex)
         {
              JOptionPane.showMessageDialog(null, ex);
         }
     }
public static void main(String args[]){ 
    Compte x=new Compte();
    x.ID=2;
   Update(x);
}  
}  