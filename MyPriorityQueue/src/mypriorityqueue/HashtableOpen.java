package mypriorityqueue;

import java.lang.Object;

import java.io.*;

public class HashtableOpen
{
  // Data Fields
  private Entry [] table;
  private static final int START_CAPACITY             = 101;
  private double LOAD_THRESHOLD                       = 0.75;
  private int numKeys;
  private int numDeletes;
  private final Entry  DELETED    = new Entry (null, null);

  // Constructor
  public HashtableOpen() 
  {
    table = new Entry[START_CAPACITY];
  }

  /** Contains key-value pairs for a hash table. */
  private static class Entry  
  {

    /** The key */
    private String key;

    /** The value */
    private Customer value;

    /** Creates a new key-value pair.
        @param key The key
        @param value The value
     */
    public Entry(String key, Customer value)
    {
      this.key = key;
      this.value = value;
    }

    /** Retrieves the key.
        @return The key
     */
    public String getKey() 
    {
      return key;
    }

    /** Retrieves the value.
        @return The value
     */
    public Customer getValue() 
    {
      return value;
    }

    /** Sets the value.
        @param val The new value
        @return The old value
     */
    public Customer setValue(Customer val) 
    {
      Customer oldVal = value;
      value = val;
      return oldVal;
    }
  }

  /** Returns the number of entries in the map */
  public int size() 
  {
    return numKeys;
  }

  /** Returns true if empty */
  public boolean isEmpty() 
  {
    return numKeys == 0;
  }

  /** Finds either the target key or the first empty slot in the
      search chain using linear probing.
      pre: The table is not full.
      @param key The key of the target object
      @return The position of the target or the first empty slot if
              the target is not in the table.
   */
  private int find(String key) 
  {
    // Calculate the starting index.
    int index = hashCodeCalc(key) % table.length;
    if (index < 0)
    {
      index += table.length; // Make it positive.
    }
      // Increment index until an empty slot is reached
      // or the key is found.
    while ( (table[index] != null) && (!key.equals(table[index].key))) 
    {
      index++;                              // Check for wraparound.
      if (index >= table.length)
      {
        index = 0;                          // Wrap around.
      }
    }
    return index;
  }
  
  public int hashCodeCalc(String key)
  {
      int val;
      int len;
      int i;
      len = key.length();
      
      val = 0;
      
      for(i = 0; i<len; i++)
      {
          val += key.charAt(i) * Math.pow(31, len-i-1);
      }
     
     return val;
  }

  /** Method get for class HashtableOpen.
      @param key The key being sought
      @return the value associated with this key if found;
              otherwise, null
   */
  public Customer get(String key) 
  {
    // Find the first table element that is empty
    // or the table element that contains the key.
    int index = find(key);

    // If the search is successful, return the value.
    if (table[index] != null)
      return table[index].value;
    else
      return null; // key not found.
  }

  /** Method put for class HashtableOpen.
      post: This key-value pair is inserted in the
            table and numKeys is incremented. If the key is already
            in the table, its value is changed to the argument
            value and numKeys is not changed. If the LOAD_THRESHOLD
            is exceeded, the table is expanded.
      @param key The key of item being inserted
      @param value The value for this key
      @return Old value associated with this key if found;
              otherwise, null
   */
  public Customer put(String key, Customer value) {
    // Find the first table element that is empty
    // or the table element that contains the key.
    int index = find(key);

    // If an empty element was found, insert new entry.
    if (table[index] == null) {
      table[index] = new Entry (key, value);
      numKeys++;
      // Check whether rehash is needed.
      double loadFactor = (double) (numKeys + numDeletes) / table.length;
      
      if (loadFactor > LOAD_THRESHOLD)
        rehash();
      
      return null;
    }

    // assert: table element that contains the key was found.
    // Replace value for this key.
    Customer oldVal = table[index].value;
    table[index].value = value;
    return oldVal;
  }

  /** Expands table size when loadFactor exceeds LOAD_THRESHOLD
      post: The size of table is doubled and is an odd integer.
            Each non-deleted entry from the original table is
            reinserted into the expanded table.
            The value of numKeys is reset to the number of items
            actually inserted; numDeletes is reset to 0.
   */
  private void rehash() 
  {
    // Save a reference to oldTable.
    Entry [] oldTable = table;
    // Double capacity of this table.
    table = new Entry[2 * oldTable.length + 1];

    // Reinsert all items in oldTable into expanded table.
    numKeys = 0;
    numDeletes = 0;
    for (int i = 0; i < oldTable.length; i++) 
    {
      if ( (oldTable[i] != null) && (oldTable[i] != DELETED)) 
      {
        // Insert entry in expanded table
        put(oldTable[i].key, oldTable[i].value);
      }
    }
  }
}