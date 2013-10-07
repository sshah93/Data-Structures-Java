package dlclist;

public class DLClist 
{   
    private static class DLNode <Object> 
    {    
        public Object data;
        public DLNode<Object> next = null;
        public DLNode<Object> prev = null;
    
    public DLNode(Object o)
    {
        data = o;
        next = null;
        prev = null;
    }
    
    public DLNode(Object o, DLNode<Object> n, DLNode<Object> p)
    {
        data = o;
        prev = p;
        next = n;
    }
}
    
    private int size;
    private DLNode<Object> head;
    
    public DLClist()
    {
        head = null;
        size = 0;
    }
        
    public boolean add(Object o)
    {
        DLNode newNode = new DLNode(o);
        
        if(head == null) 
        {          
            head = newNode;
            newNode.next = head;
            newNode.prev = head;
        }
        
        else if(size == 1)
        {
            newNode.prev = head;
            newNode.next = head;
            head.prev = newNode;
            head.next = newNode;
            newNode = head.next;
        }
        
        else
        {
            newNode.prev = head.prev;
            newNode.next = head;
            head.prev.next = newNode;
            head.prev = newNode;
            newNode = head.next;
        }
        
      size++;
      return true;
    }
    
    public boolean add(int i, Object o)
    {
        DLNode newNode = new DLNode(o);
        DLNode temp = head;
        
        if(i==0)
        {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
            head = newNode;
            size++;
        }
        
        if(i>0)
        {            
            for(int x=0; x<i; x++)
            {
                temp = temp.next;
            }            
            newNode.next = temp;
            newNode.prev = temp.prev;
            temp.prev.next = newNode;
            temp.prev = newNode;
            size++;
        }
        
        if(i<0)
        {
            for(int x=0; x>i+1; x--)
            {
                temp = temp.prev;
            }
            newNode.next = temp.prev.next;
            newNode.prev = temp.prev;
            temp.prev.next = newNode;
            temp.prev = newNode;
            size++;
        }  
        return true;
    }
    
    public boolean append(Object o)
    {        
        DLNode newNode = new DLNode(o);
                
        if(size == 0)
        {
            newNode.next = head;
            newNode.prev = head;
        }
        
        if (size > 0)
        {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;            
        }
        
        size++;
        return true;
    } 
    
    public Object get(int i)
    {
        DLNode temp = head;
        
        if(i>0)
        {
            for(int x=0; x<i; x++)
            {
                temp = temp.next;
            }     
        }
        
        else if(i<0)
        {
            for (int x=0; x>i; x--)
            {
                temp = temp.prev;
            }
        }
        System.out.println("\nThe data at position " + i + " is " + temp.data);
        return temp.data;
 }
    
    public Object get()
    {        
        if(head == null)
        {
          System.out.println("\nThere's no head");
            return null;
        }
        System.out.println("\nThe data at head pos is " + head.data);
        return head.data;
    }
    
    public Object getLast()
    {
        DLNode temp = head;
        
        if(head == null)
        {
            return null;
        }
        
        else
        {
            temp = head.prev;
        }
        
        System.out.println("\nThe data at the last position is " + temp.data);
        return head.prev.data;
    }
    
    public void moveHead(int i)
    {                
        DLNode temp = head;
        
        if(i>0)
        {
            for (int j=0; j<i; j++)
            {
                temp = temp.next;
                head = temp;
            }            
        }
                
        else if (i<0)
        {
            for (int k=0; k>i; k++)
            {
                temp = temp.prev;
                head = temp;
            }
        }
                
        else
        {
            head = temp;
        }
        System.out.println("\nThe new head is " + temp.data);
    }
    
    public int size()
    {
        System.out.println("\nThe size of the DLCL is " + size);
        return size;
    }
    
    public Object removeLast()
    {        
        Object temp = head.prev.data;
        
        if(head == null)
        {
            System.out.println("\nThe list is already empty!");
            return null;
        }
        
        else
        {                       // head != null case 
            head.prev.prev.next = head;
            head.prev = head.prev.prev;
            size--;
            System.out.println("\nThe object removed is " + temp);
            return temp;       //only 2 steps, garbage collector takes care of rest
        }
    }
    
    public Object remove()
    {        
        DLNode temp = head;
        
        if(size == 1)
        {
            head = null;
            size--;
            System.out.println("\nThe removed head is "+ temp.data);
            return temp.data;            
        }
                
        else if (size > 1)
        {
            temp.next.prev =  temp.prev;
            temp.prev.next = temp.next;
            head = temp.next;
            size--;
            System.out.println("\nThe removed head is "+ temp.prev.data);
            return temp.data;
        }
                
        else
        {
            System.out.println("\nThere's no nodes in the list!");
            throw new ArrayIndexOutOfBoundsException();
        }
     }
    
    public Object remove(int i)
    {                               //i=0 case
        DLNode temp = head;
        
        if(i == 0)
        {
            remove();
        }
        
        else if(i > 0)
        {
            
            for(int j = 0; j < i; j++)
            {
                temp = temp.next;
            }
            
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
        }
        
        else
        {
            
            for (int j = 0; j > i; j--)
            {
                temp = temp.prev;
            }
            
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        
        size--;
        System.out.println("\nThe object removed from " + i + " position is: " + temp.data);
        return temp.data;          
    }
    
    public boolean remove(Object o)
    {
        DLNode temp = head;
        
        for(int j = 0; j < size; j++)
        {    
            if(temp.data.equals(o))
            {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                size--;
                return true;
            }
        temp = temp.next;
        }
        return false;
    }
    
    public void showList()
    {        
        DLNode temp = head;
        System.out.println("\nThe list is: ");
        
        if(head == null)
        {
            System.out.println("\nNo Elements here!");
        }
        
        for(int i=0; i<size; i++) 
        {
            System.out.println(temp.data.toString());
            temp = temp.next;
        }
    }
    
    public static void main(String[] args) 
    {
        Integer o = 555;
        DLClist myList = new DLClist();
        
        myList.get();
        myList.showList();
        myList.add(0);
        myList.add(1);
        myList.add(2);
        myList.showList();
        myList.get();
        myList.add(1,101);
        myList.get(5);
        myList.append(200);
        myList.getLast();
        myList.moveHead(2);
        myList.get();
        myList.getLast();
        myList.add(8,555);
        myList.size();
        myList.remove(2);
        myList.remove();
        myList.getLast();
        myList.get();
        myList.removeLast();
        myList.getLast();
        myList.get();
        myList.size();
        myList.showList();
        myList.get();
        myList.showList();
        myList.remove();
        myList.showList();
        myList.remove(1);
        myList.showList();
        myList.remove(o);
        myList.showList();
    }
}