package Misc.heap;

public class HeapLogic {
	
	public Integer left(Integer node){
		return 2*node;
	}
	
	public Integer right(Integer node){
		return 2*node + 1;
	}
	
	public Integer parent(Integer node){
		return node/2;
	}

}
