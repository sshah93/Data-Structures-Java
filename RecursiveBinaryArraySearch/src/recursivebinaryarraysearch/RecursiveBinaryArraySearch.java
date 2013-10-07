package recursivebinaryarraysearch;

import java.util.Arrays;

public class RecursiveBinaryArraySearch 
{
    private static int binarySearch(Object[] items, Comparable target, int first, int last) 
    {
        if (first > last)
            return -1; // Base case for unsuccessful search.
        else
        {
            int middle = (first + last) / 2; // Next probe index.
            int compResult = target.compareTo(items[middle]);
        if (compResult == 0)
            return middle; // Base case for successful search.
        else if (compResult < 0)
            return binarySearch(items, target, first, middle - 1);
        else
            return binarySearch(items, target, middle + 1, last);
        }
    }
    
    public static int binarySearch(Object[] items, Comparable target) 
    {
        return binarySearch(items, target, 0, items.length - 1);
    }
    
    public static void main(String[] args) 
    {
       Integer[] newArray = new Integer[20]; 
       
       for(int i = 0; i <= 20; i++)
       {
           newArray[i] = 2*i;           
       }
       
       int j = RecursiveBinaryArraySearch.binarySearch(newArray, 16);
       
       System.out.println("The Element is at the position " + j);
    }
}
