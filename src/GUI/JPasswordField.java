package GUI;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author dell
 */
public class JPasswordField extends javax.swing.JPasswordField{

    private static final long seriaLVersionUID =1L;
    public JPasswordField( int size ){
        super() ;
        setForeground( new Color(0,50,140));
        setFont(new Font("Tahoma",Font.BOLD,size));
        setHorizontalAlignment(JLabel.CENTER);
    }
/*
     public void setHorizontalAlignment(int CENTER) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
*/


}