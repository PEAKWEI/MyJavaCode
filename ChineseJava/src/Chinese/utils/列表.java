package Chinese.utils;

import java.util.ArrayList;
import java.util.Iterator;

public class �б�<T> extends ArrayList<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private ArrayList<T> contents;

	public �б�() {
		super();
		this.contents = new ArrayList<>();
	}

	public void ����(T t) {
		contents.add(t);
	}
	
	public Integer ��ȡ����() {
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
		return "�б� [contents=" + contents + "]";
	}
	
}
