/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2_Beta;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class CompteException extends Exception {
    public CompteException(){
        super();
           JFrame H=new JFrame();  
 JOptionPane.showMessageDialog(H,"Sold Insuffisant","Alert",JOptionPane.WARNING_MESSAGE);      }
    
}
