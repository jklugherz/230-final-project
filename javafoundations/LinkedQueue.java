//********************************************************************
//  LinkedQueue.java       Java Foundations
//
//  Represents a linked implementation of a queue.
//********************************************************************

package javafoundations;

import javafoundations.exceptions.*;

public class LinkedQueue<T> implements Queue<T> {
 private int count;
 private LinearNode<T> front, rear;

 //-----------------------------------------------------------------
 //  Creates an empty queue.
 //-----------------------------------------------------------------
 public LinkedQueue() {
  count = 0;
  front = rear = null;
 }

 //-----------------------------------------------------------------
 //  Adds the specified element to the rear of this queue.
 //-----------------------------------------------------------------
 public void enqueue (T el) {
   //create a LinearNote out of the input element
  LinearNode<T> node = new LinearNode<T>(el);

  if (count == 0)
   front = node;
  else
   rear.setNext(node);

  rear = node;
  count++;
 }

 //-----------------------------------------------------------------
 //  The following methods are left as Programming Projects.
 //-----------------------------------------------------------------
 public T dequeue () throws EmptyCollectionException {
   if(count == 0){
     throw new EmptyCollectionException("This queue is empty.");
   }
   
   else{
     T element = front.getElement();
     front = front.getNext();
     count--;
     return element;
   }
 }
 
 public T first () throws EmptyCollectionException {
   if(count == 0){
     throw new EmptyCollectionException("This queue is empty.");
   }
   else{
     return front.getElement();
   }
 }
 
 public boolean isEmpty() {
   return (count==0);
 }
 
 public int size() {
   return count;
 }
 
 public String toString() {
   String s = "<front of queue>\n";
   LinearNode<T> node = front;
   while(node != null) {
     s += node.getElement() + "\n";
     node = node.getNext();
   }
   s += "<back of queue>";
   return s;
 }
 
 public static void main(String[] args) {
   /*
   LinkedQueue<String> l= new LinkedQueue<String>();
   l.enqueue("a");
   l.enqueue("b");
   l.enqueue("c");
   l.enqueue("d");
   System.out.println(l);
   System.out.println(l.dequeue());
   System.out.println(l.first());
   System.out.println(l);
   */
 }
}
