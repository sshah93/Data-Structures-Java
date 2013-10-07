package finalproject;

/* CS 284 Final Project */

/* I pledge my honor that I have abided by the Stevens Honor System - Suketu Shah */

import java.io.*;

public class MyPriorityQueue 
{
    private MyMaxHeap theQueue;
    
    public MyPriorityQueue()
    {
        theQueue = new MyMaxHeap();
    }
    
    public MyPriorityQueue(Customer[] arr, int n)
    {
        theQueue = new MyMaxHeap(arr, n); 
    }
    
    public boolean offer(Customer cust)
    {
        theQueue.add(cust); //call the add() from MyMaxHeap class
        return true;
    }
    
    public Customer remove()
    {
        if(isEmpty() == true) //check if the heap is empty or not
        {
            System.out.println("This is an empty queue!");
            return null;
        }
        
        Customer removedItem = theQueue.removeMax();
        //System.out.println("\nThe removed element of the heap is: " + removedItem.name +" who had a priority of: " + removedItem.priority);
        return removedItem;
    }
    
    public Customer peek()
    {
        if(isEmpty() == true)
        {
            System.out.println("This is an empty heap!");
            return null;
        }
        
        Customer topMost = theQueue.peakElement();
        System.out.println("\nThe current root of the heap is: " + topMost.name);
        return topMost;
    }
    
    public boolean isEmpty()
    {
        if(theQueue.size() == 0)
        {
            System.out.println("\nA queue ran out!\n");
            return true;
        }
        //System.out.println("\nThe Heap is NOT empty!");    
        return false;
    }
    
    public void showList() 
    {
        if(theQueue.size() == 0)
        {
            System.out.println("A Queue got exhausted. It's a Scheme queue if there are Priority Queue's with Customers printed above it or else it's a Customer Queue.");
            return;
        }
            
        System.out.append("Here's the Priority Queue:\n");
        theQueue.showList();
    }   
    
    public static void main(String[] args) 
    {
        MyPriorityQueue[] queue  = new MyPriorityQueue[4];  //array of size 4 null references //{new MyPriorityQueue(), new MyPriorityQueue(), new MyPriorityQueue(), new MyPriorityQueue()} ; 
        queue[0] = new MyPriorityQueue();
        queue[1] = new MyPriorityQueue();
        queue[2] = new MyPriorityQueue();
        queue[3] = new MyPriorityQueue();
       
        MyPriorityQueue scheme = new MyPriorityQueue();
        
        HashtableOpen hashTable = new HashtableOpen();
        
        System.out.println("The Hash Table exists but it isn't 100% functional.");
        System.out.println("Everything else besides the Hash Function works perfectly fine.");
        System.out.println("The Hash Code is also calculated without using Java API. Thanks.\n");
        
        try
        {
            BufferedReader person= new BufferedReader(new FileReader(new File("customers.dat")));
            
            for(String x= person.readLine();x!=null;x=person.readLine())
            {
                String[] result = x.split("\\|");
                            
                if(result[0].length()!=0)
                {
                    Customer cust = new Customer(result[0], Double.parseDouble(result[1]), Integer.parseInt(result[2]), Integer.parseInt(result[3]), Integer.parseInt(result[4])); 
                    cust.setWeight0();
                    queue[0].offer(cust);
                }
                
                if(result[0].length() != 0)
                {
                    Customer cust = new Customer(result[0], Double.parseDouble(result[1]), Integer.parseInt(result[2]), Integer.parseInt(result[3]), Integer.parseInt(result[4]));                  
                    cust.setWeight1();
                    queue[1].offer(cust);
                }
                
                if(result[0].length() != 0)
                {
                    Customer cust = new Customer(result[0], Double.parseDouble(result[1]), Integer.parseInt(result[2]), Integer.parseInt(result[3]), Integer.parseInt(result[4]));                  
                    cust.setWeight2();
                    queue[2].offer(cust);
                }
                
                if(result[0].length() != 0)
                {
                    Customer cust = new Customer(result[0], Double.parseDouble(result[1]), Integer.parseInt(result[2]), Integer.parseInt(result[3]), Integer.parseInt(result[4]));                  
                    cust.setWeight3();
                    queue[3].offer(cust);                
                }
            }            
                        
            BufferedReader in= new BufferedReader(new FileReader(new File("schemes.dat")));
            
            for(String x= in.readLine();x!=null;x=in.readLine())
            {
                String[] result = x.split("\\|");
                            
                if(result[0].length()!=0)
                {
                    Customer cust = new Customer(Integer.parseInt(result[0]), Integer.parseInt(result[1])); 
                    scheme.offer(cust);
                }
            }
        }     
        
        catch(IOException e)
        {
            System.out.println("File I/O error");
        }
        
        while(!scheme.isEmpty()) 
        {
            Customer temp = scheme.remove();           
            int type = temp.getType(); 
            
            if(queue[type].isEmpty())
            {
              System.out.println("Ran out of customers!");
              return;
            }
            
            Customer target = queue[type].remove();
            
            if(target != null)
            {
                System.out.println("The customer with the highest priority for Scheme " + type + " is " + target.name + " who had a priority of " + target.priority + " for salary $" + temp.profit);
            }
            
            while(!queue[type].isEmpty() && target != null)
            {
                if(hashTable.get(target.name) == null)
                {
                    hashTable.put(target.name, target);
                    System.out.println(target.name);
                    //break;
                }
                
                else if(hashTable.get(target.name) != null)
                {
                    Customer newTarget = queue[type].remove();
  
                    while(hashTable.get(newTarget.name) == null)
                    {
                        hashTable.put(newTarget.name, newTarget); 
                        System.out.println(target.name);
                        break;
                    }
                }
                break;
            }
         }
        
        queue[0].showList();
        System.out.println();
        queue[1].showList();
        System.out.println();
        queue[2].showList();
        System.out.println();
        queue[3].showList();
        System.out.println();
        scheme.showList();
    }
}