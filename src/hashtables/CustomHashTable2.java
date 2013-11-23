package hashtables;

/**
 * Basic implementation of a HashTable.
 * Currently supports:
 * 	- setting size of storage initially
 * 	- Putting and Getting of key, value String Pairs
 *  - Blocking Resizing of array when load factor reaches cutoff 
 * @author sjc
 */
public class CustomHashTable2 {
    String[] array;
    double loadFactor;
    
    public CustomHashTable2(int initialSize, double lfactor){
        array = new String[initialSize];
        loadFactor = lfactor;
    }
    
    public String get(String key){
        int k = hash(key);
        return array[k];
    }
    
    public void put(String key, String val){
        int k = hash(key);
        array[k] = val;
    }
    
    private int hash(String key) {  
        return (Math.abs(key.hashCode())) % array.length;  
    }
}
