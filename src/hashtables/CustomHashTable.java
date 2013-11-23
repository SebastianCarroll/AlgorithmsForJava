package hashtables;

/**
 * Basic implementation of a HashTable.
 * Currently supports:
 * 	- setting size of storage initially
 * 	- Putting and Getting of key, value String Pairs
 * @author sjc
 */
public class CustomHashTable {
    String[] array;
    
    public CustomHashTable(int initialSize){
        array = new String[initialSize];
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
