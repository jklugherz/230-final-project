/************************************************************************
  * MotivatePanel.java
  * Panel that uses tree, displays motivational quote. 
  * Sara Vannah, Julia Klugherz, Andjela Stojkovic
  * 
  * Main Contributor: Julia 
  * Edits by: Andjela
  ************************************************************************/

import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MotivatePanel extends JPanel {
  private JLabel intro, middle, quoteLabel;
  private String question, quote;
  private JButton yes, no, reset;
  private Quotes quoteTree;
  private int questionCount;
  
  //constructor takes in driver frame and next panel
  public MotivatePanel(Quotes quoteTree){
    this.quoteTree = quoteTree;
    questionCount = 1; 
    
    setLayout(new BorderLayout());
    Font font1 = new Font("Crystal", Font.PLAIN, 15);
    Font font2 = new Font("Impact", Font.PLAIN, 20);
   
    //label which prompts user to answer questions
    String q = "Answer these questions [YES/NO] to get your personalized motivational quote!";
    intro = new JLabel(q, JLabel.CENTER);
    add(intro, BorderLayout.NORTH);
    intro.setFont(font2);
    
    //middle panel will be grid layout so question is in center
    JPanel middlePanel = new JPanel();
    middlePanel.setBackground(new Color(176, 205, 252));
    middlePanel.setLayout (new GridLayout (3, 1)); 
    middlePanel.add(new JLabel(" ", JLabel.CENTER)); //add empty label
    
    //panel where questions are asked
    JPanel questionPanel = new JPanel();
    question = quoteTree.getRootQuestion(); //set first question to root question!
    questionPanel.setBackground(new Color(176, 205, 252));
    middle = new JLabel(question, JLabel.CENTER);
    middle.setFont(font1);
    questionPanel.add(middle);
    
    //buttons for the question panel
    yes = new JButton("Yes");
    no = new JButton("No");
    reset = new JButton("Reset");
    questionPanel.add(yes);
    questionPanel.add(no);
    questionPanel.add(reset);
    
    //add questions to the middle panel
    middlePanel.add(questionPanel);
    add(middlePanel, BorderLayout.CENTER);
    
    //add action listeners for yes & no buttons
    ButtonListener a1 = new ButtonListener();
    yes.addActionListener(a1);
    no.addActionListener(a1);
    reset.addActionListener(a1);
    
    //panel to show the quote after quesetions are answered
    quote = " ";
    JPanel quotePanel = new JPanel();
    quoteLabel = new JLabel(quote, JLabel.CENTER);
    quoteLabel.setFont(new Font("Crystal", Font.PLAIN, 25));
    quotePanel.add(quoteLabel);
    quotePanel.setBackground(new Color(255, 237, 165));
    add(quotePanel, BorderLayout.SOUTH);

    setBackground(new Color(176, 205, 252));
  }
  
  
  
  private class ButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event) {
      //if button pressed was yes
      if (event.getSource() == yes) {
        String newText = quoteTree.getLeftString(); //gets left String
        if (questionCount == 3) { //if count is 3, string is the quote
          middle.setText(" "); //clear questions label
          quoteLabel.setText(newText); //set quote
        }
        else { //if count is not 3, string is a question
          middle.setText(newText); 
          questionCount++;
        }
      }
      else if (event.getSource() == no) {
        String newText = quoteTree.getRightString(); //gets right String
        if (questionCount == 3) {
          middle.setText(" ");
          quoteLabel.setText(newText);
        }
        else {
          middle.setText(newText);
          questionCount++;
        }
      }
      else if (event.getSource() == reset) { 
        quoteLabel.setText(" "); //resets quote
        quoteTree.resetTree(); //resets tree
        String newText = quoteTree.getRootQuestion(); //resets the root question
        middle.setText(newText);
        questionCount = 1; //resets questionCount
      }
    }
  }
}
