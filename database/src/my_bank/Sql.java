package tp2_Beta;
import java.sql.*;
class Sql {
public static Connection connect(String url)
{
    Connection con=null;
    try
    {
    Class.forName("oracle.jdbc.Driver.OracleDriver");
        con=DriverManager.getConnection(url);
        
    }  
        catch(Exception e){}
    
    
    
    return con;
}
public static void Update(Compte c)
{ try {
    Connection con=connect("url");
    PreparedStatement pst=con.prepareStatement("SELECT * FROM Compte WHERE COMPTE_ID=?");
    pst.setInt(1, c.ID);
    ResultSet rs=pst.executeQuery();
    
   if (rs.next()) 
   {
      Statement st=con.createStatement();
       st.executeUpdate("Update Compte set Compte_id="+c.ID+ "where COmpte_ID="+c.ID+";");
   } 
       
       
       
       
   }
 catch(SQLException e){}
}
public static void Delete(Compte c)
{ try {
    Connection con=connect("url");
    PreparedStatement pst=con.prepareStatement("SELECT * FROM Compte WHERE COMPTE_ID=?");
    pst.setInt(1, c.ID);
    ResultSet rs=pst.executeQuery();
    
   if (rs.next()) 
   {
      Statement st=con.createStatement();
       st.executeUpdate("Delete from Compte where COmpte_ID="+c.ID+";");
   } 
       
       
       
       
   }
 catch(SQLException e){}
}





}