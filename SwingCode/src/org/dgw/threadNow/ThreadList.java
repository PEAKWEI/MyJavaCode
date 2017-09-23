package org.dgw.threadNow;

import java.util.ArrayList;
import java.util.List;

import sun.management.resources.agent;
import sun.security.action.GetBooleanAction;

public class ThreadList {

	private static ThreadGroup getRootThreadGroups() {

		// 获取源线程组
		ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();
		while (true) {
			if (rootGroup.getParent() != null) {
				rootGroup = rootGroup.getParent();
			} else {
				break;
			}
		}
		return rootGroup;
	}

	private static List<String> getThreadss(ThreadGroup group) {
		// 对象数组 进行传值
		Thread[] threads = new Thread[group.activeCount()];
		List<String> gList = new ArrayList<String>();
		int count = group.enumerate(threads, false);
		for (int i = 0; i < count; i++) {
			gList.add(group.getName() + threads[i].getName());
		}
		return gList;

	}
	public static void main(String[] args) {
		obArray ob=new obArray(12);
		System.out.println(ob.getAge());
		//对象数组  未完成初始化
		obArray[] obArrays=new obArray[12];
		//这次真正完成初始化
		for (int i = 0; i < obArrays.length; i++) {
			  obArrays[i]=new obArray(i);
		}
		for (int i = 0; i < obArrays.length; i++) {
			System.out.println(obArrays[i].getAge());
		}
	}

}

class obArray {
	private int age;

	public obArray() {
		
	}
	public obArray(int age) {
		this.age=age;
	}

	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
