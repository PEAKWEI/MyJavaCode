package Chinese.utils;

import java.util.ArrayList;
import java.util.Iterator;

public class 列表<T> extends ArrayList<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private ArrayList<T> contents;

	public 列表() {
		super();
		this.contents = new ArrayList<>();
	}

	public void 增加(T t) {
		contents.add(t);
	}
	
	public Integer 获取长度() {
		return contents.size();
	}
	
	@Override
	public Iterator<T> iterator() {
		return contents.iterator();
	}

	@Override
	public int size() {
		return contents.size();
	}

	@Override
	public T get(int index) {
		return contents.get(index);
	}

	@Override
	public String toString() {
		return "列表 [contents=" + contents + "]";
	}
	
}
