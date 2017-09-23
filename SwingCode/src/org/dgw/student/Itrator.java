package org.dgw.student;

import java.util.ArrayList;
import java.util.Iterator;

public class Itrator {

	public static void main(String[] args) {
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		for (int i = 0; i <10; i++) {
			arrayList.add(i);
			
		}
		for (Iterator iterator = arrayList.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);
		}
		/*for (Integer integer : arrayList) {
			System.out.println(integer);
		}*/
		
	}

}
