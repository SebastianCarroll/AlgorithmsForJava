package linkedList;

import base.Node;

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
	
	public Node pop(){
		Node popped = new Node(key, value);
		remove(key);
		return popped;
	}
	
	public void reverse(){
		reverseList(this);
		//key = newHead.key;
		//value = newHead.value;
		//next = newHead.next;
	}
	
	private LList reverseList(LList list){
		LList nextList = list.next;
		if(nextList == null || nextList.key == null){
            // Youve reached the end of the list so
            // make this the head.
			key = list.key;
			value = list.value;
			next  = list.next;
            return list;
        }
		
		list.next = null;
		
		LList prevList = reverseList(nextList);
		
		if(prevList.key == key && prevList.value == value){
			next = list;
		}
		
		prevList.next = list;
		
		
		return list;
	}
	
	public String stringify() {
		String toString = stringifyNode();
		if(next == null){
			return toString;
		}
		return toString + next.stringify();
	}
	
	private String stringifyNode(){
		if(key == null){
			return "";
		} else {
			return "(" + key + ", " + value +")";
		}
	}
}
