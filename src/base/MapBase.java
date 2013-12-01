package base;

public interface MapBase {
	public abstract void put(String key, String value);
	public abstract String get(String key);
	public abstract Boolean containsKey(String key);
}