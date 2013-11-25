package hashtables;

/**
 * Basic implementation of a HashTable.
 * Currently supports:
 * 	- setting size of storage initially
 * 	- Putting and Getting of key, value String Pairs
 *  - Blocking Resizing of array when load factor reaches cutoff
 * TODO:
 *  - Deal with collisions
 *  - Dynamic resizing to reduce wait time
 * @author sjc
 */
public class CustomHashTable2 {
    
    Node[] array;
    double cutoffLoadFactor;
    double currentLoadFactor = 0;
    int count = 0;
    
    public CustomHashTable2(int initialSize, double lfactor){
        array = new Node[initialSize];
        cutoffLoadFactor = lfactor;
    }
    
    public CustomHashTable2(int initialSize){
        array = new Node[initialSize];
        cutoffLoadFactor = 0.75;
    }
    
    public String get(String key){
        int index = hash(key, array.length);
        Node n = array[index];
        return n.value;
    }
    
    public void put(String key, String val){
        if(count/array.length > cutoffLoadFactor) {
            increaseArraySize();
        }
        int index = hash(key, array.length);
        array[index] = new Node(key, val);
        count++;
    }
    
    private void increaseArraySize(){
        int curLen = array.length;
        Node[] newElems = new Node[curLen*2];
        rehashElements(array, newElems);
    }
    
    private void rehashElements(Node[] oldElements, Node[] newElements){
        for(int i=0; i<oldElements.length; i++){
            Node oldNode = oldElements[i];
            if(oldNode != null){
                int newIndex = hash(oldNode.key, newElements.length);
                newElements[newIndex] = new Node(oldNode.key, oldNode.value);
            }
        }
        array = newElements;
    }
    
    private int hash(String key, int length) {  
        return (Math.abs(key.hashCode())) % length;  
    }
}
