/************************************************************************
  * InputTasks.java
  * GUI Panel where the user can input tasks
  * Sara Vannah, Julia Klugherz, Andjela Stojkovic
  * 
  * Main Contributors: Julia and Andjela
  ************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class InputTasks extends JPanel {
  private ToDoList list;
  private JPanel text, questions; 
  private JButton addTask;
  private JTextField name;
  private JSlider timeItTakes;
  private JComboBox dueDate, priorityFactor; 

  
  public InputTasks(ToDoList list) {
    this.list = list;
    
    //set layout of entire panel and define fonts that are used
    setLayout (new BorderLayout());
    Font font1 = new Font("Crystal", Font.PLAIN, 15);
    Font font2 = new Font("Impact", Font.PLAIN, 20);
    
    //create panel for the introduction text
    text = new JPanel();
    JLabel t = new JLabel("First of all... what do you have to do?");
    text.add(t);
    text.setBackground(new Color(176, 205, 252)); //sets background to light blue
    add(text, BorderLayout.NORTH);
    t.setFont(font2);
    
    
    //add new panel for the questions --> 2 by 2 grid layout
    questions = new JPanel();
    questions.setLayout(new GridLayout (2, 2));
   
    //four menus in gridLayout 
    //first menu: input name of task
    JPanel taskPanel = new JPanel();
    JLabel nameOfTask = new JLabel ("Name of task:");
    name = new JTextField(10);
    taskPanel.add(nameOfTask);
    taskPanel.add(name);
    questions.add(taskPanel); //add to questions panel
    nameOfTask.setFont(font1);
    taskPanel.setBackground(new Color(255, 237, 165));
    
 
    //second menu: the time it takes to complete the task 
    JPanel timePanel = new JPanel();
    timeItTakes = new JSlider(JSlider.HORIZONTAL, 0, 10, 0); //slider from 0 to 10
    timeItTakes.setMinorTickSpacing(1);
    timeItTakes.setMajorTickSpacing(5);
    timeItTakes.setPaintTicks(true);
    timeItTakes.setPaintLabels(true);
    JLabel timeLabel = new JLabel ("Time it takes to complete (in hours): ");
    timePanel.add(timeLabel);
    timePanel.add(timeItTakes);
    questions.add(timePanel);
    timeLabel.setFont(font1); //set font
    timePanel.setBackground(new Color(255, 237, 165)); //set background of panel to yellow
    
    //third menu: due date panel
    JPanel dueDatePanel = new JPanel();
    Integer[] when = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30}; 
    dueDate = new JComboBox(when);
    JLabel dueLabel = new JLabel ("How many days from now is it due?");
    dueDatePanel.add(dueLabel);
    dueDatePanel.add(dueDate);
    questions.add(dueDatePanel);
    dueLabel.setFont(font1);
    dueDatePanel.setBackground(new Color(255, 237, 165)); //set background of panel to yellow
    
    //priority factor panel
    JPanel priorityPanel = new JPanel();
    Integer[] factor = {1, 2, 3}; 
    priorityFactor = new JComboBox(factor);
    JLabel prioritylabel = new JLabel ("On a scale of 1-3 (3 being the highest), what is the priority of this task?");
    priorityPanel.add(prioritylabel);
    priorityPanel.add(priorityFactor);
    questions.add(priorityPanel);
    prioritylabel.setFont(font1);
    priorityPanel.setBackground(new Color(255, 237, 165)); //set background of panel to yellow
    
    //add the questions panel
    add(questions, BorderLayout.CENTER);

    
    //Creates and adds the button user presses when done entering info & button to add task.
    addTask = new JButton("Add task");
    add(addTask, BorderLayout.SOUTH); 
    
    //button listener to add tasks
    ButtonListener a1 = new ButtonListener();
    addTask.addActionListener(a1);

    setBackground(new Color(176, 205, 252));
  }
  
  
  private class ButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event) {
      if (event.getSource() == addTask) {
        //create four parameters to create a task
        String taskName = name.getText();
        int numHours = (int) timeItTakes.getValue();
        int taskDue = (Integer) dueDate.getSelectedItem();
        int taskPF = (Integer) priorityFactor.getSelectedItem();
        
        //create a new task
        Task newTask = new Task(taskName, numHours, taskDue, taskPF);
        //System.out.println(newTask);
        
        //add to list
        list.addTask(newTask);
        //System.out.println(list);
      }
    }
  }
}