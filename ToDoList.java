/************************************************************************
  * ToDoList.Java
  * Holds the tasks in a LinkedList. 
  * Sara Vannah, Julia Klugherz, Andjela Stojkovic
  *
  * Main Contributor: Sara
  ************************************************************************/

import java.util.*;

public class ToDoList{
  private static LinkedList<Task> toDo;
  //private static int currentDate;
  
  public ToDoList(){
    toDo = new LinkedList<Task>();
  }
  
  //------------------------------------------------------------------------
  // Get the first task to do in ToDoList
  //------------------------------------------------------------------------
  public static String getFirstTask(){
    if (toDo.isEmpty()) 
      return "Your schedule is empty!";
   return toDo.get(0).getName() +", which takes "+toDo.get(0).getTimeItTakes()+" hours."; 
  }
  
  //------------------------------------------------------------------------
  // Gets remaining tasks, starting at 2 tasks and going to a maximum of 10
  // returns as a String
  //------------------------------------------------------------------------
  public static String getNextTasks(){
    String result = "";
    int taskIndex = 1;
    while (taskIndex < toDo.size() && taskIndex < 10){
      result+= (taskIndex)+". "+toDo.get(taskIndex).getName()+
        ", which takes "+toDo.get(taskIndex).getTimeItTakes()+" hours.<br>";
      taskIndex++;
    }
    return result;
  }
  
  //------------------------------------------------------------------------
  // Add a task to ToDoList
  //------------------------------------------------------------------------
  public static void addTask(Task task){
    toDo.add(task);
    orderTasks();
  }
  
  //------------------------------------------------------------------------
  // Remove a task from ToDoList
  //------------------------------------------------------------------------
  public static void removeTask(Task task){
   toDo.remove(toDo.indexOf(task));
  }
 
  
  //------------------------------------------------------------------------
  // Locates a task in toDoList and prints it out, or states that the task isn't there
  //------------------------------------------------------------------------
  public static String findTask(Task task){
    if(toDo.indexOf(task) != -1){
      return task.toString();
    } else{
      return "Task not found in list.";
    }
  }
  
  
  //------------------------------------------------------------------------
  // Orders tasks in ToDoList
  //------------------------------------------------------------------------
  public static void orderTasks(){
    double[] weight = new double[toDo.size()]; 
    //System.out.println("size is "+toDo.size());
    //calculate priority factor
    for (int task = 0; task < toDo.size(); task++){
      //calculate weight for a task based on how long it takes, how long you have to get it done, and how important it is
      //highest weight = most important
      weight[task] = toDo.get(task).getTimeItTakes() + toDo.get(task).getPriorityFactor() - toDo.get(task).getDueDate();
    }
    
    //sort tasks by weight
    selectionSort(weight);
    
  }
  
  //------------------------------------------------------------------------
  // Selection sort helper method, adapted from Java Foundations
  //------------------------------------------------------------------------
  private static void selectionSort(double[] weights){
    int maxIndex;
    
    for (int index = 0; index < weights.length-1; index++){
     maxIndex = index;
     for (int scan = index+1; scan < weights.length; scan++){
       if (weights[scan] > weights[maxIndex]){
        maxIndex = scan; 
       }
     }
     swap(weights, maxIndex, index);
    }
  }
  
  
  //------------------------------------------------------------------------
  // Swap helper method, adapated from Java Foundations
  // Swaps two elements in the weights array as well as in the toDoList
  //------------------------------------------------------------------------
  private static void swap (double[] weights, int index1, int index2){
    //elements that will be swapped out
   double tempWeight = weights[index1];
   
   Task tempTask1 = toDo.get(index1);
   Task tempTask2 = toDo.get(index2);
   
   //perform the swap
   toDo.set(index1, tempTask2);
   toDo.set(index2, tempTask1);
   weights[index1] = weights[index2];
   weights[index2] = tempWeight;
  }
  
  
  
  //------------------------------------------------------------------------
  // toString, prints individual tasks
  //------------------------------------------------------------------------
  public String toString(){
    String result = "Tasks:\n";
    for (int taskIndex = 0; taskIndex < toDo.size(); taskIndex++){
      result+=toDo.get(taskIndex);
    }
    return result;
  }
  
 /* public static void main(String[] args){
    ToDoList test = new ToDoList();
    Task testTask1 = new Task("test1", 2, 1, 2);
    Task testTask2 = new Task("test2", 2, 7, 2);
    Task testTask3 = new Task("test3", 2, 3, 2);
    test.addTask(testTask1);
    test.addTask(testTask2);
    test.addTask(testTask3);
    System.out.println(test);
    test.removeTask(testTask1);
    System.out.println(test);
    System.out.println("Expect not to find task "+test.findTask(testTask1));
    System.out.println("Expect to find task "+test.findTask(testTask3));
    
  }*/
  }
  