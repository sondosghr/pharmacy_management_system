package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;


public class JButton extends javax.swing.JButton{
    private static final long seriaLVersionUID =1L;
    private Object setBorderFactory;

    public JButton( String text ,int size){
        super(text);
        setForeground(new Color(0,50,140));
        setBackground(new Color(255,217,15));
        setOpaque(true);
        setBorderFactory.createEmptyBorder(10,10,10,10);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setFont(new Font("Tahoma",Font.BOLD,size));
        setHorizontalAlignment(JLabel.CENTER);

    }




}