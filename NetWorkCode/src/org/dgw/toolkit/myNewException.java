package org.dgw.toolkit;

/**
 * 
 * @author Administrator �Զ����쳣���ʹ�÷���
 *
 */
// �Զ��x�������
public class myNewException extends Exception {

	public myNewException(String s) {
		super(s);
		System.out.println(s);
	}
}
//�Զ��x�Į����ʹ��
class naviException {
	
	public static void main(String[] args) throws myNewException{
		    //�{���k�����ڛ]��������r��Ҳ�����{�ã����^̎���k���H�H���@ʾ��һ�lӍϢ
			throw new myNewException("�Զ��x�����");
	}

}
