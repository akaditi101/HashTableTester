import java.util.LinkedList;

public class HashTable
{
    private LinkedList[] table;
    private int size; //number of elements in the table

    public HashTable(int tableSize)
    {
        table = new LinkedList[tableSize];
        for (int i = 0; i < tableSize; i++)
        {
            table[i] = new LinkedList();
        }
        size = 0;
    }

    /**
      *  returns the number of unique elements in the hash table
      */
    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return (size == 0);
    }

    /*
     *  If obj is not a duplicate, stores obj in the hash table,
     *  increases size (number of unique objects stored) and returns true;
     *  otherwise, obj is not added and the method returns false.
     */
    public boolean add(Object obj)
    {
        if (contains(obj))
            return false;
        int index = Math.abs(obj.hashCode()) % table.length;
        table[index].add(obj);
        size++;
        return true;
    }

    /**
     * Returns true if obj is in the table, false otherwise
     */
    public boolean contains(Object obj)
    {
        int index = Math.abs(obj.hashCode()) % table.length;
        LinkedList x = table[index];
        for (Object curr : x)
        {
            if (curr.equals(obj))
                return true;
        }
        return false;
    }

    /**
     * If obj is in the table, removes obj, updates the size (number of unique objects),
     * and returns true; otherwise returns false.
     */
    public boolean remove(Object obj)
    {
        if (contains(obj))
        {
            int index = Math.abs(obj.hashCode()) % table.length;
            LinkedList temp = table[index];
            table[index].remove(obj);
            size --;
            return true;
        }
           return false; 
    }
    
    /**
      * Returns the length of the longest chain (the size of the largest bucket)
      * in the hash table. 
      */
    public int longestChain()
    {
        int longest = 0;
        for (int i = 0; i < table.length; i++)
          {
              if (table[i].size() > longest)
                  longest = table[i].size();
          }
        return longest;
    }

    @Override
    public String toString()
    {
        String res = "HASHTABLE\n";
        for (int i = 0; i < table.length; i++)
        {
            res += "bucket " + i + "  ";
            for (Object c : table[i])
            {
                res += c + " ";
            }
            res += "\n";
        }
        return res;
    }
}