import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*; 
class text extends JFrame implements ActionListener { 
  
    static JFrame f;  
    static JButton b;  
    static JLabel l; 
    static JTextArea jt1,jt2,jt3;  
    text() 
    { 
    } 
    public static void main(String[] args) 
    {  
        f = new JFrame("textfield");  
        
        l = new JLabel("nothing entered"); 
        
        b = new JButton("merge");  
        
        text te = new text();  
        
        b.addActionListener(te);  
        
        jt1 = new JTextArea(10, 10);
        jt2 = new JTextArea(10, 10);
        jt3 = new JTextArea(10, 10);
   
        JPanel p = new JPanel(); 
   
        p.add(jt1);
        p.add(jt2);
        p.add(jt3);
        p.add(b); 
        p.add(l); 
  
        f.add(p); 
         
        f.setSize(100, 100); 
  
        f.show(); 
    } 
  
   
    public void actionPerformed(ActionEvent e) 
    { 
        String s = e.getActionCommand(); 
        if (s.equals("merge")) { 
             
            jt3.setText((jt1.getText()).concat(jt2.getText())); 
        } 
    } 
} 
