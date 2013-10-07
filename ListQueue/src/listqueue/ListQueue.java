package listqueue;

import java.lang.String;

import java.util.NoSuchElementException;

public class ListQueue<E> {
    
    public static class Node <E> {
        private E data;
        private Node <E> next;
        
        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }
        
        private Node(E dataItem, Node <E> nodeRef) {
            data = dataItem;
            next = nodeRef;
            
        }
    }
    
    private Node<E> front;
    private Node<E> rear;
    private int size;
    
    public boolean offer(E item) {
        if(front == null) {
            rear = new Node<E>(item);
            front = rear;
        } else {
            rear.next = new Node<E> (item);
            rear = rear.next;
        }
        size++;
        return true;
    }
    
    public E peek() {
        if(size == 0) {
            return null;
        } else {
            return front.data;
        }
    }
    
    public E poll() {
        E item = peek();
        if(item == null) {
            return null;
        } 
        
        front = front.next;
        size--;
        return item;
    }
    
    public E element(){
        if (size == 0)
        {
            throw new NoSuchElementException();
        }
        return front.data;
    }
    
    public E remove()
    {
        E item = peek();
        if (item == null)
        {
            throw new NoSuchElementException();
        }
        front = front.next;
        size--;
        return item;
    }
    
    public static void main(String[] args)
    {
        ListQueue<String> words = new ListQueue<String>();
        ListQueue<String> upper = new ListQueue<String>();
        ListQueue<String> lower = new ListQueue<String>();
        
        words.offer("Adam");
        words.offer("Anthony");
        words.offer("jamal");
        words.offer("johnpaul");
        words.offer("stephen");
        words.offer("Tushar");
        words.offer("Mike");
        words.offer("ratna");
        words.offer("prem");
        words.offer("Jobin");
        String data;
        
        try
        {
            while(words.peek() != null) 
            {
                data = words.remove();
                if(Character.isUpperCase(data.charAt(0)))
                {
                    System.out.println("Insert in upper: " + data);
                    upper.offer(data);                                        
                } 
                
                else 
                {
                    System.out.println("Insert in lower: " + data);
                    lower.offer(data);
                }
            }
        }
        
        catch (NoSuchElementException e)
        {
            System.out.println(e.toString());
        }
    }
}