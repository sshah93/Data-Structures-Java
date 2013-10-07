package finalproject;

import java.lang.Object;

import java.util.Arrays;

class MyMaxHeap
    {
        private Customer[] theHeap;
        private int size;
        private int capacity;
        
        public MyMaxHeap()
        {
            size = 0;
            capacity = 5;
            theHeap  = new Customer[capacity];
        }
        
        public MyMaxHeap(Customer[] arr, int n) 
        {            
            if(n<0)
            {
                throw new IndexOutOfBoundsException();
            }
            
            if(n==0)
            {
                return;
            }
            
            if(n>0 && n == arr.length)
            {
                for(int i=0; i<arr.length; i++)
                {
                    Customer temp = arr[i];
                    add(temp);
                }
            }
        }
        
        public int size()
        {
            return size;
        }
        
        public void reallocate()
        {
            capacity = 2 * capacity;
            theHeap = Arrays.copyOf(theHeap, capacity);
        }
        
        public boolean add(Customer cust)
        {
            if (size == capacity)
            {
                reallocate();       //double up the array length
            }
            
            theHeap[size] = cust;            
            size++;                     //counter
            int child = size - 1;
            int parent = (child - 1) / 2;                       // Find childÃ¢â‚¬â„¢s parent.
            
            while (parent >= 0 && (compare(parent,child)) < 0) // Reheap
            {
                swap(parent, child);
                child = parent;
                parent = (child - 1) / 2;                       
            }
            return true;
        }
        
        public Customer peakElement()
        {
            if(size == 0)
            {
                System.out.println("There are no elements available here!");
            }
            
            Customer temp;
            temp = theHeap[0];
            return temp;
        }
       
        public Customer removeMax()
        {
            if(size == 0)
            {
                System.out.println("There are no elements available here!");
                return null;
            }
            
            Customer temp;
            temp = theHeap[0];
            theHeap[0] = theHeap[size - 1];
            
            if (size == 1) 
            {
                theHeap[0] = null;
            }
    
            /* Remove the last item from the ArrayList and place it into
               the first position. */
    
            theHeap[size] = null;          // The parent starts at the top.
            int parent = 0;
            
            while (true) 
            {
                int leftChild = 2 * parent + 1;
                
                if (leftChild >= size()) 
                {
                    break; // Out of heap.
                }

                int rightChild = leftChild + 1;
                
                int minChild = leftChild; // Assume leftChild is smaller.
                // See whether rightChild is smaller.

                if (rightChild < size() && compare(leftChild,rightChild) < 0) 
                {
                    minChild = rightChild;
                }
                // assert: minChild is the index of the smaller child.
                // Move smaller child up heap if necessary.

                if (compare(parent, minChild) < 0) 
                {
                    swap(parent, minChild);
                    parent = minChild;
                }

                else 
                { // Heap property is restored.
                    break;
                }
            }
            
            size--;
            return temp;
        }
        
        public void showList() 
        {
            for(int i=0; i<size; i++)
            {
                String name = theHeap[i].name;
                double w    = theHeap[i].priority;
                double x    = theHeap[i].income;
                int    y    = theHeap[i].nrCars;
                int    z    = theHeap[i].nrHouses;
                int    a    = theHeap[i].coolness;
                System.out.println("Customer: " + name + " Salary: " + x + " Number of Cars: " + y + " Number of Houses: " + z + " Coolness: " + a + " Priority: " + w);
            }    
        }
        
        private void swap(int i, int j)
        {
            Customer temp = theHeap[i];
            theHeap[i] = theHeap[j];
            theHeap[j] = temp;            
        }
        
        private int compare(int i, int j)
        {
            if (theHeap[i].priority > theHeap[j].priority)
            {
                return 1;
            }
            
            else if(theHeap[i].priority == theHeap[j].priority)
            {
                return 0;
            }
            
            else 
            {
                return -1;
            }
        }
    }