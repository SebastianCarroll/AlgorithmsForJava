package Misc.linkedList;

public class LListRushed1<E> {
	public Node<E> head = null;
	
	public void Insert(E newValue){
		Node<E> newNode = new Node<E>(null, newValue);
		if(isEmpty()){
			head = newNode;
		} else {
			Node<E> oldhead = head;
			newNode.next = oldhead;
			head = newNode;
		}
	}
	
	public void Delete(E toDelete){
		Node<E> current = head;
		while(current != null){
			if(current.next.value == toDelete){
				current.next = current.next.next;
				current.next = null;
				break;
			}
		}
	}
	
	public boolean isEmpty(){
		return head == null;
	}
}

class Node<E> {
	public Node<E> next;
	public E value;
	
	public Node(Node<E> n, E v){
		next = n; 
		value = v;
	}
}
