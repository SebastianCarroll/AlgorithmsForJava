package linkedList;

import base.Node;

public class CustomLinkedList {
	
	private Node head;
	
	public CustomLinkedList(Node h){
		head = h;
	}
	
	public void insert(String key, String value){
		if(head == null){
			head = new Node(key, value);
		}else{
			Node toInsert = new Node(key, value, head.deepCopy());
			head = toInsert;
		}
	}
	
	public Node fetch(String key){
		// TODO Auto-generated method stub
		return new Node("test", "test");
	}
	
	public String toString(){
		return toString(head);
	}
	
	private String toString(Node n){
		if(n == null){
			return "";
		}
		return n.toString() + toString(n);
	}
}
