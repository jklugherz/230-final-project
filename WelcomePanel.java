/************************************************************************
  * WelcomePanel.java
  * Represents the first panel of our GUI.
  * Sara Vannah, Julia Klugherz, Andjela Stojkovic
  * 
  * Main Contributor: Andjela
  * Edits by: Julia
  ************************************************************************/


import java.awt.*;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class WelcomePanel extends JPanel {
  private JLabel welcome;
  private JLabel next;
  private JLabel instructions;
  
  public WelcomePanel() {
    setLayout(new BorderLayout());
    Font font1 = new Font("Impact", Font.PLAIN, 50);
    Font font2 = new Font("Impact", Font.PLAIN, 30);
    
    //welcome label
    String s = "Welcome to My Very Own GUI Life Coach!\n";
    welcome = new JLabel(s, JLabel.CENTER);
    add(welcome, BorderLayout.NORTH);
    welcome.setFont(font1);
    
    //doge
    JLabel picLabel = new JLabel(new ImageIcon("doge.jpg"));
    add(picLabel, BorderLayout.CENTER);
    
    //instructions
    String i = "Click the \"Add task\" tab to get planning!";
    instructions = new JLabel(i, JLabel.CENTER);
    instructions.setFont(font2);
    add(instructions, BorderLayout.SOUTH);
    
    setBackground(new Color(176, 205, 252));

  }

}
