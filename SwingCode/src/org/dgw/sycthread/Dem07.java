package org.dgw.sycthread;

public class Dem07 extends Thread{
         public Dem07(String name) {
			super(name);
		}
          //静态的值只被一个对象使用 就不会单独执行第二个值
           static   int i=0;
        public void run() {
			for (  i=0 ; i < 10; i++) {
				System.out.println(this.getName()+i);
			}
		}
        
        public static void main(String[] args) {
			Dem07 dem07=new Dem07("A");
			Dem07 dem072=new Dem07("B");
			dem07.start();
			dem072.start();
		}
}
