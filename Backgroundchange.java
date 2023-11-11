
package javaapplication58;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.event.*;
import javax.swing.ButtonGroup;

public class Backgroundchange extends JFrame implements ActionListener {
    
    JLabel l1,l2,l3;
    JTextArea area;
    JRadioButton b1,b2,b3,b4;
    ButtonGroup group1,group2;
    
    Backgroundchange(){
        l1 = new JLabel("Enter the text here");
        l1.setBounds(230,100,150,100);
        l1.setFont(new Font("TimesRoman",Font.BOLD,18));
        l2 = new JLabel("Background");
        l2.setBounds(100,375,150,100);        
        l3 = new JLabel("Foreground");
        l3.setBounds(100,420,150,100);
        
        Insets insets = new Insets(20,20,20,20);
        area = new JTextArea(100,100);
        area.setFont(new Font("TimesRoman",Font.PLAIN,18));
        area.setBounds(200,190,200,200);
        area.setMargin(insets);
        
        b1 = new JRadioButton("Red");
        b1.setBounds(200,415,100,20);
        b1.addActionListener(this);
        
        b2 = new JRadioButton("Blue");
        b2.setBounds(330,415,100,20);
        b2.addActionListener(this);

        b3 = new JRadioButton("Gray");
        b3.setBounds(200,465,100,20);
        b3.addActionListener(this);
        
        b4 = new JRadioButton("Green");
        b4.setBounds(330,465,100,20);
        b4.addActionListener(this);        
           
        group1 = new ButtonGroup();
        group1.add(b1); group1.add(b2);
        
        group2 = new ButtonGroup();
        group2.add(b3); group2.add(b4);
        
        add(l1);add(l2);add(l3);
        add(area);
        add(b1);add(b2);add(b3);add(b4);
 
        setLayout(null);
        setSize(600,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void handleButtonAction(Color bgColor, Color fgColor) {
        getContentPane().setBackground(bgColor);
        l1.setForeground(fgColor);
        l2.setForeground(fgColor);
        l3.setForeground(fgColor);
        b1.setForeground(fgColor);
        b2.setForeground(fgColor);
        b1.setBackground(bgColor);
        b2.setBackground(bgColor);
        b3.setBackground(bgColor);
        b4.setBackground(bgColor);
        b3.setForeground(fgColor);
        b4.setForeground(fgColor);
    }

    /**
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            handleButtonAction(Color.red, Color.white);
        }
        if(ae.getSource()==b2){
            handleButtonAction(Color.blue, Color.white);
        }
        if(ae.getSource()==b3){
            area.setBackground(Color.lightGray);
        }
        if(ae.getSource()==b4){
            area.setBackground(Color.green);
        }
    }
    public static void main(String[] args) {
        new Backgroundchange();
    }
}
