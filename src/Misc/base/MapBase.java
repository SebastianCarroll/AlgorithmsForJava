package Misc.base;

public interface MapBase {
	public void put(String key, String value);
	public String get(String key);
	public Boolean containsKey(String key);
	public void delete(String key);
}