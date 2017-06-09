/************************************************************************
  * SchedulePanel.java
  * Panel that holds the schedule
  * Sara Vannah, Julia Klugherz, Andjela Stojkovic
  * 
  * Main Contributor: Sara
  * Edits by: Julia and Andjela
  ************************************************************************/

import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SchedulePanel extends JPanel{
  private JTextField task;
  private JPanel firstTaskPanel, remainTasksPanel;
  private JButton getSched;
  private JLabel t, taskLabel;
  private String firstTask;
  private ToDoList list;
  
  public SchedulePanel(ToDoList list){
    this.list = list;
    
    //first task on to-do list
    firstTask = list.getFirstTask(); //accounts for a pre-existing list
    Font font1 = new Font("Crystal", Font.BOLD, 15);
    setLayout (new BorderLayout());
    
    //intro panel with button
    JPanel introPanel = new JPanel();
    getSched = new JButton("Click to get your schedule");
    introPanel.add(getSched);
    introPanel.setBackground(new Color(176, 205, 252)); //sets background to yellow
    add(introPanel, BorderLayout.NORTH);
    
    //add button listener to getSched
    ButtonListener a1 = new ButtonListener();
    getSched.addActionListener(a1);
    
    //create panel to hold the tasks
    JPanel allTasksPanel = new JPanel();
    allTasksPanel.setBackground(new Color(255, 237, 165));
    allTasksPanel.setLayout (new BoxLayout (allTasksPanel, BoxLayout.Y_AXIS));
    
    //panel that holds the first task
    firstTaskPanel = new JPanel();
    String topLabel = "We suggest you start with this task:\n"+firstTask;
    t = new JLabel(topLabel);
    t.setFont(font1);
    firstTaskPanel.add(t);
    firstTaskPanel.setBackground(new Color(255, 237, 165));
    allTasksPanel.add(firstTaskPanel);
    
    //panel that holds the remaining tasks
    remainTasksPanel = new JPanel();
    String botLabel = "<html>Here are your remaining tasks: <br>"+ list.getNextTasks()+"</html>";
    taskLabel = new JLabel(botLabel);
    taskLabel.setFont(font1);
    remainTasksPanel.add(taskLabel);
    remainTasksPanel.setBackground(new Color(255, 237, 165)); //sets background to light blue
    allTasksPanel.add(remainTasksPanel);
    
    add(allTasksPanel, BorderLayout.CENTER);
    
  }
  
  private class ButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event){
      if (event.getSource() == getSched) { //update schedule
        t.setText("We suggest you start with this task:\n"+list.getFirstTask());
        taskLabel.setText("<html>Here are your remaining tasks: <br>"+ list.getNextTasks()+"</html>");
      }
    }
  }
  
}