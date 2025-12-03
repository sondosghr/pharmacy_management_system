package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComponent;

public class JFrame  extends javax.swing.JFrame{
    private static final long seriaLVersionUID =1L;


    public JFrame(int w, int l , JComponent p ){
        super("pharmacy Management System");
        setSize(625, 350);
        getContentPane().setBackground( new Color(0,50,140));
        getContentPane().setLayout(new BorderLayout(20,20));
        setLocation(p);

    }

    private void setLocation(JComponent p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}