package kwarraylist;

public class TestKWArrayList {
    public static void main(String[] args){
        KWArrayList<Integer> myList = new KWArrayList<Integer>();
        myList.add(5);
        myList.add(20);
        myList.add(12);
        myList.add(1,8);
        int sum = 0;
        
        for (int i = 0; i<myList.size(); i++){
            sum = sum + myList.get(i);
        }
        
        System.out.println("The sum is " + sum);
        
        myList.set(2,7);
        
        for (int i = 0; i<myList.size(); i++){
            sum = sum + myList.get(i);
        }
        
        System.out.println("The sum is " + sum);
        
        try {
          myList.remove(10);          
        }
        
        catch (Exception e){
            System.out.println("There's an ArrayindexoutofBound exception thrown!");
            //System.exit(1);
        }
        
        myList.remove(1);
        
        for (int i = 0; i<myList.size(); i++){
            sum = sum + myList.get(i);
        }
        
        System.out.println("The sum is " + sum);
    }
}