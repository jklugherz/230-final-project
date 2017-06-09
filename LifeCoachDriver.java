/************************************************************************
  * LifeCoachDriver.java
  * Driver class for our project. 
  * Sara Vannah, Julia Klugherz, Andjela Stojkovic
  * 
  * Main Contributors: Everyone
  ************************************************************************/

import javax.swing.*;

public class LifeCoachDriver
{
  //-----------------------------------------------------------------
  //  Creates and displays the main program frame.
  //-----------------------------------------------------------------
  public static void main (String[] args)
  {
    JFrame frame = new JFrame ("My Very Own GUI Life Coach"); // Create JFrame for overall structure of GUI
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); // Close GUI upon pressing x
    
    ToDoList list = new ToDoList();
    Quotes tree = new Quotes();
    
    /*
    //sample Task object
    //format for Task object is (String name, int timeItTakes, int dueDate, int priorityFactor)
    Task testTask1 = new Task("Make bed", 1, 1, 2);
    Task testTask2 = new Task("Study for physics", 5, 3, 2);
    Task testTask3 = new Task("Meet boiis", 1, 1, 3);
    list.addTask(testTask1);
    list.addTask(testTask2);
    list.addTask(testTask3);
    */
    
    
    JTabbedPane tp = new JTabbedPane();
    tp.addTab("Welcome!", new WelcomePanel());
    tp.addTab("Add task", new InputTasks(list));
    tp.addTab("Schedule", new SchedulePanel(list));
    tp.addTab("Motivation", new MotivatePanel(tree));
    
    
    frame.getContentPane().add(tp);

    frame.pack();
    frame.setVisible(true);
  }
}
