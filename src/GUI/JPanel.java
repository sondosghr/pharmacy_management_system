package GUI;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;




public class JPanel extends javax.swing.JPanel{

    private static final long seriaLVersionUID =1L;

    public JPanel(LayoutManager l, int top,int left,int bottom,int right ){
        super(l);
        setBackground(null);
        setBorder(BorderFactory.createEmptyBorder(top,left,bottom,right));

    }


}