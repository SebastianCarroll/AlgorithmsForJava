package Misc.linkedList;

import Misc.base.Node;

/**
 * Singly Linked List implementation that stores key,value pairs of strings
 * @author sjc
 *
 */
public class LList {
	
	private String key;
	private String value;
	private LList next;
	
	public LList(){
		key = null;
		value = null;
		next = null;
	}
	
	public LList(String k, String v){
		key = k;
		value = v;
		next = null;
	}
	
	public LList(String k, String v, LList n){
		key = k;
		value = v;
		next = n;
	}
	
	/**
	 * Inserts the new key/value pair at the head of the list
	 * @param k 
	 * Key to insert
	 * @param v
	 * Value to insert
	 */
	public void insert(String k, String v){
		if(key == null && value == null){
			key = k;
			value = v;
		} else {
			LList copyHead = new LList(key, value, next);
			key = k;
			value = v;
			next = copyHead;
		}
	}
	
	/**
	 * Removes node from list which matches the key value provided
	 * @param k - Key value to match
	 * @return value of node removed or null if no node was found
	 */
	public String remove(String k){
		if(next != null && next.next != null && next.key == key){
			LList found = next;
			next = next.next;
			return found.value;
		}
		
		if(key == k){
			LList found = new LList(key, value, next);
			if(next == null){
				key = null;
				value = null;
			}else{
				key = next.key;
				value = next.value;
				next = next.next;
			}
			return found.value;
		}
		return next.remove(k);
	}
	
	/**
	 * Finds and returns the value associated with the key
	 * @param k The key to search for
	 * @return Value associated with the Key or null if the key doesn't exist
	 */
	public String fetch(String k){
		if(key == k){
			return value;
		} else if(key == null || next == null){
			return null;
		}
		return next.fetch(k);
	}
	
	/**
	 * Removes and returns first node in the list
	 * @return First node in the list
	 */
	public Node pop(){
		Node popped = new Node(key, value);
		remove(key);
		return popped;
	}
	
	/**
	 * Reverses the order of the nodes in the list
	 */
	public void reverse(){
		LList head = new LList();
		reverseList(this, head);
		this.update(head.next);
	}
	
	private LList reverseList(LList list, LList head){
		LList nextList = list.next;
		if(nextList == null || nextList.key == null){
            // You've reached the end of the list so
            // make this the head.
			head.next = list.deepCopy();
            return head.next;
        }
		
		// Without this cycles will be introduces
		list.next = null;
		
		LList prevList = reverseList(nextList, head);
		
		prevList.next = list.deepCopy();
		
		return prevList.next;
	}
	
	/**
	 * Converts List Structure to a string representation
	 * @return String representation
	 */
	public String stringify() {
		String toString = stringifyNode();
		if(next == null){
			return toString;
		}
		return toString + next.stringify();
	}
	
	/**
	 * Creates a new List with the same values as this one
	 * @return The cloned list
	 */
	public LList deepCopy(){
		return new LList(key,value,next);
	}
	
	/**
	 * Make the current list look the same as the list supplied
	 * @param toCopy - List which will be copied over to the current list
	 */
	public void update(LList toCopy){
		key = toCopy.key;
		value = toCopy.value;
		next = toCopy.next;
	}
	
	private String stringifyNode(){
		if(key == null){
			return "";
		} else {
			return "(" + key + ", " + value +")";
		}
	}
}
