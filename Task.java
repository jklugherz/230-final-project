/************************************************************************
  * Task.java
  * Represents a task. 
  * Sara Vannah, Julia Klugherz, Andjela Stojkovic
  * 
  * Main Contributor: Julia
  ************************************************************************/

class Task { //implements Comparable<Task> {
  protected String name;
  protected int timeItTakes;
  protected int dueDate;
  protected int priorityFactor;
  
  public Task(String name, int timeItTakes, int dueDate, int priorityFactor) {
    this.name = name;
    this.timeItTakes = timeItTakes;
    this.dueDate = dueDate;
    this.priorityFactor = priorityFactor;
  }
  
//----------------------------------------------------------------- 
// Getter for name of task
//----------------------------------------------------------------- 
  public String getName() {
    return name;
  }
  
//----------------------------------------------------------------- 
// Getter for time it takes to complete task
//-----------------------------------------------------------------  
  public int getTimeItTakes() {
    return timeItTakes;
  }
  
//----------------------------------------------------------------- 
// Getter for due date
//-----------------------------------------------------------------  
  public int getDueDate() {
    return dueDate;
  }
  
//----------------------------------------------------------------- 
// Getter for priority factor
//----------------------------------------------------------------- 
  public int getPriorityFactor() {
    return priorityFactor;
  }
  
//----------------------------------------------------------------- 
// Setter for name of task
//-----------------------------------------------------------------
  public void setName(String newName) {
    name = newName;
  }
  
//----------------------------------------------------------------- 
// Setter for time it takes to complete
//-----------------------------------------------------------------  
  public void setTimeItTakes(int newTime) {
    timeItTakes = newTime;
  }
  
//----------------------------------------------------------------- 
// Setter for due date
//-----------------------------------------------------------------  
  public void setDueDate(int newDate) {
    dueDate = newDate;
  }
  
//----------------------------------------------------------------- 
// Setter for priority factor
//-----------------------------------------------------------------  
  public void setPriorityFactor(int priority) {
    priorityFactor = priority;
  }
  
  public String toString() {
    String s = "";
    s += "Name: " + name + "\n";
    s += "Time It Takes: " + timeItTakes + "\n";
    s += "Due Date: " + dueDate + "\n";
    s += "Priority factor: " + priorityFactor + "\n";
    return s;
  }
}