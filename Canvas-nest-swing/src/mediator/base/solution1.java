package mediator.base;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

class Fruit{}
class Apple extends Fruit{}
class Jonathan extends Fruit{}
class Orange extends Fruit{}

class Cache<K,V> extends LinkedHashMap<K, V>{
	
	private int cacheSize;
	
	public Cache(int cacheSize){
		super(16, 0.75F, true);
		this.cacheSize=cacheSize;
	}

	@Override
	protected boolean removeEldestEntry(Entry<K, V> eldest) {
		return size()>=cacheSize;
	}
	
	public void getElem(K key,V value) {
		this.put(key, value);
	}
	
	public void setElem(K key) {
		this.get(key);
	}
}
