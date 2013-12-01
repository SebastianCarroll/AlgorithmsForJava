package base;

public class Node {
    public String key;
    public String value;
    public Node next;
    
    public Node(String k, String v){
        key = k;
        value = v;
        next = null;
    }
    
    public Node(String k, String v, Node n){
        key = k;
        value = v;
        next = n;
    }
    
    public Node deepCopy(){
    	return new Node(key, value, next);
    }
    
    public String stringify(){
    	return "("+ key +", "+value+")";
    }
}
