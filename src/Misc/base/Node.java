package Misc.base;

public class Node {
    public String key;
    public String value;
    
    public Node(String k, String v){
        key = k;
        value = v;
    }
    
    public Node(String k, String v, Node n){
        key = k;
        value = v;
    }
    
    public Node deepCopy(){
    	return new Node(key, value);
    }
    
    public String stringify(){
    	return "("+ key +", "+value+")";
    }
    
    public Boolean isEmpty(){
    	return key == null && value == null;
    }
    
    public void empty(){
    	key = null;
    	value = null;
    }
}
