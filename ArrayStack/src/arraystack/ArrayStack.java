package arraystack;

import java.util.EmptyStackException;

import java.util.Arrays;

public class ArrayStack<E> 
{
    private E[] theData;
    int topOfStack = -1;
    private int capacity = 0;
    private static final int INITIAL_CAPACITY = 10;
    
    public static void main(String[] args)
    {
        ArrayStack<Integer> anArray = new ArrayStack<Integer>();
        
        anArray.push(0);
        anArray.push(1);
        System.out.println(anArray.push(0));
        System.out.println(anArray.push(1));
        System.out.println(anArray.peek());
        System.out.println(anArray.pop());
        System.out.println("The array is " + anArray.toString());
        
    }
    
    public ArrayStack()
    {
        theData = (E[]) new Object[INITIAL_CAPACITY];
    }
    
    public E push(E obj) 
    {
        if(topOfStack == theData.length - 1)
        {
            reallocate();
        }
        
        topOfStack++;
        theData[topOfStack] = obj;
        return obj;
    }
    
    public E pop() 
    {
        if(empty()) 
        {
            throw new EmptyStackException();
        }
        
        return theData[topOfStack--];
    }
    
    public E peek()
    {
        E obj;
        if(empty())
        {
            throw new EmptyStackException();            
        }
        
        obj = theData[topOfStack];
        return obj;
    }
    
    public boolean empty()
    {
        if(topOfStack == -1)
        {
            System.out.println("This is an empty array");
            return true;
        }
        
        return false;
    }
    
    public void reallocate()
    {
        capacity = 2 * capacity;
        theData = Arrays.copyOf(theData, capacity);
    }
        
}