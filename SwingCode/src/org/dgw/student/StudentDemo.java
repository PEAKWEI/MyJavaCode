package org.dgw.student;

import java.util.HashSet;
import java.util.Iterator;

public class StudentDemo {
	
		public static void main(String[] args) {
			HashSet<Student> hSet=new HashSet<Student>();
			hSet.add(new Student("����ζ", 19));
			hSet.add(new Student("����ζ2", 19));
			hSet.add(new Student("����ζ3", 19));
			hSet.add(new Student("����ζ4", 19));
			hSet.add(new Student("����ζ5", 19));
			hSet.add(new Student("����ζ6", 19));
			hSet.add(new Student("����ζ7", 19));
			hSet.add(new Student("����ζ8", 19));
			hSet.add(new Student("����ζ9", 19));
			hSet.add(new Student("����ζ0", 19));
			hSet.add(new Student("����ζ9", 19));
			hSet.add(new Student("����ζ9", 19));
			Iterator<Student> iterator=hSet.iterator();
			for (Student student : hSet) {
				System.out.println(student.name+student.age);
			}
			
		}

}
