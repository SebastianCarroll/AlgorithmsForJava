package hashtables;

import base.*;

/**
 * Basic implementation of a HashTable which uses Linear Probing to resolve conflicts.
 * Currently supports:
 * 	- setting size of storage initially
 * 	- Putting and Getting of key, value Strings Pairs
 *  - Deal with collisions through Linear Probing
 * TODO:
 *  - Blocking Resizing of array when load factor reaches cutoff
 *  - Dynamic resizing to reduce wait time
 * @author sjc
 */
public class ProbedHashTable implements MapBase {
	Node[] elements;
	Double cutOffLoad = 0.75;
	Double count = 0.0;
	
	public ProbedHashTable(){
		elements = new Node[10];
	}
	
	public ProbedHashTable(Integer initialSize){
		elements = new Node[initialSize];
	}
	
	public ProbedHashTable(Integer initialSize, Double initialCutOffLoad){
		elements = new Node[initialSize];
		cutOffLoad = initialCutOffLoad;
	}

	@Override
	public void put(String key, String value) {
		resizeIfNecessary();
		int emptyIndex = findEmptyNodeIndex(key);
		elements[emptyIndex] = new Node(key, value);
		count++;
	}

	@Override
	public String get(String key) {
		Integer matched = findMatchingNodeIndex(key);
		return matched != null ? elements[matched].value : null;
	}

	@Override
	public Boolean containsKey(String key) {
		Integer matched = findMatchingNodeIndex(key);
		return matched != null;
	}

	@Override
	public void delete(String key) {
		Integer matched = findMatchingNodeIndex(key);
		elements[matched].empty();
	}
	
	private void resizeIfNecessary(){
		if(count/elements.length > cutOffLoad ){
			resizeTable();
		}
	}
	
	private void resizeTable(){
		// Using a secondary HashMap to ease the resize code.
		// Seems sub-optimal though I'm not sure why
		ProbedHashTable moreElems = new ProbedHashTable(elements.length * 2);
		for(Node old : elements){
			if(old == null || old.key == null) continue;
			moreElems.put(old.key, old.value);
		}
		elements = moreElems.elements.clone();
	}
	
    private int hash(String key, int length) {  
        return (Math.abs(key.hashCode())) % length;  
    }
    
    private int findEmptyNodeIndex(String key){
    	int index = getIndex(key);
    	int slotsConsidered = 0;
		Node position = elements[index];
		while(position != null && slotsConsidered < elements.length){
			index = getNextIndex(index);
			position = elements[index];
			slotsConsidered++;
		} 
		return index;
    }
    
    private Integer findMatchingNodeIndex(String key){
    	int index = getIndex(key);
    	int slotsConsidered = 0;
		Node position = elements[index];
		
		if(position == null){
			return null;
		}
		
		while(position.key != key){
			index = getNextIndex(index);
			position = elements[index];
			if(slotsConsidered > elements.length || position == null){
				return null;
			}
		}
		return index;
    }
    
	private int getIndex(String key){
		return hash(key, elements.length);
	}
    
    private int getNextIndex(int index){
    	return index == elements.length -1 ? 0 : ++index;
    }
	
}
