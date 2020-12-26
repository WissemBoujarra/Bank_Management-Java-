package tp2_Beta;



/**
 *
 * @author user
 */
public class Locks extends LocksStaticMethods {
    public String cin;
    public String username;
    public String password;
    public int id;
    
    public Locks (String C,String User,String Pass,int id)
          {this.username=User;
        this.password=Pass;
        this.cin=C;
          this.id=id;}
    
      public Locks()
    {
       
        cin="0";
    }
      public String tostring ()
{
return this.id+":"+this.username+":"+this.password+":"+this.cin;}

    
 
         
         }
