package org.dgw.keyevent;

/**
 * java���ڲ����
 * �ڲ����в��ܰ�����̬���� ���Լ̳о�̬����  ��Ա����������static final��Ա������ӿڵĳ�Ա����������ʿ����һ��
 * @author Administrator
 *  �ڲ����ǿ������ⲿ�ཨ��ͨ�ŵ� ���ͨ�ŷ�ʽ���Ǳ�������Ĭ���ڹ����б���ģ�
 *  �ڲ�����Է����ⲿ�����г�Ա�ģ�����˽�г�Ա
 *  �ڲ��������public private protected ��� ���ֲ��ڲ��಻���@�����
 *  �L���ⲿĳɆT��������Ĭ�S�� 
 */
public class Inenrclasss {
	
	String text="java devlopment";
	
	//Ƕ�׃Ȳ��Ҳ���� �o�B�Ȳ��
	private  class add{
		
		final static int   add=12;
		public  void name() {
			System.out.println(text);
		}
	}
	
	public static void main(String[] args) {
		//�������ڲ���ķ��ʰ취
		Inenrclasss in1=new Inenrclasss();
		Inenrclasss.add name1=in1.new add();
		name1.name();
		//���ǵڶ��ַ��ʷ�ʽ
		Inenrclasss.add name2=new Inenrclasss().new add();
		name2.name();
		System.out.println("����������������������������������������");
		//�ֲ��ڲ���
		Inenrclasss in2=new Inenrclasss();
		in2.name1();
	}
	/*
	 * �ֲ��ڲ��� �ڷ����ڶ������ Ϊ�ֲ��ڲ���
	 * ������public private protected��������
	 * �ֲ��ڲ���
		
		1   �ھֲ��ڲ���ǰ���������η�public��private,protected. 
		
		2   ���Զ������ⲿ��ͬ���ı���
		
		     ����ڲ���û�����ⲿ��ͬ���ı��������ڲ����п���ֱ�ӷ����ⲿ���ʵ������
		
		     ����ڲ����������ⲿ��ͬ���ı�����ֱ���ñ��������ʵ����ڲ���ı���,��this.���������ʵ�Ҳ���ڲ������.
		
		     ���ⲿ����.this.�ڲ�����������ʵ����ⲿ�����
		
		3   �����Զ��徲̬�����ͷ��� �Ȳ��Ҳ�����ⲿ�Ȳ��һ�ӵ���
		
		4   ���Է����ⲿ��ľֲ�����(�������ڵı���)�����Ǳ���������final��     
		
		5   ���Է����ⲿ������г�Ա
	 */
	public void name1() {
		
		int age=23;
		 class sub{
			 //static String s = "name";�ڲ����в��ܶ���static����.   
	            public void aaa(){   
	                System.out.println("�ֲ�����K��ֵΪ:  "+text);   
	                System.out.println("��Χ���Ա����str1��ֵ:  "+age);   
	                
	            } 
	            
		}
		new sub().aaa();
		
	}

}
