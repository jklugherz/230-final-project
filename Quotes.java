/***********************************************************************
  * Quotes.java
  * Represents the decision tree that holds the motivational quotes.
  * Julia Klugherz, Andjela Stojkovic, Sara Vannah
  * 
  * Main Contributor: Andjela
  * Edits by: Julia and Sara
  *****************************************************************/

import javafoundations.*; 
import java.util.Scanner; 

public class Quotes { 
  
  private LinkedBinaryTree<String> tree; 
  private String question;
  LinkedBinaryTree<String> n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15;
  String e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15;
  
//-----------------------------------------------------------------  
// Sets up the question tree. 
//----------------------------------------------------------------- 
  public Quotes() {
    
    e1 = "Are you feeling good today?"; 
    e2 = "Are you excited to take on tasks in your schedule?"; //no from e1
    e3 = "Have you been feeling down in the dumps lately?"; //yes from e1
    e4 = "Are you planning free time in your schedule?"; //no from e2
    e5 = "Do you have a lot to do?"; //yes from e2
    e6 = "Is it the weekend?"; //no from e3
    e7 = "Have you treated yourself lately?"; //yes from e3
    e8 = "Your only limit is you."; //no from e4
    e9 = "Do something today your future self will thank you for."; //yes from e4
    e10 = "Organization is the foundation to get the rest of your life in gear."; // no from e5
    e11 = "You will never have this day again, so make it count."; // yes from e5
    e12 = "Carpe that diem!"; //no from e6
    e13 = "Don't watch the clock; do what it does. Keep going."; //yes from e6
    e14 = "Take a step back, evaluate what's important, and enjoy life."; //no from e7
    e15 = "Treat yoself."; //yes from e7
    
    n14 = new LinkedBinaryTree<String>(e14);
    n15 = new LinkedBinaryTree<String>(e15);
    n8 = new LinkedBinaryTree<String>(e8); 
    n9 = new LinkedBinaryTree<String>(e9); 
    n4 = new LinkedBinaryTree<String>(e4, n8, n9); 
    n10 = new LinkedBinaryTree<String>(e10); 
    n11 = new LinkedBinaryTree<String>(e11); 
    n5 = new LinkedBinaryTree<String>(e5, n10, n11);
    n12 = new LinkedBinaryTree<String>(e12); 
    n13 = new LinkedBinaryTree<String>(e13); 
    n6 = new LinkedBinaryTree<String>(e6, n12, n13); 
    n7 = new LinkedBinaryTree<String>(e7, n14, n15); 
    n2 = new LinkedBinaryTree<String>(e2, n4, n5); 
    n3 = new LinkedBinaryTree<String>(e3, n6, n7); 
    tree = new LinkedBinaryTree<String>(e1, n2, n3); //(string, L child, R child)
  }
  
//----------------------------------------------------------------- 
// Gets the string of the right tree, resets the tree
//----------------------------------------------------------------- 
  public String getRightString() {
    LinkedBinaryTree<String> current = tree;
    int size = current.size();
    String s = "";
    if (current.size() > 1) {
      current = current.getRight();
      s = current.getRootElement();
    } 
    tree = current;
    return s;
  }
  
  
//----------------------------------------------------------------- 
// Gets the string of the left tree, resets the tree
//----------------------------------------------------------------- 
  public String getLeftString() {
    LinkedBinaryTree<String> current = tree;
    int size = current.size();
    String s = "";
    if (current.size() > 1) {
      current = current.getLeft();
      s = current.getRootElement();
    } 
    tree = current;
    return s;
  }
    
  
//----------------------------------------------------------------- 
// Gets the root element of the tree
//----------------------------------------------------------------- 
  public String getRootQuestion() {
    return tree.getRootElement();
  }
  
  
//----------------------------------------------------------------- 
// Resets the tree to the first element
//----------------------------------------------------------------- 
  public void resetTree() {
    tree = new LinkedBinaryTree<String>(e1, n2, n3); 
  }
      
  
  /*
//----------------------------------------------------------------- 
// Follows the quotes tree based on user responses. 
//----------------------------------------------------------------- 
  
  public void feeling() { 
    
    Scanner scan = new Scanner(System.in); 
    LinkedBinaryTree<String> current = tree; 
    System.out.println ("Heard you need some motivation :)"); 
    while (current.size() > 1) { 
      System.out.println (current.getRootElement()); 
      
      if (scan.nextLine().equalsIgnoreCase("YES")) 
        current = current.getLeft(); 
      
      else current = current.getRight(); 
    } 
    System.out.println (current.getRootElement()); 
  }
  */
  
  
  public static void main (String[] args) { 
    /*
    Quotes quote = new Quotes(); 
    System.out.println(quote.getRootQuestion()); 
    System.out.println(quote.getRightString());
    System.out.println(quote.getRightString());
    */
    
  } 
}
    
    