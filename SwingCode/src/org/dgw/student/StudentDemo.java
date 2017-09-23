package org.dgw.student;

import java.util.HashSet;
import java.util.Iterator;

public class StudentDemo {
	
		public static void main(String[] args) {
			HashSet<Student> hSet=new HashSet<Student>();
			hSet.add(new Student("代果味", 19));
			hSet.add(new Student("代果味2", 19));
			hSet.add(new Student("代果味3", 19));
			hSet.add(new Student("代果味4", 19));
			hSet.add(new Student("代果味5", 19));
			hSet.add(new Student("代果味6", 19));
			hSet.add(new Student("代果味7", 19));
			hSet.add(new Student("代果味8", 19));
			hSet.add(new Student("代果味9", 19));
			hSet.add(new Student("代果味0", 19));
			hSet.add(new Student("代果味9", 19));
			hSet.add(new Student("代果味9", 19));
			Iterator<Student> iterator=hSet.iterator();
			for (Student student : hSet) {
				System.out.println(student.name+student.age);
			}
			
		}

}
