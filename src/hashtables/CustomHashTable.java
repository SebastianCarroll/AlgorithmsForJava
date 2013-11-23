package hashtables;

public class CustomHashTable {
    String[] array;
    int loadFactor;
    
    public CustomHashTable(int initialSize, int lfactor){
        array = new String[initialSize];
        loadFactor = lfactor;
    }
    
    public String get(int key){
        String val = "";
        if(keyIsValid(key)){
            val = array[key];
        } else {
            // What to do if key isnt valid?
        }
        return val;
    }
    
    public void put(int key, String val){
        if(keyIsValid(key)){
            array[key] = val;
        }
    }
    
    private Boolean keyIsValid(int key){
        return (key < array.length && key > -1);
    }
}