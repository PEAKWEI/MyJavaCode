package org.dgw.keyevent;

/**
 * java中内部类的
 * 内部类中不能包含静态方法 可以继承静态方法  成员变量可以是static final成员变量与接口的成员变量定义隐士方法一样
 * @author Administrator
 *  内部类是可以与外部类建立通信的 这个通信方式的是编译器的默认内购进行编译的，
 *  内部类可以访问外部类所有成员的，包括私有成员
 *  内部类可以用public private protected 修飾 而局部内部类不能這樣修飾
 *  訪問外部類的成員方法都是默許的 
 */
public class Inenrclasss {
	
	String text="java devlopment";
	
	//嵌套內部類也就是 靜態內部類
	private  class add{
		
		final static int   add=12;
		public  void name() {
			System.out.println(text);
		}
	}
	
	public static void main(String[] args) {
		//下面是内部类的访问办法
		Inenrclasss in1=new Inenrclasss();
		Inenrclasss.add name1=in1.new add();
		name1.name();
		//这是第二种访问方式
		Inenrclasss.add name2=new Inenrclasss().new add();
		name2.name();
		System.out.println("━━━━━━━━━━━━━━━━━━━━");
		//局部内部类
		Inenrclasss in2=new Inenrclasss();
		in2.name1();
	}
	/*
	 * 局部内部类 在方法内定义的类 为局部内部类
	 * 不能有public private protected进行修饰
	 * 局部内部类
		
		1   在局部内部类前不能用修饰符public和private,protected. 
		
		2   可以定义与外部类同名的变量
		
		     如果内部类没有与外部类同名的变量，在内部类中可以直接访问外部类的实例变量
		
		     如果内部类中有与外部类同名的变量，直接用变量名访问的是内部类的变量,用this.变量名访问的也是内部类变量.
		
		     用外部类名.this.内部类变量名访问的是外部类变量
		
		3   不可以定义静态变量和方法 內部類，也就是外部內部類一樣道理
		
		4   可以访问外部类的局部变量(即方法内的变量)，但是变量必须是final的     
		
		5   可以访问外部类的所有成员
	 */
	public void name1() {
		
		int age=23;
		 class sub{
			 //static String s = "name";内部类中不能定义static变量.   
	            public void aaa(){   
	                System.out.println("局部常量K的值为:  "+text);   
	                System.out.println("外围类成员变量str1的值:  "+age);   
	                
	            } 
	            
		}
		new sub().aaa();
		
	}

}
