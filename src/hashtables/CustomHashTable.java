package hashtables;

import base.MapBase;
import base.Node;
import linkedList.LList;

/**
 * Basic implementation of a HashTable.
 * Currently supports:
 * 	- setting size of storage initially
 * 	- Putting and Getting of key, value Strings Pairs
 *  - Blocking Resizing of array when load factor reaches cutoff
 * TODO:
 *  - Deal with collisions - currently just overwrites if a key
 *  	hashes to the same slot
 *  - Dynamic resizing to reduce wait time
 * @author sjc
 */
public class CustomHashTable implements MapBase {
    
    LList[] elements;
    double cutoffLoadFactor;
    double currentLoadFactor = 0;
    int count = 0;
    
    public CustomHashTable(int initialSize, double lfactor){
    	elements = new LList[initialSize];
        cutoffLoadFactor = lfactor;
    }
    
    public CustomHashTable(int initialSize){
        elements = new LList[initialSize];
        cutoffLoadFactor = 0.75;
    }
    
    public String get(String key){
        int index = hash(key, elements.length);
        LList n = elements[index];
        return n.fetch(key);
    }
    
    public void put(String k, String v){
        if(tooManyElements()) {
            increaseArraySize();
        }
        addNewElement(k, v);
        count++;
    }
    
    private void addNewElement(String k, String v){
        int index = hash(k, elements.length);
        LList toAdd = elements[index];
        toAdd.insert(k, v);
    }
    
    private Boolean tooManyElements(){
    	return count/elements.length > cutoffLoadFactor;
    }
    
    public Boolean containsKey(String key) {
        // TODO Auto-generated method stub
        return null;
    }
    
    private void increaseArraySize(){
        int curLen = elements.length;
        LList[] newElems = new LList[curLen*2];
        rehashElements(elements, newElems);
    }
    
    private void rehashElements(LList[] oldElements, LList[] newElements){
    	for(LList oldList : oldElements){
    		Node n;
    		do{
    			n = oldList.pop();
    	        int index = hash(n.key, newElements.length);
    	        LList toAdd = newElements[index];
    	        toAdd.insert(n.key, n.value);
    		}
    		while(n != null);
    	}
        elements = newElements;
    }
    
    private int hash(String key, int length) {  
        return (Math.abs(key.hashCode())) % length;  
    }
}
